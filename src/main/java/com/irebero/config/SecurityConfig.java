package com.irebero.config;


import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.irebero.ServiceImpl.UserSecurityService;


@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	// @Autowired
	// private Environment env;

	@Autowired
	private UserSecurityService userSecurityService;
//salt help to encrypt the password
	private static final String SALT = "salt";

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(12, new SecureRandom(SALT.getBytes()));
	}

	public static final String[] PUBLIC_MATCHERS = { 
			 
			"/backupcss/**",
			"/backupjs/**",
			"/fonts/**",
			"/css/**",
			"/css1/**",
			"/dist/**",
			"/js1/**",
			"/js/**",
			"/newRole",
			"/images/**", 
			"/",
			"/trackForm",
			"/districtForm",
			"/pug",
			"/scss",
			"/vendor",
			"/docFiles/**",
			"/about/**",
			"/contact/**", 
			"/error/**/*", 
			"/console/**",
			"/doc/file/retrieve/**",
			"/signup",
			"/index",
			"/index1",
			"/CheckEmail",
			"/ConfirmPassword",
			"/dashboard",
			"/index2"
	};

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().
		// antMatchers("/**").
//		antMatchers(PUBLIC_MATCHERS).permitAll();
		antMatchers(PUBLIC_MATCHERS).permitAll().anyRequest().authenticated();

		http.csrf().disable().cors().disable().formLogin().failureUrl("/index?error").defaultSuccessUrl("/BranchForm")
				.loginPage("/index").permitAll().and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/index?logout")
				.deleteCookies("remember-me").permitAll().and().rememberMe();
		
//		http.csrf().disable().cors().disable().formLogin().failureUrl("/index?error").defaultSuccessUrl("/index1")
//		.loginPage("/index").permitAll().and().logout()
//		.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/index?logout")
//		.deleteCookies("remember-me").permitAll().and().rememberMe();
//		
		
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
		auth.userDetailsService(userSecurityService).passwordEncoder(passwordEncoder());
	}

}