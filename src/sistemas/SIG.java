package sistemas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import sistemas.entities.Aluno;
import sistemas.entities.Compromisso;
import sistemas.entities.EntidadeAcademica;
import sistemas.entities.Entrevista;
import sistemas.entities.PedidoCompra;
import sistemas.entities.Professor;
import sistemas.entities.Reuniao;
import sistemas.entities.Sala;

public class SIG {
	public static final DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
	public static final DateTimeFormatter formatoDataSemHora = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	// Administrativo
	public static Reuniao marcarReuniaoAdministrativo(String horario,String local, ArrayList<String> participantes) {
	    LocalDateTime horarioFormatado = LocalDateTime.parse(horario, formatoData);
	    
		return Administrativo.marcarReuniao(horarioFormatado, local, participantes);
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
	
	// Almoxarifado
	public static void adicionarNoEstoqueAlmoxarifado(String material, int quantidade) {
		Almoxarifado.adicionarNoEstoque(material, quantidade);
	}
	
	public static int verificarEstoqueAlmoxarifado(String material) {
		return Almoxarifado.verificarEstoque(material);
	}
	
	public static void registrarNovoPedidoAlmoxarifado(int numeroPedido, LocalDate data) {
		Almoxarifado.registrarNovoPedido(numeroPedido, data);
	}
	
	public static ArrayList<PedidoCompra> verificarListaPedidosAlmoxarifado(){
		return Almoxarifado.getPedidosCompra();
	}
	
	// Infraestura
	public static Sala adicionarSalaInfraestrutura(String nome, int capacidade) {
		return Infraestrutura.adicionarSala(nome, capacidade);
	}
	
	public static void reservarSalaInfraestrutura(Sala sala, LocalDate data) {
		Infraestrutura.reservarSala(sala, data);
	}
	
	public static HashMap<Sala, Set<LocalDate>> verificarSalasReservadasInfraestrutura(){
		return Infraestrutura.getSalasReservadas();
	}
	
}
