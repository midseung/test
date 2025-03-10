package kr.co.soldesk.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.co.soldesk.beans.User;

@Mapper
public interface UserMapper {
	//회원가입
	@Insert("insert into test_user(user_id, user_pass, user_name,user_age, user_gender, user_job, user_address) "
			+ "values(#{user_id},#{user_pass} ,#{user_name}, #{user_age}, #{user_gender}, #{user_job},#{user_address} )")
	void insert_data(User user);
	
	//로그인
	@Select("select * from test_user where user_id = #{user_id} and user_pass = #{user_pass}")
	User login(User user);
	
	//모든회원조회
	@Select("select * from test_user")
	List<User> allMember();
	
	
	@Update("update test_user set user_name = #{user_name}, user_age = #{user_age}, user_gender = #{user_gender}, user_address = #{user_address}, user_job = #{user_job} "
			+ "where user_id = #{user_id}")
	void update(User user);
	
	//개별 회원 조회
	@Select("select * from test_user where user_id = #{id}")
	User getUser(String id);
	
	//회원확인
	@Select("select user_id from test_user where user_id = #{id} and user_pass = #{pass}")
	String checkUser(@Param("id") String id,@Param("pass") String pass);

	@Delete("delete from test_user where user_id = #{id}")
	void deleteUser(@Param("id") String id);
	
}
