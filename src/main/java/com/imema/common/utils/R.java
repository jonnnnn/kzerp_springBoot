/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.common.utils;

import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据
 *
 * @author Mark sunlightcs@gmail.com
 */
public class R extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;
	
	public R() {
		put("code", 0);
		put("msg", "success");
	}
	
	public static R error() {
		return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
	}
	
	public static R error(String msg) {
		return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
	}
	
	public static R error(int code, String msg) {
		R r = new R();
		r.put("code", code);
		r.put("msg", msg);
		return r;
	}

	public static R ok(String msg) {
		R r = new R();
		r.put("msg", msg);
		return r;
	}
	
	public static R ok(Map<String, Object> map) {
		R r = new R();
		r.putAll(map);
		return r;
	}
	
	public static R ok() {
		return new R();
	}

	@Override
	public R put(String key, Object value) {
		super.put(key, value);
		return this;
	}

	public R putData(Object data) {
		put("data", data);
		return this;
	}

	public R putData(String key, Object value) {
		if(get("data") != null) {
			if(get("data") instanceof Map) {
				((Map)get("data")).put(key, value);
			}
		} else {
			Map data = new HashMap();
			data.put(key, value);
			put("data", data);
		}
		return this;
	}

//	提取请求参数
	public static Map<String,Object> extractParams(Map<String,Object> parameters){
		return (Map<String,Object>)((Map<String,Object>)
				parameters.get("dataForm")).get("data");
	}
}
