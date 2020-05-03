package org.suyuesheng.spring.s03.pojo;

public class Address {
    private double xRay;
    private double yRay;

    public Address() {
    }

    public Address(double xRay, double yRay) {
        this.xRay = xRay;
        this.yRay = yRay;
    }

    public double getxRay() {
        return xRay;
    }

    public void setxRay(double xRay) {
        this.xRay = xRay;
    }

    public double getyRay() {
        return yRay;
    }

    public void setyRay(double yRay) {
        this.yRay = yRay;
    }

    @Override
    public String toString() {
        return "Address{" +
                "xRay=" + xRay +
                ", yRay=" + yRay +
                '}';
    }
}
