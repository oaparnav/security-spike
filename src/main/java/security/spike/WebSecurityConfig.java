package security.spike;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.addFilterBefore(tokenHeaderAuthFilter(), BasicAuthenticationFilter.class)
			.authenticationProvider(new TokenAuthenticationProvider())
			.authorizeRequests()
			.anyRequest()
				.authenticated();
	}

	@Bean
	public TokenHeaderAuthenticationFilter tokenHeaderAuthFilter() throws Exception {
		TokenHeaderAuthenticationFilter authFilter = new TokenHeaderAuthenticationFilter();
		authFilter.setAuthenticationManager(authenticationManagerBean());
		authFilter.setAuthenticationSuccessHandler((req, res, auth) -> {});
		return authFilter;
	}
}
