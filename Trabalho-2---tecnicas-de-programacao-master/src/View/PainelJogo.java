package View;

import Control.Plano.Plano;
import Control.elementos.Bug;
import Control.elementos.Dev;
import Control.planetas.Planeta;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

import java.util.ArrayList;
import java.util.List;

public class PainelJogo extends JPanel {

    private static final int LINHAS = 16;
    private static final int COLUNAS = 17;
    private ArrayList<Planeta> planetas;
    public ArrayList<CelulaVisual> listaCelulas = new ArrayList<CelulaVisual>();
    List<Bug> bugs;
    List<Dev> devs;
    public Plano plano;

    public PainelJogo(Plano plano) {
    	planetas = plano.getPlanetas();
        bugs = plano.getBugs();
        devs = plano.getDevs();
        setLayout(new GridLayout(LINHAS, COLUNAS));
        setBackground(Color.WHITE);
        criarCelulas();
        atualizarPlano(planetas, listaCelulas);
    }


    public void criarCelulas() {
        Border borda = BorderFactory.createLineBorder(Color.BLACK);
        listaCelulas = new ArrayList<>();

        for (int linha = LINHAS - 1; linha >= 0; linha--) {
            for (int coluna = 0; coluna < COLUNAS; coluna++) {
                JLabel celula = new JLabel("(" + coluna + "," + linha + ")");
                celula.setBorder(borda);
                celula.setHorizontalAlignment(SwingConstants.CENTER);
                celula.setVerticalAlignment(SwingConstants.CENTER);

                CelulaVisual celulaVisual = new CelulaVisual(linha, coluna, celula);
                listaCelulas.add(celulaVisual);

                add(celulaVisual.getLabel());
            }
        }
    }

    public void atualizarPlano(ArrayList<Planeta> planetas, ArrayList<CelulaVisual> ListacelulaVisual) {
        for (CelulaVisual celulaVisual1 : ListacelulaVisual) {
            celulaVisual1.label.setIcon(null);
        }

        for (Bug bug1 : bugs) {
            for (CelulaVisual celulaVisual1 : ListacelulaVisual) {
                if (bug1 != null && bug1.getPosicaoX() == celulaVisual1.getY() && bug1.getPosicaoY() == celulaVisual1.getX()) {
                    celulaVisual1.label.setIcon(bug1.imagemBug);
                }
            }
        }

        for (Dev dev : devs) {
            for (CelulaVisual celulaVisual1 : ListacelulaVisual) {
                if (dev != null && dev.getPosicaoX() == celulaVisual1.getY() && dev.getPosicaoY() == celulaVisual1.getX()) {
                    celulaVisual1.label.setIcon(dev.imagemDev);
                }
            }
        }

        for (Planeta planeta : planetas) {
            for (CelulaVisual celulaVisual : ListacelulaVisual) {
                if (planeta.getPosicaoY() == celulaVisual.getX() && planeta.getPosicaoX() == celulaVisual.getY()) {
                    celulaVisual.label.setIcon(planeta.getImagemPlaneta());
                }
            }
        }

        // Adicione as imagens específicas aqui
        adicionarImagemEmPosicao(ListacelulaVisual, "/view/images/java (1).png", 7, 7);
        adicionarImagemEmPosicao(ListacelulaVisual, "/view/images/java (1).png", 7, 8);
        adicionarImagemEmPosicao(ListacelulaVisual, "/view/images/java (1).png", 7, 9);
        adicionarImagemEmPosicao(ListacelulaVisual, "/view/images/java (1).png", 8, 7);
        adicionarImagemEmPosicao(ListacelulaVisual, "/view/images/java (1).png", 8, 8);
        adicionarImagemEmPosicao(ListacelulaVisual, "/view/images/java (1).png", 8, 9);

    }

    private void adicionarImagemEmPosicao(ArrayList<CelulaVisual> listaCelulas, String caminhoImagem, int x, int y) {
        for (CelulaVisual celulaVisual : listaCelulas) {
            if (celulaVisual.getX() == x && celulaVisual.getY() == y) {
                ImageIcon imagem = new ImageIcon(getClass().getResource(caminhoImagem));
                celulaVisual.label.setIcon(imagem);
            }
        }
    }



    public void criarPlano() {
        for (int i = 0; i < listaCelulas.size(); i++) {
            this.add(listaCelulas.get(i).getLabel());
        }
    }

    public void resetarPlanoVisual() {
        this.removeAll();
        criarCelulas();
        atualizarPlano(planetas, listaCelulas);
        this.revalidate();
        this.repaint();
    }

    public ArrayList<CelulaVisual> getListaCelulas() {
        return listaCelulas;
    }


}
