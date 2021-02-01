package com.ensapay.core.web;

import com.ensapay.core.dao.AdminRepository;
import com.ensapay.core.dao.AgentRepository;
import com.ensapay.core.entities.Admin;
import com.ensapay.core.entities.Agent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.UUID;

@Component
@WebService(name = "AdminWS", targetNamespace = "http://spring.io/guides/gs-producing-web-service")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class AdminWS {

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private AgentRepository agentRepository;

    //Methode pour la connexion admin
    @WebMethod
    public String loginVerified(@WebParam(name="login") String login, @WebParam(name="pass") String pass){
        //Admin a = adminRepository.findById("6016c7e24e00f80b451febc4").get();
        Admin a = adminRepository.findAll().get(0);
        if(a.getLogin().equals(login) && a.getPass().equals(pass))
            return "success";
        else
            return "failed";
    }

    //Methode pour creer un agent
    @WebMethod
    public String addNewAgent(

            @WebParam(name="nom") String nom, @WebParam(name="prenom") String prenom,
            @WebParam(name="cin") String cin,@WebParam(name="date_naiss") String date_naiss,
            @WebParam(name="adresse") String adresse,@WebParam(name="email") String email,
            @WebParam(name="conf_email") String conf_email, @WebParam(name="tel") String tel,
            @WebParam(name="irc") String irc,@WebParam(name="patente") String patente
    ){


        //generer identifiant
        String uniqueKey = UUID.randomUUID().toString();
        System.out.println (uniqueKey);

        //generer password
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz";
        StringBuilder s = new StringBuilder(8);

        for (int i = 0; i < 8; i++) {
            int index = (int)(str.length() * Math.random());
            s.append(str.charAt(index));
        }
        System.out.println(s.toString());

        agentRepository.save(
                new Agent(null,uniqueKey,s.toString(),nom,prenom,cin,date_naiss,adresse,email,conf_email,tel,irc,patente)
        );

        return uniqueKey+","+s.toString() ;
    }
}
