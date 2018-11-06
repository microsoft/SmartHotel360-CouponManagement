package com.example.fabrikam.HotelCoupon.model;

import com.example.fabrikam.HotelCoupon.data.Coupon;
import com.example.fabrikam.HotelCoupon.data.Guest;

import javax.validation.Valid;
import java.util.ArrayList;

public class CouponListViewModel {
    @Valid
    private ArrayList<Coupon> couponList = new ArrayList<Coupon>();

    @Valid
    private Guest guest;

    public CouponListViewModel() {}

    public CouponListViewModel(ArrayList<Coupon> couponList, Guest guest) {
        this.couponList = couponList;
        this.guest = guest;
    }

    public ArrayList<Coupon> getCouponList() {
        return couponList;
    }
    public void setCouponList(ArrayList<Coupon> couponList) {
        this.couponList = couponList;
    }

    public Guest getGuest(){
        return guest;
    }
    public void setGuest(Guest guest){
        this.guest = guest;
    }
}
