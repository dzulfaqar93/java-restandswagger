package com.restEval.service;

import java.util.List;

import com.restEval.dto.MProvinceDto;


public interface MProvinceSvc {

	public List<MProvinceDto> findAllProv();
	public MProvinceDto findOneProv(String provId);
	public void save(MProvinceDto dto);
	public void update(MProvinceDto dto);
	public void delete(String provId);
}
