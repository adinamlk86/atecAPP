import {Component, OnInit} from '@angular/core';
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


  constructor(private clientService: ClientService) {
  }

  ngOnInit() {

  }

  createEquipment(form){

    let newEquipment: Equipment;
    newEquipment = form.value;

    this.clientService.saveEquipment(newEquipment).subscribe(
      result=>{
        newEquipment.id=result.id;

        this.equipmentList.push(newEquipment);
      },
      error => {
        alert("An error occurred while saving equipment.");
      }
    );
  }


}
