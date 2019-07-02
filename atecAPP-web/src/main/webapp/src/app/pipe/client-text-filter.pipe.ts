import { Pipe, PipeTransform } from '@angular/core';
import {Client} from "../client/model/client";

@Pipe({
  name: 'clientTextFilter'
})
export class ClientTextFilterPipe implements PipeTransform {

  transform(clients: Client[], text: string): Client[] {
    if(text == null && text === ""){
      return clients;
    }
    return clients.filter(n=> n.name.includes(text));
  }

}
