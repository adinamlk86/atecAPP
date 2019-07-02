import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {HttpClientModule} from '@angular/common/http';

import {AppComponent} from './app.component';
import {ClientComponent} from './client/client.component';
import {NavigationComponent} from './navigation/navigation.component';
import {AppRoutingModule} from "./app-routing.module";
import {FormsModule} from "@angular/forms";
import { EquipmentComponent } from './client/equipment/equipment.component';
import { ClientTextFilterPipe } from './pipe/client-text-filter.pipe';


@NgModule({
  declarations: [
    AppComponent,
    ClientComponent,
    NavigationComponent,
    EquipmentComponent,
    ClientTextFilterPipe,


  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
