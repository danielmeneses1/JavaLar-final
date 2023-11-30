package View;
import Control.elementos.Bug;
import Control.elementos.Dev;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class CelulaVisual {
    public JLabel label;
    private int x;
    private int y;
    private Bug bug;
    private Dev dev;

    public CelulaVisual(int linha, int coluna, JLabel label) {
        this.x = linha;
        this.y = coluna;
        this.label = label;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Component getLabel() {
        return label;
    }

    public Bug getBug() {
        return bug;
    }

    public Dev getDev() {
        return dev;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CelulaVisual that = (CelulaVisual) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

