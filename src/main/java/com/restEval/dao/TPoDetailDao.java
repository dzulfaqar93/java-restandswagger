package com.restEval.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.restEval.entity.TPoDetail;
import com.restEval.entity.TPoDetailPK;

public interface TPoDetailDao extends JpaRepository<TPoDetail, TPoDetailPK> {

//	@Query("select td from TPoDetail td where td.poNo = :id")
//	public TPoDetail findOne(@Param("id") String id);
	
	@Query("select td,to,mi from TPoDetail td, TPo to, MItem mi where td.poNo = to.poNo and td.itemId = mi.itemId and td.poNo =:cari")
	public List<Object[]> findAllById(@Param("cari")String poNo);
	
	@Modifying
	@Query("delete from TPoDetail td where td.poNo =:cari")
	public void deleteByOrder(@Param("cari")String poNo);
	
	@Query("select td,to,mi from TPoDetail td, TPo to, MItem mi where td.poNo = to.poNo and td.itemId = mi.itemId")
	public List<Object[]> findAllDetail();
	
}
