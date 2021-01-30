package com.ensapay.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;

@Configuration
public class MyConfig {

    @Bean
    SimpleJaxWsServiceExporter serviceExporter() {
        SimpleJaxWsServiceExporter serviceExporter = new SimpleJaxWsServiceExporter();
        serviceExporter.setBaseAddress("http//0.0.0.0:8888");
        return serviceExporter;
    }
}
