/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isr.finalisrlogin.daoImpl;

import com.isr.finalisrlogin.dbUtils.NewHibernateUtil;
import com.isr.finalisrlogin.entity.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import com.isr.finalisrlogin.dao.ExistsDAO;
import org.apache.log4j.Logger;

/**
 *
 * @author Bhagya Perera
 */
public class ExistsDAOImpl implements ExistsDAO {

    private final Logger logger = Logger.getLogger(ExistsDAOImpl.class);

    @Override
    public boolean isEmailExists(String email) {
        boolean returnValue = false;
        try {
            Session session = NewHibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(User.class);
            criteria.add(Restrictions.eq("email", email));
            User user = (User) criteria.uniqueResult();
            if (user != null) {
                returnValue = true;
            }
            session.close();
        } catch (Exception e) {
            logger.info("Threw a Exception in ExistsDAOImpl.isEmailExists() Method :- ", e);
        }

        return returnValue;
    }

    @Override
    public boolean isMobileExists(String mobile) {
        boolean returnValue = false;
        try {
            Session session = NewHibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(User.class);
            criteria.add(Restrictions.eq("mobile", mobile));
            User user = (User) criteria.uniqueResult();
            if (user != null) {
                returnValue = true;
            }
            session.close();

        } catch (Exception e) {
            logger.info("Threw a Exception in ExistsDAOImpl.isMobileExists() Method :- ", e);
        }
        return returnValue;
    }

}
