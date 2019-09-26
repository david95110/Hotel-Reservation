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

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getSpaType() {
        return spaType;
    }

    public String getTime() {
        return time;
    }
}
