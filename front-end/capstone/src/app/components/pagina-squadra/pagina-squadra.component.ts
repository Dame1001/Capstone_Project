import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MaglieService } from 'src/app/maglie.service';
import { SquadreService } from 'src/app/squadre.service';
import { Maglia, Squadra } from 'src/app/utils/interfacce';

@Component({
  selector: 'app-pagina-squadra',
  templateUrl: './pagina-squadra.component.html',
  styleUrls: ['./pagina-squadra.component.scss']
})
export class PaginaSquadraComponent implements OnInit {

  campionato:string=""
  squadra:string=""
  squadraOggetto:Squadra={  id_squadra:1,
    nome:"",
    logo:"",
    campionato:""};
  maglie:Maglia[]=[]
  constructor(private ms:MaglieService, private route:ActivatedRoute, private ss:SquadreService, private router:Router) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(param=>{
      this.squadra=<string>param.get('squadra');
      this.campionato=<string>param.get('campionato')
      console.log(this.squadra)
      console.log(this.campionato)
      this.ottieniMaglie()
      this.ottieniSquadra()

    })
  }

  ottieniMaglie() {
    this.ms.maglie(this.campionato, this.squadra).subscribe(data=>{
      this.maglie=data
      console.log(this.maglie)
    })
  }

  ottieniSquadra() {
    this.ss.squadra(this.squadra).subscribe(data=>{
      this.squadraOggetto=data
    })

  }

  dettaglio(id:number) {
    this.router.navigate([`/maglia/${id}`]);
  }
}

