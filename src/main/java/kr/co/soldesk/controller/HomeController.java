package kr.co.soldesk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.soldesk.beans.User;
import kr.co.soldesk.service.TestService;

@Controller
public class HomeController {

	@Autowired
	private TestService testService;
	
	
	@RequestMapping("/")
	public String home(Model model) {
	
		List<User> list = testService.allMember();
		
		model.addAttribute("memberList", list);
		model.addAttribute("user");
		
		return "index";
	}
	
	
	
}
