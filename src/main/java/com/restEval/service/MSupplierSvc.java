package com.restEval.service;

import java.util.List;

import com.restEval.dto.MSupplierDto;


public interface MSupplierSvc {

	public List<MSupplierDto> findAllSup();
	public MSupplierDto findOneSup(String supId);
	public void save(MSupplierDto dto);
	public void update(MSupplierDto dto);
	public void delete(String supId);
}
