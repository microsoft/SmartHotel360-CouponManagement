package com.example.fabrikam.HotelCoupon.dao;

import com.example.fabrikam.HotelCoupon.data.Guest;
import com.example.fabrikam.HotelCoupon.data.RoomType;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface GuestRepository extends CrudRepository<Guest, Long> {

    @Override
    ArrayList<Guest> findAll();

    List<Guest> findByFirstNameAndLastName(String firstName,String lastName);

}
