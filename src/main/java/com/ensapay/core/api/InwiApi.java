package com.ensapay.core.api;

import com.ensapay.core.entities.ClientBanque;
import com.ensapay.core.entities.Recharge;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/recharge")
public class InwiApi {

    @RequestMapping("/getMessage")
    public String recupererForm(){

        final String uri = "http://localhost:62708/api/recharge/getMessage";

        RestTemplate restTemplate = new RestTemplate();

        String reponse = restTemplate.getForObject(uri, String.class);

        return reponse;
    }

    @PostMapping
    public String ajouterRecharge(@PathVariable("recharge") Recharge recharge){

        final String uri = "http://localhost:62708/api/recharge";

        RestTemplate restTemplate = new RestTemplate();

        String reponse = restTemplate.postForObject( uri, recharge, String.class);
        
        return "Compte bien recharge";
    }
}
