package com.duxuewei.onjava.trans;


import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class Demo {

    public static void main(String[] args) {

        Demo1 demo1 = new Demo1();
        demo1.setData1("1");
        demo1.setData2("2");
        demo1.setData3("3");
        /// Demo2 demo2 = new Demo2();
        /// demo2.setData2("2");
        /// demo2.setData3("3");
        /// demo2.setData4("4");
        String json = JSON.toJSONString(demo1);
        Demo2 demo2 = JSONObject.parseObject(json, Demo2.class);
        System.err.println(demo2);


        /*TbDepositoryinfo a1 = new TbDepositoryinfo();

        a1.setBarcode("123");
        a1.setCreatedat(DateUtil.date());
        System.err.println(a1);
        String o = JSON.toJSONString(a1);

        DepositoryInfoNowDTO2 dto = JSONObject.parseObject(o,DepositoryInfoNowDTO2.class);
        System.err.println(dto);*/

    }

}
