package com.company;

public class Location {
    private double latitude;
    private double longitude;
    private String phone;
    private String address;

    public Location(double latitude, double longitude, String phone, String address) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.phone = phone;
        this.address = address;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Location{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
