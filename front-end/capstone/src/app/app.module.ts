import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { SerieaPageComponent } from './components/seriea-page/seriea-page.component';
import { PremierleaguePageComponent } from './components/premierleague-page/premierleague-page.component';
import { LaligaPageComponent } from './components/laliga-page/laliga-page.component';
import { BundesligaPageComponent } from './components/bundesliga-page/bundesliga-page.component';
import { Ligue1PageComponent } from './components/ligue1-page/ligue1-page.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderComponent,
    FooterComponent,
    SidebarComponent,
    SerieaPageComponent,
    PremierleaguePageComponent,
    LaligaPageComponent,
    BundesligaPageComponent,
    Ligue1PageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
