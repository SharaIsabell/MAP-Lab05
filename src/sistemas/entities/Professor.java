package sistemas.entities;

public class Professor implements EntidadeAcademica{
	private String nome, matricula;
	private Horario horarioProfessor;
	private double tempoDeCasa;

	public Professor(String nome, String matricula) {
		this.nome = nome;
		this.matricula = matricula;
	}
	
	public void adicionarHorario(Horario horarioProfessor) {
		this.horarioProfessor = horarioProfessor;
	}
	
	// Getters & Setter
	public void setTempoDeCasa(double tempoDeCasa) {
		this.tempoDeCasa = tempoDeCasa;
	}
	
	public double getTempoDeCasa() {
		return tempoDeCasa;
	}
	
	public String getNome() {
		return nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public Horario getHorario() {
		return horarioProfessor;
	}
	
}
