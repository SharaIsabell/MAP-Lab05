package sistemas.entities;

import java.time.LocalDateTime;

public class CreatorTurmas {
	public static Professor cadastrarProfessor(String nome, String matricula) {
		return new Professor(nome, matricula);
	}
	
	public static Aluno cadastrarAluno(String nome, String matricula) {
		return new Aluno(nome, matricula);
	}
	
	public static Disciplina criarDisciplina(String nome, String id) {
		Disciplina disciplina = new Disciplina(nome, id);
		return disciplina;
	}
	
	public static Horario criarHorario(EntidadeAcademica entidadeAcademica) {
		if (entidadeAcademica instanceof Professor) {
			return new HorarioProfessor(entidadeAcademica);
		} else if (entidadeAcademica instanceof Aluno){
			return new HorarioAluno(entidadeAcademica);
		} else {
			throw new RuntimeException("É necessário que seja um Professor ou um Aluno para ter um Horário");
		}
	}
	
	public static Turma criarTurma(EntidadeAcademica professor, Disciplina disciplina, LocalDateTime horario, int quantidadeMaxima) {
		Turma turma = new Turma(professor, disciplina, horario, quantidadeMaxima);
		professor.getHorario().getTurmas().add(turma);
		return turma;
	}
	
	public static void matricularAluno(Aluno aluno, Turma turma) {
		for (int i = 0; i < aluno.getHorario().getTurmas().size(); i++) { // Verifica se a nova Turma causa choque de horário com as turmas do horário do Aluno
			if (aluno.getHorario().getTurmas().get(i).getHorario() == turma.getHorario()) {
				throw new RuntimeException("Choque de Horário");
			}
		}
		
		aluno.getHorario().getTurmas().add(turma);
		turma.getAlunos().add(aluno);
	}
}
