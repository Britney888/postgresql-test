package com.example.postgresqltest.entity;

import java.time.LocalDate;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 
 *
 * @author 
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Weather implements Serializable {

    private static final long serialVersionUID = 1L;

    private String city;

    private Integer tempLo;

    private Integer tempHi;

    private float prcp;

    private LocalDate date;


}
