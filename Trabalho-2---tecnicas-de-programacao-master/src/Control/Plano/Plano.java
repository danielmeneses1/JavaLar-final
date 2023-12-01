package Control.Plano;

import Control.elementos.Bug;
import Control.elementos.Dev;
import Control.planetas.*;
import model.GerenciadorArquivoInstantes;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

public class  Plano {
    public ArrayList<Planeta> planetas = new ArrayList<Planeta>();
    public int quantidade;
    private ArrayList<Bug> bugs = new ArrayList<>();
    private ArrayList<Dev> devs = new ArrayList<>();
    protected Celula[][] celulas = new Celula[17][16];
    private ArrayList<Bug> bugsApagados = new ArrayList<>();
    private ArrayList<Dev> devsColididos = new ArrayList<>();
    private ArrayList<Planeta> falecidos = new ArrayList<>();
    private GerenciadorArquivoInstantes gerenciadorArquivoInstantes = new GerenciadorArquivoInstantes();
    private ArrayList<int[]> valoresConvertidos = new ArrayList<>();
    private ArrayList<String> dados = new ArrayList<String>();
    private int instanteAtual = 0;
    private int quadrante1Devs = 0;
    private int quadrante2Devs = 0;
    private int quadrante3Devs = 0;
    private int quadrante4Devs = 0;
    private int quadrante1Bugs = 0;
    private int quadrante2Bugs = 0;
    private int quadrante3Bugs = 0;
    private int quadrante4Bugs = 0;
    private int Matricula = 539724;
    private String nome = "Daniel Dalessandro";



    public Plano() {
        PovoarCelulasVazias();
        preencherPlanetas();
    }

    public void incrementarQuantidade() {
        quantidade+=1;
    }
    public void preencherPlanetas() {
        planetas.add(new Python());
        planetas.add(new JavaScript());
        planetas.add(new RubyOnRails());
        planetas.add(new PHP());
        planetas.add(new CSharp());
        planetas.add(new CMais());
        planetas.add(new C());
    }

    public void exibirPosicaoPlanetas(ArrayList<Planeta> plano){
        for(Planeta planeta : plano){
           planeta.exibirPosicao();
        }
    }

    public void preencherBugs(int quantidade) {
        for (int i = 0; i < quantidade; i++) {
            Random random = new Random();
            int posicaoX = random.nextInt(17);
            int posicaoY = random.nextInt(16);

            while (this.celulas[posicaoX][posicaoY].verificarPreenchimento()) {
                posicaoX = random.nextInt(17);
                posicaoY = random.nextInt(16);
            }
            Bug bug = new Bug(posicaoX, posicaoY);
            bugs.add(bug);
            celulas[posicaoX][posicaoY].setElemento(bug);
        }
    }

    public void preencherDevs(int quantidade) {
        for (int i = 0; i < quantidade; i++) {
            Random random = new Random();
            int posicaoX = random.nextInt(17);
            int posicaoY = random.nextInt(16);

            while (celulas[posicaoX][posicaoY].verificarPreenchimento()) {
                posicaoX = random.nextInt(17);
                posicaoY = random.nextInt(16);
            }
            Dev dev = new Dev(posicaoX, posicaoY);
            devs.add(dev);
            celulas[posicaoX][posicaoY].setElemento(dev);
        }
    }

    public void PovoarCelulasVazias() {
        for (int i = 0; i < celulas.length; i++) {
            for (int j = 0; j < celulas[i].length; j++) {
                celulas[i][j] = new Celula(i, j);
            }
        }
    }

    public void processarInstantes() {
        ArrayList<String[]> valores = gerenciadorArquivoInstantes.ConverterValores();
        for (String[] valor : valores){
            int[] instantesConvertidos= new int[10];
            for (int i = 1; i < instantesConvertidos.length; i++) {
                instantesConvertidos[i-1]= Integer.parseInt(valor[i]);
            }
            valoresConvertidos.add(instantesConvertidos);
        }
    }

    public void mover() {
        
        if (valoresConvertidos.isEmpty()) {
            mostrarMensagemFaltaDearquivo();
            return;
        }
        if (instanteAtual >= valoresConvertidos.size()) {
            mostrarMensagemFinalArquivo();
            return;
        }

        int[] instantes = valoresConvertidos.get(instanteAtual);
        preencherBugs(instantes[7]);
        preencherDevs(instantes[8]);
        for (int i = 0; i < planetas.size(); i++) {
            planetas.get(i).mover(instantes[i]);
            System.out.println(planetas.get(i).getNome()+" "+ instantes[i]);
        }
        verificarColisaoBug();
        verificarColisaoDev();
        explodirPlaneta();
        instanteAtual++;
        verificarQuadranteBugs();
        verificarQuadranteDevs();
        System.out.println();
        
    }

