package com.restEval.service;

import java.util.List;

import com.restEval.dto.TPoDetailDto;

public interface TPoDetailSvc {

	public List<TPoDetailDto> findAllDetail();
	public TPoDetailDto findOneDetail(String poNo);

	public List<TPoDetailDto> findAllByParam(String poNo);
	public void save(TPoDetailDto dto);
	public void update(TPoDetailDto dto);
	public void delete(String poNo);
}
