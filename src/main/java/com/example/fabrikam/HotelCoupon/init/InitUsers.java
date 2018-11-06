package com.example.fabrikam.HotelCoupon.init;

import com.example.fabrikam.HotelCoupon.data.User;
import com.example.fabrikam.HotelCoupon.dao.UserRepository;
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
@Order(value=1)
public class InitUsers implements CommandLineRunner{


    @Autowired
    private UserRepository repository;

    @Override
    public void run(String... args) throws Exception {
        for(String str : args){
            System.out.println("InitUsers---------->"+str);
        }
        System.out.println("Data is being initialized, init users............");
        Map<String,String> mapUsers = new HashMap<String, String>(){{
            put("admin","pass");
            put("me@smarthotel360.com","1234");
        }};
        for (Map.Entry<String, String> entry : mapUsers.entrySet()) {
            String username = entry.getKey();
            String password = entry.getValue();
            if(repository.findByUsername(username).isEmpty()){
                repository.save(new User(username,password));
            }
        }
    }

}

