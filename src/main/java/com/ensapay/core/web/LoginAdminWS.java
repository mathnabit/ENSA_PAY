package com.ensapay.core.web;

import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;

@Component
@WebService(name = "LoginAdminWS")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class LoginAdminWS {

    @WebMethod
    public String login(){
        return "succes";
    }

}

