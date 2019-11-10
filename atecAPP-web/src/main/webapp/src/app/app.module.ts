import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import {AppRoutingModule} from "./app-routing.module";
import {ReactiveFormsModule, FormsModule} from "@angular/forms";

import { ClientTextFilterPipe } from './pipe/client-text-filter.pipe';

import {AppComponent} from './app.component';
import {ClientComponent} from './client/client.component';
import {NavigationComponent} from './navigation/navigation.component';
import { EquipmentComponent } from './equipment/equipment.component';
import { NoticeComponent } from './notice/notice.component';
import { NewClientFormComponent } from './forms/new-client-form/new-client-form.component';
import { WelcomePageComponent } from './welcome-page/welcome-page.component';
import { NewEquipmentFormComponent } from './forms/new-equipment-form/new-equipment-form.component';
import { NewNoticeFormComponent } from './forms/new-notice-form/new-notice-form.component';


@NgModule({
  declarations: [
    AppComponent,
    ClientComponent,
    NavigationComponent,
    EquipmentComponent,
    ClientTextFilterPipe,
    NoticeComponent,
    NewClientFormComponent,
    WelcomePageComponent,
    NewEquipmentFormComponent,
    NewNoticeFormComponent,


  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
