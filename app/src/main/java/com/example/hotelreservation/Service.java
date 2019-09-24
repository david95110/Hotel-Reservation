package com.example.hotelreservation;

public class Service {

    private String serviceId;
    private String customerName;
    private String roomNumber;
    private String phoneNumber;
    private String time;
    private String serviceType;

    public Service() {

    }

    public Service(String serviceId, String customerName, String roomNumber, String phoneNumber, String time, String spinnerser){
        this.serviceId=serviceId;
        this.customerName=customerName;
        this.roomNumber=roomNumber;
        this.phoneNumber=phoneNumber;
        this.time=time;
        this.serviceType=spinnerser;
    }



    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSpinnerser() {
        return serviceType;
    }

    public void setSpinnerser(String spinnerser) {
        this.serviceType = spinnerser;
    }
}
