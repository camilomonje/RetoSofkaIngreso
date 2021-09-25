package com.sofka.RetoSofkaU.ui;

import com.sofka.RetoSofkaU.models.Juego;
import com.sofka.RetoSofkaU.models.Jugador;
import com.sofka.RetoSofkaU.models.Pregunta;
import com.sofka.RetoSofkaU.repositories.PreguntaCrudRepsitory;
import com.sofka.RetoSofkaU.services.Consultas;
import com.sofka.RetoSofkaU.services.NumeroAleatorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class UIMenu {

    @Autowired
    PreguntaCrudRepsitory preguntaCrudRepsitory;


    public  void showMenu() {
        int response = 0;
        do {
            System.out.println("1. Iniciar Juego");
            System.out.println("2. Historial Jugadores");
            System.out.println("3. Reglas");
            System.out.println("4. Crear nueva pregunta");
            System.out.println("0. Salir");
            Scanner sc = new Scanner(System.in);
            response = Integer.parseInt(sc.nextLine());

            switch (response) {
                case 0:
                    System.out.println("Gracias por participar");
                    break;
                case 1:
                    inicioJuego();
                    break;
                case 2:
                    //Historial Jugadores
                    break;
                case 3:
                    //Reglas
                    break;
                case 4:
                    //Crear nueva pregunta
                    break;
                default:
                    System.out.println("Ingresa una opción correcta \n");
            }
        }while(response != 0);
    }

    public  Jugador registrarJugador() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese tu nombre");
        String name = String.valueOf(sc.nextLine());
        Jugador jugador = new Jugador(name, 0);

        return jugador;
    }

    public  void inicioJuego(){
        Jugador jugador = registrarJugador();
        System.out.println("Bienvenido " + jugador.getName() + "!!!");
        System.out.println("Tu puntaje Inicial es: " + jugador.getPuntaje());
        System.out.println();
        NumeroAleatorio numeroAleatorio = new NumeroAleatorio();
        Juego juego = new Juego(1, jugador);
        //do {
            numeroAleatorio.setNumeroA(1, 5);
            int nA = numeroAleatorio.getNumeroA();
            System.out.println("Nivel " + juego.getRonda() + " pregunta numero " + nA);
            Consultas consultas = new Consultas();

            try {
                consultas.getByCategoriaAndIdPregunta(1,2);
                List<Pregunta> preguntaList =  preguntaCrudRepsitory.findPreguntaByCategoriaAndIdPregunta(1,2);
            } catch (Exception e) {
                System.out.println ("El error es: " + e.getMessage());
                e.printStackTrace();
            }

            //List<Pregunta> preguntaList =  preguntaCrudRepsitory.findPreguntaByCategoriaAndIdPregunta(1, 1);
            //System.out.println("Este dato" + preguntaList);
            /*System.out.println(preguntaList.get(0).getEnunciado());
            System.out.println("1. " + preguntaList.get(0).getOpciones().get(0));
            System.out.println("2. " + preguntaList.get(0).getOpciones().get(1));
            System.out.println("3. " + preguntaList.get(0).getOpciones().get(2));
            System.out.println("4. " + preguntaList.get(0).getOpciones().get(3));
            System.out.println();
            System.out.println("Cual es tu respuesta");
            Scanner sc = new Scanner(System.in);
            int opcion = Integer.parseInt(sc.nextLine());
            if (opcion == preguntaList.get(0).getRespuestaCorrecta()){
                System.out.println("Correcto!!");
                jugador.setPuntaje(juego.getRonda());
            }else {
                System.out.println("Incorrecto");
                juego.setFinish(true);
            }*/

       // }while(!juego.isFinish());

    }

    /*public static List<Pregunta> getPregunta(int categoria, int idPregunta){

        return preguntaCrudRepsitory.findPreguntaByCategoriaAndIdPregunta(categoria,idPregunta);

    }*/



    public void reglas (){
        System.out.println("Este es un concurso de preguntas y respuestas, para ganar dinero");
        System.out.println("El juego consiste en contestar las preguntas, y si contestas bien avanzas al siguiente nivel");
        System.out.println("Cada nivel que avances tiene un mayor nivel de dificultad.");
        System.out.println("Si contestas mal en cualquier nivel pierdes todo el premio");
        System.out.println("Si te retiras en cualquier nivel, te quedas con el acumulado que lleves");
        System.out.println("Premios:");
        System.out.println("::Nivel 1: $50.000 ");
        System.out.println("::Nivel 2: $250.000 ");
        System.out.println("::Nivel 3: $500.000 ");
        System.out.println("::Nivel 4: $1.000.000 ");
        System.out.println("::Nivel 5: $5.000.000 ");
        int response = 0;
        do {
            System.out.println("\nPara volver al menu anterior marque 0.");
            Scanner sc = new Scanner(System.in);
            response = Integer.parseInt(sc.nextLine());
            if (response != 0) {
                System.out.println("Escriba una opción correcta");
            }
        }while (response != 0);
    }

}
