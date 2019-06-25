package com.restEval.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.restEval.entity.MProvince;

public interface MProvinceDao extends CrudRepository<MProvince, Long>, JpaRepository<MProvince, Long> {

	@Query("select mp from MProvince mp where mp.provId = :id")
	public MProvince findOne(@Param("id") String id);
	
}
