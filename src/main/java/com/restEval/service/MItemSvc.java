package com.restEval.service;

import java.util.List;

import com.restEval.dto.MItemDto;

public interface MItemSvc {

	public List<MItemDto> findAllItem();
	public MItemDto findOneItem(String itemId);
	public void save(MItemDto dto);
	public void update(MItemDto dto);
	public void delete(String itemId);
	
}
