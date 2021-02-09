package com.example.postgresqltest.utils;


import com.example.postgresqltest.common.BaseException;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Data
@Slf4j
@ApiModel(description = "公共返回")
public class HttpResult<T> implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -4118386780685379201L;

    /**
     * 响应消息头
     */
    @ApiModelProperty(value = "响应消息头", name = "header", dataType = "RestResponseHeader")
    private RestResponseHeader header;

    /**
     * 响应消息体(泛型)
     */
    @ApiModelProperty(value = "响应消息体", name = "body")
    private T body = null;

    /**
     * 构造方法
     */
    public HttpResult() {
        super();
        this.header = new RestResponseHeader();
    }

    /**
     * 静态构造方法，处理成功
     */
    public static <T> HttpResult<T> success() {

        return new HttpResult<T>();
    }

    /**
     * 静态构造方法，处理成功
     *
     * @param body 响应消息体(泛型)
     */
    public static <T> HttpResult<T> success(T body) {
        return new HttpResult<T>(body);
    }

    /**
     * Code静态构造方法
     *
     * @param code 响应消息体(泛型)
     */
    public static <T> HttpResult<T> buildWithCode(String code) {
        return buildWithCode(code, (String) null);
    }

    public static <T> HttpResult<T> buildWithCode(String code, String message) {
        HttpResult<T> rr = new HttpResult<T>(code, message);
        return rr;
    }

    public static <T> HttpResult<T> buildWithError(Exception e) {
        String errCode = "500";
        if (e instanceof BaseException) {
            Integer code = ((BaseException) e).getCode();
            errCode = String.valueOf(code);
            log.info(errCode, e);
        } else {
            log.error(errCode, e);
        }

        HttpResult<T> rr = new HttpResult<T>(errCode, e.getMessage());
        return rr;
    }

    public static <T> HttpResult<T> buildWithErrorCode(String code, Exception e) {
        if (e instanceof BaseException) {
            log.info(code, e);
        } else {
            log.error(code, e);
        }

        HttpResult<T> rr = new HttpResult<T>(code, e.getMessage());
        return rr;
    }

    /**
     * 构造方法
     *
     * @param header 响应消息头
     * @param body   响应消息体(泛型)
     */
    public HttpResult(RestResponseHeader header, T body) {
        super();
        this.header = header;
        this.body = body;
    }

    /**
     * 构造方法
     *
     * @param header 响应消息头
     */
    public HttpResult(RestResponseHeader header) {
        super();
        this.header = header;
    }

    /**
     * 构造方法
     *
     * @param body 响应消息体(泛型)
     */
    public HttpResult(T body) {
        super();
        this.header = new RestResponseHeader();
        this.body = body;
    }

    /**
     * 构造方法
     *
     * @param code    状态码
     * @param message 状态描述
     */
    public HttpResult(String code, String message) {
        super();
        this.header = new RestResponseHeader(code, message);
    }

    /**
     * 构造方法
     *
     * @param code    状态码
     * @param message 状态描述
     * @param body    响应消息体(泛型)
     */
    public HttpResult(String code, String message, T body) {
        super();
        this.header = new RestResponseHeader(code, message);
        this.body = body;
    }

    @JsonIgnore
    public boolean isSuccess() {
        return "200".equals(this.header.getCode());
    }

    @JsonIgnore
    public static boolean checkResult(HttpResult result){
        return (null != result && result.isSuccess() && null != result.getBody());
    }


}
