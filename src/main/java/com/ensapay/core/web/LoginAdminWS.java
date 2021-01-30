package com.ensapay.core.web;

import org.springframework.stereotype.Component;

import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;

@Component
@WebServiceClient
public class LoginAdminWS {

    @WebEndpoint
    public String login(){
        return "succes";
    }

}

