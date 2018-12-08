package pl.lightmobile.guidelineservice.authorization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import pl.lightmobile.guidelineservice.AppConfiguration;

@Configuration
@EnableWebSecurity
class WebSecurity extends WebSecurityConfigurerAdapter {

    private static final String ROLE_USER = "ROLE_USER";

    @Autowired
    AppConfiguration appConfiguration;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        InMemoryUserDetailsManagerConfigurer builder = auth.inMemoryAuthentication();

        appConfiguration.getUsers().forEach(user ->
            builder.withUser(user.getName())
                .password("{noop}" + user.getPassword())
                .authorities(ROLE_USER)
        );
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
