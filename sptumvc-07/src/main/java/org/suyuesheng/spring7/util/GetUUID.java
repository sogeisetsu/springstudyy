package org.suyuesheng.spring7.util;

import org.junit.Test;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class GetUUID {
    public static String getUUID(){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(UUID.randomUUID().toString().replaceAll("-", ""));
        stringBuffer.append(new Date().getTime());
        stringBuffer.append(new Random().nextInt(1000));
        return stringBuffer.toString();
    }
    @Test
    public void testUUID(){
        System.out.println(GetUUID.getUUID());
    }
}
