package com.example.fabrikam.HotelCoupon.controller;

import com.example.fabrikam.HotelCoupon.dao.GuestRepository;
import com.example.fabrikam.HotelCoupon.data.Guest;
import com.example.fabrikam.HotelCoupon.model.GuestListViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class GuestController {

    @Autowired
    private GuestRepository guestRepository;

    @RequestMapping("/guest")
    public String index(Model model, HttpServletRequest httpRequest) {
        ArrayList<Guest> guestList = guestRepository.findAll();
        model.addAttribute("guestsModel", new GuestListViewModel(guestList));
        return "guest";
    }
}
