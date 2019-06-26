import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Client} from "../client/model/client";

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  private BASE_URL  = "http://localhost:8080/api";
  private ALL_CLIENTS_URL = `${this.BASE_URL}\\client\\all`;

  constructor(private http: HttpClient) { }

  getAllClients() : Observable<Client[]>{

    return this.http.get<Client[]>(this.ALL_CLIENTS_URL);
  }
}
