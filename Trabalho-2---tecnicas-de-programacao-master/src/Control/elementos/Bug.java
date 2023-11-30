package Control.elementos;

import javax.swing.*;

public class Bug extends Elemento{
    public String name;
    public ImageIcon imagemBug = new ImageIcon(getClass().getResource("/view/images/bug.png"));

    public Bug(int posicaoX, int posicaoY) {
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
