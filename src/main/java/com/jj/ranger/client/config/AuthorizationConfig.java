package com.jj.ranger.client.config;

import org.apache.http.HttpHost;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.inject.Inject;

@Configuration
public class AuthorizationConfig {
    private static final Logger LOG = LoggerFactory.getLogger(AuthorizationConfig.class);

    @Inject
    private Environment environment;

    @Bean
    public HttpHost buildHttpHost() {
        final String scheme = environment.getProperty("ranger.rest.scheme");
        final String host = environment.getProperty("ranger.rest.host");
        final int port = Integer.parseInt(environment.getProperty("ranger.rest.port"));
        return new HttpHost(host, port, scheme);
    }

    @Bean(name = "rangerUriV1")
    public String buildRangerUriV1() {
        return buildHttpHost().toURI();
    }


    @Bean
    public RestTemplate buildRestTemplate() {
        final String username = environment.getProperty("ranger.rest.username");
        final String password = environment.getProperty("ranger.rest.password");
        final String scheme = environment.getProperty("ranger.rest.scheme");

        if ("http".equalsIgnoreCase(scheme)) {
            ClientHttpRequestFactory requestFactory = new DefaultHttpComponentsClientHttpRequestFactory(buildHttpHost(), username, password);
            return new RestTemplate(requestFactory);
        }

        throw new RuntimeException("The following scheme is not supported: " + scheme);
    }
}
