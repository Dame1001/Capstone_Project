package com.Capstone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Capstone.entity.Maglia;
import com.Capstone.exception.ValidateException;
import com.Capstone.repository.MagliaRepository;
import com.Capstone.utils.Utils;

@Service
public class MagliaService {
	
	@Autowired
	private MagliaRepository magliaRepository;
		
	public Maglia insertMaglia(Maglia maglia) throws ValidateException {
		if(Utils.validateMaglia(maglia)) {
			return magliaRepository.save(maglia);			
		}
		throw new ValidateException("Dati maglia non validi " + maglia.toString());
	}
	
	public Maglia getMagliaById(Integer id) throws ValidateException {
		return magliaRepository.findById(id).get();
		
	}
	
	public List<Maglia> getMaglieBySquadra(String campionato, Integer id_squadra) throws ValidateException {
	//	return magliaRepository.getMaglieBySquadra(campionato, id_squadra);
		return magliaRepository.getMaglieByCampionato(campionato);
	}
	
	public List<Maglia> getAllMaglie() {
		return (List<Maglia>) magliaRepository.findAll();	
	}

}
