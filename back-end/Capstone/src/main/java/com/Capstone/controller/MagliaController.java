package com.Capstone.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.Capstone.entity.Maglia;
import com.Capstone.exception.ValidateException;
import com.Capstone.service.MagliaService;
import com.Capstone.service.SquadraService;

@RestController
@RequestMapping("/api/maglia")
public class MagliaController {
	
	@Autowired
	private MagliaService magliaService;
	
	@Autowired 
	private SquadraService squadraService;

	
	@PostMapping(value="/insert")
	public ResponseEntity<Maglia> inserimentoMaglia(@RequestBody Maglia maglia) {
		try {
			return new ResponseEntity<Maglia>(magliaService.insertMaglia(maglia), HttpStatus.OK);
		} catch (ValidateException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	@GetMapping(value ="/{id}")
	public ResponseEntity<Maglia> getMaglia(@PathVariable("id")Integer id) {
		try {
			Maglia maglia = magliaService.getMagliaById(id);
			return new ResponseEntity<Maglia>(maglia, HttpStatus.OK);
		} catch (ValidateException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	@GetMapping(value = "/{campionato}/{squadra}")
	public ResponseEntity<List<Maglia>> getMaglieBySquadra(@PathVariable("campionato")String campionato, @PathVariable("squadra") String squadra) {
		//Squadra s = squadraService.getSquadraByName(squadra);
		List<Maglia> maglie = magliaService.getAllMaglie();
		List<Maglia> magliefinali = new ArrayList<Maglia>();
		for(Maglia m : maglie) {
			if(m.getSquadra().getNome().equals(squadra)) {
				magliefinali.add(m);
			}
		}
		return new ResponseEntity<List<Maglia>> (magliefinali, HttpStatus.OK);
	}
	

}
