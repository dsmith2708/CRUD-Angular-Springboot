import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { Observable } from 'rxjs/Observable';

import { AppComponent } from './app.component';

import { AccountService } from './shared/account.service';
import { HttpClientModule } from '@angular/common/http';
import { AccountListComponent } from './account-list/account-list.component';
import { AccountEditComponent } from './account-edit/account-edit.component';

@NgModule({
  declarations: [
    AppComponent,
    AccountListComponent,
    AccountEditComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [AccountService],
  bootstrap: [AppComponent]
})
export class AppModule { }
