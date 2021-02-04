package com.ensapay.core.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "clientsbanque")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClientBanque {

    @Id
    private String id;
    private String tel;
    private double solde_bnq;
    private boolean historique;
    private boolean credit;

}
