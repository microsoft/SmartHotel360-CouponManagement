package com.example.fabrikam.HotelCoupon.dao;

import com.example.fabrikam.HotelCoupon.data.RoomType;
import com.example.fabrikam.HotelCoupon.data.User;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;


public interface RoomTypeRepository extends CrudRepository<RoomType, Long> {
    /**
     * query room type by type name
     *
     * @param type name
     * @return
     */
    ArrayList<RoomType> findByTypeName(String typeName);

    @Override
    List<RoomType> findAll();
}