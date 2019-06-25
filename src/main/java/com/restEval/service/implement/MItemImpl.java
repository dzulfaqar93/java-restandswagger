package com.restEval.service.implement;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restEval.dao.MItemDao;
import com.restEval.dto.MItemDto;
import com.restEval.entity.MItem;
import com.restEval.service.MItemSvc;

@Service("mItemSvc")
@Transactional
public class MItemImpl implements MItemSvc {
	
	@Autowired
	private MItemDao dao;

	@Override
	public List<MItemDto> findAllItem() {
		List<MItem> list = dao.findAll();
		List<MItemDto> dtos = new ArrayList<>();
		for (MItem mi : list){
			MItemDto dto = new MItemDto();
			dto.setItemId(mi.getItemId());
			dto.setItemName(mi.getItemName());
			dto.setItemPrice(mi.getItemPrice());
			dto.setSupId(mi.getSupId());
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public MItemDto findOneItem(String itemId) {
		MItem mi = dao.findOne(itemId);
		MItemDto dto = new MItemDto();
		
		if (mi != null) {
			dto.setItemId(mi.getItemId());
			dto.setItemName(mi.getItemName());
			dto.setItemPrice(mi.getItemPrice());
			dto.setSupId(mi.getSupId());
			return dto;
		}
		return dto;
	}

	@Override
	public void save(MItemDto dto) {
		MItem mi = new MItem();
		mi.setItemId(dto.getItemId());
		mi.setItemName(dto.getItemName());
		mi.setItemPrice(dto.getItemPrice());
		mi.setSupId(dto.getSupId());
		dao.save(mi);
	}

	@Override
	public void update(MItemDto dto) {
		MItem mi = dao.findOne(dto.getItemId());
		
		mi.setItemId(dto.getItemId());
		mi.setItemName(dto.getItemName());
		mi.setItemPrice(dto.getItemPrice());
		mi.setSupId(dto.getSupId());
		dao.save(mi);
	}

	@Override
	public void delete(String itemId) {
		MItem mi = new MItem();
		mi.setItemId(itemId);
		dao.delete(mi);
	}

}
