package sistemas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import sistemas.entities.Aluno;
import sistemas.entities.CreatorTurmas;
import sistemas.entities.Entrevista;
import sistemas.entities.Horario;
import sistemas.entities.PedidoCompra;
import sistemas.entities.Professor;
import sistemas.entities.Reuniao;
import sistemas.entities.Sala;
import sistemas.entities.Turma;

public class Main {
	public static void main(String[] args) {
		System.out.println("Administrativo");
		ArrayList<String> participantesReuniao = new ArrayList<String>();
		ArrayList<String> participantesEntrevista = new ArrayList<String>();
		Reuniao reuniao01 = SIG.marcarReuniaoAdministrativo("29/04/2024 10:50", "NUTES", participantesReuniao);
		Entrevista entrevista01 = SIG.marcarEntrevistaAdministrativo("01/05/2024 14:00", "CIAC", participantesEntrevista);
		
		SIG.addParticipanteAdministrativo("Shara", reuniao01);
		SIG.addParticipanteAdministrativo("Rennan", entrevista01);
		
		System.out.println("Participantes da Reunião " + reuniao01.getLocal() + " " + SIG.formatoData.format(reuniao01.getHorario()) + ":");
		for (String pessoa : participantesReuniao) {
			System.out.println(pessoa);
		}
		
		System.out.println("Participantes da Entrevista "  + entrevista01.getLocal() + " " + SIG.formatoData.format(entrevista01.getHorario()) + ":");
		for (String pessoa : participantesEntrevista) {
			System.out.println(pessoa);
		}
		
		// Financeiro
		System.out.println();
		System.out.println("Financeiro");
		SIG.adicionarFolhaDePagamentoFinanceiro(LocalDate.parse("07/05/2024", SIG.formatoDataSemHora), 11.7, 8, "Robson");
		SIG.adicionarFolhaDePagamentoFinanceiro(LocalDate.parse("06/05/2024", SIG.formatoDataSemHora), 14.9, 4, "Asheley");
		System.out.println("Total Salário dos Funcionários: " + SIG.calcularTotalSalariosFinanceiro()); 
		SIG.addAtivo("Para um equipamento de laboratório", 1449.49);
		SIG.addAtivo("Para um fundo de bolsas de estudo", 3551.11);
		SIG.addPassivo("Para uma dívida tributária", 2578.14);
		System.out.printf("Patrimônio Líquido: %.2f\n", SIG.calcularPatrimonioLiquido());
		
		
		// Professor
		System.out.println();
		System.out.println("Professor");
		Professor professor = CreatorTurmas.cadastrarProfessor("Sabrina", "0504");
		professor.setTempoDeCasa(9.2);
		
		Horario horarioProfessor = CreatorTurmas.criarHorario(professor);
		professor.adicionarHorario(horarioProfessor);
		Turma turma = CreatorTurmas.criarTurma(professor, CreatorTurmas.criarDisciplina("MAP", "01"), LocalDateTime.parse("04/08/2013 10:15", SIG.formatoData), 10);
		System.out.println("Tempo de Casa de " + professor.getNome() + " " + SIG.mostrarTempoDeCasaProfessor(professor) + " anos");
		SIG.mostrarHorario(professor);
		
		// Aluno
		System.out.println();
		System.out.println("Aluno");
		Aluno aluno = CreatorTurmas.cadastrarAluno("Horácio", "1597");
		Horario horarioAluno = CreatorTurmas.criarHorario(aluno);
		aluno.adicionarHorario(horarioAluno);
		
		System.out.println("Notas: ");
		aluno.adicionarNota(4.5);
		aluno.adicionarNota(8.1);
		SIG.mostrarNotas(aluno);
		
		CreatorTurmas.matricularAluno(aluno, turma);
		System.out.println("RDM: ");
		SIG.mostrarHorario(aluno);
		
		// Almoxarifado
		System.out.println();
		System.out.println("Almoxarifado");
		SIG.adicionarNoEstoqueAlmoxarifado("Caneta", 200);
		System.out.println("Quantidade em Estoque: " + SIG.verificarEstoqueAlmoxarifado("Caneta"));
		SIG.registrarNovoPedidoAlmoxarifado(6, LocalDate.parse("24/08/2024", SIG.formatoDataSemHora));
		
		for (PedidoCompra p1 : SIG.verificarListaPedidosAlmoxarifado()) {
			System.out.println("N°Pedido: " + p1.getNumeroPedido() + ", Data: " + p1.getData());
		}
		
		// Infraestrutura
		System.out.println();
		System.out.println("Infraestrutura");
		Sala sala = SIG.adicionarSalaInfraestrutura("LAB.V", 15);
		System.out.println("Sala Criada: " + sala);
		SIG.reservarSalaInfraestrutura(sala, LocalDate.parse("01/11/2023", SIG.formatoDataSemHora));
		
		for (Map.Entry<Sala, Set<LocalDate>> entry : SIG.verificarSalasReservadasInfraestrutura().entrySet()) {
            Sala sala1 = entry.getKey();
            Set<LocalDate> datasReservadas = entry.getValue();
            
            System.out.println("Sala: " + sala1);
            System.out.println("Datas reservadas: " + datasReservadas);
        }
	}
}
