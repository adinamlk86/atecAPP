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
  selectedClient: Client;

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

  createClient(){
    let newClient:Client = {
      id:null,
    name:'new client',
    vatCode:null,
    registrationCode:null,
    address:null,
    bank:null,
    iban:null
    };

    this.clientService.postClient(newClient).subscribe(
      result => {
        newClient.id=result.id;
        newClient.name = result.name;
        newClient.address=result.address;
        newClient.vatCode=result.vatCode;
        newClient.registrationCode=result.registrationCode;
        newClient.bank=result.bank;
        newClient.iban=result.iban;

        this.clients.push(newClient);
      },
      error =>{
        alert("An error has occurred while saving the client.");
      }

    );
  }


  updateClient(updatedClient: Client){
    this.clientService.postClient(updatedClient).subscribe(
      result =>{

      },
      error=> { alert("An error has occurred while saving the client.")}
    )
  }

  deleteClient(client: Client){
    if(confirm("Are you sure you want to delete this client?")){
      this.clientService.deleteClient(client.id).subscribe(
        result => {
          let indexOfClient = this.clients.indexOf(client);
          this.clients.splice(indexOfClient,1);
        },
        error => { alert("Could not delete client.");
        }
      );
    }
  }

  selectClient(client: Client){

    this.selectedClient = client;
    this.clientService.getClientById(client.id).subscribe(
      result=>{
        this.clients=result;
      },
      error=>{alert("An error has occurred while selecting client.")}
    );
  }

}
