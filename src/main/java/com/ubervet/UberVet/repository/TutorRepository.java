package com.ubervet.UberVet.repository;

import com.ubervet.UberVet.model.Tutor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorRepository extends MongoRepository<Tutor,Integer> {
}
