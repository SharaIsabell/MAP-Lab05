package sistemas.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Entrevista implements Compromisso{
	private LocalDateTime horario;
	private String local;
	private ArrayList<String> participantes;
	
	public Entrevista(LocalDateTime horario,String local, ArrayList<String> participantes) {
		this.horario = horario;
		this.local = local;
		this.participantes = participantes;
	}
	
	//Getters

	public LocalDateTime getHorario() {
		return horario;
	}

	public String getLocal() {
		return local;
	}

	public ArrayList<String> getParticipantes() {
		return participantes;
	}

}
