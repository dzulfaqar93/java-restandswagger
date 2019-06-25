package com.restEval.service.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restEval.dao.TPoDetailDao;
import com.restEval.dto.TPoDetailDto;
import com.restEval.entity.MItem;
import com.restEval.entity.TPo;
import com.restEval.entity.TPoDetail;
import com.restEval.entity.TPoDetailPK;
import com.restEval.service.TPoDetailSvc;

@Service("tPoDetailSvc")
@Transactional
public class TPoDetailImpl implements TPoDetailSvc {
	
	@Autowired
	private TPoDetailDao dao;

	@Override
	public List<TPoDetailDto> findAllDetail() {
		List<Object[]> list = dao.findAllDetail();
		List<TPoDetailDto> dtos = new ArrayList<>();
		for (Object[] x : list) {
			TPoDetail td = (TPoDetail) x[0];
			TPo to = (TPo) x[1];
			MItem mi = (MItem) x[2];
			
			TPoDetailDto dto = new TPoDetailDto();
			dto.setPoNo(td.getPoNo());
			dto.setItemId(mi.getItemId());
			dto.setItemName(mi.getItemName());
			dto.setItemPrice(td.getItemPrice());
			dto.setItemQty(td.getItemQty());
			dto.setSubtotal(td.getSubtotal());
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public TPoDetailDto findOneDetail(String poNo) {
		TPoDetailPK pk = new TPoDetailPK();
		pk.setPoNo(poNo);
		TPoDetail td = dao.getOne(pk);
		TPoDetailDto dto = new TPoDetailDto();
		if (td != null) {
			dto.setPoNo(td.getPoNo());
			dto.setItemPrice(td.getItemPrice());
			dto.setItemQty(td.getItemQty());
			dto.setSubtotal(td.getSubtotal());
			
			return dto;
		}
		return dto;
	}

	@Override
	public List<TPoDetailDto> findAllByParam(String poNo) {
		List<TPoDetailDto> dtos = new ArrayList<>();
		List<Object[]> list = dao.findAllById(poNo);
		for (Object[] o : list){
			TPoDetail td = (TPoDetail) o[0];
			TPo to = (TPo) o[1];
			MItem mi = (MItem) o[2];
			
			TPoDetailDto dto = new TPoDetailDto();
			dto.setPoNo(td.getPoNo());
			dto.setItemId(td.getItemId());
			dto.setItemName(mi.getItemName());
			dto.setItemPrice(td.getItemPrice());
			dto.setItemQty(td.getItemQty());
			dto.setSubtotal(td.getSubtotal());
			
//			dto.setPoNo((String) o[0]);
//			dto.setItemId((String) o[1]);
//			dto.setItemName((String) o[2]);
//			dto.setItemPrice((int) o[3]);
//			dto.setItemQty((int) o[4]);
//			dto.setSubtotal((double) o[5]);
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public void save(TPoDetailDto dto) {
		TPoDetail td = new TPoDetail();
		td.setPoNo(dto.getPoNo());
		td.setItemId(dto.getItemId());
		td.setItemPrice(dto.getItemPrice());
		td.setItemQty(dto.getItemQty());
		td.setSubtotal(dto.getSubtotal());
		dao.save(td);
	}

	@Override
	public void update(TPoDetailDto dto) {
		TPoDetailPK pk = new TPoDetailPK();
		pk.setPoNo(dto.getPoNo());
		Optional<TPoDetail> tpOpt = dao.findById(pk);
		
		if (tpOpt.isPresent()) {
			TPoDetail tp = tpOpt.get();
			tp.setPoNo(dto.getPoNo());
			tp.setItemId(dto.getItemId());
			tp.setItemPrice(dto.getItemPrice());
			tp.setItemQty(dto.getItemQty());
			tp.setSubtotal(dto.getSubtotal());
			dao.save(tp);
		}
	}

	@Override
	public void delete(String poNo) {
		TPoDetailPK pk = new TPoDetailPK();
		pk.setPoNo(poNo);
		dao.deleteByOrder(pk.getPoNo());
	}

}
