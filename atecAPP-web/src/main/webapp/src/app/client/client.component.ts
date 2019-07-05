import {Component, OnInit} from '@angular/core';
import {Client} from "./model/client";
import {ClientService} from "../service/client.service";
import {Equipment} from "../equipment/model/equipment";

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.scss']
})
export class ClientComponent implements OnInit {

  clients: Client[] = [];
  selectedClient: Client;
  equipmentList: Equipment[] = [];
  searchText: string;

  constructor(private clientService: ClientService) {
  }

  ngOnInit() {


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





  updateClient(updatedClient: Client) {
    this.clientService.postClient(updatedClient).subscribe(
      result => {

      },
      error => {
        alert("An error has occurred while saving the client.")
      }
    )
  }

  deleteClient(client: Client) {
    if (confirm("Are you sure you want to delete this client?")) {
      this.clientService.deleteClient(client.id).subscribe(
        result => {
          let indexOfClient = this.clients.indexOf(client);
          this.clients.splice(indexOfClient, 1);
        },
        error => {
          alert("Could not delete client.");
        }
      );
    }
  }

  selectClient(client: Client) {

    this.selectedClient = client;
    this.clientService.getEquipmentByClient(client.id).subscribe(
      result => {
        this.equipmentList = result;
      },
      error => {
        alert("An error has occurred while selecting client.")
      }
    );
  }






}
