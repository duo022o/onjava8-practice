
package com.duxuewei.onjava.json;

import lombok.Data;

import java.io.Serializable;
import java.util.List;


@Data
public class TransCityEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String pid;
    private String area;
    private String city;
    private String code;
    private String province;
    private String town;
    private String n;
    private List<TransCityEntity> s;

}
