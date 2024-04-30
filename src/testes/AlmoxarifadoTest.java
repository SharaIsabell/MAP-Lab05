package testes;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.BeforeClass;
import org.junit.Test;

import sistemas.Almoxarifado;
import sistemas.SIG;

public class AlmoxarifadoTest {

	static String material;
	static int quantidade;
	static LocalDate data;
	static int numeroPedido;
	static int estoque;
	
	@BeforeClass
	public static void criarObjetos() {
		material = "Caneta";
		quantidade = 267;
		numeroPedido = 4;
		data = LocalDate.parse("06/05/2024", SIG.formatoDataSemHora);
		
		Almoxarifado.adicionarNoEstoque(material, quantidade);
		estoque = Almoxarifado.verificarEstoque(material);
		Almoxarifado.registrarNovoPedido(numeroPedido, data);
		
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

}
