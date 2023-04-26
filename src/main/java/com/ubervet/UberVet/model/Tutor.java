package com.ubervet.UberVet.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Tutor extends Cliente {

    public String nomePet;
    public Integer idadePet;
    public String racaPet;
    public Boolean isMacho;
    public String carteiraVacinacao;


}
