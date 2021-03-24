package com.duxuewei.onjava.trans;

import lombok.Data;

import java.util.Date;

/**
 * desc.
 * @author zhangjiawei
 * @since 1.0.0
 */
@Data
public class DepositoryInfoNowDTO2 {
    private Long id;

    /**
     * 存管号
     */
    private String depositno;

    /**
     * 来源
     */
    private String source;

    /**
     * 客户端Id
     */
    private String clientid;

    /**
     * 客户Id
     */
    private String customerid;

    /**
     * 客户名称
     */
    private String customername;

    /**
     * 存管类型
     */
    private String deposittype;

    /**
     * 存管类型Code
     */
    private String deposittypecode;

    /**
     * 物品种类
     */
    private String itemtype;

    /**
     * 条形码
     */
    private String barcode;

    /**
     * 箱号
     */
    private String cartonno;

    /**
     * 仓库名称编码
     */
    private String warehousecode;

    /**
     * 仓库名称
     */
    private String warehouse;

    /**
     * 库位编码
     */
    private String locationcode;

    /**
     * 库位名称
     */
    private String locationname;

    /**
     * 档案存放位置
     */
    private String storageaddress;

    /**
     * 存管状态
     */
    private Short depositorystatus;

    /**
     * 入库时间
     */
    private Date instockdate;

    /**
     * 出库时间
     */
    private Date outstockdate;

    /**
     * 出库类型
     */
    private Short outstocktype;

    /**
     * 操作人Id
     */
    private String operatorid;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 创建人
     */
    private String createdbyid;

    /**
     * 创建时间
     */
    private Date createdat;

    /**
     * 更新人
     */
    private String updatedbyid;

    /**
     * 更新时间
     */
    private Date updatedat;

    /**
     * 删除人
     */
    private String deletedbyid;

    /**
     * 删除时间
     */
    private Date deletedat;

    /**
     * 是否删除：0否1是
     */
    private Boolean deleted;

    /**
     * json
     */
    private String jsonstring;
}
