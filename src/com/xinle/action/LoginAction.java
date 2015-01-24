package com.xinle.action;

import javax.annotation.Resource;  
import javax.servlet.http.HttpServletRequest;  
 
import org.apache.struts2.ServletActionContext;  
import org.springframework.stereotype.Controller;  
 
import com.xinle.entity.User;  
import com.xinle.service.UserService;  
import com.opensymphony.xwork2.ActionSupport;  
 
@Controller  
public class LoginAction extends ActionSupport {  
 
   private static final long serialVersionUID = 1L;  
 
   @Resource  
   private UserService userService;  
     
   private String username;  
   private String password;  
     
   public String login(){  
         
       HttpServletRequest request = ServletActionContext.getRequest();  
       User user = userService.findUserByNameAndPassword(username, password);  
       if (user != null) {  
           request.setAttribute("username", username);  
           return SUCCESS;  
       } else {  
           return ERROR;  
       }  
             
   }  
   public String getUsername() {  
       return username;  
   }  
   public void setUsername(String username) {  
       this.username = username;  
   }  
   public String getPassword() {  
       return password;  
   }  
   public void setPassword(String password) {  
       this.password = password;  
   }  
     
}  