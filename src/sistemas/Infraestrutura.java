package sistemas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import sistemas.entities.Sala;

public class Infraestrutura {
	private static ArrayList<Sala> salas = new ArrayList<Sala>();
	private static HashMap<Sala, Set<LocalDate>> salasReservadas = new HashMap<Sala, Set<LocalDate>>();
	
	public static Sala adicionarSala(String nome, int capacidade) {
		Sala sala = new Sala(nome, capacidade);
		salas.add(sala);
		return sala;
	}
	
	public static void reservarSala(Sala sala, LocalDate data) {
		if(!salasReservadas.containsKey(sala)) {
			salasReservadas.put(sala, new HashSet<>());
		}
		salasReservadas.get(sala).add(data);
	}

	//Getters
	
	public static ArrayList<Sala> getSalas() {
		return salas;
	}

	public static HashMap<Sala, Set<LocalDate>> getSalasReservadas() {
		return salasReservadas;
	}

}
