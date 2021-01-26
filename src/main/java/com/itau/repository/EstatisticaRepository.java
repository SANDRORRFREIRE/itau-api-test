package com.itau.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itau.entity.EstatisticaEntity;

public interface EstatisticaRepository  extends JpaRepository<EstatisticaEntity,Long> {
	
}	 

