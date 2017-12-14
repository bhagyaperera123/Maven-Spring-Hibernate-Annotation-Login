/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isr.finalisrlogin.serviceImpl;

import com.isr.finalisrlogin.dao.ExistsDAO;
import com.isr.finalisrlogin.daoImpl.ExistsDAOImpl;
import com.isr.finalisrlogin.service.ExistsService;

/**
 *
 * @author Bhagya Perera
 */
public class ExistsServiceImpl implements ExistsService {

    @Override
    public boolean isEmailExists(String email) {
        ExistsDAO existsDAO = new ExistsDAOImpl();
        return existsDAO.isEmailExists(email);
    }

    @Override
    public boolean isMobileExists(String mobile) {
        ExistsDAO existsDAO = new ExistsDAOImpl();
        return existsDAO.isMobileExists(mobile);
    }

}
