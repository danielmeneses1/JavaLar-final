package model;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorArquivoInstantes {
    private File arquivo;
    private List<String> instantes;

    public void MetodosArquivo() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivo de csv", "csv");
        fileChooser.setFileFilter(filter);
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            arquivo = fileChooser.getSelectedFile();
            System.out.println("Arquivo selecionado: " + arquivo.getAbsolutePath());
        } else if (result == JFileChooser.CANCEL_OPTION) {
            System.out.println("Operação cancelada pelo usuário");
        }
    }

    public void lerArquivo() {
        try {
            MetodosArquivo();
            instantes = Files.readAllLines(arquivo.toPath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String[]> ConverterValores(){
        lerArquivo();
        instantes.remove(0);
        ArrayList<String[]> valores = new ArrayList<>();
        for(String instante : instantes){
            String[] valoresInstante = instante.split(",");
            valores.add(valoresInstante);
        }
        return valores;
    }


}
