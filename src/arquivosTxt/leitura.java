/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arquivosTxt;

import Variaveis.grafo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author casa
 */
public class leitura {
    
    public boolean lerArquivo(String caminho, grafo var) throws FileNotFoundException{
        File arquivo = new File(caminho);
        boolean validador = false;
        String linha, vetor[];
        int nGrafo, c1, c2, peso;
        try{
            if(!arquivo.exists()){
                JOptionPane.showMessageDialog(null, "Arquivo inexitente", "Erro de leitura", JOptionPane.ERROR_MESSAGE);
                validador = false;
            }else{
                FileReader fr = new FileReader(arquivo);
                BufferedReader br = new BufferedReader(fr);
                linha = br.readLine();
                nGrafo = Integer.parseInt(linha);
                var = new grafo(nGrafo);
                for(int i = 0; i < nGrafo; i++){
                    var.nCidades[i] = br.readLine();
                }
                while (br.ready()) {
                    linha = br.readLine();
                    vetor = linha.split(";");
                    c1 = Integer.parseInt(vetor[0]);
                    c2 = Integer.parseInt(vetor[1]);
                    peso = Integer.parseInt(vetor[2]);
                    var.mGrafo[c1][c2] = peso;
                    var.mGrafo[c2][c1] = peso;
                }
                br.close();
                fr.close();
                validador = true;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return validador;
    }
}
