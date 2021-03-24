package com.duxuewei.onjava.excel;

import cn.hutool.core.io.FileUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @apiNote 处理Excel
 * @since 2021/2/2 10:22
 * @author Duxuewei
 * @version v1.0.0
 */
public class ParseExcel {
    private static List<String> nameList = new ArrayList<>();
    private static String namep = "";
    public static void main(String[] args) {
        String path = "E:\\workspace\\studying\\onjava8\\src\\main\\java\\com\\duxuewei\\onjava\\excel\\data.xlsx";
        ExcelReader reader = ExcelUtil.getReader(FileUtil.file(path));
        List<Map<String, Object>> maps = reader.readAll();
        List<Map<String, String>> newmaps = new ArrayList<>();
        for (Map<String, Object> map:maps) {
            Map<String,String> newMap = new HashMap<>();
            String target = String.valueOf(map.get("target"));
            if (target.trim().startsWith("@")) {
                String name = target.trim().replaceAll("@", "");
                newMap.put("name",name);
                target = String.valueOf(map.get("other"));
            } else {
                // newMap.put("name",namep);
            }

            if (StringUtils.isBlank(target) || "null".equals(target)) {
                target = String.valueOf(map.get("other"));
                if (StringUtils.isBlank(target)) {
                    System.err.println(target);
                }
            }
            String[] split = target.trim().split("\\s+");
            ArrayList<String> strings = new ArrayList<>(Arrays.asList(split));
            ///System.err.println(strings);
            List<String> reverse = reverse(strings);
            ///System.err.println(reverse);
            Map<String,String> news = new HashMap<>();
            String format = "";
            String date = "";
            if (reverse.size()>=4) {
                String date1 = reverse.get(2);
                String date2 = reverse.get(1);
                String sc = reverse.get(0);
                reverse.remove(0);
                reverse.remove(0);
                reverse.remove(0);
                List<String> reverse1 = reverse(reverse);
                format = String.format("%s至%s，%s  %s", formdate(date1), formdate(date2), reverse1.toString(), formsc(sc));
                date = date1;
            } else {
                format = strings.toString();
            }
            format = format.replace("[", "");
            format = format.replace("]", "");
            System.err.println(format);
            newMap.put("value",format);
            newMap.put("date",date);
            newmaps.add(newMap);
        }
        System.err.println(newmaps.size());

        // newmaps = order(newmaps);

        eportExcel(newmaps);

    }

    private static String formsc(String sc) {
        String[] split = sc.split("\\.");
        String s = split[0];
        return String.format("（%s学时）",s);
    }

    private static List<Map<String, String>> order(List<Map<String, String>> newmaps) {
        List<Map<String, String>> newmaps2 = new ArrayList<>();
        for(String name :nameList) {
            List<String> l = new ArrayList<>();
            for(Map<String, String> map :newmaps) {
                String names = map.get("name");
                if (name.equals(names)) {
                    l.add(map.get("value"));
                }
            }
            Collections.sort(l);
            for (int i = 0; i < l.size(); i++) {
                Map<String, String> map = new HashMap<>();
                map.put("name",name);
                map.put("value",l.get(0));
                newmaps2.add(map);
            }
        }
        return newmaps2;
    }


    private static void eportExcel(List<Map<String, String>> newmaps) {
        // 通过工具类创建writer
        ExcelWriter writer = ExcelUtil.getWriter("E:\\workspace\\studying\\onjava8\\src\\main\\java\\com\\duxuewei\\onjava\\excel\\data2.xlsx");
        // 合并单元格后的标题行，使用默认标题样式
        // writer.merge(newmaps.size() - 1, "数据");
        // 一次性写出内容，使用默认样式，强制输出标题
        writer.write(newmaps, true);
        // 关闭writer，释放内存
        writer.close();
    }

    private static String formdate(String date) {
        String[] split = date.split("-");
        return String.format("%s年%s月%s日",split[0],split[1],split[2]);
    }

    private static <T> List<T> reverse(List<T> strings) {
        List<T> news = new ArrayList<>(strings.size());
        for (int i = strings.size()-1; i >=0; i--) {
            news.add(strings.get(i));
        }
        return news;
    }

    public static void main2(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 5, 3, 2, 5);
        reverse(integers);

    }

}
