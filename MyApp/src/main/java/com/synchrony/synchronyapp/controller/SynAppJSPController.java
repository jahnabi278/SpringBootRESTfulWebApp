package com.synchrony.synchronyapp.controller;

import org.springframework.beans.factory.annotation.Autowired;

import java.security.Principal;
import java.util.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.synchrony.synchronyapp.logger.Logger;
import com.synchrony.synchronyapp.model.SynchronyUser;
import com.synchrony.synchronyapp.repo.SynchoronyJSPRepository;

@Controller
public class SynAppJSPController {

	@Autowired
	SynchoronyJSPRepository synRepo;

	@RequestMapping("/")
	public String home() {
		Logger.info("Index page ......");
		return "home.jsp";
	}
	
	@RequestMapping("/addSynUser")
	public String addSynUser(SynchronyUser user) {
		synRepo.save(user);
		Logger.info("User created");
		return "home.jsp";
	}
	@RequestMapping("/validateUser")
	public ModelAndView validateUser(@RequestParam String userName, @RequestParam String passWord) {
		ModelAndView mv = new ModelAndView("login.jsp");
		SynchronyUser user = synRepo.findById(userName).get();
		if (user.getPassWord().equals(passWord)) {
			return mv;
		}
		return new ModelAndView("faillogin.jsp");

	}
	@RequestMapping("/getUser")
	public ModelAndView getUser(@RequestParam String userName) {
		ModelAndView mv = new ModelAndView("showuser.jsp");
		SynchronyUser user = synRepo.findById(userName).orElse(new SynchronyUser());
		return mv.addObject(user);
	}
	
	@GetMapping("/users")
    public String showUsers(Model model) {
      List<SynchronyUser> users = new ArrayList<>();
      synRepo.findAll().forEach(users::add);
        model.addAttribute("users", users);
        return "users.jsp"; // maps to users.jsp
    }

	@RequestMapping("user")
	@ResponseBody
	public Principal user(Principal principal) {
		return principal;
	}
	
}
