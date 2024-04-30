package sistemas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import sistemas.entities.PedidoCompra;

public class Almoxarifado {
	private static HashMap<String, Integer> estoque = new HashMap<String, Integer>();
	private static ArrayList<PedidoCompra> pedidosCompra = new ArrayList<PedidoCompra>();
	
	public static void adicionarNoEstoque(String material, int quantidade) {
		if (estoque.containsKey(material)) {
			estoque.put(material, estoque.get(material) + quantidade); 
		}
		estoque.put(material, quantidade);
	}
	
	public static int verificarEstoque(String material) {
		return estoque.getOrDefault(material, 0);
	}
	
	public static void registrarNovoPedido(int numeroPedido, LocalDate data){
		PedidoCompra pedido = new PedidoCompra(numeroPedido, data);
		pedidosCompra.add(pedido);
	}
	
	//Getters

	public static HashMap<String, Integer> getEstoque() {
		return estoque;
	}

	public static ArrayList<PedidoCompra> getPedidosCompra() {
		return pedidosCompra;
	}
}
