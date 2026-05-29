package com.tricentis.demowebshop.models;

public class Address {
    private final String companyName;
    private final String country;
    private final String city;
    private final String address1;
    private final String address2;
    private final String zipPostalCode;
    private final String phoneNumber;
    private final String faxNumber;

    public Address(String companyName, String country, String city, String address1, String address2, String zipPostalCode, String phoneNumber, String faxNumber) {
        this.companyName = companyName;
        this.country = country;
        this.city = city;
        this.address1 = address1;
        this.address2 = address2;
        this.zipPostalCode = zipPostalCode;
        this.phoneNumber = phoneNumber;
        this.faxNumber = faxNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public String getZipPostalCode() {
        return zipPostalCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getFaxNumber() {
        return faxNumber;
    }
}
