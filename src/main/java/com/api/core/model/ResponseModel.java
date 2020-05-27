package com.api.core.model;

public class ResponseModel {

	public Object data = null;
	public Integer code = 0;
	public String msg ="";

	public ResponseModel(String msg) {
		this.msg = msg;
	}

	public ResponseModel(Integer code , Object data, String msg) {
		this.code = code;
		this.data = data;
		this.msg = msg;
	}

	public ResponseModel(String msg , Object data) {
		this.data = data;
		this.msg = msg;
	}

	public ResponseModel(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	

}
