package com.restEval.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.restEval.entity.MItem;

public interface MItemDao extends CrudRepository<MItem, Long>, JpaRepository<MItem, Long> {

	@Query("select mi from MItem mi where mi.itemId = :id")
	public MItem findOne(@Param("id") String id);
	
}
