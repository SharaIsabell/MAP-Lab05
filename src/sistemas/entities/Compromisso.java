package sistemas.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;

public interface Compromisso {
	LocalDateTime getHorario();
	String getLocal();
	ArrayList<String> getParticipantes();
}
