package com.restEval.service;

import java.util.List;
import com.restEval.dto.TPoDto;
import com.restEval.dto.TPoFullDto;
import com.restEval.dto.TPoHalfDto;


public interface TPoSvc {

	public List<TPoDto> findAll();
	public List<TPoDto> findAllBySearch(String search);
	public TPoDto findOneOrder(String poNo);
	public void save(TPoHalfDto dto);
	public void update(TPoHalfDto dto);
	public void delete(String poNo);
	
	public List<TPoFullDto> showAll();
}
