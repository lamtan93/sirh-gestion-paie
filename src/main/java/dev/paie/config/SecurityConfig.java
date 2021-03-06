package dev.paie.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired private PasswordEncoder passwordEncoder; 
	@Autowired private DataSource dataSource; 
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder)
				.usersByUsernameQuery("SELECT nomUtilisateur, motDePasse, estActif from Utilisateur where nomUtilisateur=?")
				.authoritiesByUsernameQuery("SELECT nomUtilisateur,role from Utilisateur WHERE nomUtilisateur = ?");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		
		http
		.authorizeRequests()
		.antMatchers("/bootstrap-3.3.7-dist/**","/css/**", "/js/**", "/images/**").permitAll()
		.anyRequest().authenticated()
		.and()
//		.exceptionHandling().accessDeniedPage("/mvc/employes") //page de redirection
//		.and()
		.formLogin()
		.loginPage("/mvc/connexion")
		.permitAll();
	}
}
