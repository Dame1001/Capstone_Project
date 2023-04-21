package com.Capstone.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name="squadra")
public class Squadra {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_squadra")
	private Integer id_squadra;
	@Column(name="nome")
	private String nome;
	@Column(name="campionato")
	private String campionato;
	@Column(name="logo")
	private String logo;
	
	public Squadra(String nome, String campionato, String logo) {
		this.nome = nome;
		this.campionato = campionato;
		this.logo = logo;
	}
}
