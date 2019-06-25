package com.restEval.service.implement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restEval.dao.TPoDao;
import com.restEval.dao.TPoDetailDao;
import com.restEval.dto.TPoDetailDto;
import com.restEval.dto.TPoDto;
import com.restEval.dto.TPoFullDto;
import com.restEval.dto.TPoHalfDto;
import com.restEval.entity.MCity;
import com.restEval.entity.MItem;
import com.restEval.entity.MSupplier;
import com.restEval.entity.TPo;
import com.restEval.entity.TPoDetail;
import com.restEval.service.TPoSvc;

@Service("tPoSvc")
@Transactional
public class TPoImpl implements TPoSvc {
	
	@Autowired
	private TPoDao tPoDao;
	@Autowired
	private TPoDetailDao tPoDetailDao;

	@Override
	public List<TPoDto> findAll() {
		List<Object[]> list = tPoDao.findAllOrder();
		List<Object[]> list2 = tPoDetailDao.findAllDetail();
		List<TPoDto> dtos = new ArrayList<>();
		List<TPoDetailDto> dtos2 = new ArrayList<TPoDetailDto>();
		for (Object[] o : list){
			
			TPo to = (TPo) o[0];
			MSupplier ms = (MSupplier) o[1];
			MCity mc = (MCity) o[2];
			
			for (Object[] x :list2) {
				
				TPoDetail td = (TPoDetail) x[0];
				TPo to1 = (TPo) x[1];
				MItem mi = (MItem) x[2];
				
				TPoDto dtoTP = new TPoDto();
				TPoDetailDto dtoTD = new TPoDetailDto();
				
				dtoTP.setPoNo(to.getPoNo());
				dtoTP.setSupName(ms.getSupName());
				dtoTP.setPoDate(to.getPoDate());
				dtoTP.setTotal(to.getTotal());
				dtoTP.setSupId(ms.getSupId());
				dtoTP.setPoAddress(to.getPoAddress());
				dtoTP.setCityId(to.getCityId());
				dtoTP.setCityName(mc.getCityName());
				dtoTP.setDiscount(to.getDiscount());
				dtoTP.setPoExpDate(to.getPoExpDate());
				dtoTP.setPoNotes(to.getPoNotes());
				dtoTP.setPoShipment(to.getPoShipment());
				dtoTP.settPoDetailDto(dtoTD);
				
				if (to.getPoNo().equals(td.getPoNo())) {
					
					dtoTD.setPoNo(td.getPoNo());
					dtoTD.setItemId(mi.getItemId());
					dtoTD.setItemName(mi.getItemName());
					dtoTD.setItemPrice(td.getItemPrice());
					dtoTD.setItemQty(td.getItemQty());
					dtoTD.setSubtotal(td.getSubtotal());
					
					dtos.add(dtoTP);
				}
			}
		}
		return dtos;
	}
	
	
	@Override
	public List<TPoFullDto> showAll() {
		List<Object[]> list = tPoDao.findAllOrder();
		List<Object[]> list2 = tPoDetailDao.findAllDetail();
		List<TPoFullDto> dtos = new ArrayList<>();
		List<TPoDetailDto> dtos2 = new ArrayList<TPoDetailDto>();
		for (Object[] o : list){
			for (Object[] x :list2) {
				
				TPo to = (TPo) o[0];
				MSupplier ms = (MSupplier) o[1];
				MCity mc = (MCity) o[2];
				TPoDetail td = (TPoDetail) x[0];
				TPo to1 = (TPo) x[1];
				MItem mi = (MItem) x[2];
				
				if (to.getPoNo().equals(td.getPoNo())) {
					TPoFullDto dtoTP = new TPoFullDto();
					dtoTP.setPoNo(to.getPoNo());
					dtoTP.setSupName(ms.getSupName());
					dtoTP.setPoDate(to.getPoDate());
					dtoTP.setTotal(to.getTotal());
					dtoTP.setSupId(ms.getSupId());
					dtoTP.setPoAddress(to.getPoAddress());
					dtoTP.setCityId(to.getCityId());
					dtoTP.setCityName(mc.getCityName());
					dtoTP.setDiscount(to.getDiscount());
					dtoTP.setPoExpDate(to.getPoExpDate());
					dtoTP.setPoNotes(to.getPoNotes());
					dtoTP.setPoShipment(to.getPoShipment());
					dtoTP.setItemId(mi.getItemId());
					dtoTP.setItemName(mi.getItemName());
					dtoTP.setItemPrice(mi.getItemPrice());
					dtoTP.setItemQty(td.getItemQty());
					dtoTP.setSubtotal(td.getSubtotal());
					dtos.add(dtoTP);
				}
			}
			
		}
		return dtos;
	}

