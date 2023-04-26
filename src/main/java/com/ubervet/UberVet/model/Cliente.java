package com.ubervet.UberVet.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public abstract class Cliente {

    @Id
    public Integer id;
    public String nome;
    public String email;
    public String telefone;
    public String cartaoCredito;

}
