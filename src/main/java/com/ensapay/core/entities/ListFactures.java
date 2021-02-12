package com.ensapay.core.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString
public class ListFactures {
    private List<Facture> factures;

    public ListFactures() {
        factures = new ArrayList<>();
    }


}
