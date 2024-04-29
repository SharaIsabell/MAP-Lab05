package sistemas.entities;

import java.time.LocalDate;
import java.util.HashMap;

public class PedidoCompra {
	private int numeroPedido;
	private LocalDate data;
	private HashMap<String, Integer> materiais;
	
	public PedidoCompra(int numeroPedido, LocalDate data) {
		this.numeroPedido = numeroPedido;
		this.data = data;
		materiais = new HashMap<>();
	}
	
	public void adicionarMaterial(String material, int quantidade) {
		materiais.put(material, quantidade);
	}
	
	public void removerMaterial(String material) {
		materiais.remove(material);
	}

	//Getters
	
	public int getNumeroPedido() {
		return numeroPedido;
	}

	public LocalDate getData() {
		return data;
	}

	public HashMap<String, Integer> getMateriais() {
		return materiais;
	}
	
}
