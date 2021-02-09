package com.example.postgresqltest.utils;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class RestResponseHeader implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** 状态码 */
	@ApiModelProperty(value = "状态码", name = "code")
	private String code = "200";

	/** 状态描述 */
	@ApiModelProperty(value = "状态描述", name = "message")
	private String message ="success";

	public RestResponseHeader() {
		super();
	}

	/**
	 * 构造方法
	 *
	 * @param code
	 *            状态码
	 * @param message
	 *            状态描述
	 */
	public RestResponseHeader(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

}
