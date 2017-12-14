/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isr.finalisrlogin.service;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Bhagya Perera
 */
public interface SaveLoginDetailsService {

    public boolean saveLogin(HttpServletRequest httpServletRequest);
}
