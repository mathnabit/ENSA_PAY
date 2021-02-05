package com.ensapay.core.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Facture {

    @Id
    private String id;
    private String ceancier;
    private String creance;
    private double montant;
    private boolean paye;
    private Date date;

}