	@Override
	public List<TPoDto> findAllBySearch(String search) {
		List<Object[]> list = tPoDao.findAllBySearch(search);
		List<TPoDto> dtos = new ArrayList<>();
		for (Object[] o : list){
			TPo to = (TPo) o[0];
			MSupplier ms = (MSupplier) o[1];
			MCity mc = (MCity) o[2];
			
			TPoDetailDto dtoTD = new TPoDetailDto();
			
			TPoDto dto = new TPoDto();
			dto.setPoNo(to.getPoNo());
			dto.setSupName(ms.getSupName());
			dto.setPoDate(to.getPoDate());
			dto.setTotal(to.getTotal());
			dto.setSupId(ms.getSupId());
			dto.setPoAddress(to.getPoAddress());
			dto.setCityId(to.getCityId());
			dto.setCityName(mc.getCityName());
			dto.setDiscount(to.getDiscount());
			dto.setPoExpDate(to.getPoExpDate());
			dto.setPoNotes(to.getPoNotes());
			dto.setPoShipment(to.getPoShipment());
			dto.settPoDetailDto(dtoTD);
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public TPoDto findOneOrder(String poNo) {
		TPo to = tPoDao.findOne(poNo);
		TPoDto dto = new TPoDto();
		if (to != null) {
			dto.setPoNo(to.getPoNo());
			dto.setPoDate(to.getPoDate());
			dto.setTotal(to.getTotal());
			dto.setSupId(to.getSupId());
			dto.setPoAddress(to.getPoAddress());
			dto.setCityId(to.getCityId());
			dto.setDiscount(to.getDiscount());
			dto.setPoExpDate(to.getPoExpDate());
			dto.setPoNotes(to.getPoNotes());
			dto.setPoShipment(to.getPoShipment());
		}
		return dto;
	}

	@Override
	public void save(TPoHalfDto dto) {
		TPo to = new TPo();
		to.setPoNo(dto.getPoNo());
		to.setSupId(dto.getSupId());
		to.setPoAddress(dto.getPoAddress());
		to.setCityId(dto.getCityId());
		to.setPoDate(dto.getPoDate());
		to.setPoExpDate(dto.getPoExpDate());
		to.setPoNotes(dto.getPoNotes());
		to.setPoShipment(dto.getPoShipment());
		to.setDiscount(dto.getDiscount());
		to.setTotal(dto.getTotal());
		tPoDao.save(to);
	}

	@Override
	public void update(TPoHalfDto dto) {
		TPo to = tPoDao.findOne(dto.getPoNo());
		
		to.setPoNo(dto.getPoNo());
		to.setSupId(dto.getSupId());
		to.setPoAddress(dto.getPoAddress());
		to.setCityId(dto.getCityId());
		to.setPoDate(dto.getPoDate());
		to.setPoExpDate(dto.getPoExpDate());
		to.setPoNotes(dto.getPoNotes());
		to.setPoShipment(dto.getPoShipment());
		to.setDiscount(dto.getDiscount());
		to.setTotal(dto.getTotal());
		tPoDao.save(to);
	}

	@Override
	public void delete(String poNo) {
		TPo pk = new TPo();
		pk.setPoNo(poNo);
		tPoDao.delete(pk);
		tPoDetailDao.deleteByOrder(poNo);
	}

}
