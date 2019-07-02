import {Equipment} from "./equipment";

export interface Client {

  id:bigint;
  name:string;
  vatCode:string;
  registrationCode:string;
  address:string;
  bank:string;
  iban:string;
  noOfEquipment:bigint;
  equipmentList: Array<Equipment>;
}
