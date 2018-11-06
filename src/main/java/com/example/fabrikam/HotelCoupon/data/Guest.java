package com.example.fabrikam.HotelCoupon.data;

import javax.persistence.*;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Guest {



    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private Date checkIn;
    private Date checkOut;
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "room_type")
    private RoomType roomType;

    private static final String guestDateFormat="MM/dd/yyyy";

    public Guest() {}

    public Guest(String firstName, String lastName,Date checkIn,Date checkOut,RoomType roomType) {
        this.firstName= firstName;
        this.lastName= lastName;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.roomType = roomType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName(){
        return this.firstName + " " + this.lastName;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckInDate(){
        Format formatter = new SimpleDateFormat(guestDateFormat);
        return formatter.format(checkIn);
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public String getCheckOutDate(){
        Format formatter = new SimpleDateFormat(guestDateFormat);
        return formatter.format(checkOut);
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }
}
