import java.util.Scanner;
import java.util.ArrayList;

//Clase main del programa
public class CitasMedicas {
    private Scanner sc = new Scanner(System.in);
    private ArrayList<Pacientes> formulario = new ArrayList<>();

    public static void main(String[] args) {
        CitasMedicas cm = new CitasMedicas();
        cm.SystemLoop();
    }
    
    private void SystemLoop(){
        System.out.println("¡Bienvenido al sistema de citas!");
        String continuar = "si";
        while (continuar.equalsIgnoreCase("si")) {
            int movimiento;
            System.out.println("Indique el numero del movimiento que quiere realizar: ");
            System.out.println("1. Agregar un paciente");
            System.out.println("2. Asignar cita");
            System.out.println("3. Consultar disponibilidad doctores");
            System.out.println("4. Mostrar formulario");
            System.out.println("5. Salir");
            movimiento = sc.nextInt();
            switch (movimiento){
                case 1:
                    Pacientes nuevoPaciente = agregarPaciente();
                    formulario.add(nuevoPaciente);
                    System.out.println("El paciente se guardó exitosamente");
                    System.out.println("Nombre: " + nuevoPaciente.getNombre());
                    System.out.println("Apellido: " + nuevoPaciente.getApellido());
                    System.out.println("Edad: " + nuevoPaciente.getEdad());
                    System.out.println("Tipo de sangre: " + nuevoPaciente.getTipoSangre());
                    System.out.println("Última cita: " + nuevoPaciente.getUltimaCita());
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Ingrese el número del paciente que quiere seleccionar: ");
                    int numeroPaciente = sc.nextInt();
                    sc.nextLine();
                    Pacientes pacienteSeleccionado = null;
                    for (Pacientes p : formulario){
                        if (p.getNumeroPaciente() == numeroPaciente   - 1){
                            pacienteSeleccionado = p;
                            String fechaProximaCita;
                            AsignarCitas  ac = new AsignarCitas();
                            fechaProximaCita = ac.asignarCitas(formulario, pacienteSeleccionado);
                            if (fechaProximaCita == null) {
                                System.out.println("Al paciente no se le puede asignar cita por ser menor de edad");
                            }
                            else{
                                System.out.println("La cita del paciente " + numeroPaciente + " se ha asignado con exito" + "\nFecha de la proxima cita: " + fechaProximaCita);
                                System.out.println();
                            }
                            break;
                        }
                    }
                    if (pacienteSeleccionado == null){
                        System.out.println("No se encontró ese numero de paciente.");
                        System.out.println();
                    }
                    break;
                case 3:
                    Doctores doctor  = new Doctores();
                    doctor.agregarDoctores();
                    doctor.disponiblidadDoctor();
                    break;
                case 4:
                    MostrarFormulario m = new MostrarFormulario();
                    m.mostrarFormulario(formulario);
                    break;
                case 5:
                    System.out.println("¡Hasta luego!");
                    continuar = "no";
                    break;
                default:
                    System.out.println("Opción no válida, intentelo nuevamente.");
                    break;
            }
        }
    }

    private Pacientes agregarPaciente() {
        System.out.println();
        System.out.println("Ingrese el nombre del paciente");
        String nombre = sc.next();
        System.out.println();
        System.out.println("Ingrese el apellido del paciente");
        String  apellido = sc.next();
        System.out.println();
        System.out.println("Ingrese la edad del paciente");
        int edad = sc.nextInt();
        System.out.println();
        sc.nextLine();
        System.out.println("Ingrese el tipo de sangre del paciente");
        String tipoSangre = sc.next();
        System.out.println();
        System.out.println("Ingrese la fecha de la última cita medica del paciente (yyyy-mm-dd)");
        String fecha = sc.next();
        System.out.println();
        fecha = fecha.replace( " ", "-" );
        Pacientes nuevoPaciente = new Pacientes();
        nuevoPaciente.setNombre(nombre);
        nuevoPaciente.setApellido(apellido);
        nuevoPaciente.setEdad(edad);
        nuevoPaciente.setTipoSangre(tipoSangre);
        nuevoPaciente.setUltimaCita(fecha);
        return nuevoPaciente;
    }
}
