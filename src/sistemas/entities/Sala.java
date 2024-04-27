package sistemas.entities;

public class Sala {
	private String nome;
	private int capacidade;
	
	public Sala(String nome, int capacidade) {
		this.nome = nome;
		this.capacidade = capacidade;
	}

	//Getters
	
	public String getNome() {
		return nome;
	}

	public int getCapacidade() {
		return capacidade;
	}

}
