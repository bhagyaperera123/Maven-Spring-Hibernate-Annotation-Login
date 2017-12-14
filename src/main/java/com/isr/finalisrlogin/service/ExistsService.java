/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isr.finalisrlogin.service;

/**
 *
 * @author Bhagya Perera
 */
public interface ExistsService {

    public boolean isEmailExists(String email);

    public boolean isMobileExists(String mobile);
}
