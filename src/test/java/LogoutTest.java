
import com.isr.finalisrlogin.controller.Encryption;
import com.isr.finalisrlogin.entity.UserLogin;
import com.isr.finalisrlogin.service.LoginService;
import com.isr.finalisrlogin.service.LogoutService;
import com.isr.finalisrlogin.service.SaveLoginDetailsService;
import com.isr.finalisrlogin.serviceImpl.LoginServiceImpl;
import com.isr.finalisrlogin.serviceImpl.LogoutServiceImpl;
import com.isr.finalisrlogin.serviceImpl.SaveLoginDetailsServiceImpl;
import org.springframework.mock.web.MockHttpServletRequest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Bhagya Perera
 */
public class LogoutTest {

    LogoutService logoutService;
    MockHttpServletRequest request;
    SaveLoginDetailsService saveLoginDetailsService;
    UserLogin userLogin;
    LoginService loginService;

    @BeforeTest
    public void setUp() {
        logoutService = new LogoutServiceImpl();
        request = new MockHttpServletRequest();
        saveLoginDetailsService = new SaveLoginDetailsServiceImpl();
        userLogin = new UserLogin();
        loginService = new LoginServiceImpl();
    }

    @Test(priority = 1)
    public void testUseeLogin() {
        userLogin.setUsername("bhagya");
        userLogin.setPassword(Encryption.encrypt("abc1995"));
        Assert.assertEquals(loginService.isAuthenticated(userLogin, request), true);
        saveLoginDetailsService.saveLogin(request);
    }

    @Test(priority = 2)
    public void testUserLogout() {
        Assert.assertEquals(logoutService.logoutUser(request), true);
        
    }

}
