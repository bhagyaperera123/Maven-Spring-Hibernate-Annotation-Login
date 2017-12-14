/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isr.finalisrlogin.service;

import com.isr.finalisrlogin.entity.User;
import com.isr.finalisrlogin.entity.UserLogin;

/**
 *
 * @author Bhagya Perera
 */
public interface CreateUserService {

    public String createUser(User user, UserLogin userLogin);
}
