import java.util.Scanner;
import java.util.ArrayList;

public class Doctores {
    private String nombreDoc;
    private String apellidoDoc;
    private String fechaDisponible;
    private ArrayList<Doctores> doctores = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void setNombreDoc(String nombreDoc) {
        this.nombreDoc = nombreDoc;
    }

    public String getNombreDoc() {
        return this.nombreDoc;
    }

    public void setApellidoDoc(String apellidoDoc) {
        this.apellidoDoc = apellidoDoc;
    }

    public String getApellidoDoc() {
        return this.apellidoDoc;
    }

    public void setFechaDisp(String fechaDisponible) {
        this.fechaDisponible = fechaDisponible;
    }

    public String getFechaDisp() {
        return this.fechaDisponible;
    }

    public void agregarDoctores() {
        String continuar = "si";
        while (continuar.equalsIgnoreCase("si")) {
            doctores.add(agregandoLista());
            System.out.println("¿Quiere ingresar otro doctor?");
            continuar = sc.next().toLowerCase();
        }
    }

    private Doctores agregandoLista() {
        System.out.println("Ingrese los datos del doctor: ");
        System.out.println();
        System.out.println("Ingrese el nombre del doctor");
        String nombreDoctor = sc.next();
        System.out.println();
        System.out.println("Ingrese el apellido del doctor");
        String apellidoDoctor = sc.next();
        System.out.println();
        System.out.println("Ingrese la fecha disponible del doctor (yyyy-MM-dd)");
        String fechadispo = sc.next();
        System.out.println();
        Doctores doc = new Doctores();
        doc.setNombreDoc(nombreDoctor);
        doc.setApellidoDoc(apellidoDoctor);
        doc.setFechaDisp(fechadispo);
        return doc;
    }

    public void disponiblidadDoctor() {
        System.out.println("Ingrese la fecha de cita dada para verificar disponibilidad (yyyy-MM-dd): ");
        String fecha = sc.next();
        boolean disponible = false;
        for (Doctores doc : doctores) {
            if (doc.getFechaDisp().equals(fecha)) {
                System.out.println("El doctor " + doc.getNombreDoc() + " " + doc.getApellidoDoc() + " está disponible en la fecha " + fecha);
                System.out.println();
                break;
            }
            else{
                disponible = true;
            }
        }
        if (disponible) {
            System.out.println("No hay doctores disponibles en la fecha " + fecha);
        }
    }
}
