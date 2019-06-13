/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GrafoRandomico;

import Variaveis.grafo;
import java.util.Random;

/**
 *
 * @author anderson
 */
public class GrafoRando {
    
    public grafo GrafoR(int nCidades, int minTon, int maxTon, int nArestas){
        int intervalo = maxTon - minTon;
        int c2, peso;
        grafo var = new grafo(nCidades);
        Random gCidades = new Random(nCidades - 1);
        Random gPeso = new Random(maxTon - minTon);
        for(int i = 0; i < nCidades; i++){
            var.nCidades[i] = String.valueOf(i) + "Cidade ";
            c2 = gCidades.nextInt();
            peso = gPeso.nextInt();
            var.mGrafo[i][c2] = peso + minTon;
            var.txtAres += String.valueOf(i + 1) + " -> " + String.valueOf(c2 + 1 ) + ", peso " + String.valueOf(peso) + "\n";
            c2 = gCidades.nextInt();
            peso = gPeso.nextInt();
            var.mGrafo[i][c2] = peso + minTon;
            //var.txtAres += String.valueOf(i + 1) + " -> " + String.valueOf(c2 + 1 ) + ", peso " + String.valueOf(peso) + "\n";
        }
    return var;
    }
}