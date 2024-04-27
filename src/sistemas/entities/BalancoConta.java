package sistemas.entities;

import java.util.HashMap;

public class BalancoConta {
	private HashMap<String, Double> ativos;
	private HashMap<String, Double> passivos;
	private double patrimonioLiquido;
	
	protected BalancoConta() {
		ativos = new HashMap<>();
		passivos = new HashMap<>();
	}

	public void adicionarAtivo(String descricao, double valor) {
		ativos.put(descricao, valor);
	}
	
	public void adicionarPassivo(String descricao, double valor) {
		passivos.put(descricao, valor);
	}
	
	public void calcularPatrimonioLiquido() {
		double totalAtivo = 0, totalPassivo = 0;
		for(double valor : ativos.values()) {
			totalAtivo += valor;
		}
		
		for(double valor : passivos.values()) {
			totalPassivo += valor;
		}
		
		patrimonioLiquido = totalAtivo - totalPassivo;
		
	}
	
	//Getters

	public HashMap<String, Double> getAtivos() {
		return ativos;
	}

	public HashMap<String, Double> getPassivos() {
		return passivos;
	}

	public double getPatrimonioLiquido() {
		return patrimonioLiquido;
	}
	
	

}
