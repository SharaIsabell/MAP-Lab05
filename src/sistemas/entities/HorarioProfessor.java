package sistemas.entities;

import java.util.ArrayList;

public class HorarioProfessor implements Horario{
	private EntidadeAcademica professor;
	private ArrayList<Turma> turmasProf;
	
	public HorarioProfessor(EntidadeAcademica entidadeAcademica) {
		if (!(entidadeAcademica instanceof Professor)) {
			throw new RuntimeException("É necessário que seja um Professor para que tenha um HorarioProfessor"); 
		}
		
		this.professor = entidadeAcademica;
		turmasProf = new ArrayList<Turma>();
	}
	
	public void horario() {
		System.out.printf("Horário de %s:\n", professor.getNome());
		for (Turma turma : turmasProf) {
			System.out.println(turma.getDisciplina().getNome());
			System.out.println(turma.getHorario().format(turma.formatoData));
		}
	}

	// Getters
	
	protected EntidadeAcademica getProfessor() {
		return professor;
	}

	public ArrayList<Turma> getTurmas() {
		return turmasProf;
	}
	
}
