package com.ensapay.core.api;

import com.ensapay.core.entities.Facture;
import com.ensapay.core.entities.ListFactures;
import com.ensapay.core.entities.Recharge;
import org.springframework.http.ResponseEntity;
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
    @RequestMapping("/impaye")
    public Facture[] getImpayes(@PathVariable("tel") String tel,@PathVariable("creance") String creance){

        final String uri = "http://localhost:3000/clients/"+ tel +"/impaye/"+ creance +"";
        //final String uri = "http://localhost:3000/clients/0766119237/impaye/EAU";

        RestTemplate restTemplate = new RestTemplate();
        System.out.println("1");
        Facture[] reponsee = restTemplate.getForObject(uri, Facture[].class);

        ResponseEntity<Facture[]> reponse = restTemplate.getForEntity(uri, Facture[].class);
        System.out.println("2" + reponse.getBody()[0]);
        //return reponse.getFactures();
        //return reponse;
        return reponsee;
    }



    //Penalites EAU + ELECTRICITE
    @RequestMapping("/outdated")
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
