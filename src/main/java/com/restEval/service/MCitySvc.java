package com.restEval.service;

import java.util.List;

import com.restEval.dto.MCityDto;


public interface MCitySvc {

	public List<MCityDto> findAllCity();
	public MCityDto findOneCity(String cityId);
	public void save(MCityDto dto);
	public void update(MCityDto dto);
	public void delete(String cityId);
}
