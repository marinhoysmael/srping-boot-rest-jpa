package br.com.alura.forum.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Classe de configuracao de seguranca
 * 
 * @author ysmael
 *
 */
@EnableWebSecurity
@Configuration
//sera usada somente no desenvolvimento de DEV
@Profile("dev")
public class DevSecurityConfigurations extends WebSecurityConfigurerAdapter {

	
	// configurações de autorização
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// Quais urls são publicas e quais são privadas
		http.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/topicos").permitAll()
		.and().csrf().disable();

	}

	// configuracções de recursos estáticos (js, css, imagens, etc...)
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
        .antMatchers("/**.html", "/v2/api-docs", "/webjars/**", "/configuration/**", "/swagger-resources/**");
	}
	

}
