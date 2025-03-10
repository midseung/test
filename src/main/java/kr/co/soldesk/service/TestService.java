package kr.co.soldesk.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import kr.co.soldesk.beans.User;
import kr.co.soldesk.repository.TestRepository;

@Service
public class TestService {

	@Autowired
	private TestRepository testRepository;
	
	@Resourc(name = "loginUser")
	private User loginuser;
	
	public void insert_data(User user) {
		testRepository.insert_data(user);
	}
	
	//로그인
	public boolean login(User user) {
		
		User tempUser =  testRepository.login(user);
		
		loginuser.setUser_id(tempUser.getUser_id());
		loginuser.setUser_pass(tempUser.getUser_pass());
		loginuser.setUser_name(tempUser.getUser_name());
		loginuser.setUser_gender(tempUser.getUser_gender());
		loginuser.setUser_job(tempUser.getUser_job());
		loginuser.setUser_address(tempUser.getUser_address());
		loginuser.setLogin(true); 
		
		
		
		return true;
	}
	
	public List<User> allMember(){
		return testRepository.allMember();
	}
	public void update(User user) {
		testRepository.update(user);
	}
	
	//회원조회
	public User getUser(String id) {
		return testRepository.getUser(id);
	}
	
	public boolean checkUser(String pass) {
		
		String id = loginuser.getUser_id();
		
		String checkId =  testRepository.checkUser(id, pass);
		
		if(checkId == null) {
			return false;
		}else {
			return true;
		}
		
		
		
	}
	
	public void deleteUser(String pass) {
		
		if(checkUser(pass)) {
			testRepository.deleteUser(loginuser.getUser_id());
		
		}
		
	}
	
}
