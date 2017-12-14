/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isr.finalisrlogin.daoImpl;

import com.isr.finalisrlogin.dao.CreateUserDAO;
import com.isr.finalisrlogin.dbUtils.NewHibernateUtil;
import com.isr.finalisrlogin.entity.User;
import com.isr.finalisrlogin.entity.UserLogin;
import com.isr.finalisrlogin.entity.UserType;
import com.isr.finalisrlogin.service.ExistsService;
import com.isr.finalisrlogin.serviceImpl.ExistsServiceImpl;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Bhagya Perera
 */
public class CreateUserDAOImpl implements CreateUserDAO {

    @Override
    public String createUser(User userDetails, UserLogin userLogin) {
        String message = "";
        Logger logger = Logger.getLogger(LoginDAOImpl.class);
        try {
            try (Session session = NewHibernateUtil.getSessionFactory().openSession()) {

                ExistsService existsService = new ExistsServiceImpl();
                if (existsService.isEmailExists(userDetails.getEmail())) {
                    message = "email";
                } else {
                    if (existsService.isMobileExists(userDetails.getMobile())) {
                        message = "mobile";
                    } else {
                        Transaction transaction = session.beginTransaction();
                        UserType userType = session.load(UserType.class, 2);
                        User user = new User();
                        user.setFname(userDetails.getFname());
                        user.setLname(userDetails.getLname());
                        user.setEmail(userDetails.getEmail());
                        user.setMobile(userDetails.getMobile());

                        UserLogin userLog = new UserLogin();
                        userLog.setUser(user);
                        userLog.setUsername(userDetails.getEmail());
                        userLog.setPassword(userLogin.getPassword());
                        userLog.setStatus(1);
                        userLog.setUserType(userType);

                        session.save(user);
                        session.save(userLog);
                        transaction.commit();
                        message = "done";
                    }
                }

            }

        } catch (Exception e) {
            logger.error("Threw a Exception in CreateUserDAOImpl.createUser() Method :- ", e);
        }
        return message;
    }

}
