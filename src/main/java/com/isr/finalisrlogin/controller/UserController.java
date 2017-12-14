/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isr.finalisrlogin.controller;

import com.isr.finalisrlogin.entity.User;
import com.isr.finalisrlogin.entity.UserLogin;
import com.isr.finalisrlogin.service.CreateUserService;
import com.isr.finalisrlogin.service.ExistsService;
import com.isr.finalisrlogin.service.LoginService;
import com.isr.finalisrlogin.service.LogoutService;
import com.isr.finalisrlogin.service.SaveLoginDetailsService;
import com.isr.finalisrlogin.serviceImpl.CreateUserServiceImpl;
import com.isr.finalisrlogin.serviceImpl.ExistsServiceImpl;
import com.isr.finalisrlogin.serviceImpl.LoginServiceImpl;
import com.isr.finalisrlogin.serviceImpl.LogoutServiceImpl;
import com.isr.finalisrlogin.serviceImpl.SaveLoginDetailsServiceImpl;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Bhagya Perera
 */
@Controller
public class UserController {

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        return "redirect:Login.jsp";
    }

    @RequestMapping(value = "userCheck", method = RequestMethod.POST)
    public String userCheck(ModelMap model, HttpServletRequest request) {
        String redirect = null;
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        com.isr.finalisrlogin.entity.UserLogin user = new com.isr.finalisrlogin.entity.UserLogin();
        user.setUsername(username);
        user.setPassword(Encryption.encrypt(password));
        LoginService loginService = new LoginServiceImpl();

        if (loginService.isAuthenticated(user, request)) {
            SaveLoginDetailsService saveLoginDetailsService = new SaveLoginDetailsServiceImpl();
            saveLoginDetailsService.saveLogin(request);
            redirect = "redirect:Home.jsp";
        } else {
            model.addAttribute("message", "worng");
            redirect = "redirect:Login.jsp";
        }

        return redirect;
    }

    @RequestMapping(value = "userLogout", method = RequestMethod.POST)
    public String userLogout(ModelMap model, HttpServletRequest request) {
        String redirect = null;

        LogoutService logoutService = new LogoutServiceImpl();

        if (logoutService.logoutUser(request)) {

            redirect = "redirect:Login.jsp";
        }
        return redirect;
    }

    @RequestMapping(value = "createUser", method = RequestMethod.POST)
    public String createUser(ModelMap model, HttpServletRequest request) {
        String redirect = null;

        CreateUserService createUserService = new CreateUserServiceImpl();
        User user = new User();
        UserLogin userLogin = new UserLogin();
        String firstName = request.getParameter("fnm");
        String lastName = request.getParameter("lnm");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String password = request.getParameter("pas");
        user.setFname(firstName);
        user.setLname(lastName);
        user.setEmail(email);
        user.setMobile(mobile);
        userLogin.setPassword(Encryption.encrypt(password));
        String service = createUserService.createUser(user, userLogin);
        if (service.equals("done")) {
            model.addAttribute("message", "success");
            redirect = "redirect:Home.jsp";
        } else {
            model.addAttribute("message", service);
            redirect = "redirect:Home.jsp";
        }
        return redirect;
    }
}
