package com.duxuewei.onjava.excel;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @apiNote 导出Excel
 * @since 2021/2/2 11:45
 * @author Duxuewei
 * @version v1.0.0
 */
public class ParseExcel2 {

    public static void main(String[] args) {
        String path = "E:\\workspace\\studying\\onjava8\\src\\main\\java\\com\\duxuewei\\onjava\\excel\\ab.xlsx";
        ExcelReader reader = ExcelUtil.getReader(FileUtil.file(path));
        List<Map<String, Object>> maps = reader.readAll();
        List<String> olds = new ArrayList<>();
        List<String> news = new ArrayList<>();
        // 新的中没有的
        List<String> olds2 = new ArrayList<>();
        // 旧的中没有的
        List<String> news2 = new ArrayList<>();
        maps.stream().forEach(map->{
            String a = toStringOrNull(map.get("a"));
            String b = toStringOrNull(map.get("b"));
            if (a!=null) {
                olds.add(a);
            }
            if (b!=null) {
                news.add(b);
            }
        });

        olds.stream().forEach(e->{
            if (!news.contains(e)) {
                olds2.add(e);
            }
        });

        news.stream().forEach(e->{
            if (!olds.contains(e)) {
                news2.add(e);
            }
        });
        System.err.println("新的中没有的");
        System.err.println(JSON.toJSONString(olds2));
        System.err.println("旧的中没有的");
        System.err.println(JSON.toJSONString(news2));

    }

    public static String toStringOrNull(Object o) {
        if (o==null) {
            return null;
        } else {
          return String.valueOf(o);
        }
    }
}
