import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';


import { NotFoundComponent } from './components/not-found/not-found.component';
import { MaterialModule } from './material.module';
import { FooterComponent } from './components/footer/footer.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { CommonModule } from '@angular/common';
import { AuthService } from 'src/app/public/login/auth.service';


@NgModule({
  imports: [
    HttpClientModule,
    RouterModule,
    MaterialModule,
    CommonModule
  ],
  declarations: [
    NotFoundComponent,
    FooterComponent,
    NavbarComponent
  ],
  exports: [
    HttpClientModule,
    RouterModule,
    NotFoundComponent,
    MaterialModule,
    FooterComponent,
    NavbarComponent,
    CommonModule,
  ],
  providers: [AuthService]
})

export class SharedModule {
  constructor() {}
}
