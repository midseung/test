package kr.co.soldesk.beans;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class User {

	@Size(min = 4, max = 10)
	private String user_id;
	
	@Size(min = 6, max = 8)
	private String user_pass;
	@NotBlank
	private String user_name;


	private int user_age;
	@NotBlank
	private String user_gender;
	
	private String user_job;
	
	@NotBlank
	private String user_address;
	
	private boolean Login;
	
	
	public boolean isLogin() {
		return Login;
	}
	public void setLogin(boolean login) {
		Login = login;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pass() {
		return user_pass;
	}
	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public int getUser_age() {
		return user_age;
	}
	public void setUser_age(int user_age) {
		this.user_age = user_age;
	}
	public String getUser_gender() {
		return user_gender;
	}
	public void setUser_gender(String user_gender) {
		this.user_gender = user_gender;
	}
	public String getUser_job() {
		return user_job;
	}
	public void setUser_job(String user_job) {
		this.user_job = user_job;
	}
	public String getUser_address() {
		return user_address;
	}
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

}
