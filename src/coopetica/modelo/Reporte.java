package coopetica.modelo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;

public class Reporte {

    public void guardarReporte(String contenido) {

        JFileChooser selector = new JFileChooser();

        int resultado = selector.showSaveDialog(null);

        if (resultado == JFileChooser.APPROVE_OPTION) {

            File archivo = selector.getSelectedFile();

            try (FileWriter escritor = new FileWriter(archivo)) {

                escritor.write(contenido);

                javax.swing.JOptionPane.showMessageDialog(
                        null, "Reporte guardado correctamente");

            } catch (IOException e) {

                javax.swing.JOptionPane.showMessageDialog(
                        null, "Error alsss guardar el reporte: " + e.getMessage());
            }
        }
    }
}