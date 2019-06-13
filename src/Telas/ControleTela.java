/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import FordFulkerson.MaxFlow;
import Variaveis.grafo;

/**
 *
 * @author anderson
 */
public class ControleTela {
    public void preencherCampor1(Principal p, grafo var){
        p.txtCidades.setText("");
        p.CBcidade1.removeAll();
        p.CBcidade2.removeAll();
        for(int i = 0; i < var.getTam(); i++){
            p.txtCidades.append(String.valueOf(i+1) + " - " + var.nCidades[i] + "\n");
            p.CBcidade1.addItem(var.nCidades[i]);
            p.CBcidade2.addItem(var.nCidades[i]);
            p.txtArestas.setText(var.txtAres);
        }
    }
    
    public void sugestoes(Principal p, grafo var, int chegada, int saida){
        MaxFlow m = new MaxFlow(); 
        int flux = 0, fluxoMax = 0;
        p.txtSolucoes.setText("");
        for(int i = 0;i < 6;i++)
        {
            if(i != chegada && i != saida){
                flux = m.fordFulkerson(var.mGrafo, saida, i);
                p.txtSolucoes.append("Outro possivel fluxo é: " + String.valueOf(flux) + " Saindo de: "+ var.nCidades[saida] + " Chegando em: " + var.nCidades[i] + "\n"); 
                if(fluxoMax < flux) fluxoMax = flux;
            }   
        }
        p.txtSolucoes.append("O maior fluxo possivel é " + String.valueOf(flux));
    }
}
