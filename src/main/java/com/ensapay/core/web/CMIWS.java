package com.ensapay.core.web;

import com.ensapay.core.dao.*;
import com.ensapay.core.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@WebService(name = "CMIWS", targetNamespace = "http://spring.io/guides/gs-producing-web-service")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class CMIWS {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private AgentRepository agentRepository;

    @Autowired
    private DemandeRepository demandeRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientBanqueRepository clientBanqueRepository;

    /* ***      ADMIN        ** */

    //Methode pour la connexion admin
    @WebMethod
    public String loginVerified(@WebParam(name="login") String login, @WebParam(name="pass") String pass){

        Admin a = adminRepository.findAll().get(0);
        if(a.getLogin().equals(login) && a.getPass().equals(pass))
            return "login avec success";
        else
            return "login ou mot de passe erroné";
    }

    //Methode pour creer un agent
    @WebMethod
    public String addNewAgent(

            @WebParam(name="nom_ag") String nom_ag, @WebParam(name="prenom_ag") String prenom_ag,
            @WebParam(name="cin") String cin,@WebParam(name="date_naiss") String date_naiss,
            @WebParam(name="adresse") String adresse,@WebParam(name="email_ag") String email_ag,
            @WebParam(name="tel_ag") String tel_ag,@WebParam(name="irc") String irc,
            @WebParam(name="patente") String patente,@WebParam(name="description") String description
    ){


        //generer identifiant = login
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
                new Agent(null,uniqueKey,s.toString(),nom_ag,prenom_ag,cin,date_naiss,adresse,email_ag,tel_ag,irc,patente,description)
        );

        return uniqueKey+","+s.toString() ;
    }


    /* ***      AGENT        ** */

    //Methode pour stocker les demandes
    @WebMethod
    public String demanderCompte(

            @WebParam(name="type_cmpte") String type_cmpte,
            @WebParam(name="nom_cl") String nom_cl,@WebParam(name="prenom_cl") String prenom_cl,
            @WebParam(name="tel_cl") String tel_cl,@WebParam(name="email_cl") String email_cl
    ){
        demandeRepository.save(
                new Demande(null,type_cmpte,nom_cl,prenom_cl,tel_cl,email_cl,false)
        );

        return "success";
    }

    //Methode pour recuperer les demandes
    @WebMethod
    public Demande[] recupererDemandes(){

        List<Demande> listeDemandes = demandeRepository.findByResolu(false);
        //System.out.println(listeDemandes);
        //System.out.println( listeDemandes.toArray(new Demande[listeDemandes.size()]));
        return listeDemandes.toArray(new Demande[listeDemandes.size()]);
    }

    //Methode pour rejeter une demande
    @WebMethod
    public String rejeterDemande(@WebParam(name="id_demande") String id_demande){

        demandeRepository.deleteById(id_demande);

        return "success";
    }

    //Methode pour la création du compte de paiement
    @WebMethod
    public String newComptePayement(@WebParam(name="tel") String tel){

        Demande demande = demandeRepository.findByTel(tel);

        ClientBanque clientBanque = clientBanqueRepository.findByTel(tel);

        //verifier l existence du compte
        List<Client> listesClients = clientRepository.findAll();
        boolean verif = listesClients.stream().filter(c -> c.getTel().equals(tel)).findFirst().isPresent();

        System.out.println("status :" + clientBanque.isStatus() + " exsite : " + verif);

        if( clientBanque.getSolde_bnq()> Integer.parseInt(demande.getTel()) && clientBanque.isStatus() && !verif)
        {
            //generation du mot de passe provisoire
            String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz";
            StringBuilder s = new StringBuilder(8);

            for (int i = 0; i < 8; i++) {
                int index = (int)(str.length() * Math.random());
                s.append(str.charAt(index));
            }

            //creation du compte client
            clientRepository.save(
                    new Client(null,tel,s.toString(),tel,demande.getEmail(),demande.getType_cmpte())
            );

            //mettre la demande comme resolu
            demande.setResolu(true);
            demandeRepository.save(demande);

            //envoie du mot de passe

            return "success";
        } else {
            return "Demande de creation du compte est refusé";
        }

    }

    //Methode pour recuperer la liste des creanciers
    @WebMethod
    public String listCreancier(){



        return "success";
    }

    //Methode pour recuperer la facture ciblée
    @WebMethod
    public String getForms(){



        return "success";
    }

    //Methode pour recuperer la facture ciblée
    @WebMethod
    public String getImpayes(){



        return "success";
    }

    //Methode pour recuperer la facture ciblée
    @WebMethod
    public String confirmerPayer(){



        return "success";
    }







}