    public void mostrarMensagemFaltaDearquivo() {
        String mensagem = "por favor, Escolha um arquivo antes de continuar";
        JOptionPane.showMessageDialog(null, mensagem, "Erro!", JOptionPane.INFORMATION_MESSAGE);
    }

    public void mostrarMensagemFinalArquivo(){
        String mensagem = "O arquivo acabou, por favor, escolha outro arquivo";
        JOptionPane.showMessageDialog(null, mensagem, "Erro!", JOptionPane.INFORMATION_MESSAGE);
    }

    public void verificarQuadranteBugs(){
        for (Bug bug : bugs){
            if(bug.getPosicaoX() >= 8 && bug.getPosicaoY() >= 8){
                quadrante1Bugs++;
            }else if(bug.getPosicaoX() <= 8 && bug.getPosicaoY() >= 8){
                quadrante2Bugs++;
            }else if(bug.getPosicaoX() <= 8 && bug.getPosicaoY() <= 8){
                quadrante3Bugs++;
            }else if(bug.getPosicaoX() >= 8 && bug.getPosicaoY() <= 8){
                quadrante4Bugs++;
            }
        }
    }
    public void verificarQuadranteDevs(){
        for (Dev dev : devs){
            if(dev.getPosicaoX() >= 8 && dev.getPosicaoY() >= 8){
                quadrante1Devs++;
            }else if(dev.getPosicaoX() <= 8 && dev.getPosicaoY() >= 8){
                quadrante2Devs++;
            }else if(dev.getPosicaoX() <= 8 && dev.getPosicaoY() <= 8){
                quadrante3Devs++;
            }else if(dev.getPosicaoX() >= 8 && dev.getPosicaoY() <= 8){
                quadrante4Devs++;
            }
        }
    }
    public void verificarColisaoDev() {
        for (Planeta planeta : planetas) {
            for (Dev dev : devs) {
                if (planeta.getPosicaoX() == dev.getPosicaoX() && planeta.getPosicaoY() == dev.getPosicaoY()) {
                    planeta.AumentarTranslação();
                    planeta.incrementarColisoesDevs();
                    //System.out.println("O planeta, " + planeta.getNome() + " encontrou um desenvolvedor na posição, X=" + planeta.getPosicaoX() + " y= " + planeta.getPosicaoY());
                    mostrarMensagemColidiuDev(planeta, dev);
                    devsColididos.add(dev);
                }
            }
            devs.removeAll(devsColididos);
        }
    }
    private void mostrarMensagemColidiuDev(Planeta planeta, Dev dev) {
        String mensagem = "O planeta " + planeta.getNome() + " encontrou um desenvolvedor na posição: X=" + planeta.getPosicaoX() + ", Y=" + planeta.getPosicaoY();
        JOptionPane.showMessageDialog(null, mensagem, "Colisão!", JOptionPane.INFORMATION_MESSAGE);
    }

    public void verificarColisaoBug() {
        for (Planeta planeta : planetas) {
            for (Bug bug : bugs) {
                if (planeta.getPosicaoX() == bug.getPosicaoX() && planeta.getPosicaoY() == bug.getPosicaoY()) {
                    planeta.DiminuirTranslação();
                    planeta.incrementarColisoesBugs();
                    //System.out.println("O planeta, " + planeta.getNome() + " encontrou um bug na posição, X=" + planeta.getPosicaoX() + " y= " + planeta.getPosicaoY());
                    bugsApagados.add(bug);
                    mostrarMensagemColidiuBugs(planeta);
                }
            }
            bugs.removeAll(bugsApagados);
        }
    }
    public void mostrarMensagemColidiuBugs(Planeta planeta) {
        String mensagem = "O planeta " + planeta.getNome() + " encontrou um bug na posição: X=" + planeta.getPosicaoX() + ", Y=" + planeta.getPosicaoY();
        JOptionPane.showMessageDialog(null, mensagem, "Colisão!", JOptionPane.INFORMATION_MESSAGE);
    }

    public void norteSulJava() {
        int ContadorNorte = 0;
        int ContadorSul = 0;
        for (Planeta planeta : planetas) {
            if (planeta.getPosicaoY() >= 8) {
                ContadorNorte++;
            } else if (planeta.getPosicaoY() <= 6) {
                ContadorSul++;
            }
        }
        System.out.println("Numero de planetas ao norte de java =" + ContadorNorte);
        System.out.println("Numero de planetas ao sul de java = " + ContadorSul);
    }

