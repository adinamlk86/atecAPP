import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ClientComponent} from "./client/client.component";
import {NoticeComponent} from "./notice/notice.component";

const routes: Routes = [
  {
    path: 'client',
    component: ClientComponent
  },
    {
      path:'equipment',
      component: ClientComponent,
      pathMatch: 'full'
    },
    {
      path:'notice',
      component: NoticeComponent
    }
]
;

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
