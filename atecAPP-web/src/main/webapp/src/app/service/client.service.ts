import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Client} from "../client/model/client";
import {Equipment} from "../client/model/equipment";

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  private BASE_URL  = "http://localhost:8080/api";
  private ALL_CLIENTS_URL = `${this.BASE_URL}/client/all`;
  private SAVE_CLIENTS_URL = `${this.BASE_URL}/client`;
  private DELETE_CLIENTS_URL = `${this.BASE_URL}/client/`;
  private CLIENT_BY_ID_URL = `${this.BASE_URL}/client/id`;
  private ALL_EQUIPMENT_URL = `${this.BASE_URL}/equipment/all`;
  private SAVE_EQUIPMENT_URL = `${this.BASE_URL}/equipment`;
  private DELETE_EQUIPMENT_URL = `${this.BASE_URL}/equipment/`;

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

  getAllEquipment(): Observable<Equipment[]>{
    return this.http.get<Equipment[]>(this.ALL_EQUIPMENT_URL);
  }

  saveEquipment(equipment: Equipment): Observable<Equipment>{
    return this.http.post<Equipment>(this.SAVE_EQUIPMENT_URL, equipment);
  }

  deleteEquipment(equipmentId: bigint): Observable<any>{
    return this.http.delete(this.DELETE_EQUIPMENT_URL + equipmentId);
  }

}
