package testes;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.BeforeClass;
import org.junit.Test;

import sistemas.Infraestrutura;
import sistemas.SIG;
import sistemas.entities.Sala;

public class InfraestruturaTest {

	static LocalDate data;
	static String nome;
	static int capacidade;
	static Sala sala;
	
	@BeforeClass
	public static void criarObjetos() {
		data = LocalDate.parse("06/05/2024", SIG.formatoDataSemHora);
		nome = "LAB.IV";
		capacidade = 23;
		
		sala = Infraestrutura.adicionarSala(nome, capacidade);
		Infraestrutura.reservarSala(sala, data);
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
