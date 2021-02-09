package com.example.postgresqltest.common;
public class BaseException extends RuntimeException {

	private static final long serialVersionUID = -1063948359196909364L;

	private Integer code;

	private String messages;

	public BaseException(String messages) {
		this.messages = messages;
	}

    public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessages() {
		return messages;
	}

	public void setMessage(String message) {
		this.messages = message;
	}

	public BaseException(Integer code, String message) {
		super(message);//改为继承父类的带参数的super，不然抛出异常信息都是null
		this.code = code;
		this.messages = message;
	}
}
