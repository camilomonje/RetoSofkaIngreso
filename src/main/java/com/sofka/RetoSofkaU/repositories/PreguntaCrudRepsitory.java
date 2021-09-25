package com.sofka.RetoSofkaU.repositories;

import com.sofka.RetoSofkaU.models.Pregunta;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PreguntaCrudRepsitory extends MongoRepository<Pregunta, String> {

    List<Pregunta> findPreguntaByCategoriaAndIdPregunta(int categoria, int idPregunta);

}
