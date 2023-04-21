package com.Capstone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.Capstone.entity.Squadra;

public interface SquadraRepository extends CrudRepository<Squadra, Integer> {
	@Query(value="Select * from Squadra s where s.nome =:nome", nativeQuery=true)
	public Squadra getSquadraByNome(@Param("nome")String nome);
	
	List<Squadra> findByCampionato(String campionato);
		
	
	
	

}


