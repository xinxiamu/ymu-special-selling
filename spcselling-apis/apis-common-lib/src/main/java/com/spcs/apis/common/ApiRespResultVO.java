package com.spcs.apis.common;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;

public class ApiRespResultVO extends ResourceSupport implements Serializable {
	
	private static final long serialVersionUID = -1397589752578789670L;

	private boolean success = true;

	/**
	 * 业务逻辑code
	 */
	private int code = 200;

	/**
	 * 对应code的文字描述
	 */
	private String description = "";

	/**
	 * 返回主体
	 */
	private static Object data = "";

	public ApiRespResultVO addLink(Link link) {
		add(link);
		return this;
	}

	public ApiRespResultVO() {
	}

	public static ApiRespResultVO getInstance(Object result,HttpStatus status) {
		return new ApiRespResultVO(result,status);
	}

	/**
	 * 成功返回。
	 * @param data
	 */
	public ApiRespResultVO(Object data, HttpStatus status) {
		this.data = (new ResponseEntity(data,status)).getBody();
		this.code = status.value();
	}

	/**
	 * 失败抛出异常。
	 * @param code
	 * @param description
	 * @param e
	 */
	public void failaur(final int code,final String description,final Exception e) {
		this.success = false;
		this.description = description;
		if (e != null) {
			this.data = e;
		}
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
