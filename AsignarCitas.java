
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AsignarCitas {
    int edadPaciente;
    Pacientes pacientes = new Pacientes();
    LocalDate fechaActual = LocalDate.now();
    
    public String asignarCitas(ArrayList<Pacientes> pacientes, Pacientes pacienteSeleccionado) {
        String fechaPaciente = null;
        for (Pacientes paciente : pacientes) {
            if (paciente.getNumeroPaciente() == pacienteSeleccionado.getNumeroPaciente()) {
                edadPaciente = paciente.getEdad();
                if (edadPaciente > 45) {
                    fechaPaciente = fechaActual.plusDays(15).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                }
                else if (edadPaciente > 35) {
                    fechaPaciente = fechaActual.plusMonths(1).plusDays(15).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                }
                else if (edadPaciente > 25) {
                    fechaPaciente = fechaActual.plusMonths(2).plusDays(15).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                }
                else if (edadPaciente >= 18) {
                    fechaPaciente = fechaActual.plusMonths(3).plusDays(15).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                }
                else {
                    System.out.println("El paciente no cumple con los requisitos para asignarle una cita");
                }
            }
        }
        return fechaPaciente;
    }
}
