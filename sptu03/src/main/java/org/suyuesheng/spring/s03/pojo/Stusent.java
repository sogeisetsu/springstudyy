package org.suyuesheng.spring.s03.pojo;

import java.util.*;

public class Stusent {
    private int age;
    private Address address;
    private Map<String,String> studentMap;
    private List<String> stringList;
    private String[] strings;
    private Properties properties;
    private Set<String> stringSet;

    public Stusent() {
    }

    public Stusent(int age, Address address, Map<String, String> studentMap, List<String> stringList, String[] strings, Properties properties, Set<String> stringSet) {
        this.age = age;
        this.address = address;
        this.studentMap = studentMap;
        this.stringList = stringList;
        this.strings = strings;
        this.properties = properties;
        this.stringSet = stringSet;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Map<String, String> getStudentMap() {
        return studentMap;
    }

    public void setStudentMap(Map<String, String> studentMap) {
        this.studentMap = studentMap;
    }

    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public String[] getStrings() {
        return strings;
    }

    public void setStrings(String[] strings) {
        this.strings = strings;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Set<String> getStringSet() {
        return stringSet;
    }

    public void setStringSet(Set<String> stringSet) {
        this.stringSet = stringSet;
    }

    @Override
    public String toString() {
        return "Stusent{" +
                "age=" + age +
                ", address=" + address +
                ", studentMap=" + studentMap +
                ", stringList=" + stringList +
                ", strings=" + Arrays.toString(strings) +
                ", properties=" + properties +
                ", stringSet=" + stringSet +
                '}';
    }
}
