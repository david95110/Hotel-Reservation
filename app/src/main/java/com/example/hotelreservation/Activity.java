package com.example.hotelreservation;

public class Activity {

    private String serviceId;
    private String roomNumber;
    private String phoneNumber;
    private String customerName;
    private String activity;
    private String time;

    public Activity() {
    }

    public Activity(String serviceId, String roomNumber, String phoneNumber, String customerName, String activity, String time) {
        this.serviceId = serviceId;
        this.roomNumber = roomNumber;
        this.phoneNumber = phoneNumber;
        this.customerName = customerName;
        this.activity = activity;
        this.time = time;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
