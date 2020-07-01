package com.jm.utils;

import java.util.HashMap;

public class ResponseInfo extends HashMap<String, Object>{
	
	private static final long serialVersionUID = 1L;
	
	public ResponseInfo(){
		put("code","200");
		put("msg","操作成功");
	}
	
	public static ResponseInfo error(String msg){
		return error("500",msg);
	}
	
	public static ResponseInfo error(String code, String msg){
		ResponseInfo r = new ResponseInfo();
		r.put("code", code);
		r.put("msg", msg);
		return r;
	}
	
	public static ResponseInfo ok(Object data){
		ResponseInfo r = new ResponseInfo();
		r.put("data", data);
		return r;
	}

}
