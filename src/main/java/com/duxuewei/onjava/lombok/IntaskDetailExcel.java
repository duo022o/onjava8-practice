package com.duxuewei.onjava.lombok;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class IntaskDetailExcel {

    /** 资料名称 */
    @EqualsAndHashCode.Exclude
    private String name;
    /** 资料编码 */
    private String code;
    /**
     * 失败原因
     */
    @EqualsAndHashCode.Exclude
    private String cause;


}