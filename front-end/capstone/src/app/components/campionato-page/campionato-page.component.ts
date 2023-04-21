import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { SquadreService } from 'src/app/squadre.service';
import { Squadra } from 'src/app/utils/interfacce';

@Component({
  selector: 'app-campionato-page',
  templateUrl: './campionato-page.component.html',
  styleUrls: ['./campionato-page.component.scss']
})
export class CampionatoPageComponent implements OnInit {

  campionato:string="Serie A"
  squadre:Squadra[]=[]
  constructor(private ss:SquadreService, private route:ActivatedRoute, private router:Router) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe(param=>{
      this.campionato=<string>param.get('campionato');
      console.log(this.campionato)
      this.ottieniSquadre()
    })
  }

  ottieniSquadre() {

    this.ss.squadre(this.campionato).subscribe(data=>{
      this.squadre=data
      console.log(this.squadre)
    })
  }


}
