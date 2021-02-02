package com.ensapay.core.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Document(collection = "demandes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Demande {

    private String id;
    private String type_cmpte;
    private String nom_cl;
    private String prenom_cl;
    private String tel_cl;
    private String email_cl;
    private boolean resolu;

}
