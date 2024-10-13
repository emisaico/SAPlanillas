import { NgModule } from '@angular/core';
import { SharedModule } from '../core/shared/shared.module';

import { AdminComponent } from './admin.component';
import { AdminRoutingModule } from './admin-routing.module';
import { ReactiveFormsModule } from '@angular/forms';
import { BoletasComponent } from './boletas/boletas.component';
import { AuthService } from '../public/login/auth.service';
import { BoletaService } from './services/boleta.service';
import { AuthGuard } from '../core/guards/auth.guard';

@NgModule({
  imports: [
    SharedModule,
    AdminRoutingModule,
    ReactiveFormsModule
  ],
  declarations: [
    AdminComponent,
    BoletasComponent
  ],
  exports: [],
  providers: [AuthService,BoletaService,AuthGuard],
})
export class AdminModule {
  constructor() {}
}
