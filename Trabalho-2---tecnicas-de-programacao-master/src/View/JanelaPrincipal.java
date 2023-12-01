package View;

import Control.Plano.Plano;
import Control.EscreverDadosNoArquivo;
import Control.ProcessarDadosBanco;
import model.JavalarDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class JanelaPrincipal extends JFrame {
    private Plano plano = new Plano();
    private PainelJogo painelJogo = new PainelJogo(plano);
    private PainelBotoes painelBotoes = new PainelBotoes(plano, painelJogo);
    private JavalarDAO relatorio = new JavalarDAO(plano, plano.getPlanetas(), painelJogo);
    private ProcessarDadosBanco processarDadosBanco;
  


    private Bottoes botaoInstante = new Bottoes("Processar Proximo Instante");
    private Bottoes EscolherArquivo = new Bottoes("Escolher novo arquivo");
    private Bottoes gravarRelatorio = new Bottoes("Gravar Relatorio");
    private Bottoes processarDadosDeOutrosUsuarios = new Bottoes("Processar dados de outros usuarios");
    private  Bottoes GravarDados = new Bottoes("Gravar Dados de outros Usuários");

    public JanelaPrincipal() {

        setTitle("Sistema JavaLar");
        setSize(1000, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        painelJogo = new PainelJogo(plano);
        add(painelJogo, BorderLayout.CENTER);
        relatorio = new JavalarDAO(painelJogo.plano, plano.getPlanetas(), painelJogo);

        adicionarBotoes();
        setVisible(true);
        organizador();
    }


    ActionListener actionProcessarInstante = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == botaoInstante) {
                plano.mover();
                painelJogo.resetarPlanoVisual();
                revalidate();
                repaint();

            }
        }
    };
    ActionListener actionEscolherArquivo = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == EscolherArquivo) {
                plano.processarInstantes();
            }
        }
    };

    ActionListener actionGravarRelatorio = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == gravarRelatorio) {
                relatorio.inserirDados(plano, plano.getPlanetas());
            }
        }
    };
    
    ActionListener actionProcessarDadosDeOutrosUsuarios = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == processarDadosDeOutrosUsuarios) {
                processarDadosBanco = new ProcessarDadosBanco();
            }
        }
    };
    ActionListener GravarDadosOutrosUsuarios = new ActionListener() {
        private EscreverDadosNoArquivo escritor = new EscreverDadosNoArquivo(relatorio);
        @Override
        public void actionPerformed(ActionEvent e) {
            escritor.chamarTodosOsMetodosDeEscrita("dados.txt");
        }
    };

    public void adicionarBotoes() {
        botaoInstante.addActionListener(actionProcessarInstante);
        painelBotoes.add(botaoInstante);
        EscolherArquivo.addActionListener(actionEscolherArquivo);
        painelBotoes.add(EscolherArquivo);
        gravarRelatorio.addActionListener(actionGravarRelatorio);
        painelBotoes.add(gravarRelatorio);
        processarDadosDeOutrosUsuarios.addActionListener(actionProcessarDadosDeOutrosUsuarios);
        painelBotoes.add(processarDadosDeOutrosUsuarios);
        GravarDados.addActionListener(GravarDadosOutrosUsuarios);
        painelBotoes.add(GravarDados);
        this.add(painelBotoes, BorderLayout.EAST);
    }

    public void organizador() {
        setLayout(new BorderLayout());
    }

    public Bottoes getBotaoInstante() {
        return botaoInstante;
    }

    public Bottoes getEscolherArquivo() {
        return EscolherArquivo;
    }

    public Bottoes getGravarRelatorio() {
        return gravarRelatorio;
    }
}




