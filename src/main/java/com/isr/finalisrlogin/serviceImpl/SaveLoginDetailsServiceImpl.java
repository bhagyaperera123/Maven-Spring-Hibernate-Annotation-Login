/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isr.finalisrlogin.serviceImpl;

import com.isr.finalisrlogin.dao.SaveLoginDetailsDAO;
import com.isr.finalisrlogin.daoImpl.SaveLoginDetailsDAOImpl;
import com.isr.finalisrlogin.service.SaveLoginDetailsService;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Bhagya Perera
 */
public class SaveLoginDetailsServiceImpl implements SaveLoginDetailsService {

    @Override
    public boolean saveLogin(HttpServletRequest httpServletRequest) {
        SaveLoginDetailsDAO saveLoginDetailsDAO = new SaveLoginDetailsDAOImpl();
        return saveLoginDetailsDAO.saveLogin(httpServletRequest);
    }

}
