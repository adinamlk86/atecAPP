import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Equipment} from "./model/equipment";
import {ClientService} from "../service/client.service";
import {Client} from "../client/model/client";

@Component({
  selector: 'app-equipment',
  templateUrl: './equipment.component.html',
  styleUrls: ['./equipment.component.scss']
})
export class EquipmentComponent implements OnInit {


  equipmentList: Equipment[]=[];
  clients: Client[]=[];


  constructor(private clientService: ClientService) { }

  ngOnInit() {
    this.getAllEquipment();
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
