/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isr.finalisrlogin.service;

import com.isr.finalisrlogin.entity.UserLogin;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Bhagya Perera
 */
public interface LoginService {

    public boolean isAuthenticated(UserLogin userLogin, HttpServletRequest httpServletRequest);
}