    public void verificarAlinhamento() {
        for (Planeta planeta : planetas) {
            for (Planeta planeta1 : planetas) {
                if (planeta1.getPosicaoY() == planeta.getPosicaoY() + 1 && planeta1.getPosicaoX() == planeta.getPosicaoX()) {
                    System.out.println("O planeta " + planeta.getNome() + " está alinhado com " + planeta1.getNome());
                } else if (planeta1.getPosicaoY() == planeta.getPosicaoY() + 1 && planeta1.getPosicaoX() == planeta.getPosicaoX() - 1) {
                    System.out.println("O planeta " + planeta.getNome() + " está alinhado com " + planeta1.getNome());
                } else if (planeta1.getPosicaoY() == planeta.getPosicaoY() - 1 && planeta1.getPosicaoX() == planeta.getPosicaoX()) {
                    System.out.println("O planeta " + planeta.getNome() + " está alinhado com " + planeta1.getNome());
                } else if (planeta1.getPosicaoY() == planeta.getPosicaoY() - 1 && planeta1.getPosicaoX() == planeta.getPosicaoX() - 1) {
                    System.out.println("O planeta " + planeta.getNome() + " está alinhado com " + planeta1.getNome());
                } else if (planeta1.getPosicaoY() == planeta.getPosicaoY() - 1 && planeta1.getPosicaoX() == planeta.getPosicaoX() + 1) {
                    System.out.println("O planeta " + planeta.getNome() + " está alinhado com " + planeta1.getNome());
                } else if (planeta1.getPosicaoY() == planeta.getPosicaoY() + 1 && planeta1.getPosicaoX() == planeta.getPosicaoX() + 1) {
                    System.out.println("O planeta " + planeta.getNome() + " está alinhado com " + planeta1.getNome());
                }
            }
        }
    }

    public void explodirPlaneta() {
        for (Planeta planeta : planetas) {
            if (planeta.getTranslacao() == 0) {
                System.out.println("O planeta " + planeta.getNome() + " explodiu");
                falecidos.add(planeta);
                mostrarMensagemExplodiu(planeta);
            }
        }
        planetas.removeAll(falecidos);

    }
    private void mostrarMensagemExplodiu(Planeta planeta) {
        String mensagem = "O planeta " + planeta.getNome() + " explodiu!";
        JOptionPane.showMessageDialog(null, mensagem, "Explosão!", JOptionPane.WARNING_MESSAGE);
    }

    public void posicoesBugs(){
        for (Bug bug : bugs){
            System.out.println("Bug criado na posição x= "+ bug.getPosicaoX() + " y= "+ bug.getPosicaoY());
        }
    }
    public void posicoesDevs(){
        for (Dev dev : devs){
            System.out.println("Dev criado na posição x= "+ dev.getPosicaoX() + " y= "+ dev.getPosicaoY());
        }
    }

    public void numeroDeBugs(){
        int total = 0;
        for (Bug bug:bugs){
            total ++;
        }
        System.out.println("Foram criados "+ total + " bugs");
    }
    public void numeroDeDevs(){
        int total = 0;
        for (Dev dev : devs){
            total ++;
        }
        System.out.println("Foram criados "+ total + " desenvolvedores");
    }
    public void distanciaEntreOsPlanetas(){
        DecimalFormat formato = new DecimalFormat("#.##");
        int deltaX= 0;
        int deltaY = 0;
        for(Planeta planeta : planetas){
            for (Planeta planeta1 : planetas){
                deltaX = Math.abs(planeta.getPosicaoX() - planeta1 .getPosicaoX());
                deltaY = Math.abs(planeta.getPosicaoY() - planeta1.getPosicaoY());
                if(planeta.getNome() != planeta1.getNome()){
                    System.out.println("A distancia entre " + planeta.getNome() + " e " + planeta1.getNome() +" é " + formato.format((Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY,2)))));
                }}
        }
    }

    public ArrayList<Planeta> getPlanetas() {
        return planetas;
    }

    public void setPlanetas(ArrayList<Planeta> planetas) {
        this.planetas = planetas;
    }

    public ArrayList<Bug> getBugs() {
        return bugs;
    }

    public ArrayList<Dev> getDevs() {
        return devs;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public int getQuadrante1Devs() {
        return quadrante1Devs;
    }

    public int getQuadrante2Devs() {
        return quadrante2Devs;
    }

    public int getQuadrante3Devs() {
        return quadrante3Devs;
    }

    public int getQuadrante4Devs() {
        return quadrante4Devs;
    }

    public int getQuadrante1Bugs() {
        return quadrante1Bugs;
    }

    public int getQuadrante2Bugs() {
        return quadrante2Bugs;
    }

    public int getQuadrante3Bugs() {
        return quadrante3Bugs;
    }

    public int getQuadrante4Bugs() {
        return quadrante4Bugs;
    }

    public String getNome() {
        return nome;
    }

    public int getMatricula() {
        return Matricula;
    }
}
