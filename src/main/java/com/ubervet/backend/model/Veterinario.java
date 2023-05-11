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
    public String id;
    public String nome;
    public String registro;
    public String especializacao;
    public String endereco;
    public String telefone;
    public String email;
    public String senha;
}
