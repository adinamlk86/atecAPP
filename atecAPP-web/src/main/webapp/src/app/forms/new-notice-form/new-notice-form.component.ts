import { Component, OnInit } from '@angular/core';
import {ClientService} from "../../service/client.service";
import {FormControl, FormGroup} from "@angular/forms";
import {Client} from "../../client/model/client";
import {Notice} from "../../notice/model/notice";

@Component({
  selector: 'app-new-notice-form',
  templateUrl: './new-notice-form.component.html',
  styleUrls: ['./new-notice-form.component.scss']
})
export class NewNoticeFormComponent implements OnInit {

  noticeList: Notice[]=[];
  clients: Client[]=[];
  form: FormGroup;
  show: boolean=false;

  constructor(private clientService: ClientService) {

  }

  ngOnInit() {

    this.getClients();
    this.form = new FormGroup({
      clientId: new FormControl(''),
      equipmentId:new FormControl(''),
      description:new FormControl(''),
      status:new FormControl(''),
      registerDate:new FormControl('')
    })
  }

  createNotice() {
    this.clientService.postNotice(this.form.value).subscribe(
      result=>{
        this.form.value.id=result.id;

        this.noticeList.push(this.form.value);
      },
      error=>{
        alert("An error has occurred while saving notice.");
      }
    );
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


  toggle() {
    this.show = !this.show;

  }





}
