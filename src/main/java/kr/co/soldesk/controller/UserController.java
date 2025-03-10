package kr.co.soldesk.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.soldesk.beans.User;
import kr.co.soldesk.service.TestService;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private TestService testService;

	@GetMapping("/home")
	public String home() {
		return "redirect:/";
	}
	
	//회원가입 페이지
	@GetMapping("/join")
	public String join(@ModelAttribute User user) {
		return "user/join";
	}
	//로그인 페이지
	@GetMapping("/login")
	public String login(@ModelAttribute User user) {
		return "user/login";
	}
	//회원가입
	@PostMapping("/join_pro")
	public String join_pro(@Valid User user, BindingResult result) {
		if (result.hasErrors()) {
			return "user/join";
		}
		testService.insert_data(user);

		return "redirect:/";
	}
	//로그인
	@PostMapping("/login_pro")
	public String login_pro(@ModelAttribute User user, HttpSession session) {
	    try {
	        boolean result = testService.login(user);
	        if(result) {
	            // 로그인 성공시 세션에 사용자 정보 저장
	            session.setAttribute("user", user);
	            return "redirect:/";
	        }
	    } catch(Exception e) {
	        // 로그인 실패시
	    }
	    // 실패시 다시 로그인 페이지로
	    return "user/login";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	@GetMapping("/update")
	public String update(HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");

		model.addAttribute("user", user);
		return "user/update";
	}

	@PostMapping("/update_pro")
	public String update_pro(@ModelAttribute User user, @RequestParam String user_pass, HttpSession session, Model model) {
	    // 세션에서 현재 로그인된 사용자 정보를 가져옵니다
	    User loginUser = (User) session.getAttribute("user");
	    
	    // 입력한 비밀번호가 현재 로그인된 사용자의 비밀번호와 일치하는지 확인
	    if (!loginUser.getUser_pass().equals(user_pass)) {
	        // 비밀번호가 일치하지 않으면 에러 메시지를 추가하고 수정 페이지로 돌아갑니다
	        model.addAttribute("error", "비밀번호가 일치하지 않습니다.");
	        return "user/update";
	    }
	    
	    // 비밀번호가 일치하면 회원정보를 업데이트합니다
	    testService.update(user);
	    
	    // 세션의 사용자 정보도 업데이트
	    loginUser.setUser_age(user.getUser_age());
	    loginUser.setUser_gender(user.getUser_gender());
	    loginUser.setUser_job(user.getUser_job());
	    loginUser.setUser_address(user.getUser_address());
	    
	    session.setAttribute("user", loginUser);
	    
	    // 성공 메시지를 추가하고 마이페이지로 리다이렉트
	    return "redirect:/user/mypage?id=" + loginUser.getUser_id();
	}
	
	
	@GetMapping("/mypage")
	public String mypage(@RequestParam String id, Model model) {
		
		User user = testService.getUser(id);
		
		model.addAttribute("user", user);
		
		return "user/mypage";
	}
	
	@GetMapping("/delete")
	public String deleteUser() {
		
		return "user/delete";
	}
	
	@PostMapping("/deletePro")
	public String deletePro(@RequestParam String user_pass) {
		
		testService.deleteUser(user_pass);
		
		return "redirect:/";
	}
	
	
	
	
}
