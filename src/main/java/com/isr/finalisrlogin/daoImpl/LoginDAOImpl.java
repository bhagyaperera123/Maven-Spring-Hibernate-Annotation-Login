/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isr.finalisrlogin.daoImpl;

import com.isr.finalisrlogin.dao.LoginDAO;
import com.isr.finalisrlogin.entity.UserLogin;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.apache.log4j.Logger;

/**
 *
 * @author Bhagya Perera
 */
public class LoginDAOImpl implements LoginDAO {

    @Override
    public boolean isAuthenticated(UserLogin userLogin, HttpServletRequest httpServletRequest) {
        boolean exists = false;
        Logger logger = Logger.getLogger(LoginDAOImpl.class);
        try {
            Session session = com.isr.finalisrlogin.dbUtils.NewHibernateUtil.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(com.isr.finalisrlogin.entity.UserLogin.class);
            criteria.add(Restrictions.eq("username", userLogin.getUsername()));
            criteria.add(Restrictions.eq("password", userLogin.getPassword()));

            com.isr.finalisrlogin.entity.UserLogin login = (com.isr.finalisrlogin.entity.UserLogin) criteria.uniqueResult();
            if (login != null) {
                exists = true;
                HttpSession httpSession = httpServletRequest.getSession();
                httpSession.setAttribute("UID", login.getUser().getIdUser());
                httpSession.setAttribute("NAME", login.getUser().getFname() + " " + login.getUser().getLname());
                httpSession.setAttribute("MOBILE", login.getUser().getMobile());
                httpSession.setAttribute("EMAIL", login.getUser().getEmail());
                httpSession.setAttribute("USERTYPE", login.getUserType().getIdUserType());
            }
            session.close();
        } catch (Exception e) {
            logger.info("Threw a Exception in LoginDAOImpl.isAuthenticated() Method :- ", e);
        }

        return exists;
    }

}
