package com.ubervet.UberVet.repository;

import com.ubervet.UberVet.model.Veterinario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeterinarioRepository extends MongoRepository<Veterinario, Integer> {
}
