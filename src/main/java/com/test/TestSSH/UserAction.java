package com.test.TestSSH;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.test.TestSSH.domain.User;
import com.test.TestSSH.service.UserManager;

/**
 * 
 * 
 * @author liudi
 */
public class UserAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(UserAction.class);

    private User user;
    private List<User> userList;

    @Autowired
    private UserManager userManager;

    @Override
    public String execute() throws Exception {
        userList = userManager.findAll();
        return SUCCESS;
    }

    public void detail() throws IOException {
        String id = ServletActionContext.getRequest().getParameter("id");
        user = userManager.get(Integer.valueOf(id));
        // AjaxUtil.ajaxJSONResponse(user);
        HttpServletResponse response = ServletActionContext.getResponse();
        PrintWriter out = response.getWriter();
        out.println("Hello " + user.getUserName());
    }
    
    public String load(){
        String id = ServletActionContext.getRequest().getParameter("id");
        user = userManager.load(Integer.valueOf(id));
        return SUCCESS;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
    
    
}
