package com.Capstone.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="maglia")
public class Maglia {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_maglia")
	private Integer id_maglia;
	@Column(name="nome_prodotto")
	private String nome;
	//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_squadra", nullable = false)
    private Squadra squadra;
	@Column(name="colore")
	private String colore;
	@Column(name="prezzo")
	private Double prezzo;
	@Column(name="immagine")
	private String immagine;
	
	public Maglia(String nome, Squadra squadra, String colore, Double prezzo, String immagine) {
		super();
		this.nome = nome;
		this.squadra = squadra;
		this.colore = colore;
		this.prezzo = prezzo;
		this.immagine = immagine;
	}
	
	
}
