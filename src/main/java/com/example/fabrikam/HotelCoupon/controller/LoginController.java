package com.example.fabrikam.HotelCoupon.controller;

import com.example.fabrikam.HotelCoupon.dao.UserRepository;
import com.example.fabrikam.HotelCoupon.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;

@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    private UserRepository repository;

    private static final String loginState="loginState";
    private static final String loginStateParam = "loginStateStr";


    @RequestMapping("/")
    public String index(Model model, String loginStateStr) {
        model.addAttribute("loginUser", new User());
        boolean state = true;
        if(null!=loginStateStr && loginStateStr.equalsIgnoreCase("false"))
            state = false;
        model.addAttribute(loginState,state);
        return "login";
    }

    @RequestMapping("/formPost")
    public ModelAndView login(User user, Model model, HttpServletRequest httpRequest) {
        new ModelAndView("redirect:/user/list?success=true");
        ModelAndView failedUrl = new ModelAndView("redirect:/?"+loginStateParam+"=false");
        ModelAndView successUrl = new ModelAndView("redirect:/guest");
        String username = user.getUsername();
        String password = user.getPassword();
        if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
            return failedUrl;
        }
        ArrayList<User> searchedUsers = repository.findByUsername(username);
        if(searchedUsers.isEmpty()){
            return failedUrl;
        }
        for (User item : searchedUsers){
            if(item.getPassword().equalsIgnoreCase(password)){
                System.out.println("Login successfully.");
                httpRequest.getSession().setAttribute("user",user);
                return successUrl;
            }
        }
        return failedUrl;
    }
}
