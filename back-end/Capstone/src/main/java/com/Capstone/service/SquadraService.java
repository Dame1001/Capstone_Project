package com.Capstone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Capstone.entity.Squadra;
import com.Capstone.repository.SquadraRepository;

@Service
public class SquadraService {
	
	@Autowired
	SquadraRepository squadraRepository;
	
	public Squadra getSquadraByName(String nome) {
		return squadraRepository.getSquadraByNome(nome);
	}
	
	public List<Squadra> getSquadraByCampionato(String campionato) {
		return squadraRepository.findByCampionato(campionato);
	}

}
