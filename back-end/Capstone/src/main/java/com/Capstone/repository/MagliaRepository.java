package com.Capstone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.Capstone.entity.Maglia;
import com.Capstone.exception.ValidateException;

public interface MagliaRepository extends CrudRepository<Maglia, Integer> {
	@Query(value="Select * from Maglia m where m.colore =:colore ", nativeQuery=true)
	public List <Maglia> getMaglieByColore(@Param("colore")String colore);
	
	@Query(value="Select * from Maglia m where m.campionato =:campionato and m.id_squadra =:squadra", nativeQuery=true)
	public List <Maglia> getMaglieBySquadra(@Param("campionato")String campionato, @Param("squadra")Integer id_squadra) throws ValidateException;

	@Query(value="Select * from Maglia m where m.campionato =:campionato", nativeQuery=true)
	public List <Maglia> getMaglieByCampionato(@Param("campionato")String campionato) throws ValidateException;
}
