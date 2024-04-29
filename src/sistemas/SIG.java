package sistemas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import sistemas.entities.Aluno;
import sistemas.entities.Compromisso;
import sistemas.entities.EntidadeAcademica;
import sistemas.entities.Entrevista;
import sistemas.entities.Professor;
import sistemas.entities.Reuniao;

public class SIG {
	public static final DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
	public static final DateTimeFormatter formatoDataSemHora = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	// Administrativo
	public static Reuniao marcarReuniãoAdministrativo(String horario,String local, ArrayList<String> participantes) {
	    LocalDateTime horarioFormatado = LocalDateTime.parse(horario, formatoData);
	    
		return Administrativo.marcarReunião(horarioFormatado, local, participantes);
	}
	
	public static Entrevista marcarEntrevistaAdministrativo(String horario,String local, ArrayList<String> participantes) {
	    LocalDateTime horarioFormatado = LocalDateTime.parse(horario, formatoData);
	    
	    return Administrativo.marcarEntrevista(horarioFormatado, local, participantes);
	}
	
	public static void addParticipanteAdministrativo(String pessoa, Compromisso compromisso) {
		Administrativo.addParticipante(pessoa, compromisso);
	}
	
	// Financeiro
	public static void adicionarFolhaDePagamentoFinanceiro(LocalDate data, double ganhoPorHora, int horasTrabalhadas, String nome) {
		Financeiro.adicionarFolhaPagamento(data, ganhoPorHora, horasTrabalhadas, nome);
	}
	
	public static double calcularTotalSalariosFinanceiro() {
		return Financeiro.calcularTotalSalarios();
	}
	
	public static void addAtivo(String descricao, double valor) {
		Financeiro.getBalancoContas().adicionarAtivo(descricao, valor);
	}
	
	public static void addPassivo(String descricao, double valor) {
		Financeiro.getBalancoContas().adicionarPassivo(descricao, valor);
	}
	
	public static double calcularPatrimonioLiquido() {
		Financeiro.getBalancoContas().calcularPatrimonioLiquido();
		return Financeiro.getBalancoContas().getPatrimonioLiquido();
	}
	
	// Professor
	public static void mostrarHorario(EntidadeAcademica entidadeAcademica) {
		entidadeAcademica.getHorario().horario();
	}
	
	public static double mostrarTempoDeCasaProfessor(Professor professor) {
		return professor.getTempoDeCasa();
	}
	
	// Aluno
	public static void mostrarNotas(Aluno aluno) {
		for (double nota : aluno.getNotas()) {
			System.out.println(nota);
		}
	}
	
}
