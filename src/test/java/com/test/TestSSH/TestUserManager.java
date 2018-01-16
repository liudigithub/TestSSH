package com.test.TestSSH;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.test.TestSSH.domain.User;
import com.test.TestSSH.service.UserManager;

/**
 * 
 * 
 * @author liudi
 * @date 2018��1��16��
 */
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = {  
        "classpath:spring.xml",  
        "classpath:spring-hibernate.xml"  
})
public class TestUserManager {
    private static final Logger LOGGER = Logger.getLogger(TestUserManager.class);  
    @Autowired  
    UserManager userManager;  
      
    @Test  
    public void save() {  
        User user = new User();  
        user.setUserName("liudi223332");  
        user.setPassword("12345622332");  
        user.setGender(0);  
        userManager.save(user);  
//        JSON.toJSONString(id);  
    }  
}
