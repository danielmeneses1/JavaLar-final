package Control.planetas;

import Control.elementos.Elemento;

import javax.swing.*;

public abstract class Planeta extends Elemento implements IPlaneta {
    protected String nome;
    protected int translacao;
    protected double rotacao;
    protected int anoJavalar = 0;
    protected int colisoesBugs = 0;
    protected int colisoesDevs = 0;
    protected String resumo;
    protected ImageIcon imagemPlaneta;

    public Planeta(int posicaoX, int posicaoY) {
        super(posicaoX, posicaoY);
    }

    public void exibirPosicao(){
        System.out.println("Posicao de "+ this.getClass().getSimpleName()+": x= "+ posicaoX + " y= "+ posicaoY);
    }

    public void totalRotacao(int momento){
        System.out.println("no planeta "+ this.getClass().getSimpleName() +" passaram-se: "+(momento*rotacao) + " horas");
    };
    public void totalAnos(){
        System.out.println("no planeta "+ this.getClass().getSimpleName() +" passaram-se: "+ anoJavalar + " anos");
    }

    public void AumentarTranslação(){
        translacao+=1;
    }

    public void DiminuirTranslação(){
        translacao-=1;
    }

    public void incrementarColisoesDevs(){
        colisoesDevs +=1;
    }
    public void incrementarColisoesBugs(){
        colisoesBugs +=1;
    }
    protected boolean passouInicio(int pX, int pY){
        return posicaoX == pX && posicaoY ==pY;
    }



    public String getNome() {
        return nome;
    }

    public int getTranslacao() {
        return translacao;
    }

    public int getPosicaoX() {
        return posicaoX;
    }

    public void setPosicaoX(int posicaoX) {
        this.posicaoX = posicaoX;
    }

    public int getPosicaoY() {
        return posicaoY;
    }

    public void setPosicaoY(int posicaoY) {
        this.posicaoY = posicaoY;
    }


    public int getColisoesBugs() {
        return colisoesBugs;
    }

    public int getColisoesDevs() {
        return colisoesDevs;
    }

    public double getRotacao() {
        return rotacao;
    }

    public String getResumo() {
        return resumo;
    }

    public ImageIcon getImagem() {
        return imagemPlaneta;
    }

    public Icon getImagemPlaneta() {
        return imagemPlaneta;
    }

    public int getAnoJavalar() {
        return anoJavalar;
    }
}
