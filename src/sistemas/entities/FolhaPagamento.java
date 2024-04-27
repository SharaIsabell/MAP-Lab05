package sistemas.entities;

import java.time.LocalDate;

public class FolhaPagamento {
	private LocalDate data;
	private double ganhoPorHora;
	private int horasTrabalhadas;
	private String nome;
	
	public FolhaPagamento(LocalDate data, double ganhoPorHora, int horasTrabalhadas, String nome) {
		this.data = data;
		this.ganhoPorHora = ganhoPorHora;
		this.horasTrabalhadas = horasTrabalhadas;
		this.nome = nome;
	}
	
	public double calcularSalario() {
		return ganhoPorHora * horasTrabalhadas;
	}

	//Getters
	
	public LocalDate getData() {
		return data;
	}

	public double getGanhoPorHora() {
		return ganhoPorHora;
	}

	public int getHorasTrabalhadas() {
		return horasTrabalhadas;
	}

	public String getNome() {
		return nome;
	}
}
