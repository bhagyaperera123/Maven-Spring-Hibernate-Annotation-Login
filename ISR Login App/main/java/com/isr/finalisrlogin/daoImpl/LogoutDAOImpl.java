/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isr.finalisrlogin.daoImpl;

import com.isr.finalisrlogin.dao.LogoutDAO;
import com.isr.finalisrlogin.dbUtils.NewHibernateUtil;
import com.isr.finalisrlogin.entity.UserLoginDetail;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Bhagya Perera
 */
public class LogoutDAOImpl implements LogoutDAO {

    @Override
    public boolean logoutUser(HttpServletRequest httpServletRequest) {
        boolean exists = false;
        Logger logger = Logger.getLogger(LoginDAOImpl.class);
        HttpSession httpSession = httpServletRequest.getSession();
        try {
            Session session = NewHibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            int userId = Integer.parseInt(httpSession.getAttribute("ULID").toString());
            UserLoginDetail userLoginDetails = session.load(UserLoginDetail.class, userId);
            userLoginDetails.setOuttime(new Date());
            session.update(userLoginDetails);
            transaction.commit();
            session.close();
            exists = true;
            httpSession.invalidate();
        } catch (HibernateException e) {
            exists = false;
            logger.info("Threw a Exception in LogoutDAOImpl.logoutUser() Method :- ", e);
        }

        return exists;
    }

}
