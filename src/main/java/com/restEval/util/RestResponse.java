package com.restEval.util;

import java.io.Serializable;

public class RestResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// deklarasi variabel                                                
	private String message;                                              
	private int status;                                                  
	private Object object;    
	                                                                     
	// tambahkan class pojo klik alt+shift+s -> generate setter & getter 
	public String getMessage() {                                         
		return message;                                                  
	}                                                                    
	public void setMessage(String message) {                             
		this.message = message;                                          
	}                                                                    
	public int getStatus() {                                             
		return status;                                                   
	}                                                                    
	public void setStatus(int status) {                                  
		this.status = status;                                            
	}                                                                    
	public Object getObject() {                                          
		return object;                                                   
	}                                                                    
	public void setObject(Object object) {                               
		this.object = object;                                            
	}                                                                    
	public static long getSerialversionuid() {                           
		return serialVersionUID;                                         
	}          
	
	
	
	public RestResponse() {
		super();
	}
	public RestResponse(int status, String message, Object object) {
		super();
		this.status = status;
		this.message = message;
		this.object = object;
	}
}
