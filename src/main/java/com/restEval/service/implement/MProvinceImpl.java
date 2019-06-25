package com.restEval.service.implement;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restEval.dao.MProvinceDao;
import com.restEval.dto.MProvinceDto;
import com.restEval.entity.MProvince;
import com.restEval.service.MProvinceSvc;

@Service("mProvinceSvc")
@Transactional
public class MProvinceImpl implements MProvinceSvc {
	
	@Autowired
	private MProvinceDao dao;

	@Override
	public List<MProvinceDto> findAllProv() {
		List<MProvince> list = dao.findAll();
		List<MProvinceDto> dtos = new ArrayList<>();
		for (MProvince mp : list){
			MProvinceDto dto = new MProvinceDto();
			dto.setProvId(mp.getProvId());
			dto.setProvName(mp.getProvName());
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public MProvinceDto findOneProv(String provId) {
		MProvince mp = dao.findOne(provId);
		MProvinceDto dto = new MProvinceDto();

		if (mp != null) {
			dto.setProvId(mp.getProvId());
			dto.setProvName(mp.getProvName());
			return dto;
		}
		return dto;
	}

	@Override
	public void save(MProvinceDto dto) {
		MProvince mp = new MProvince();
		mp.setProvId(dto.getProvId());
		mp.setProvName(dto.getProvName());
		dao.save(mp);
	}

	@Override
	public void update(MProvinceDto dto) {
		MProvince mp = dao.findOne(dto.getProvId());
		mp.setProvId(dto.getProvId());
		mp.setProvName(dto.getProvName());
		dao.save(mp);
	}

	@Override
	public void delete(String provId) {
		MProvince mp = new MProvince();
		mp.setProvId(provId);
		dao.delete(mp);
	}

}
