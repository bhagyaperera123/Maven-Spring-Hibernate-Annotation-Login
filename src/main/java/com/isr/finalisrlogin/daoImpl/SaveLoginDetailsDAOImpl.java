/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isr.finalisrlogin.daoImpl;

import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import com.isr.finalisrlogin.dao.SaveLoginDetailsDAO;
import com.isr.finalisrlogin.dbUtils.NewHibernateUtil;
import com.isr.finalisrlogin.entity.User;
import com.isr.finalisrlogin.entity.UserLoginDetail;
import eu.bitwalker.useragentutils.UserAgent;
import java.util.Date;
import javax.servlet.http.HttpSession;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Bhagya Perera
 */
public class SaveLoginDetailsDAOImpl implements SaveLoginDetailsDAO {

    @Override
    public boolean saveLogin(HttpServletRequest httpServletRequest) {
        boolean exists = false;
        Logger logger = Logger.getLogger(LoginDAOImpl.class);
        HttpSession httpSession = httpServletRequest.getSession();
        try {

            String remoteAddress = httpServletRequest.getHeader("X-FORWARDED-FOR");
            if (remoteAddress == null || "".equals(remoteAddress)) {
                remoteAddress = httpServletRequest.getRemoteAddr();
            }
            Session session = NewHibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            UserAgent userAgent = UserAgent.parseUserAgentString(httpServletRequest.getHeader("User-Agent"));
            UserLoginDetail userLoginDetails = new UserLoginDetail();
            User user = session.load(User.class, Integer.parseInt(httpSession.getAttribute("UID").toString()));

            userLoginDetails.setUser(user);
            userLoginDetails.setIntime(new Date());
            userLoginDetails.setIpaddress(remoteAddress);
            userLoginDetails.setBrowserdetails(userAgent.getBrowser().getName());
            userLoginDetails.setOperatingsystem(userAgent.getOperatingSystem().getName());
            session.save(userLoginDetails);
            transaction.commit();
            session.close();
            exists = true;

            httpSession.setAttribute("ULID", userLoginDetails.getIdUserLoginDetail());

        } catch (HibernateException e) {
            exists = false;
            logger.info("Threw a Exception in SaveLoginDetailsImpl.saveLogin() Method :- ", e);
        }
        return exists;
    }

}
