package fr.diginamic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	JWTAuthorizationFilter jwtAuthorizationFilter;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// toutes les requêtes sont permises
		// => aucune n'est soumise à authentification
		http.csrf().disable().authorizeRequests().antMatchers("/authentification").permitAll().antMatchers("/grades")
				.permitAll().anyRequest().authenticated().and().headers().frameOptions().disable().and()
				.addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);
		;
	}

}
