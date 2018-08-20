package org.tom.security.browser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.tom.security.core.properties.SecurityProperties;
import org.tom.security.core.validate.code.ValidateCodeFilter;

/**
 * SpringSecurity配置
 *
 * @author Tom（bibi8086@gmail.com）
 * @date 2018/5/28 下午11:46
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private AuthenticationSuccessHandler tomAuthenticationSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler tomAuthenticationFailureHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        ValidateCodeFilter validateCodeFilter = new ValidateCodeFilter();
        validateCodeFilter.setAuthenticationFailureHandler(tomAuthenticationFailureHandler);
        validateCodeFilter.setSecurityProperties(securityProperties);
        validateCodeFilter.afterPropertiesSet();

        // 表单方式登录
        http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
                .formLogin()
                .loginPage("/authentication/require")
                .loginProcessingUrl("/authentication/form")
                .successHandler(tomAuthenticationSuccessHandler)
                .failureHandler(tomAuthenticationFailureHandler)
                // Basic方式登录
                //http.httpBasic()
                .and()
                // 该配置意思是：接下来的是需要请求授权
                .authorizeRequests()
                // permitAll 允许任何人访问
                .antMatchers("/authentication/require",
                        securityProperties.getBrowser().getLoginPage(),
                        "/code/image").permitAll()
                // 任何请求
                .anyRequest()
                // 都需要认证
                .authenticated()
                .and()
                .csrf().disable();
    }
}
