package com.sofka.RetoSofkaU;

import com.sofka.RetoSofkaU.models.Juego;
import com.sofka.RetoSofkaU.models.Jugador;
import com.sofka.RetoSofkaU.models.Pregunta;
import com.sofka.RetoSofkaU.utils.NumeroAleatorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.sofka.RetoSofkaU.repositories.JugadorCrudRepository;
import com.sofka.RetoSofkaU.repositories.PreguntaCrudRepsitory;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;



@SpringBootApplication
public class RetoSofkaUApplication implements CommandLineRunner {

	@Autowired
	PreguntaCrudRepsitory preguntaCrudRepsitory;

	@Autowired
	JugadorCrudRepository jugadorCrudRepository;


	public static void main(String[] args) {
		SpringApplication.run(RetoSofkaUApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/*String enunciado = "¿Quien es el autor del Quijote de la Mancha?";
		int categoria = 5;
		int idPregunta = 5;
		List<String> opciones  = new ArrayList<>();
		opciones.add("Cristobal Colon");
		opciones.add("Gabriel Garcia Marquez");
		opciones.add("Leonardo Da Vinci");
		opciones.add("Miguel de Cervantes Saavedra");
		int respuestaCorrecta = 3;

		Pregunta pregunta = new Pregunta(idPregunta, categoria, enunciado, opciones, respuestaCorrecta);
		preguntaCrudRepsitory.save(pregunta);

		/*for (int i = 1; i <=5 ; i++) {
			for (int j = 1; j <= 5; j++) {
				Pregunta pregunta = new Pregunta(j, i, enunciado, opciones, respuestaCorrecta);
				preguntaCrudRepsitory.save(pregunta);

			}
		}*/
		Thread.sleep(2000);
		System.out.println("\n\nBienvenidos al Challenge");
		System.out.println("Concurso de Preguntas y Respuestas");

		int response = 0;
		do {
			System.out.println("\n\n");
			System.out.println("1. Iniciar Juego");
			System.out.println("2. Historial Jugadores");
			System.out.println("3. Reglas");
			System.out.println("0. Salir");
			Scanner sc = new Scanner(System.in);
			response = Integer.parseInt(sc.nextLine());

			switch (response) {
				case 0:
					System.out.println("Gracias por participar");
					break;
				case 1:
					Jugador jugador = registrarJugador();
					System.out.println("Bienvenido " + jugador.getName() + "!!!");
					System.out.println("Tu puntaje Inicial es: " + jugador.getPuntaje());
					System.out.println();
					NumeroAleatorio numeroAleatorio = new NumeroAleatorio();
					Juego juego = new Juego(1, jugador);
					while (!juego.isFinish()) {
						numeroAleatorio.setNumeroA(1, 5);
						int nA = numeroAleatorio.getNumeroA();
						System.out.println("Nivel " + juego.getRonda());
						List<Pregunta> preguntaList = preguntaCrudRepsitory.findPreguntaByCategoriaAndIdPregunta(juego.getRonda(), nA);
						int opcion = esquemaPregunta(preguntaList);
						if (opcion == preguntaList.get(0).getRespuestaCorrecta()){
							System.out.println("Correcto!!");
							jugador.setPuntaje(juego.getRonda()*100 + jugador.getPuntaje());
							System.out.println(jugador.getName() + " Tu puntaje actual es: " + jugador.getPuntaje());

							System.out.println("\n");
							if (juego.getRonda() < 5){
								boolean estado = false;
								do	{
									System.out.println("1. Continuar al siguiente Nivel");
									System.out.println("2. Terminar y obtener acumulado");
									int response1 = Integer.parseInt(sc.nextLine());

									switch (response1) {
										case  1:
											estado = true;
											break;
										case 2:
											estado = true;
											juego.setFinish(true);
											jugadorCrudRepository.save(jugador);
											System.out.println("El juego a terminado");
											System.out.println("Tu puntuacion final es: " + jugador.getPuntaje());

											break;
										default:
											System.out.println("Escribe la opción correcta\n");
									}
								}while (!estado);
							}
						}else {
							System.out.println("Incorrecto");
							jugador.setPuntaje(0);
							System.out.println("Perdiste el acumulado");
							jugadorCrudRepository.save(jugador);
							juego.setFinish(true);
						}

						juego.setRonda(juego.getRonda() + 1);

						if (juego.getRonda() > 5) {
							System.out.println("Felicitaciónes Ganaste el juego");
							System.out.println("Obtuviste: " +jugador.getPuntaje());
							jugadorCrudRepository.save(jugador);
							juego.setFinish(true);
						}
					}
					break;
				case 2:
					System.out.println("Historial de jugadores");
					List<Jugador> jugadorList = jugadorCrudRepository.findAll();
					historicoJugadores(jugadorList);
					break;
				case 3:
					reglas();
					break;
				default:
					System.out.println("Ingresa una opción correcta \n");
			}
		}while(response != 0);

	}

	public static int esquemaPregunta (List<Pregunta> pregunta) {
		boolean estado = false;
		int opcion = 0;

			System.out.println(pregunta.get(0).getEnunciado());
			System.out.println("1. " + pregunta.get(0).getOpciones().get(0));
			System.out.println("2. " + pregunta.get(0).getOpciones().get(1));
			System.out.println("3. " + pregunta.get(0).getOpciones().get(2));
			System.out.println("4. " + pregunta.get(0).getOpciones().get(3));
			System.out.println();
		do {
			System.out.println("Cual es tu respuesta: ");
			Scanner sc = new Scanner(System.in);
			opcion = Integer.parseInt(sc.nextLine());

			if (opcion < 1 || opcion > 4) {
				System.out.println("Escriba la opción correcta");

			}else {
				estado = true;
			}
		}while (!estado);

		return opcion;
	}

	public static void historicoJugadores (List<Jugador> jugadorList) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < jugadorList.size(); i++) {
			System.out.println((i+1) + ". Nombre: " + jugadorList.get(i).getName() + " Puntaje: "
					+ jugadorList.get(i).getPuntaje()+ " Fecha: " + jugadorList.get(i).getFecha());
		}
		int responseH = 0;
		do {
			System.out.println("\nPara volver al menu anterior marque 0.");
			responseH = Integer.parseInt(sc.nextLine());
			if (responseH != 0) {
				System.out.println("Escriba una opción correcta");
			}
		}while (responseH != 0);
	}


	public static Jugador registrarJugador() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingresa tu nombre");
		String name = String.valueOf(sc.nextLine());
		Jugador jugador = new Jugador(name, 0);

		return jugador;
	}

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










