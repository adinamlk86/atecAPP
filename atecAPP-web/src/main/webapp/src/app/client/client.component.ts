import {Component, OnInit} from '@angular/core';
import {Client} from "./model/client";
import {ClientService} from "../service/client.service";
import {Equipment} from "./model/equipment";

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.scss']
})
export class ClientComponent implements OnInit {

  clients: Client[] = [];
  selectedClient: Client;
  equipmentList: Equipment[] = [];

  constructor(private clientService: ClientService) {
  }

  ngOnInit() {
    this.getAllEquipment();

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


  createClient() {
    let newClient: Client = {
      id: null,
      name: 'new client',
      vatCode: null,
      registrationCode: null,
      address: null,
      bank: null,
      iban: null
    };

    this.clientService.postClient(newClient).subscribe(
      result => {
        newClient.id = result.id;
        newClient.name = result.name;
        newClient.address = result.address;
        newClient.vatCode = result.vatCode;
        newClient.registrationCode = result.registrationCode;
        newClient.bank = result.bank;
        newClient.iban = result.iban;

        this.clients.push(newClient);
      },
      error => {
        alert("An error has occurred while saving the client.");
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
    this.clientService.getClientById(client.id).subscribe(
      result => {
        this.clients = result;
      },
      error => {
        alert("An error has occurred while selecting client.")
      }
    );
  }

  getAllEquipment() {
    this.clientService.getAllEquipment().subscribe(
      response => {

        this.equipmentList = response;

      },
      error => {
        alert("An error has occurred while getting equipment list!")
      }
    )
  }


  createEquipment(){
    let newEquipment: Equipment = {
      id:null,
      type:null,
    brand:"KM",
    model:"bizhub",
    code:null
    };

    this.clientService.saveEquipment(newEquipment).subscribe(
      result=>{
        newEquipment.id=result.id;
        newEquipment.type=result.type;
        newEquipment.brand=result.brand;
        newEquipment.model=result.model;
        newEquipment.code=result.code;

        this.equipmentList.push(newEquipment);
      },
      error => {
        alert("An error occurred while saving equipment.");
      }
    );
  }

  deleteEquipment(equipment: Equipment) {
    if (confirm("Are you sure you want to delete this equipment?")) {
      this.clientService.deleteEquipment(equipment.id).subscribe(
        res => {
          let indexOfNote = this.equipmentList.indexOf(equipment);
          this.equipmentList.splice(indexOfNote, 1);
        },
        err => {
          alert("An error has occurred deleting the equipment.");
        }
      );
    }

  }

  updateEquipment(updatedEquipment: Equipment) {
    this.clientService.saveEquipment(updatedEquipment).subscribe(
      res => {
      },
      err => {
        alert("An error occurred while saving the equipment.");
      }
    );

  }
}
