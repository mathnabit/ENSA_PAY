package com.ensapay.core.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "agents")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Agent {

    @Id
    private String id;
    private String login;
    private String pass;
    private String nom;
    private String prenom;
    private String cin;
    private String date_naiss;
    private String adresse;
    private String email;
    private String conf_email;
    private String tel;
    private String irc;
    private String patente;





}
