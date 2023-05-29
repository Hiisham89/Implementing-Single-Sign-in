package com.hosham.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.IdTokenClaimNames;
//import org.springframework.security.oauth2.client.registration.ClientRegistration;
//import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
//import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
//import org.springframework.security.oauth2.core.AuthorizationGrantType;
//import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
//import org.springframework.security.oauth2.core.oidc.IdTokenClaimNames;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SingleConfig {
	
	@Bean
	SecurityFilterChain securityfilterchain(HttpSecurity http) throws Exception {
	
		
	http.authorizeHttpRequests((requests) -> requests
			.anyRequest().authenticated())
			.oauth2Login();
		
		
		return http.build();
	}
	
	
	
//	@Bean
//	public ClientRegistrationRepository clientRegistrationRepository() {
//		return new InMemoryClientRegistrationRepository(this.githubClientRegistration());
//	}
//
// 	private ClientRegistration githubClientRegistration() {
// 		return ClientRegistration.withRegistrationId("Github")
// 			.clientId("e65eeaaddb03fe8e2166")
// 			.clientSecret("c4c6996766c13016312180d9591ce916967e13c4")
// 			.clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
// 			.authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
// 			.redirectUri("//localhost:8080")
// 			.clientName("Github")
// 			.build();
//	}


	@Bean
	 public ClientRegistrationRepository clientRegistrationRepository() {
	        return new InMemoryClientRegistrationRepository(this.clientRegistration());
	    }
	
	private ClientRegistration clientRegistration() {
        return CommonOAuth2Provider.GITHUB.getBuilder("github")
                .clientId("e65eeaaddb03fe8e2166")
                .clientSecret("7a8470369a1cf6ff06dbc68fcbef0f0e8b69bac0")
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .build();

    }
}
