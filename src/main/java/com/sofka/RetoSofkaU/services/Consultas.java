package com.sofka.RetoSofkaU.services;

import com.sofka.RetoSofkaU.models.Pregunta;
import com.sofka.RetoSofkaU.repositories.PreguntaCrudRepsitory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Consultas {

    @Autowired
    PreguntaCrudRepsitory preguntaCrudRepsitory;

    public List<Pregunta> getByCategoriaAndIdPregunta (int categoria, int idPregunta) {
        return preguntaCrudRepsitory.findPreguntaByCategoriaAndIdPregunta(categoria, idPregunta);
    }


}
