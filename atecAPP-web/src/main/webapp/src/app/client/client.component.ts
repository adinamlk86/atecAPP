import {Component, OnInit} from '@angular/core';
import {Client} from "./model/client";
import {ClientService} from "../service/client.service";

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.scss']
})
export class ClientComponent implements OnInit {

  clients: Client[] = [];

  constructor(private clientService: ClientService) {
  }

  ngOnInit() {
    this.getAllClients();
  }

  getAllClients() {

    this.clientService.getAllClients().subscribe(
      response => {
        this.clients = response;
      },
      error => {
        alert("An error has occurred!")
      }
    );
  }

}
