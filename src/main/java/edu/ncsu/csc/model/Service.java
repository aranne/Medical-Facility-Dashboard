package edu.ncsu.csc.model;

public class Service {
    private String serviceCode;
    private String name;

    public Service() {
    }

    public Service(String serviceCode, String name) {
        this.serviceCode = serviceCode;
        this.name = name;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
