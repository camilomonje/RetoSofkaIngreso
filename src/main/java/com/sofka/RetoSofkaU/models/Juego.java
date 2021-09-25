package com.sofka.RetoSofkaU.models;

public class Juego {
    private int ronda;
    private Jugador jugador;
    private boolean finish;

    public Juego (int ronda, Jugador jugador){
        this.ronda = ronda;
        this.jugador = jugador;
        this.finish = false;
    }

    public int getRonda() {
        return ronda;
    }

    public void setRonda(int ronda) {
        this.ronda = ronda;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }
}
