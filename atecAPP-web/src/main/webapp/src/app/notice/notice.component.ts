import {Component, OnInit} from '@angular/core';
import {ClientService} from "../service/client.service";
import {Notice} from "./model/notice";
import {Equipment} from "../equipment/model/equipment";

@Component({
  selector: 'app-notice',
  templateUrl: './notice.component.html',
  styleUrls: ['./notice.component.scss']
})
export class NoticeComponent implements OnInit {

  notices: Notice[] = [];

  constructor(private clientService: ClientService) {
  }

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
    );
  }

  deleteNotice(notice: Notice) {
    if (confirm("Are you sure you want to delete this notice?")) {
      this.clientService.deleteNotice(notice.id).subscribe(
        result => {
          let index = this.notices.indexOf(notice);
          this.notices.splice(index, 1);
        },
        error => {
          alert("An error has occurred deleting the notice.");
        }
      );
    }
  }

  updateNotice(updatedNotice: Notice) {
    this.clientService.saveNotice(updatedNotice).subscribe(
      res => {
      },
      err => {
        alert("An error occurred while saving the equipment.");
      }
    );
  }


}
