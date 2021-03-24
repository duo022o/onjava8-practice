package com.duxuewei.onjava.trans;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 存管物品信息
 */
@Data
public class TbDepositoryinfo implements Serializable {

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
     * 渠道编码
     */
    private String channelcode;

    /**
     * 渠道名称
     */
    private String channelname;

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

    private String jsonnow;

    /**
     * 属性1
     */
    private String key1;

    /**
     * 属性2
     */
    private String key2;

    /**
     * 属性3
     */
    private String key3;

    /**
     * 属性4
     */
    private String key4;

    /**
     * 属性5
     */
    private String key5;

    /**
     * 属性6
     */
    private String key6;

    /**
     * 属性7
     */
    private String key7;

    /**
     * 属性8
     */
    private String key8;

    /**
     * 属性9
     */
    private String key9;

    /**
     * 属性10
     */
    private String key10;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "Id";

    public static final String COL_DEPOSITNO = "DepositNo";

    public static final String COL_SOURCE = "Source";

    public static final String COL_CLIENTID = "ClientId";

    public static final String COL_CUSTOMERID = "CustomerId";

    public static final String COL_CUSTOMERNAME = "CustomerName";

    public static final String COL_CHANNELCODE = "ChannelCode";

    public static final String COL_CHANNELNAME = "ChannelName";

    public static final String COL_DEPOSITTYPE = "DepositType";

    public static final String COL_DEPOSITTYPECODE = "DepositTypeCode";

    public static final String COL_ITEMTYPE = "ItemType";

    public static final String COL_BARCODE = "BarCode";

    public static final String COL_CARTONNO = "CartonNo";

    public static final String COL_WAREHOUSECODE = "WarehouseCode";

    public static final String COL_WAREHOUSE = "Warehouse";

    public static final String COL_LOCATIONCODE = "LocationCode";

    public static final String COL_LOCATIONNAME = "LocationName";

    public static final String COL_STORAGEADDRESS = "StorageAddress";

    public static final String COL_DEPOSITORYSTATUS = "DepositoryStatus";

    public static final String COL_INSTOCKDATE = "InStockDate";

    public static final String COL_OUTSTOCKDATE = "OutStockDate";

    public static final String COL_OUTSTOCKTYPE = "OutStockType";

    public static final String COL_OPERATORID = "OperatorId";

    public static final String COL_OPERATOR = "Operator";

    public static final String COL_CREATEDBYID = "CreatedById";

    public static final String COL_CREATEDAT = "CreatedAt";

    public static final String COL_UPDATEDBYID = "UpdatedById";

    public static final String COL_UPDATEDAT = "UpdatedAt";

    public static final String COL_DELETEDBYID = "DeletedById";

    public static final String COL_DELETEDAT = "DeletedAt";

    public static final String COL_DELETED = "Deleted";

    public static final String COL_JSONSTRING = "JsonString";

    public static final String COL_JSONNOW = "JsonNow";

    public static final String COL_KEY1 = "Key1";

    public static final String COL_KEY2 = "Key2";

    public static final String COL_KEY3 = "Key3";

    public static final String COL_KEY4 = "Key4";

    public static final String COL_KEY5 = "Key5";

    public static final String COL_KEY6 = "Key6";

    public static final String COL_KEY7 = "Key7";

    public static final String COL_KEY8 = "Key8";

    public static final String COL_KEY9 = "Key9";

    public static final String COL_KEY10 = "Key10";
}