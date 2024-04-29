package sistemas.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Turma {
	private ArrayList<Aluno> alunos;
	private EntidadeAcademica professor;
	private Disciplina disciplina;
	private LocalDateTime horario;
	public static DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
	private int quantidadeMaxima;
	
	public Turma(EntidadeAcademica entidadeAcademica, Disciplina disciplina, LocalDateTime horario, int quantidadeMaxima) {
		if (!(entidadeAcademica instanceof Professor)) {
			throw new RuntimeException("É necessário que seja um Professor para que tenha uma Turma");
		}
		this.professor = entidadeAcademica;
		this.disciplina = disciplina;
		this.horario = horario;
		this.quantidadeMaxima = quantidadeMaxima;
		alunos = new ArrayList<Aluno>();
	}
	
	protected boolean estaCheia() {
		return alunos.size() >= quantidadeMaxima;
	}
	
	// Getters & Setters
	
	protected EntidadeAcademica getProfessor() {
		return professor;
	}

	protected void setProfessor(Professor professor) {
		this.professor = professor;
	}

	protected ArrayList<Aluno> getAlunos() {
		return alunos;
	}

	protected Disciplina getDisciplina() {
		return disciplina;
	}

	protected LocalDateTime getHorario() {
		return horario;
	}

	protected int getQuantidadeMaxima() {
		return quantidadeMaxima;
	}
	
}