package arbolavl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame ventana = new JFrame("Árbol AVL");
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana.setSize(800, 600);
            ventana.setLayout(new BorderLayout());

            PanelArbol<Integer> panelArbol = new PanelArbol<>();
            ArbolAvl<Integer> arbol = new ArbolAvl<>(panelArbol);

            // Panel de control con botones
            JPanel panelControl = new JPanel();
            JTextField campoValor = new JTextField(5);
            JButton botonInsertar = new JButton("Insertar");
            JButton botonEliminar = new JButton("Eliminar");

            panelControl.add(new JLabel("Valor:"));
            panelControl.add(campoValor);
            panelControl.add(botonInsertar);
            panelControl.add(botonEliminar);

            // Acción para insertar un nodo
            botonInsertar.addActionListener(e -> {
                try {
                    int valor = Integer.parseInt(campoValor.getText());
                    arbol.insertar(valor);
                    campoValor.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(ventana, "Ingrese un número válido.");
                }
            });

            // Acción para eliminar un nodo
            botonEliminar.addActionListener(e -> {
                try {
                    int valor = Integer.parseInt(campoValor.getText());
                    arbol.borrar(valor);
                    campoValor.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(ventana, "Ingrese un número válido.");
                }
            });

            ventana.add(panelControl, BorderLayout.NORTH);
            ventana.add(panelArbol, BorderLayout.CENTER);
            ventana.setVisible(true);
        });
    }
}
