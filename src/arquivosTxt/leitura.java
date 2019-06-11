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
    
    public grafo lerArquivo(String caminho) throws FileNotFoundException{
        File arquivo = new File(caminho);
        grafo var = null;
        String linha, vetor[];
        int nGrafo, c1, c2, peso;
        try{
            if(arquivo.getName().endsWith(".txt")){
                if(!arquivo.exists()){
                    JOptionPane.showMessageDialog(null, "Arquivo inexitente", "Erro de leitura", JOptionPane.ERROR_MESSAGE);
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
                        c1 = Integer.parseInt(vetor[0]) - 1;
                        c2 = Integer.parseInt(vetor[1]) - 1;
                        System.out.println(c1 + " " + c2);
                        peso = Integer.parseInt(vetor[2]);
                        var.mGrafo[c1][c2] = peso;
                    }
                    br.close();
                    fr.close();
                    System.out.println("leitura de arquivo completada com sucesso, 1 cidade: " + var.nCidades[0]); 
                }
            }else{
                JOptionPane.showMessageDialog(null, "Formato incorreto", "Erro de leitura", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return var;
    }
}
