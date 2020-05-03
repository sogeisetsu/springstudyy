package org.suyuesheng.spring.sptu04.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

public class Person {

    public Person() {
    }

    public Person(Address address, Phone phone) {
        this.address = address;
        this.phone = phone;
    }
//    @Autowired
//    @Qualifier("address001")
    @Resource(name = "address001")
    private Address address;
    @Resource
    private Phone phone;


    public Address getAddress() {
        return address;
    }

    public Phone getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "address=" + address +
                ", phone=" + phone +
                '}';
    }
}
