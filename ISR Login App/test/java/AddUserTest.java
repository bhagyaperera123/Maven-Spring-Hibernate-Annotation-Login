
import com.isr.finalisrlogin.controller.Encryption;
import com.isr.finalisrlogin.entity.User;
import com.isr.finalisrlogin.entity.UserLogin;
import com.isr.finalisrlogin.service.CreateUserService;
import com.isr.finalisrlogin.serviceImpl.CreateUserServiceImpl;
import org.springframework.mock.web.MockHttpServletRequest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/* *

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * @author Bhagya Perera
 */
public class AddUserTest {

    UserLogin userLogin;
    User user;
    MockHttpServletRequest request;
    CreateUserService createUserService;

    @BeforeTest
    public void setUp() {
        userLogin = new UserLogin();
        user = new User();
        request = new MockHttpServletRequest();
        createUserService = new CreateUserServiceImpl();
    }

    /**
     * add to here new email address and new phone number. 
     */
    @Test (priority = 1)
    public void testUserCreate() {
        user.setFname("abc");
        user.setLname("abc");
        user.setEmail("undertaker1@gmail.com");
        user.setMobile("0110864782");
        userLogin.setPassword("allinone123");
        userLogin.setUsername("abc2018");
        userLogin.setPassword(Encryption.encrypt("abcABC2018"));
        Assert.assertEquals(createUserService.createUser(user, userLogin), "done");

    }
    /**
     * this email address already exists in the database.
     */
    @Test
    public void testEmail() {
        user.setFname("abc");
        user.setLname("abc");
        user.setEmail("bhagyaperera142@gmail.com");
        user.setMobile("070632762");
        userLogin.setPassword("allinone123");
        userLogin.setUsername("abc2018");
        userLogin.setPassword(Encryption.encrypt("abc2018"));
        Assert.assertEquals(createUserService.createUser(user, userLogin), "email");

    }
    
    /**
     * this mobile number already exists in the database.
     */
    @Test
    public void testMobile() {
        user.setFname("abc");
        user.setLname("abc");
        user.setEmail("underTaker@gmail.com");
        user.setMobile("07041511904");
        userLogin.setPassword("allinone123");
        userLogin.setUsername("abc2018");
        userLogin.setPassword(Encryption.encrypt("abc2018"));
        Assert.assertEquals(createUserService.createUser(user, userLogin), "mobile");

    }

}
