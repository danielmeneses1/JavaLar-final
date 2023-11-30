package View;

import javax.swing.*;
import java.awt.*;

public class Bottoes extends JButton {
    public Bottoes(String texto) {
        setText(texto);
        setFocusable(false);
        setPreferredSize(new Dimension(250, 80));
        setMinimumSize(new Dimension(250, 80));
        setMaximumSize(new Dimension(250, 80));
        setFont(new Font("arial", Font.BOLD, 11));

    }
}
