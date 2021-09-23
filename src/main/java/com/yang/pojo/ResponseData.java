package com.yang.pojo;

import com.alibaba.fastjson.JSONObject;

import lombok.Data;

@Data
public class ResponseData {
	private String code;
	private Object data;
	private String msg;
	private boolean bool;

	public ResponseData() {
	}
	/**
	 * 
	 * @param code
	 * @param data
	 * @param msg
	 */
	public ResponseData(boolean bool,String code, Object data, String msg) {
		this.code = code;
		this.data = data;
		this.msg = msg;
		this.bool = bool;
	}
	
	/**
	 * 
	 * @param code
	 * @param data
	 * @param msg
	 * @return
	 */
	public static String result(boolean bool,String code, Object data, String msg) {
		ResponseData res = new ResponseData(bool,code, data, msg);
		String jsonResult = JSONObject.toJSONString(res);
		return jsonResult;		
	}
	
	public static String result(boolean bool, String msg) {
		ResponseData res = new ResponseData();
		res.setBool(bool);
		res.setMsg(msg);
		String jsonResult = JSONObject.toJSONString(res);
		return jsonResult;		
	}
	
	/**
	 * 返回错误信息
	 * @param msg
	 * @return
	 */
	public static String error(String msg) {
		ResponseData res = new ResponseData();
		res.setBool(false);
		res.setMsg(msg);
		String jsonResult = JSONObject.toJSONString(res);
		return jsonResult;	
	}
}
