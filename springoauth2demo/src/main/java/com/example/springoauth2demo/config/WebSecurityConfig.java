package com.example.springoauth2demo.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//import org.springframework.security.oauth2.client.endpoint.DefaultAuthorizationCodeTokenResponseClient;
//import org.springframework.security.oauth2.client.endpoint.OAuth2AccessTokenResponseClient;
//import org.springframework.security.oauth2.client.endpoint.OAuth2AuthorizationCodeGrantRequest;
//import org.springframework.security.oauth2.client.registration.ClientRegistration;
//import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
//import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
//import org.springframework.security.oauth2.client.web.AuthorizationRequestRepository;
//import org.springframework.security.oauth2.client.web.HttpSessionOAuth2AuthorizationRequestRepository;
//import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;


//@EnableWebSecurity
@Configuration
//@PropertySource("application-oauth2.properties")
//@ConfigurationProperties(prefix = "spring.security.oauth2.client.registration.google")
@EnableOAuth2Sso
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
//        http.authorizeRequests()
//                //.antMatchers("/**")
//                //.authenticated()
//                .antMatchers("/oauth_login", "/user")
//                .permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .oauth2Login()
//                .loginPage("/oauth_login");
        http
                .antMatcher("/**")
                .authorizeRequests()
                    .antMatchers("/", "/login**", "/webjars/**", "/error**")
                        .permitAll()
                    .anyRequest()
                        .authenticated();
    }

//    @Bean
//    public AuthorizationRequestRepository<OAuth2AuthorizationRequest> authorizationRequestRepository() {
//        return new HttpSessionOAuth2AuthorizationRequestRepository();
//    }
//
//    @Bean
//    public OAuth2AccessTokenResponseClient<OAuth2AuthorizationCodeGrantRequest> accessTokenResponseClient() {
//        DefaultAuthorizationCodeTokenResponseClient accessTokenResponseClient = new DefaultAuthorizationCodeTokenResponseClient();
//        return accessTokenResponseClient;
//    }
//
//    //private static List<String> clients = Arrays.asList("google", "facebook");
//    private static List<String> clients = Arrays.asList("google");
//
//    @Bean
//    public ClientRegistrationRepository clientRegistrationRepository() {
//        List<ClientRegistration> registrations = clients.stream()
//                .map(c -> getRegistration(c))
//                .filter(registration -> registration != null)
//                .collect(Collectors.toList());
//
//
//        return new InMemoryClientRegistrationRepository(registrations);
//    }
//
//    private static String CLIENT_PROPERTY_KEY = "spring.security.oauth2.client.registration";
//
//    //@Autowired
//    //private Environment env;
//
//    String google_client;
//
//    private ClientRegistration getRegistration(String client) {
////        String clientId = env.getProperty(CLIENT_PROPERTY_KEY + client + ".client-id");
////
////        if (clientId == null) {
////            return null;
////        }
////
////        String clientSecret = env.getProperty(CLIENT_PROPERTY_KEY + client + ".client-secret");
////        if (client.equals("google")) {
////            return CommonOAuth2Provider.GOOGLE.getBuilder(client)
////                    .clientId(clientId)
////                    .clientSecret(clientSecret)
////                    .build();
////        }
////        if (client.equals("facebook")) {
////            return CommonOAuth2Provider.FACEBOOK.getBuilder(client)
////                    .clientId(clientId)
////                    .clientSecret(clientSecret)
////                    .build();
////        }
//
//
//        return null;
//    }
}
