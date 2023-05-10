package com.ubervet.backend.repository;

import com.ubervet.backend.model.Veterinario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeterinarioRepository extends MongoRepository<Veterinario, Integer>{

    Veterinario findByNome(String nome);

    void deleteByNome(String nome);

    Veterinario findByEmail(String email);

    void deleteByEmail(String email);
}
