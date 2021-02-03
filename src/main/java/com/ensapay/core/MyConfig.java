package com.ensapay.core;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;

import javax.activation.DataSource;


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


}
