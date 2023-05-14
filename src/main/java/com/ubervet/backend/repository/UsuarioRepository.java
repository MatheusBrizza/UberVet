package com.ubervet.backend.repository;

import com.ubervet.backend.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {

    Usuario findByEmail(String email);

}
