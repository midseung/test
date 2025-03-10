package kr.co.soldesk.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import kr.co.soldesk.beans.User;

@Configuration
@ComponentScan(basePackages = { "kr.co.soldesk.repository", "kr.co.soldesk.service" })
@PropertySource("/WEB-INF/properties/db.properties")
@MapperScan("kr.co.soldesk.mapper")
public class RootAppContext {

	@Value("${db.classname}")
	public String db_classname;

	@Value("${db.url}")
	public String db_url;

	@Value("${db.username}")
	public String db_username;

	@Value("${db.password}")
	public String db_password;

	@Bean("loginUser")
	@SessionScope
	public User user() {
		return new User();
	}
	
	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource source = new BasicDataSource();
		source.setDriverClassName(db_classname);
		source.setUrl(db_url);
		source.setUsername(db_username);
		source.setPassword(db_password);
		return source;
	}

	@Bean
	public SqlSessionFactory factory(BasicDataSource source) throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(source);
		SqlSessionFactory factory = factoryBean.getObject();
		return factory;
	}

}
