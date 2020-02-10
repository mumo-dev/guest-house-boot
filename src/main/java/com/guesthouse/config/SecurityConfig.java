package com.guesthouse.config;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.guesthouse.security.RestAuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity( prePostEnabled = true )
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Value( "${security.signing-key}" )
    private String signingKey;

    //    @Value( "${security.encoding-strength}" )
    //    private Integer encodingStrength;

    @Value( "${security.security-realm}" )
    private String securityRealm;

    @Qualifier( "customUserDetailsService" )
    @Autowired
    private UserDetailsService userDetailsService;

    private static final List<String> AUTH_LIST = Arrays.asList(
            "/swagger-resources/**",
            "/swagger-ui.html**",
            "/webjars/**",
            "favicon.ico" );

    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {

        return super.authenticationManager();
    }


    @Override
    protected void configure( AuthenticationManagerBuilder auth )
            throws Exception {

        auth.userDetailsService( userDetailsService ).passwordEncoder(
                encoder() );
    }


    @Bean
    public PasswordEncoder encoder() {

        return new BCryptPasswordEncoder();
    }


    @Override
    public void configure( WebSecurity web ) throws Exception {

        web.ignoring().antMatchers(
                "/v2/api-docs",
                "/swagger-ui.html",
                "/webjars/**",
                "**/swagger-resources/**",
                "/guesthouse/client/register/initialdata",
                "/guesthouse/client/register/save" );

    }


    @Override
    protected void configure( HttpSecurity http ) throws Exception {

        http.sessionManagement().sessionCreationPolicy(
                SessionCreationPolicy.STATELESS ).and().authorizeRequests()
                .antMatchers( "/actuator/**", "/api-docs/**" ).permitAll()
                .antMatchers().permitAll()
                .antMatchers( "/guesthouse/api/**" ).authenticated().and()
                .httpBasic()
                .realmName( securityRealm ).and().csrf().disable();

        //        http
        //                .antMatcher( "/**" ).authorizeRequests().anyRequest().authenticated()
        //                .and()
        //                .exceptionHandling()
        //                .defaultAuthenticationEntryPointFor( swaggerAuthenticationEntryPoint(),
        //                        new CustomRequestMatcher( AUTH_LIST ) )
        //                .and()
        //                .httpBasic()
        //                .authenticationEntryPoint( restAuthenticationEntryPoint )
        //                .and()
        //                .csrf().disable();
    }


    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {

        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey( signingKey );
        return converter;
    }


    @Bean
    public TokenStore tokenStore() {

        return new JwtTokenStore( accessTokenConverter() );
    }


    @Bean
    public DefaultTokenServices tokenServices() {

        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore( tokenStore() );
        defaultTokenServices.setAccessTokenValiditySeconds( 60 );
        defaultTokenServices.setSupportRefreshToken( true );
        return defaultTokenServices;
    }


    @Bean
    public BasicAuthenticationEntryPoint swaggerAuthenticationEntryPoint() {

        BasicAuthenticationEntryPoint entryPoint = new BasicAuthenticationEntryPoint();
        entryPoint.setRealmName( "Swagger Realm" );
        return entryPoint;
    }

    private class CustomRequestMatcher implements RequestMatcher {

        private List<AntPathRequestMatcher> matchers;

        private CustomRequestMatcher( List<String> matchers ) {

            this.matchers = matchers.stream().map( AntPathRequestMatcher::new ).collect( Collectors
                    .toList() );
        }


        @Override
        public boolean matches( HttpServletRequest request ) {

            return matchers.stream().anyMatch( a -> a.matches( request ) );
        }

    }

}
