package com.ubervet.UberVet.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Veterinario extends Cliente {

    public String registro;
    public String especializacao;

}
