package com.restEval.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.restEval.entity.MCity;

public interface MCityDao extends JpaRepository<MCity, Long>, CrudRepository<MCity, Long> {

	@Query("select mc from MCity mc where mc.cityId = :id")
	public MCity findOne(@Param("id") String id);
	
}
