import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Client} from "../client/model/client";
import {Equipment} from "../equipment/model/equipment";
import {Notice} from "../notice/model/notice";

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  private BASE_URL  = "http://localhost:8080/api";
  private ALL_CLIENTS_URL = `${this.BASE_URL}/client/all`;
  private SAVE_CLIENTS_URL = `${this.BASE_URL}/client`;
  private DELETE_CLIENTS_URL = `${this.BASE_URL}/client/`;
  private EQUIPMENT_BY_CLIENT_URL = `${this.BASE_URL}/equipment/byClient/`;
  private ALL_EQUIPMENT_URL = `${this.BASE_URL}/equipment/all`;
  private SAVE_EQUIPMENT_URL = `${this.BASE_URL}/equipment`;
  private DELETE_EQUIPMENT_URL = `${this.BASE_URL}/equipment/`;
  private ALL_NOTICES_URL = `${this.BASE_URL}/notice/all`;
  private SAVE_NOTICE_URL = `${this.BASE_URL}/notice`;
  private DELETE_NOTICE_URL = `${this.BASE_URL}/notice/`;

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

  getEquipmentByClient(clientId: bigint): Observable<Equipment[]> {
    return this.http.get<Equipment[]>(this.EQUIPMENT_BY_CLIENT_URL + clientId);
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

  getAllNotices(): Observable<Notice[]>{
    return this.http.get<Notice[]>(this.ALL_NOTICES_URL);

  }

  postNotice(newNotice: Notice): Observable<Notice>{
    return this.http.post<Notice>(this.SAVE_NOTICE_URL, newNotice);

  }

  deleteNotice(noticeId: bigint): Observable<any>{
    return this.http.delete(this.DELETE_NOTICE_URL + noticeId);
  }

  saveNotice(notice: Notice): Observable<Notice>{
    return this.http.post<Notice>(this.SAVE_NOTICE_URL, notice);
  }
}
