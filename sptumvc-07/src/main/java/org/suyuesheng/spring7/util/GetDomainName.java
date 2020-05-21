package org.suyuesheng.spring7.util;

import org.junit.Test;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetDomainName {
    private String url;
    private int index;

    /**
     * 获取网络的根域名
     * @param url
     * @return
     */
    public static String getDomainName(String url){
        String pattern = "/(?!/)";
        Pattern compile = Pattern.compile(pattern);
        Matcher matcher = compile.matcher(url);
        ArrayList<Integer> list = new ArrayList<>();
        while (matcher.find()){
            list.add(matcher.start());
        }
        return url.substring(0, list.get(1)+1);
    }

    /**
     *根据 index 来返回几级域名<br/>
     * 如果 index为0，则返回顶级域名，如http://localhost:8080/。<br/>
     * 如果index大于url所包含的最大域名级数就返回url<br/>
     * @param url
     * @param index  域名的级别，0为顶级域名，以此类推。
     * @return
     */
    public static String getDomainName(String url,int index){
        String pattern = "/(?!/)";
        Pattern compile = Pattern.compile(pattern);
        Matcher matcher = compile.matcher(url);
        ArrayList<Integer> list = new ArrayList<>();
        while (matcher.find()){
            list.add(matcher.start());
        }
        try{
            if(index>=list.size()-1){
                return url;
            }else if (index<0){
                return null;
            }else {
                return url.substring(0, list.get(index+1)+1);
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    @Test
    public void testDomain(){
        System.out.println(GetDomainName.getDomainName("http://localhost:8080/test/session"));//http://localhost:8080/
        System.out.println(GetDomainName.getDomainName("http://localhost:8080/test/session/", 3)); //http://localhost:8080/test/session/
    }
}
