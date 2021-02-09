package com.example.postgresqltest.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 
 *
 * @author ning
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Cities implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private Integer location;


}
