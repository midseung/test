package kr.co.soldesk.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.soldesk.beans.User;
import kr.co.soldesk.mapper.UserMapper;

@Repository
public class TestRepository {

	@Autowired
	private UserMapper userMapper;

	public void insert_data(User user) {
		userMapper.insert_data(user);
	}
	//로그인
	public User login(User user) {
		return userMapper.login(user);
	}
	
	public List<User> allMember(){
		return userMapper.allMember();
	}

	public void update(User user) {
		userMapper.update(user);
	}
	
	//회원조회
	public User getUser(String id) {
		return userMapper.getUser(id);
	}
	
	//회원확인
	public String checkUser(String id, String pass) {
		userMapper.checkUser(id,pass);
		return "";
	}
	//회원삭제
	public void deleteUser(String id) {
		userMapper.deleteUser(id);
	}
	
}
