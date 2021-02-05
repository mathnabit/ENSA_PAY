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
@RequestMapping("/clients")
public class RedalApi {

    //Impayes EAU + ELECTRICITE
    @RequestMapping
    public List<Facture> getImpayes(@PathVariable("tel") String tel,@PathVariable("creance") String creance){

        final String uri = "http://localhost:3000/clients/"+ tel +"impaye/"+ creance +"";

        RestTemplate restTemplate = new RestTemplate();

        List<Facture> reponse = (List<Facture>) restTemplate.getForObject(uri, Facture.class);

        return reponse;
    }



    //Penalites EAU
    @RequestMapping
    public List<Facture> getPenalites(@PathVariable("tel") String tel,@PathVariable("creance") String creance){

        final String uri = "http://localhost:3000/clients/"+ tel +"outdated/"+ creance + "";

        RestTemplate restTemplate = new RestTemplate();

        List<Facture> reponse = (List<Facture>) restTemplate.getForObject(uri, Facture.class);

        return reponse;
    }



    @PostMapping
    public String payerFacture(@PathVariable("tel") String tel,@PathVariable("creance") String creance,
                               @PathVariable("id_fact") String id_fact
    ){

        final String uri = "http://localhost:3000/clients/"+ tel +"paye/"+ creance +"";

        RestTemplate restTemplate = new RestTemplate();

        String reponse = restTemplate.postForObject( uri, id_fact, String.class);

        return "Facture est payée";
    }

}
