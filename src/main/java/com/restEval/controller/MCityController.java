package com.restEval.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restEval.dto.MCityDto;
import com.restEval.service.MCitySvc;
import com.restEval.util.RestResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/city")
@Api(tags = "MCityController")
public class MCityController {
	
	@Autowired
	private MCitySvc svc;
	
	@ApiOperation(value = "Return City Data")
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public RestResponse findAll() {
		RestResponse response = new RestResponse();
		response.setStatus(1);
		response.setMessage("Sukses");
		List<MCityDto> dto = svc.findAllCity();
		response.setObject(dto);
		return response;
		// http://localhost:8081/bootcamp06/customer/all
	}
	
//	@RequestMapping(value = "/all/{id}", method = RequestMethod.GET)
//	public RestResponse findAll(@PathVariable("id") String id) {
//		RestResponse response = new RestResponse();
//		response.setStatus(1);
//		response.setMessage("Sukses");
//		List<MCityDto> dto = svc.findAllCityWithParam(id);
//		response.setObject(dto);
//		return response;
//		// http://localhost:8081/bootcamp06/customer/all
//	}
	
	// @ApiOperation(value = "Add City Data")
	// @RequestMapping(value = "/add", method = RequestMethod.POST)
	// public RestResponse addCity(@RequestBody MCityDto dto) {
	// 	RestResponse response = new RestResponse();
	// 	if (dto.getCityId() == null) {
	// 		response.setStatus(2);
	// 		response.setMessage("id City Tidak Ada!, Silahkan Coba Lagi yaa!");
	// 	} else {
	// 		response.setStatus(1);
	// 		svc.save(dto);
	// 		response.setMessage("Data berhasil ditambahkan!");
	// 	}
	// 	return response;
	// }
	
	// @ApiOperation(value = "Update City Data")
	// @RequestMapping(value = "/update", method = RequestMethod.PUT)
	// public RestResponse updateCity(@RequestBody MCityDto dto) {
	// 	RestResponse response = new RestResponse();
	// 	if (dto.getCityId() == null) {
	// 		response.setStatus(2);
	// 		response.setMessage("id City Tidak Ada!, Silahkan Coba Lagi yaa!");
	// 	} else {
	// 		response.setStatus(1);
	// 		svc.update(dto);
	// 		response.setMessage("Data berhasil ditambahkan!");
	// 	}
	// 	return response;
	// }
	
	// @ApiOperation(value = "Delete City Data")
	// @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	// public RestResponse deleteCustomer(@PathVariable("id") String id) {
	// 	RestResponse response = new RestResponse();
	// 	response.setStatus(1);
	// 	svc.delete(id);
	// 	response.setMessage("Data berhasil dihapus!");
	// 	return response;
	// 	// http://localhost:8081/bootcamp06/customer/delete/C009
	// }
	

}
