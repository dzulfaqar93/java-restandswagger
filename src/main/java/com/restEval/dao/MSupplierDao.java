package com.restEval.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.restEval.entity.MSupplier;

public interface MSupplierDao extends CrudRepository<MSupplier, Long>, JpaRepository<MSupplier, Long> {

	@Query("select ms from MSupplier ms where ms.supId = :id")
	public MSupplier findOne(@Param("id") String id);
	
}
