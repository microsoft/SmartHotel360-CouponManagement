package com.example.fabrikam.HotelCoupon.dao;

import com.example.fabrikam.HotelCoupon.data.Coupon;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface CouponRepository extends CrudRepository<Coupon, Long> {
    ArrayList<Coupon> findByTitle(String title);

    @Override
    ArrayList<Coupon> findAll();
}
