package com.duxuewei.onjava.annotation;

// annotations/PasswordUtils.java
import java.util.*;

/**
 * [测试UserCase]
 * @Author: [Du Xue wei]
 * @CreateDate: [2020-07-8, 周三, 16:3]
 * @Version: [v1.0.0]
 */
public class PasswordUtils {
    @UseCase(id = 47, description =
            "Passwords must contain at least one numeric")
    public boolean validatePassword(String passwd) {
        return (passwd.matches("\\w*\\d\\w*"));
    }
    @UseCase(id = 48)
    public String encryptPassword(String passwd) {
        return new StringBuilder(passwd)
                .reverse().toString();
    }
    @UseCase(id = 49, description =
            "New passwords can't equal previously used ones")
    public boolean checkForNewPassword(
            List<String> prevPasswords, String passwd) {
        return !prevPasswords.contains(passwd);
    }
}
