package com.example.fabrikam.HotelCoupon.init;

import com.example.fabrikam.HotelCoupon.dao.GuestRepository;
import com.example.fabrikam.HotelCoupon.dao.RoomTypeRepository;
import com.example.fabrikam.HotelCoupon.data.Guest;
import com.example.fabrikam.HotelCoupon.data.RoomType;
import com.example.fabrikam.HotelCoupon.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;


/**
 * init db data
 */
@Component
@Order(value=3)
public class InitGuests implements CommandLineRunner{

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @Autowired
    private GuestRepository guestRepository;

    private List<RoomType> roomTypes;

    private Map<String,String> guestNames;

    private RoomType getRandomRoomType(){
        if(roomTypes==null || roomTypes.isEmpty()){
            roomTypes = roomTypeRepository.findAll();
        }
        if(roomTypes.isEmpty())
            return null;
        Random rand =new Random();
        int i;
        i=rand.nextInt(roomTypes.size());
        return roomTypes.get(i);
    }


    private Map<String,String> getGuestNames(){
        if(guestNames==null || guestNames.isEmpty()){
            String[] guestNameArray = new String[]{
                    "Sophie Stevenson",
                    "Louisa Lane",
                    "Jim McKenzie",
                    "Micheal Estrada",
                    "Bessie Swanson",
                    "Ray Garner",
                    "Jacob Powers"
            };
            guestNames = new HashMap<String,String>();
            for(String name : guestNameArray){
                String[] splitedName = name.split(" ");
                guestNames.put(splitedName[0],splitedName[1]);
            }
        }
        return guestNames;
    }

    private Date[] getRandomCheckInCheckOut(){
        int seed = 7;
        Random rand = new Random();
        int inDate = -1 * rand.nextInt(seed);
        int outDate = rand.nextInt(seed);
        Date dt = new Date();
        Date checkIn = calculateDate(dt,inDate);
        Date checkOut = calculateDate(dt,outDate);
        return new Date[]{checkIn,checkOut};
    }

    private Date calculateDate(Date dt,int diff){
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, diff);
        return c.getTime();
    }

    @Override
    public void run(String... args) throws Exception {
        for(String str : args){
            System.out.println("InitGuests---------->"+str);
        }
        System.out.println("Data is being initialized, init guests............");
        Map<String,String> mapGuestNames = getGuestNames();
        for (Map.Entry<String, String> entry : mapGuestNames.entrySet()) {
            String firstName = entry.getKey();
            String lastName = entry.getValue();
            Date[] checkInOut = getRandomCheckInCheckOut();
            Guest toAdd = new Guest(firstName,lastName,checkInOut[0],checkInOut[1],getRandomRoomType());
            if(guestRepository.findByFirstNameAndLastName(firstName,lastName).isEmpty()) {
                guestRepository.save(toAdd);
            }
        }
    }

}

