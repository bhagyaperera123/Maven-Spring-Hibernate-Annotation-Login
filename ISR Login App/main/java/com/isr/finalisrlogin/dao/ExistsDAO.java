/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isr.finalisrlogin.dao;

/**
 *
 * @author Bhagya Perera
 */
public interface ExistsDAO {
    public boolean isEmailExists(String email);
    public boolean isMobileExists(String mobile);
}
