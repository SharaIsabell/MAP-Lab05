package testes;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import sistemas.Administrativo;
import sistemas.entities.CompromissoException;
import sistemas.entities.Entrevista;
import sistemas.entities.Reuniao;

public class AdministrativoTest {

	static LocalDateTime horario;
	static ArrayList<String> participantes;
	static Reuniao reuniao;
	static Entrevista entrevista;
	static String local;
	
	@BeforeClass
	public static void criarObjetos() {
		horario = LocalDateTime.now();
        participantes = new ArrayList<>();
        local = "NUTES";
        participantes.add("João");
        participantes.add("Maria");
        reuniao = Administrativo.marcarReuniao(horario, local, participantes);
        entrevista = Administrativo.marcarEntrevista(horario, local, participantes);
	}
	
	@Test
	public void marcarReuniaoTest() { // Testa se a reunião foi marcada corretamente
		assertEquals(Administrativo.getReunioesAgendadas().get(0).getLocal(), reuniao.getLocal());
	}
	
	@Test(expected = CompromissoException.class)
	public void marcarReuniaoMesmoHorarioTest() { 
		Reuniao reuniao02 = Administrativo.marcarReuniao(horario, local, participantes);
	}
	
	@Test
	public void marcarEntrevistaTest() { // Testa se a entrevista foi marcada corretamente
		assertEquals(Administrativo.getEntrevistasAgendadas().get(0).getLocal(), entrevista.getLocal());
	}
	
	@Test(expected = CompromissoException.class)
	public void marcarEntrevistaMesmoHorarioTest() {
		Entrevista entrevista02 = Administrativo.marcarEntrevista(horario, local, participantes);
	}

}
