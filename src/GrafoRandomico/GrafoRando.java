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
        int intervalo = maxTon - minTon + 1;
        int c1, c2, peso;
        grafo var = new grafo(nCidades);
        Random gCidades = new Random();
        Random gPeso = new Random();
        var.txtAres = "";
        for(int i = 0; i < nCidades; i++){
            for(int j = 0; j < nCidades; j++){
                var.mGrafo[i][j] = -1;
            }
            var.nCidades[i] = "Cidade " + (i + 1);
        }
        for(int i = 0; i < nArestas; i++){
            c1 = gCidades.nextInt(nCidades);
            while(true){
                c2 = gCidades.nextInt(nCidades);
                if(c1 != c2 && var.mGrafo[c1][c2] < 0) break;
            }
            peso = gPeso.nextInt(intervalo) + minTon;
            var.mGrafo[c1][c2] = peso;
            var.txtAres += String.valueOf(c1 + 1) + " -> " + String.valueOf(c2 + 1 ) + ", peso " + String.valueOf(peso) + "\n";
            //var.txtAres += String.valueOf(i + 1) + " -> " + String.valueOf(c2 + 1 ) + ", peso " + String.valueOf(peso) + "\n";
        }
    return var;
    }
}