package sistemas.entities;

import java.util.ArrayList;

public class HorarioAluno implements Horario{
	private EntidadeAcademica aluno;
	private ArrayList<Turma> turmasAluno;
	
	protected HorarioAluno(EntidadeAcademica entidadeAcademica) {
		if (!(entidadeAcademica instanceof Aluno)) {
			throw new RuntimeException("É necessário que seja um Aluno para que tenha um HorarioAluno"); 
		}
		
		this.aluno = entidadeAcademica;
		turmasAluno = new ArrayList<Turma>();
	}
	
	public void horario() {
		for (Turma turma : turmasAluno) {
			System.out.println(turma.getDisciplina().getNome());
			System.out.println(turma.getHorario().format(turma.formatoData));
		}
	}
	
	// Getters
	
	protected EntidadeAcademica getAluno() {
		return aluno;
	}

	public ArrayList<Turma> getTurmas() {
		return turmasAluno;
	}
	
}
