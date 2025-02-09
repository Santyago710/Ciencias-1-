package arbolavl;

import javax.swing.*;
import java.awt.*;

public class PanelArbol<T extends Comparable<T>> extends JPanel {
    private Nodo<T> raiz;

    public void actualizar(Nodo<T> raiz) {
        this.raiz = raiz;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (raiz != null) {
            dibujarNodo(g, raiz, getWidth() / 2, 50, getWidth() / 4);
        }
    }

    private void dibujarNodo(Graphics g, Nodo<T> nodo, int x, int y, int espacio) {
        if (nodo != null) {
            g.setColor(Color.BLACK);
            g.fillOval(x - 15, y - 15, 30, 30);
            g.setColor(Color.WHITE);
            g.drawString(nodo.getData().toString(), x - 5, y + 5);

            if (nodo.getHijoIq() != null) {
                g.setColor(Color.BLACK);
                g.drawLine(x, y, x - espacio, y + 50);
                dibujarNodo(g, nodo.getHijoIq(), x - espacio, y + 50, espacio / 2);
            }
            if (nodo.getHijoDer() != null) {
                g.setColor(Color.BLACK);
                g.drawLine(x, y, x + espacio, y + 50);
                dibujarNodo(g, nodo.getHijoDer(), x + espacio, y + 50, espacio / 2);
            }
        }
    }
}
