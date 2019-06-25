package com.restEval.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.restEval.entity.TPo;

public interface TPoDao extends JpaRepository<TPo, String> {

	@Query("select tp from TPo tp where tp.poNo = :id")
	public TPo findOne(@Param("id") String id);
	
	@Query("select to,ms,mc from TPo to, MSupplier ms, MCity mc where to.supId = ms.supId and mc.cityId = to.cityId")
	public List<Object[]> findAllOrder();
	
	@Query("select to,ms,mc from TPo to, MSupplier ms, MCity mc where to.supId = ms.supId and mc.cityId = to.cityId and (to.poNo like %:search% or ms.supName like %:search%)")
	public List<Object[]> findAllBySearch(@Param("search")String search);
	
}
