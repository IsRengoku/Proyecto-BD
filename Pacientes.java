public class Pacientes {
    
    private String nombre;
    private String apellido;
    private int edad;
    private String tipoSangre;
    private String ultimaCita;
    private int numeroPaciente;

    public Pacientes() {
    
    }

    public int getNumeroPaciente(){
        return numeroPaciente;
    }

    public void setNumeroPaciente(int numeroPaciente){
        this.numeroPaciente = numeroPaciente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public String getUltimaCita() {
        return ultimaCita;
    }

    public void setUltimaCita(String ultimaCita) {
        this.ultimaCita = ultimaCita;
    }
}

