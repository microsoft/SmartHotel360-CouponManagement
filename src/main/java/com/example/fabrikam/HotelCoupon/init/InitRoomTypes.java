package com.example.fabrikam.HotelCoupon.init;

import com.example.fabrikam.HotelCoupon.dao.RoomTypeRepository;
import com.example.fabrikam.HotelCoupon.data.RoomType;
import com.example.fabrikam.HotelCoupon.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


/**
 * init db data
 */
@Component
@Order(value=2)
public class InitRoomTypes implements CommandLineRunner {

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @Override
    public void run(String... args) throws Exception {
        for(String str : args){
            System.out.println("InitRoomTypes---------->"+str);
        }
        String[] roomTypesArray = new String[]{"Executive","Junior Suite","Harbor View","Garden View","Penthouse"};
        for (String roomTypeName : roomTypesArray) {
            if(roomTypeRepository.findByTypeName(roomTypeName).isEmpty()){
                roomTypeRepository.save(new RoomType(roomTypeName));
            }
        }
        System.out.println("Data is being initialized, init room types............");
    }

}
