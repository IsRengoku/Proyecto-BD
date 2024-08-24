import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

public class MostrarFormulario {

    private JFrame frame;
    private JPanel panel;
    private JLabel[] labels;
    private JTextField[] textFields;

    public void mostrarFormulario(ArrayList<Pacientes> formulario) {
        ArrayList<String> labelsText = new ArrayList<>();
        ArrayList<ArrayList<String>> textFieldsValues = new ArrayList<>();
    
        labelsText.add("Nombre: ");
        labelsText.add("Apellido: ");
        labelsText.add("Edad: ");
        labelsText.add("Tipo de sangre: ");
        labelsText.add("Última cita: ");
    
        for (Pacientes p : formulario) {
            ArrayList<String> pacienteValues = new ArrayList<>();
            pacienteValues.add(p.getNombre());
            pacienteValues.add(p.getApellido());
            pacienteValues.add(Integer.toString(p.getEdad()));
            pacienteValues.add(p.getTipoSangre());
            pacienteValues.add(p.getUltimaCita());
            textFieldsValues.add(pacienteValues);
        }
    
        createForm(labelsText, textFieldsValues);
    }
    
    private void createForm(ArrayList<String> labelsText, ArrayList<ArrayList<String>> textFieldsValues) {
        frame = new JFrame("Formulario");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
    
        panel = new JPanel();
        panel.setLayout(new GridLayout(textFieldsValues.size(), 2));
    
        labels = new JLabel[labelsText.size()];
        textFields = new JTextField[textFieldsValues.size() * labelsText.size()]; // Se multiplica por la cantidad de etiquetas para asegurar suficiente espacio
    
        int textFieldIndex = 0;
        for (int i = 0; i < textFieldsValues.size(); i++) {
            for (int j = 0; j < labelsText.size(); j++) {
                labels[j] = new JLabel(labelsText.get(j));
                textFields[textFieldIndex] = new JTextField(textFieldsValues.get(i).get(j));
                panel.add(labels[j]);
                panel.add(textFields[textFieldIndex]);
                textFieldIndex++;
            }
        }
    
        frame.add(panel);
        frame.setVisible(true);
    }
    
}

