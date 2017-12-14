/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isr.finalisrlogin.serviceImpl;

import com.isr.finalisrlogin.dao.LogoutDAO;
import com.isr.finalisrlogin.daoImpl.LogoutDAOImpl;
import com.isr.finalisrlogin.service.LogoutService;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Bhagya Perera
 */
public class LogoutServiceImpl implements LogoutService {

    @Override
    public boolean logoutUser(HttpServletRequest httpServletRequest) {
        LogoutDAO logoutDAO = new LogoutDAOImpl();
        return logoutDAO.logoutUser(httpServletRequest);
    }

}
