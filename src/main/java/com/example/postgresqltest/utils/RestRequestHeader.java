package com.example.postgresqltest.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * 请求消息头
 *
 * @author YAZUO)WU-TONG
 *
 */
@Data
@AllArgsConstructor
public class RestRequestHeader  implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = -4363387588926602131L;


    /** 分页大小 */
    private int pageSize;

    /** 页码 */
    private int pageNum;

    /** 扩展字段 */
    private String ext;

    /** 构造方法 */
    public RestRequestHeader() {
        super();
    }
}
