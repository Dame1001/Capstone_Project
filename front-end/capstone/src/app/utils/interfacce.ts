export interface Squadra {
  id_squadra:number,
  nome:string,
  logo:string,
  campionato:string
}

export interface Maglia {
  id_maglia:number,
  nome:string
  id_squadra:number,
  colore:string,
  prezzo:number,
  immagine:string
}

export interface User {
  email:string;
  accessToken:string;
  username:string;
}
