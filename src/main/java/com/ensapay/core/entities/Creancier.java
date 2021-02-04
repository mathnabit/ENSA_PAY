package com.ensapay.core.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "creanciers")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Creancier {

    @Id
    private String id;
    private String nom;
    private String categorie;
    private ArrayList<String> creances;

}
