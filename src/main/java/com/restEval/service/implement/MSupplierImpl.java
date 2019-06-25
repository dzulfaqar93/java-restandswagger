package com.restEval.service.implement;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restEval.dao.MSupplierDao;
import com.restEval.dto.MSupplierDto;
import com.restEval.entity.MSupplier;
import com.restEval.service.MSupplierSvc;

@Service("mSuppliereSvc")
@Transactional
public class MSupplierImpl implements MSupplierSvc {
	
	@Autowired
	private MSupplierDao dao;

	@Override
	public List<MSupplierDto> findAllSup() {
		List<MSupplier> list = dao.findAll();
		List<MSupplierDto> dtos = new ArrayList<>();
		for (MSupplier ms : list){
			MSupplierDto dto = new MSupplierDto();
			dto.setSupId(ms.getSupId());
			dto.setSupName(ms.getSupName());
			dto.setSupAddress(ms.getSupAddress());
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public MSupplierDto findOneSup(String supId) {
		MSupplier ms = dao.findOne(supId);
		
		MSupplierDto dto = new MSupplierDto();
		if (ms != null) {
			dto.setSupId(ms.getSupId());
			dto.setSupName(ms.getSupName());
			dto.setSupAddress(ms.getSupAddress());
			return dto;
		}
		return dto;
	}

	@Override
	public void save(MSupplierDto dto) {
		MSupplier ms = new MSupplier();
		ms.setSupId(dto.getSupId());
		ms.setSupName(dto.getSupName());
		ms.setSupAddress(dto.getSupAddress());
		dao.save(ms);
	}

	@Override
	public void update(MSupplierDto dto) {
		MSupplier ms = dao.findOne(dto.getSupId());
		
		ms.setSupId(dto.getSupId());
		ms.setSupName(dto.getSupName());
		ms.setSupAddress(dto.getSupAddress());
		dao.save(ms);
	}

	@Override
	public void delete(String supId) {
		MSupplier ms = new MSupplier();
		ms.setSupId(supId);
		dao.delete(ms);
	}

}
