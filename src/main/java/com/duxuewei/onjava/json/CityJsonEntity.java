
package com.duxuewei.onjava.json;

import lombok.Data;

import java.io.Serializable;


@Data
public class CityJsonEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String area;
    private String city;
    private String code;
    private String name;
    private String province;
    private String town;


}
