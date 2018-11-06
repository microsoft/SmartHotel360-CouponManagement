package com.example.fabrikam.HotelCoupon.model;

import com.example.fabrikam.HotelCoupon.data.Guest;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

public class GuestListViewModel {
    @Valid
    private ArrayList<Guest> guestList = new ArrayList<Guest>();

    public GuestListViewModel() {}

    public GuestListViewModel(ArrayList<Guest> guestList) {
        this.guestList = guestList;
    }

    public ArrayList<Guest> getGuestList() {
        return guestList;
    }

    public void setGuestList(ArrayList<Guest> guestList) {
        this.guestList = guestList;
    }
}
