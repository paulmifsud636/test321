package com.project;

import java.sql.SQLException;
import java.util.Objects;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class LoginController 
{
	@Autowired
    private LoginService loginService; 
	
	@Autowired
	private MyRepo repo;

	@GetMapping("/login")  
    public ModelAndView login() {
     ModelAndView mv = new ModelAndView("login");
        mv.addObject("user", new Login());
        return mv;
    }
 
    @PostMapping("/login")
    public String login(@ModelAttribute("user") Login user ) throws SQLException {    
    	Login webUser = loginService.login(user.getUsername(), user.getPassword());
     		if(Objects.nonNull(webUser))
     		{ 
     			return "redirect:/";
     		} 
     		else 
     		{
     			return "redirect:/login";  
     		}
    }
   
    @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
    public String logoutDo(HttpServletRequest request,HttpServletResponse response)
    {
           return "redirect:/login";
    }
    
    @RequestMapping("/change")
    public String change() 
    {
    	String username="admin";
  		Optional<Login> optionalLogin = repo.findByUsername(username);
  		Login login = optionalLogin.get();
  		login.setPassword("Pass&123");
  		repo.save(login);	 	
    	return "redirect:/login";
    }
}
