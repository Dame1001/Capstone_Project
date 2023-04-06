import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { SerieaPageComponent } from './components/seriea-page/seriea-page.component';
import { PremierleaguePageComponent } from './components/premierleague-page/premierleague-page.component';
import { LaligaPageComponent } from './components/laliga-page/laliga-page.component';
import { BundesligaPageComponent } from './components/bundesliga-page/bundesliga-page.component';
import { Ligue1PageComponent } from './components/ligue1-page/ligue1-page.component';

const routes: Routes = [
  {path: '', component: HomeComponent },
  {path: 'seriea', component: SerieaPageComponent },
  {path: 'premierleague', component: PremierleaguePageComponent },
  {path: 'liga', component: LaligaPageComponent },
  {path: 'bundesliga', component: BundesligaPageComponent },
  {path: 'ligue1', component: Ligue1PageComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
