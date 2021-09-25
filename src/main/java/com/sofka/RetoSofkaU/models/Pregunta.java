package com.sofka.RetoSofkaU.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "preguntas")
public class Pregunta {

    @Id
    private String id;
    private int idPregunta;
    private String enunciado;
    private List<String> opciones;
    private int respuestaCorrecta;
    private int categoria;

    public Pregunta(int idPregunta, int categoria, String enunciado, List<String> opciones, int respuestaCorrecta){
        this.idPregunta = idPregunta;
        this.categoria = categoria;
        this.opciones = opciones;
        this.enunciado = enunciado;
        this. respuestaCorrecta = respuestaCorrecta;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public List<String> getOpciones() {
        return opciones;
    }

    public void setOpciones(List<String> respuestas) {
        this.opciones = respuestas;
    }

    public int getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(Integer respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }



    @Override
    public String toString() {
        return "Pregunta{" +
                "id='" + id + '\'' +
                ", idPregunta=" + idPregunta +
                ", enunciado='" + enunciado + '\'' +
                ", opciones=" + opciones +
                ", respuestaCorrecta=" + respuestaCorrecta +
                ", categoria=" + categoria +
                '}';
    }
}
