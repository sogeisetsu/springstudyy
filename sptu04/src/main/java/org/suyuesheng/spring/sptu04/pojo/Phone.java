package org.suyuesheng.spring.sptu04.pojo;


public class Phone {
    public Phone() {
    }

    private String phoneBrand;

    public String getPhoneBrand() {
        return phoneBrand;
    }

    public void setPhoneBrand(String phoneBrand) {
        this.phoneBrand = phoneBrand;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "phoneBrand='" + phoneBrand + '\'' +
                '}';
    }
}
