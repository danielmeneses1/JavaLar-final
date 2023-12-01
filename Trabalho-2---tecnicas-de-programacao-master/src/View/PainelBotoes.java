package View;
import Control.Plano.Plano;
import Control.planetas.Planeta;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PainelBotoes extends JPanel {

   
    private Plano plano;
    private ArrayList<Planeta> planetas = new ArrayList<>();
    private ArrayList<CelulaVisual> planos = new ArrayList<>();

    public PainelBotoes(Plano plano, PainelJogo painelJogo) {
        this.plano = plano;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.BLUE);
        setPreferredSize(new Dimension(250, 600));
        setVisible(true);
    }
}
