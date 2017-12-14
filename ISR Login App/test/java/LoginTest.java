/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.isr.finalisrlogin.controller.Encryption;
import com.isr.finalisrlogin.entity.UserLogin;
import com.isr.finalisrlogin.service.LoginService;
import com.isr.finalisrlogin.service.SaveLoginDetailsService;
import com.isr.finalisrlogin.serviceImpl.LoginServiceImpl;
import com.isr.finalisrlogin.serviceImpl.SaveLoginDetailsServiceImpl;
import org.springframework.mock.web.MockHttpServletRequest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author Bhagya Perera
 */
public class LoginTest {

    UserLogin userLogin;
    LoginService loginService;
    MockHttpServletRequest request;
    SaveLoginDetailsService saveLoginDetailsService;

    @BeforeTest
    public void setUp() {
        userLogin = new UserLogin();
        loginService = new LoginServiceImpl();
        request = new MockHttpServletRequest();
        saveLoginDetailsService = new SaveLoginDetailsServiceImpl();
    }

    @Test
    public void testCorrectDetails() {
        userLogin.setUsername("bhagya");
        userLogin.setPassword(Encryption.encrypt("abc1995"));
        Assert.assertEquals(loginService.isAuthenticated(userLogin, request), true);
        saveLoginDetailsService.saveLogin(request);
    }

    @Test
    public void testIncorrectUsername() {
        userLogin.setUsername("abchd");
        userLogin.setPassword(Encryption.encrypt("abc1995"));
        Assert.assertEquals(loginService.isAuthenticated(userLogin, request), false);
    }

    @Test
    public void testIncorrectPassword() {
        userLogin.setUsername("bhagya");
        userLogin.setPassword(Encryption.encrypt("abcdef"));
        Assert.assertEquals(loginService.isAuthenticated(userLogin, request), false);
    }

    @Test
    public void testEmptyParams() {
        userLogin.setUsername("");
        userLogin.setPassword(Encryption.encrypt(""));
        Assert.assertEquals(loginService.isAuthenticated(userLogin, request), false);
    }

}
