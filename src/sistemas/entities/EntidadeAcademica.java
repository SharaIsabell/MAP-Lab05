package sistemas.entities;

public interface EntidadeAcademica {
	String getNome();
	String getMatricula();
	Horario getHorario();
	void adicionarHorario(Horario horario);
}
