package com.sofka.RetoSofkaU.repositories;

import com.sofka.RetoSofkaU.models.Jugador;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JugadorCrudRepository extends MongoRepository<Jugador, String> {

}
