/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isr.finalisrlogin.serviceImpl;

import com.isr.finalisrlogin.dao.LoginDAO;
import com.isr.finalisrlogin.daoImpl.LoginDAOImpl;
import com.isr.finalisrlogin.entity.UserLogin;
import com.isr.finalisrlogin.service.LoginService;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Bhagya Perera
 */
public class LoginServiceImpl implements LoginService {

    @Override
    public boolean isAuthenticated(UserLogin userLogin,HttpServletRequest httpServletRequest) {
        LoginDAO loginDAO = new LoginDAOImpl();
        return loginDAO.isAuthenticated(userLogin,httpServletRequest);
    }
}
