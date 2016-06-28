package com.jj.ranger.client.config;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.protocol.HttpContext;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

import java.net.URI;

public class DefaultHttpComponentsClientHttpRequestFactory extends HttpComponentsClientHttpRequestFactory {
    private HttpHost host;
    private String userName;
    private String password;

    public DefaultHttpComponentsClientHttpRequestFactory(HttpHost host, String userName, String password) {
        super();
        this.host = host;
        this.userName = userName;
        this.password = password;
    }

    @Override
    protected HttpContext createHttpContext(HttpMethod httpMethod, URI uri) {
        BasicScheme basicAuth = new BasicScheme();

        AuthCache authCache = new BasicAuthCache();
        authCache.put(host, basicAuth);

        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(new AuthScope(host), new UsernamePasswordCredentials(userName, password));

        HttpClientContext localContext = HttpClientContext.create();
        localContext.setAuthCache(authCache);
        localContext.setCredentialsProvider(credentialsProvider);

        return localContext;
    }

}
