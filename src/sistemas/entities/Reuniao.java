package sistemas.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Reuniao implements Compromisso{
	private LocalDateTime horario;
	private String local, decisao;
	private ArrayList<String> participantes;

	public Reuniao(LocalDateTime horario,String local, ArrayList<String> participantes) {
		this.horario = horario;
		this.local = local;
		this.participantes = participantes;
		decisao = null;
	}
	
	public void decisaoTomada(String decisao) {
		this.decisao = decisao;
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

	public String getDecisao() {
		return decisao;
	}

}
