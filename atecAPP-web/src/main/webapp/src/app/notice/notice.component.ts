import {Component, OnInit} from '@angular/core';
import {ClientService} from "../service/client.service";
import {Notice} from "./model/notice";

@Component({
  selector: 'app-notice',
  templateUrl: './notice.component.html',
  styleUrls: ['./notice.component.scss']
})
export class NoticeComponent implements OnInit {

  notices: Notice[] =[];
  constructor(private clientService: ClientService) { }

  ngOnInit() {
    this.getAllNotices();
  }

  getAllNotices() {
    this.clientService.getAllNotices().subscribe(
      response => {
        this.notices = response;
      },
      error => {
        alert("An error has occurred!")
      }
    );  }

  createNotice() {
    let newNotice: Notice = {
      id: null,
      registerDate: new Date,
      status: 'status',
      description: 'description',
      clientId: null,
      equipmentId: null

    };

    this.clientService.postNotice(newNotice).subscribe(
      result => {
        newNotice.id = result.id;

        this.notices.push(newNotice);
      },
      error => {
        alert("An error has occurred while registering the new notice.");
      }
    );
  }
}
