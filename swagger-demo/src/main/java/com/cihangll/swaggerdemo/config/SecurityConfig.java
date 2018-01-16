package com.cihangll.swaggerdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Eğer projemizde Spring Security - enabled durumdaysa /console ile H2 database console kısmına giriş yapamayız.
 * Default olarak security H2 database console ' unu bloklar.
 *
 * H2 database console 'unu aktif duruma getirmek için;
 * 1)/console/* yoluna izin vermemiz gerekir.
 * 2)CRSF (Cross-Site Request Forgery) disable duruma getirmemiz gerekir.Default olarak spring CSRF ataklarına karşı koruma sağlar.
 * 3)H2 database console bir frame içerisinde çalıştığından bunu Spring Security içerisinde etkinleştirmemiz gerekir.
 *
 * UYARI!!!!!!!
 *
 * Gerçek bir websitede bu Spring Security konfigürasyon işlemi kullanılmak iyi bir fikir değil.Kullanılmamalı.
 * Bu konfigürasyon sadece "yazılım geliştirme aşamasında" H2 database console'a erişmek için kullanılmalı.
 * Gerçek bir websitesinde H2 database console unun erişime açık olmaması gerekir. :D
 *
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").permitAll()
				.and().authorizeRequests().antMatchers("/console/**").permitAll();
		http.csrf().disable();
		http.headers().frameOptions().disable();
	}
}
