package com.sofka.RetoSofkaU.utils;

public class NumeroAleatorio {
    private int numeroA;

    public int getNumeroA() {
        return this.numeroA;
    }

    public void setNumeroA(double min, double max) {
        this.numeroA = (int) (Math.floor((Math.random() * (max - min +1)))+ min);
    }
}
