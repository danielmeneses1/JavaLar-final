package View;
import Control.Plano.Plano;
import Control.planetas.Planeta;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PainelBotoes extends JPanel {

    // private Bottoes botaoInstante = new Bottoes("Processar Proximo Instante");
    // private Bottoes botaoLer = new Bottoes("Ler novo arquivo de Entrada");
    // private Bottoes botaoRelatorio = new Bottoes("Gravar Relatorio");
    // private Bottoes botaoLerOutros = new Bottoes("Ler dados de outros participantes");
    // private Bottoes botaoGravarSaida = new Bottoes("Gravar Arquivo de Saída");

    private int momento = 0;
    private int quantitadeBugs= 0;
    private int quantidadeDevs = 0;
    private Plano plano;
    private ArrayList<Planeta> planetas = new ArrayList<>();
    private ArrayList<CelulaVisual> planos = new ArrayList<>();

    public PainelBotoes(Plano plano, PainelJogo painelJogo) {
        this.plano = plano;
        // this.painelJogo = painelJogo;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.BLUE);
        setPreferredSize(new Dimension(250, 600));
        setVisible(true);
        // add(Box.createVerticalStrut(60));
        // add(botaoInstante);
        // botaoInstante.addActionListener(actionListener);
        // add(Box.createRigidArea(new Dimension(0, 10)));
        // add(botaoLer);
        // add(Box.createRigidArea(new Dimension(0, 10)));
        // add(botaoRelatorio);
        // add(Box.createRigidArea(new Dimension(0, 10)));
        // add(botaoLerOutros);
        // add(Box.createRigidArea(new Dimension(0, 10)));
        // add(botaoGravarSaida);
        // add(Box.createRigidArea(new Dimension(0, 10)));
    }
}
