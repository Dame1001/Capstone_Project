import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MaglieService } from 'src/app/maglie.service';
import { SquadreService } from 'src/app/squadre.service';
import { Maglia } from 'src/app/utils/interfacce';

@Component({
  selector: 'app-pagina-maglia',
  templateUrl: './pagina-maglia.component.html',
  styleUrls: ['./pagina-maglia.component.scss']
})
export class PaginaMagliaComponent implements OnInit {

  id:string="";
  maglia!:Maglia;
  controllo:boolean=false;
  constructor(private route:ActivatedRoute, private ms:MaglieService) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(param=>{
      this.id=(<string>param.get('id'));
      this.ottieniMaglia()
    })
  }

  ottieniMaglia() {
    this.ms.maglia(this.id).subscribe(data=>{
      this.maglia=data
      console.log(this.maglia)
    })

  }

  controlloFunzione(){
    if(this.controllo==true) {
      this.controllo=false;
    }else {
      this.controllo=true;
    }
    console.log(this.controllo);
  }

}
