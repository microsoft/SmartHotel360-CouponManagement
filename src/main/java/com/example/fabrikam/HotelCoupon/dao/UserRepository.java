package com.example.fabrikam.HotelCoupon.dao;

import com.example.fabrikam.HotelCoupon.data.User;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;


public interface UserRepository extends CrudRepository<User, Long> {
    /**
     * query user by username
     *
     * @param username
     * @return
     */
    ArrayList<User> findByUsername(String username);

}
