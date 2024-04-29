package sistemas;

import java.time.LocalDateTime;
import java.util.ArrayList;

import sistemas.entities.Compromisso;
import sistemas.entities.CompromissoException;
import sistemas.entities.Entrevista;
import sistemas.entities.Reuniao;

public class Administrativo {
	private static ArrayList<Reuniao> reunioesAgendadas = new ArrayList<>();
	private static ArrayList<Entrevista> entrevistasAgendadas = new ArrayList<>();
	
	protected static Reuniao marcarReunião(LocalDateTime horario,String local, ArrayList<String> participantes) {
		Reuniao reuniao = new Reuniao(horario, local, participantes);
		for(Reuniao reuniaoMarcada : reunioesAgendadas) {
			if(reuniaoMarcada.getHorario() == reuniao.getHorario()) {
				throw new CompromissoException("Já existe uma reunião marcada neste horário");
			}
		}
		reunioesAgendadas.add(reuniao);
		return reuniao;
	}
	
	protected static Entrevista marcarEntrevista(LocalDateTime horario,String local, ArrayList<String> participantes) {
		Entrevista entrevista = new Entrevista(horario, local, participantes);
		for(Entrevista entrevistaMarcada : entrevistasAgendadas) {
			if(entrevistaMarcada.getHorario() == entrevista.getHorario()) {
				throw new CompromissoException("Já existe uma entrevista marcada neste horário");
			}
		}
		entrevistasAgendadas.add(entrevista);
		return entrevista;
	}
	
	protected static void addParticipante(String pessoa, Compromisso compromisso) {
		compromisso.getParticipantes().add(pessoa);
	}

	protected static ArrayList<Reuniao> getReunioesAgendadas() {
		return reunioesAgendadas;
	}

	protected static ArrayList<Entrevista> getEntrevistasAgendadas() {
		return entrevistasAgendadas;
	}
	
}
