package com.ubervet.backend.repository;

import com.ubervet.backend.model.Veterinario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VeterinarioRepository extends MongoRepository<Veterinario, Integer>{

    Optional<Veterinario> findById(String id);

    void deleteById(String id);

    Veterinario findByEmail(String email);

    void deleteByEmail(String email);
}
