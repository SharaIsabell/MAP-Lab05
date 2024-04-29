package sistemas.entities;

import java.util.ArrayList;

public class Aluno implements EntidadeAcademica {
	private String nome, matricula;
	private Horario horarioAluno;
	private ArrayList<Double> notas;

	protected Aluno(String nome, String matricula) {
		this.nome = nome;
		this.matricula = matricula;
		this.notas = new ArrayList<Double>();
	}
	
	public void adicionarHorario(Horario horarioAluno) {
		this.horarioAluno = horarioAluno;
	}
	
	public void adicionarNota(double nota) {
		this.notas.add(nota);
	}
	
	// Getters
	
	public String getNome() {
		return nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public Horario getHorario() {
		return horarioAluno;
	}
	
	public ArrayList<Double> getNotas(){
		return notas;
	}
	
}