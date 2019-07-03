import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Equipment} from "../model/equipment";

@Component({
  selector: 'app-equipment',
  templateUrl: './equipment.component.html',
  styleUrls: ['./equipment.component.scss']
})
export class EquipmentComponent implements OnInit {

  @Input() equipment: Equipment;
  @Output() equipmentUpdated: EventEmitter<Equipment> = new EventEmitter<Equipment>();
  @Output() equipmentDeleted: EventEmitter<Equipment> = new EventEmitter<Equipment>();

  constructor() { }

  ngOnInit() {
  }

  updateEquipment(){

    this.equipmentUpdated.emit(this.equipment);
  }

  deleteEquipment(){
    this.equipmentDeleted.emit(this.equipment);
  }

}
