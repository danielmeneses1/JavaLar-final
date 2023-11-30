package Control.elementos;

import javax.swing.*;
import java.util.Random;

public class Dev extends Elemento{
    Random random = new Random();
    public String name;
    public ImageIcon imagemDev = new ImageIcon(getClass().getResource("/view/images/dev.png"));

    public Dev(int posicaoX, int posicaoY) {
        super(posicaoX, posicaoY);
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
}