package com.ensapay.core.web;

import com.ensapay.core.dao.AdminRepository;
import com.ensapay.core.entities.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;

@Component
@WebService(name = "LoginAdminWS", targetNamespace = "http://spring.io/guides/gs-producing-web-service")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class LoginAdminWS {

    @Autowired
    private AdminRepository adminRepository;
    private int testVar = 1;
    @WebMethod
    public String loginVerified(@WebParam(name="login") String login, @WebParam(name="pass") String pass){
        Admin a = adminRepository.findById("6016c7e24e00f80b451febc4").get();
        if(a.getLogin().equals(login) && a.getPass().equals(pass))
            return "success";
        else
            return "failed";
    }

}

