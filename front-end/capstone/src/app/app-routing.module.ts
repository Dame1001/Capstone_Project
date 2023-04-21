import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { CampionatoPageComponent } from './components/campionato-page/campionato-page.component';
import { PaginaSquadraComponent } from './components/pagina-squadra/pagina-squadra.component';
import { PaginaMagliaComponent } from './components/pagina-maglia/pagina-maglia.component';

const routes: Routes = [
  //Components
  {path: '', component: HomeComponent },
  {path: 'campionato/:campionato', component: CampionatoPageComponent},
  {path: ':campionato/:squadra', component: PaginaSquadraComponent},
  {path: 'maglia/:id', component: PaginaMagliaComponent},
  //login & register
  {path: 'login', component: LoginComponent},
  {path: 'signin', component: RegisterComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
