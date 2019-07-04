import { Component, OnInit } from '@angular/core';
import {Client} from "../../client/model/client";
import {ClientService} from "../../service/client.service";

@Component({
  selector: 'app-new-client-form',
  templateUrl: './new-client-form.component.html',
  styleUrls: ['./new-client-form.component.scss']
})
export class NewClientFormComponent implements OnInit {

  clients: Client[]=[];

  constructor(private clientService: ClientService) { }

  ngOnInit() {
  }

  createClient(form) {

    let newClient: Client;
    newClient = form.value;

    this.clientService.postClient(newClient).subscribe(
      result => {
        newClient.id = result.id;

        this.clients.push(newClient);
      },
      error => {
        alert("An error has occurred while saving the client.");
      }
    );
  }
}
