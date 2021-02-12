package com.ensapay.core.api;

import com.ensapay.core.entities.Facture;
import com.ensapay.core.entities.Recharge;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/client")
public class IamApi {

    //Impayes JAWAL + INTERNET
    @RequestMapping("/getImpaye")
    public Facture[] getImpayes(@PathVariable("tel") String tel, @PathVariable("creance") String creance){

        final String uri = "http://localhost:8000/api/client/getImpaye/"+Integer.parseInt(tel)+"/"+creance;

        RestTemplate restTemplate = new RestTemplate();

        Facture[] reponse = restTemplate.getForObject(uri, Facture[].class);

        return reponse;
    }

    //Penalites JAWAL + INTERNET
    @RequestMapping("/getImpayeMois")
    public Facture[] getPenalites(@PathVariable("tel") String tel, @PathVariable("creance") String creance){

        final String uri = "http://localhost:8000/api/client/getImpayeMois/"+tel+"/"+creance;

        RestTemplate restTemplate = new RestTemplate();

        Facture[] reponse =  restTemplate.getForObject(uri, Facture[].class);

        return reponse;
    }


    @PostMapping
    public String payerFacture(@PathVariable("tel") String tel, @PathVariable("id_fact") String id_fact){

        final String uri = "http://localhost:8000/api/client/validePayement/"+Integer.parseInt(tel)+"/"+Integer.parseInt(id_fact);

        RestTemplate restTemplate = new RestTemplate();

        String reponse = restTemplate.postForObject( uri, Integer.parseInt(id_fact), String.class);

        return "Facture est payée";
    }

}
