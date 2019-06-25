package com.restEval.service.implement;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restEval.dao.MCityDao;
import com.restEval.dao.MProvinceDao;
import com.restEval.dto.MCityDto;
import com.restEval.dto.MProvinceDto;
import com.restEval.entity.MCity;
import com.restEval.entity.MProvince;
import com.restEval.service.MCitySvc;

@Service("mCitySvc")
@Transactional
public class MCityImpl implements MCitySvc {

	@Autowired
	private MCityDao dao;
	
	@Autowired
	private MProvinceDao daoProv;
	
	@Override
	public List<MCityDto> findAllCity() {
		List<MCity> list = dao.findAll();
		List<MProvince> listProv = daoProv.findAll();
		List<MCityDto> dtos = new ArrayList<>();
		for (MCity mc : list){
			for (MProvince mp : listProv) {
				if (mc.getProvId().equals(mp.getProvId())) {
					MCityDto dto = new MCityDto();
					dto.setCityId(mc.getCityId());
					dto.setCityName(mc.getCityName());
					dto.setProvId(mc.getProvId());
					dto.setProvName(mp.getProvName());
					dtos.add(dto);
				} 
			}
			//return dtos;
		}
		return dtos;
	}

	@Override
	public MCityDto findOneCity(String cityId) {
		MCity mc = dao.findOne(cityId);
		MCityDto dto = new MCityDto();
		
		if (mc != null) {
			dto.setCityId(mc.getCityId());
			dto.setCityName(mc.getCityName());
			dto.setProvId(mc.getProvId());
			return dto;
		}
		return dto;
	}

	@Override
	public void save(MCityDto dto) {
		MCity mc = new MCity();
		mc.setCityId(dto.getCityId());
		mc.setCityName(dto.getCityName());
		mc.setProvId(dto.getProvId());
		dao.save(mc);

	}

	@Override
	public void update(MCityDto dto) {
		MCity mc = dao.findOne(dto.getCityId());
		
		mc.setCityId(dto.getCityId());
		mc.setCityName(dto.getCityName());
		mc.setProvId(dto.getProvId());
		dao.save(mc);

	}

	@Override
	public void delete(String cityId) {
		MCity mc = new MCity();
		mc.setCityId(cityId);
		dao.delete(mc);

	}

}
