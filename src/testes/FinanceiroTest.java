package testes;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.BeforeClass;
import org.junit.Test;

import sistemas.Financeiro;
import sistemas.SIG;

public class FinanceiroTest {

	static LocalDate data;
	static double ganhoPorHora;
	static int horasTrabalhadas;
	static String nome;
	static double totalSalario;
	
	@BeforeClass
	public static void criarObjetos() {
		data = LocalDate.parse("06/05/2024", SIG.formatoDataSemHora);
		ganhoPorHora = 27.8;
		horasTrabalhadas = 8;
		nome = "Daniel";
		
		Financeiro.adicionarFolhaPagamento(data, ganhoPorHora, horasTrabalhadas, nome);
		totalSalario = Financeiro.calcularTotalSalarios();
	}
	
	@Test
	public void adicionarFolhaPagamentoTest() {
		assertEquals(Financeiro.getFolhasPagamento().get(0).getHorasTrabalhadas(), 8);
	}
	
	@Test
	public void calcularTotalSalarioTest() {
		assertEquals(totalSalario, 6672, 0);
	}

}
