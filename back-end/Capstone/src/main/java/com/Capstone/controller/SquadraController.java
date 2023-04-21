package com.Capstone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Capstone.entity.Squadra;
import com.Capstone.repository.SquadraRepository;
import com.Capstone.service.SquadraService;


@RestController
@RequestMapping("/api/squadra")
public class SquadraController {
	
	@Autowired 
	private SquadraService squadraService;
	
	@Autowired
	private SquadraRepository squadraRepository;
	
	@GetMapping(value="/{campionato}")
	public ResponseEntity<List<Squadra>> getSquadraByCampionato(@PathVariable("campionato") String campionato) {
		return new ResponseEntity<List<Squadra>>(squadraService.getSquadraByCampionato(campionato), HttpStatus.OK);
	}
	
	@GetMapping(value="/nome/{nome}")
	public ResponseEntity <Squadra> getSquadraByNome(@PathVariable("nome") String nome) {
		return new ResponseEntity<Squadra>(squadraRepository.getSquadraByNome(nome), HttpStatus.OK);
	}

}
