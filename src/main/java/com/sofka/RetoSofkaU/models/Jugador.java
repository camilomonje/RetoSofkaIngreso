package com.sofka.RetoSofkaU.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "jugadores")
public class Jugador {

    @Id
    private String id;
    private String name;
    private int puntaje;

    public Jugador (String name, int puntaje){
        this.name = name;
        this.puntaje = puntaje;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {

        this.puntaje = puntaje ;
    }
}
