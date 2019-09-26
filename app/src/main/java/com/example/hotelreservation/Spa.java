package com.example.hotelreservation;

public class Spa {
     String spaId;
     String roomNumber;
     String phoneNumber;
     String customerName;
     String spaType;
     String time;

    public Spa() {
    }

    public Spa(String spaId, String roomNumber, String phoneNumber, String customerName, String spaType, String time) {
        this.spaId = spaId;
        this.roomNumber = roomNumber;
        this.phoneNumber = phoneNumber;
        this.customerName = customerName;
        this.spaType = spaType;
        this.time = time;
    }

    public String getSpaId() {
        return spaId;
    }

    public void setSpaId(String spaId) {
        this.spaId = spaId;
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

    public String getSpaType() {
        return spaType;
    }

    public void setSpaType(String spaType) {
        this.spaType = spaType;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
