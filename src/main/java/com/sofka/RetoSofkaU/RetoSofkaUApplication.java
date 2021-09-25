package com.sofka.RetoSofkaU;

import com.sofka.RetoSofkaU.models.Pregunta;
import com.sofka.RetoSofkaU.services.Consultas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.sofka.RetoSofkaU.repositories.JugadorCrudRepository;
import com.sofka.RetoSofkaU.repositories.PreguntaCrudRepsitory;


import java.util.ArrayList;
import java.util.List;

import static com.sofka.RetoSofkaU.ui.UIMenu.showMenu;

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
		System.out.println("Bienvenidos al Challenge");
		System.out.println("Concurso de Preguntas y Respuestas");
		System.out.println("\n");

		//showMenu();

		/*String enunciado = "cuanto es 2 + 2?";
		int categoria = 1;
		int idPregunta = 2;
		List<String> opciones  = new ArrayList<>(4);
		opciones.add("1");
		opciones.add("2");
		opciones.add("3");
		opciones.add("4");
		int respuestaCorrecta = 4;

		Pregunta pregunta = new Pregunta(idPregunta, categoria, enunciado, opciones, respuestaCorrecta);
		preguntaCrudRepsitory.save(pregunta);*/

		List<Pregunta> preguntaList = preguntaCrudRepsitory.findPreguntaByCategoriaAndIdPregunta(1,2);
		System.out.println("este dato: " + preguntaList);
		System.out.println(preguntaList.get(0).getEnunciado());
		System.out.println("1. " + preguntaList.get(0).getOpciones().get(0));
		System.out.println("2. " + preguntaList.get(0).getOpciones().get(1));
		System.out.println("3. " + preguntaList.get(0).getOpciones().get(2));
		System.out.println("4. " + preguntaList.get(0).getOpciones().get(3));





		/*System.out.println("Hello Mundo");
		//Pregunta pregunta = new Pregunta(1, 2, );
		//preguntaCrudRepsitory.save(pregunta);
		//Jugador jugador = new Jugador( "Camilo", 200);
		//jugadorCrudRepository.save(jugador);

		List<Jugador> jugadorList = jugadorCrudRepository.findAll();
		System.out.println("Este es el dato: " + jugadorList.get(0).getName());*/


	}
}
