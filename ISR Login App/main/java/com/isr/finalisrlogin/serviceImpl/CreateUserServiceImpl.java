/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isr.finalisrlogin.serviceImpl;

import com.isr.finalisrlogin.dao.CreateUserDAO;
import com.isr.finalisrlogin.daoImpl.CreateUserDAOImpl;
import com.isr.finalisrlogin.entity.User;
import com.isr.finalisrlogin.entity.UserLogin;
import com.isr.finalisrlogin.service.CreateUserService;

/**
 *
 * @author Bhagya Perera
 */
public class CreateUserServiceImpl implements CreateUserService {

    @Override
    public String createUser(User user, UserLogin userLogin) {
        CreateUserDAO createUserDAO = new CreateUserDAOImpl();
        return createUserDAO.createUser(user, userLogin);
    }

}
