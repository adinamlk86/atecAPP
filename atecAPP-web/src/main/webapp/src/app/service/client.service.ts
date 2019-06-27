import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Client} from "../client/model/client";

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  private BASE_URL  = "http://localhost:8080/api";
  private ALL_CLIENTS_URL = `${this.BASE_URL}/client/all`;
  private SAVE_CLIENTS_URL = `${this.BASE_URL}/client`;
  private DELETE_CLIENTS_URL = `${this.BASE_URL}/client/`;
  private CLIENT_BY_ID_URL = `${this.BASE_URL}/client/id`;

  constructor(private http: HttpClient) { }

  getAllClients() : Observable<Client[]>{

    return this.http.get<Client[]>(this.ALL_CLIENTS_URL);
  }

  postClient(newClient: Client): Observable<Client> {
    return this.http.post<Client>(this.SAVE_CLIENTS_URL,newClient);
  }

  deleteClient(id: bigint):Observable<any>{

    return this.http.delete(this.DELETE_CLIENTS_URL + id);
  }

  getClientById(id: bigint): Observable<Client[]> {
    return this.http.get<Client[]>(this.CLIENT_BY_ID_URL + id);
  }
}
