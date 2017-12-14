/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isr.finalisrlogin.dbUtils;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Bhagya Perera
 */
public class NewHibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        Logger logger = Logger.getLogger(NewHibernateUtil.class);
        try {
            StandardServiceRegistry standardRegistry
                    = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
            Metadata metaData = new MetadataSources(standardRegistry).getMetadataBuilder().build();
            sessionFactory = metaData.getSessionFactoryBuilder().build();
        } catch (Throwable th) {
            logger.info("Enitial SessionFactory creation failed", th);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
