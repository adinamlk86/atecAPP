import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ClientComponent} from "./client/client.component";
import {NoticeComponent} from "./notice/notice.component";
import {EquipmentComponent} from "./equipment/equipment.component";
import {NewClientFormComponent} from "./forms/new-client-form/new-client-form.component";
import {WelcomePageComponent} from "./welcome-page/welcome-page.component";

const routes: Routes = [
    {
      path: 'client',
      component: ClientComponent
    },
    {
      path: 'equipment',
      component: EquipmentComponent,
      pathMatch: 'full'
    },
    {
      path: 'notice',
      component: NoticeComponent
    },
    {
      path: '',
      component: WelcomePageComponent
    }
  ]
;

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
