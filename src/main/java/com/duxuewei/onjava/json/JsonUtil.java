package com.duxuewei.onjava.json;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

public class JsonUtil {
    //写文件
    public static String writeJsonfile(String content, String filePath){
        try {
            FileUtils.writeStringToFile(new File(filePath), content, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }
    //读取文件
    public static String readJsonFile( String filePath) {
        String content = null;
        try {
            content = FileUtils.readFileToString(new File(filePath), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
}