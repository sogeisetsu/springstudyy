package org.suyuesheng.spring.util;

import org.junit.Test;

import java.util.UUID;

public class IDUtil {
    public static String getID(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
