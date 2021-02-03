package com.ensapay.core.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "clients")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Client {

    @Id
    private String id;
    private String login;
    private String pass;
    private String tel;
    private String email;
    private String type_cmpte;


}
