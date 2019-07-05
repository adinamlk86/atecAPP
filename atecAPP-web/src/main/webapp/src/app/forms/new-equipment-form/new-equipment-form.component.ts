import {Component, OnInit} from '@angular/core';
import {FormGroup, FormControl} from "@angular/forms";
import {Equipment} from "../../equipment/model/equipment";
import {ClientService} from "../../service/client.service";
import {Client} from "../../client/model/client";

@Component({
  selector: 'app-new-equipment-form',
  templateUrl: './new-equipment-form.component.html',
  styleUrls: ['./new-equipment-form.component.scss']
})
export class NewEquipmentFormComponent implements OnInit {

  equipmentList: Equipment[] = [];
  clients: Client[]=[];
  form: FormGroup;
  show: boolean=false;

  constructor(private clientService: ClientService) {
  }

  ngOnInit() {

    this.getClients();
    this.form = new FormGroup({
      type: new FormControl(''),
      brand:new FormControl(''),
      model:new FormControl(''),
    code:new FormControl(''),
    clientId:new FormControl('')
    })
  }

  getClients(){
    this.clientService.getAllClients().subscribe(
      response => {
        this.clients = response;
      },
      error => {
        alert("An error has occurred!")
      }
    );
  }

  createEquipment(){

    this.clientService.saveEquipment(this.form.value).subscribe(
      result=>{
        this.form.value.id=result.id;

        this.equipmentList.push(this.form.value);
      },
      error => {
        alert("An error occurred while saving equipment.");
      }
    );
  }

  toggle() {
    this.show = !this.show;

  }


}
