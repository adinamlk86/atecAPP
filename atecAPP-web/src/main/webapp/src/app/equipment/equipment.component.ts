import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Equipment} from "./model/equipment";
import {ClientService} from "../service/client.service";

@Component({
  selector: 'app-equipment',
  templateUrl: './equipment.component.html',
  styleUrls: ['./equipment.component.scss']
})
export class EquipmentComponent implements OnInit {

  @Input() equipment: Equipment;
  @Output() equipmentUpdated: EventEmitter<Equipment> = new EventEmitter<Equipment>();
  @Output() equipmentDeleted: EventEmitter<Equipment> = new EventEmitter<Equipment>();

  equipmentList: Equipment[]=[];

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
  updateEquipment(){

    this.equipmentUpdated.emit(this.equipment);
  }

  deleteEquipment(){
    this.equipmentDeleted.emit(this.equipment);
  }

}
