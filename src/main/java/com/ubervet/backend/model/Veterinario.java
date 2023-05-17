package com.ubervet.backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Veterinario {

    @Id
    private String id;
    private String nome;
    private String registro;
    private String especializacao;
    private String endereco;
    private String telefone;
    private String email;
    private String senha;
}
