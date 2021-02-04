package com.ensapay.core.api;

import com.ensapay.core.entities.Client;
import com.ensapay.core.entities.ClientBanque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/client")
public class DbBanqueApi {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{id}")
    public ClientBanque getClient(@PathVariable("tel") String tel){

        final String uri = "http://localhost:55241/api/client/"+tel;

        RestTemplate restTemplate = new RestTemplate();

        ClientBanque client = restTemplate.getForObject(uri, ClientBanque.class);

        //System.out.println(client);
        return client;
    }
}
