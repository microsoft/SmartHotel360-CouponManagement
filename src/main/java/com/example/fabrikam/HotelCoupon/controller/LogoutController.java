package com.example.fabrikam.HotelCoupon.controller;

import com.example.fabrikam.HotelCoupon.dao.UserRepository;
import com.example.fabrikam.HotelCoupon.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class LogoutController {

    @RequestMapping("/logout")
    public String login(HttpServletRequest httpRequest) {
        HttpSession session = httpRequest.getSession();
        User user=(User)session.getAttribute("user");
        if(null != user)
            session.removeAttribute("user");
        return "redirect:/";
    }
}
