package com.example.fabrikam.HotelCoupon.init;

import com.example.fabrikam.HotelCoupon.dao.CouponRepository;
import com.example.fabrikam.HotelCoupon.data.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
//import sun.misc.BASE64Encoder;
import java.util.Base64;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.*;

@Component
@Order(value=4)
public class InitCoupons implements CommandLineRunner {


    @Autowired
    private CouponRepository couponRepository;

    private Date[] getRandomFromTo(){
        int seed = 17;
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
            System.out.println("InitCoupons---------->"+str);
        }
        String[] addressLine1Array = new String[]{"12423 Main St","9020 Third Ave","555 Virginia St","9020 Third Ave","1922 Wilfred Ave","1923 Wilfred Ave","9020 Third Ave","230 Fifth Ave"};
        String[] addressLine2Array = new String[]{"Seattle, WA, 98101","Seattle, WA, 98101","Seattle, WA, 98101","Seattle, WA, 98101","Seattle, WA, 98101","Seattle, WA, 98101","Seattle, WA, 98101","Seattle, WA, 98101"};
        String[] companyNameArray = new String[]{"Fourth Coffee","Liberty Delightful Sinful Bakery & Café","Contoso","Liberty Delightful Sinful Bakery & Café","Alpine Ski House","Alpine Ski House","Liberty Delightful Sinful Bakery & Café","Northwind Traders"};
        String[] titleArray = new String[]{"Buy One Coffee, Get One Free","Buy Two Entrees, get $50 OFF","Unlimited Fries with every drink","25% OFF all baked goods","$200 OFF 3-night hotel stay","20% OFF Night Skiing passes","Buy One Dozen Cupcakes, Get 2 Free","50% OFF all sale merchandise"};

        String[] descriptionArray = new String[]{"Get your caffeine on at one of the best coffee houses in the city! Select from one of our 10 delicious house flavors.","Enjoy the best food the city has to offer! Enjoy two entrees today and receive a $50 discount off the total bill.","Can get enough fries? Order a drink and fries and enjoy unlimited refills on fries today!","Have you tried our famous croissants or our fresh muffins baked daily? Now get a 25% discount on any of our fresh baked goods today!","Luxury awaits you at the finest hotel in the city! Book a 3-night hotel stay with us and receive $200 off upon checking in.","Ski at the best local resort from 7pm-12am every night and enjoy the panaromic city views from the top! Purchase your night skiing pass today and receive 20% off your purchase.","Can't get enough cupcakes for your party? Enjoy the city's most delicious cupcakes and share the joy amongst your family and friends! Buy a dozen cupcakes today and get 2 more cupcakes free!","The latest trends in clothing doesn't have to be expensive - now enjoy 50% off all apparel already marked at a discount and stay stylish at modest prices!"};

        String[] imageNameArray = new String[]{
                "shutterstock_261745823@2x.png","shutterstock_219202168@2x.png","shutterstock_273398612@2x.png","shutterstock_441814081@2x.png","shutterstock_560973166@2x.png","shutterstock_530971099@2x.png","shutterstock_410864815@2x.png","shutterstock_453427750@2x.png"
        };
        String qrCodeImgName = "QRcode@2x.png";


        for(int i = 0;i<8;i++){
            Coupon newCoupon = new Coupon();
            newCoupon.setAddressLine1(addressLine1Array[i]);
            newCoupon.setAddressLine2(addressLine2Array[i]);
            newCoupon.setCompanyName(companyNameArray[i]);
            newCoupon.setDescription(descriptionArray[i]);
            int basicYear = 1900;
            Date[] fromTo = new Date[]{
                    new Date(2018-basicYear,6,16),
                    new Date(2019-basicYear,0,1)
            };
            newCoupon.setRedeemableFrom(fromTo[0]);
            newCoupon.setRedeemableTo(fromTo[1]);
            newCoupon.setImage(getBase64ImgString(imageNameArray[i]));
            newCoupon.setQrCodeImage(getBase64ImgString(qrCodeImgName));
            newCoupon.setTitle(titleArray[i]);

            if(couponRepository.findByTitle(titleArray[i]).isEmpty()) {
                couponRepository.save(newCoupon);
            }
        }
        System.out.println("Data is being initialized, init coupons............");
    }

    private String getBase64ImgString(String imageName)
    {
        String path = "/static/images/";
        String imgStr = "";
        BufferedImage image = null;
        try {
            image = ImageIO.read(getClass().getResource(path+imageName));
            imgStr = encodeToString(image,"png");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imgStr;
    }

    private String encodeToString(BufferedImage image, String type) {
        String imageString = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {
            ImageIO.write(image, type, bos);
            byte[] imageBytes = bos.toByteArray();

            imageString = encryptBASE64(imageBytes);

            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageString;
    }

    public static String encryptBASE64(byte[] data) {
        // BASE64Encoder encoder = new BASE64Encoder();
        // String encode = encoder.encode(data);
        Base64.Encoder encoder = Base64.getEncoder();
        String encode = encoder.encodeToString(data);
        return encode;
    }

}
