package testes;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import sistemas.Administrativo;
import sistemas.Almoxarifado;
import sistemas.Financeiro;
import sistemas.Infraestrutura;
import sistemas.SIG;
import sistemas.entities.CompromissoException;
import sistemas.entities.CreatorTurmas;
import sistemas.entities.Entrevista;
import sistemas.entities.Professor;
import sistemas.entities.Reuniao;
import sistemas.entities.Sala;

public class SIGTest {

	static String horario, local, nome, descricaoAtivo, descricaoPassivo, material, nomeSala;
	static ArrayList<String> participantes;
	static Reuniao reuniao;
	static Entrevista entrevista;
	static double ganhoPorHora, totalSalario, valorAtivo, valorPassivo, patrimonioLiquido;
	static int horasTrabalhadas, estoque, quantidade, numeroPedido, capacidade;
	static LocalDate data;
	static Professor professor;
	static Sala sala;
	
	@BeforeClass
	public static void criarObjetos() {
		horario = "01/09/2024 07:59";
		data = LocalDate.parse("06/05/2024", SIG.formatoDataSemHora);
        participantes = new ArrayList<>();
        local = "NUTES";
        participantes.add("João");
        participantes.add("Maria");
        ganhoPorHora = 27.8;
		horasTrabalhadas = 8;
		nome = "Davis";
		descricaoAtivo = "Para um equipamento de laboratório";
		valorAtivo = 1449.50;
		descricaoPassivo = "Para uma dívida tributária";
		valorPassivo = 1040.14;
		professor = CreatorTurmas.cadastrarProfessor("Ana", "0456");
		professor.setTempoDeCasa(9.2);
		material = "Caneta";
		quantidade = 267;
		numeroPedido = 4;
		nomeSala = "LAB.IV";
		capacidade = 23;
		
		sala = SIG.adicionarSalaInfraestrutura(nomeSala, capacidade);
		SIG.reservarSalaInfraestrutura(sala, data);
		
		SIG.adicionarNoEstoqueAlmoxarifado(material, quantidade);
		estoque = SIG.verificarEstoqueAlmoxarifado(material);
		SIG.registrarNovoPedidoAlmoxarifado(numeroPedido, data);
		
        reuniao = SIG.marcarReuniaoAdministrativo(horario, local, participantes);
        entrevista = SIG.marcarEntrevistaAdministrativo(horario, local, participantes);
        
        SIG.adicionarFolhaDePagamentoFinanceiro(data, ganhoPorHora, horasTrabalhadas, nome);
		totalSalario = SIG.calcularTotalSalariosFinanceiro();
		
		SIG.addAtivo(descricaoAtivo, valorAtivo);
		SIG.addPassivo(descricaoPassivo, valorPassivo);
		patrimonioLiquido = SIG.calcularPatrimonioLiquido();
		
		SIG.mostrarTempoDeCasaProfessor(professor);
	}
	
	@Test
	public void marcarReuniaoTest() { // Testa se a reunião foi marcada corretamente
		assertEquals(Administrativo.getReunioesAgendadas().get(0).getLocal(), reuniao.getLocal());
	}
	
	@Test
	public void marcarEntrevistaTest() { // Testa se a entrevista foi marcada corretamente
		assertEquals(Administrativo.getEntrevistasAgendadas().get(0).getLocal(), entrevista.getLocal());
	}
	
	@Test
	public void adicionarFolhaPagamentoTest() {
		assertEquals(Financeiro.getFolhasPagamento().get(0).getHorasTrabalhadas(), 8);
	}
	
	@Test
	public void calcularTotalSalarioTest() {
		assertEquals(totalSalario, 6672, 0);
	}
	
	@Test
	public void calcularPatrimonioLiquidoTest() {
		assertEquals(patrimonioLiquido, 409.35, 1);
	}
	
	@Test
	public void mostrarTempoDeCasaProfessorTest() {
		assertEquals(professor.getTempoDeCasa(), 9.2, 0);
	}
	
	@Test
	public void adicionarNoEstoqueTest() {
		assertTrue(Almoxarifado.getEstoque().containsKey(material));
	}
	
	@Test
	public void verificarEstoqueTest() {
		assertEquals(Almoxarifado.getEstoque().get(material).intValue(), estoque);
	}
	
	@Test
	public void registrarNovoPedidoTest() {
		assertEquals(Almoxarifado.getPedidosCompra().get(0).getNumeroPedido(), 4);
	}

	@Test
	public void adicionarSalaTest() {
		assertEquals(Infraestrutura.getSalas().get(0).getNome(), "LAB.IV");
	}
	
	@Test
	public void reservarSalaTest() {
		assertTrue(Infraestrutura.getSalasReservadas().containsKey(sala));
	}

}
