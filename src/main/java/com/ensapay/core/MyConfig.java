package com.ensapay.core;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;
import org.springframework.web.client.RestTemplate;

import javax.activation.DataSource;
import java.time.Duration;


@Configuration
public class MyConfig {

    /*public static final String DEFAULT_BASE_ADDRESS = "http://localhost:8585/";
    private String baseAddress = DEFAULT_BASE_ADDRESS;

    public void setBaseAddress(String baseAddress) {
        this.baseAddress = baseAddress;
    }

    @Bean
    protected void publishEndpoint(Endpoint endpoint, WebService annotation) {
        Endpoint.publish("http://0.0.0.0:8585/AdminWS", new AdminWS());

    }*/


    @Bean
    SimpleJaxWsServiceExporter serviceExporter() {
        SimpleJaxWsServiceExporter serviceExporter = new SimpleJaxWsServiceExporter();
        serviceExporter.setBaseAddress("http://0.0.0.0:8585/");

        return serviceExporter;
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {

        return builder
                .setConnectTimeout(Duration.ofMillis(3000))
                .setReadTimeout(Duration.ofMillis(3000))
                .build();
    }

}
