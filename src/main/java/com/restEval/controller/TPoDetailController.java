package com.restEval.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.restEval.dto.TPoDetailDto;
import com.restEval.dto.TPoHalfDto;
import com.restEval.service.TPoDetailSvc;
import com.restEval.util.RestResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/transactiondetail")
@Api(tags = "TransactionDetailController")
public class TPoDetailController {
	
	@Autowired
	private TPoDetailSvc svc;
	
	@ApiOperation(value = "Return Transaction Data")
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public RestResponse findAll() {
		RestResponse response = new RestResponse();
		response.setStatus(1);
		response.setMessage("Sukses");
		List<TPoDetailDto> dto = svc.findAllDetail();
		response.setObject(dto);
		return response;
		// http://localhost:8081/bootcamp06/customer/all
	}
	
	@ApiOperation(value = "Return Transaction Data with Param")
	@RequestMapping(value = "/all/{id}", method = RequestMethod.GET)
	@ResponseBody
	public RestResponse findAll(@PathVariable("id") String id) {
		RestResponse response = new RestResponse();
		response.setStatus(1);
		response.setMessage("Sukses");
		List<TPoDetailDto> dto = svc.findAllByParam(id);
		response.setObject(dto);
		return response;
		// http://localhost:8081/bootcamp06/customer/all
	}
	
	@ApiOperation(value = "Add Transaction Data")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public RestResponse addTrans(@RequestBody TPoDetailDto dto) {
		RestResponse response = new RestResponse();
		if (dto.getPoNo() == null) {
			response.setStatus(2);
			response.setMessage("id Transaction Tidak Ada!, Silahkan Coba Lagi yaa!");
		} else {
			response.setStatus(1);
			svc.save(dto);
			response.setMessage("Data berhasil ditambahkan!");
		}
		return response;
	}
	
	@ApiOperation(value = "Update Transaction Data")
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public RestResponse updateTrans(@RequestBody TPoDetailDto dto) {
		RestResponse response = new RestResponse();
		if (dto.getPoNo() == null && dto.getItemId() == null) {
			response.setStatus(2);
			response.setMessage("id Order Tidak Ada!, Silahkan Coba Lagi yaa!");
		} else {
			response.setStatus(1);
			svc.update(dto);
			response.setMessage("Data berhasil ditambahkan!");
		}
		return response;
	}
	
	@ApiOperation(value = "Delete Transaction Data")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public RestResponse deleteTrans(@PathVariable("id") String id) {
		RestResponse response = new RestResponse();
		response.setStatus(1);
		svc.delete(id);
		response.setMessage("Data berhasil dihapus!");
		return response;
		// http://localhost:8081/bootcamp06/customer/delete/C009
	}

}
