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
        p.CBcidade1.removeAllItems();
        p.CBcidade2.removeAllItems();
        for(int i = 0; i < var.getTam(); i++){
            p.txtCidades.append(String.valueOf(i+1) + " - " + var.nCidades[i] + "\n");
            p.CBcidade1.addItem(var.nCidades[i]);
            p.CBcidade2.addItem(var.nCidades[i]);
            p.txtArestas.setText(var.txtAres);
        }
    }
    
    public void sugestoes(Principal p, grafo var, int saida, int chegada, int fm){
        MaxFlow m = new MaxFlow(var.getTam()); 
        int flux[]=new int[var.getTam()];
        int fluxoMax = fm;
        p.lResultado.setText(var.txtResul);
        p.txtSolucoes.setText("");
        for(int i = 0;i < var.getTam();i++)
        {
            if(i != chegada && i != saida){
                flux[i] = m.fordFulkerson(var.mGrafo, saida, i);
                p.txtSolucoes.append("Outro possivel fluxo é: " + String.valueOf(flux[i]) + " toneladas, Saindo de: "+ var.nCidades[saida] + " Chegando em: " + var.nCidades[i] + "\n"); 
            }   
        }
        for(int x=0;x< var.getTam();x++)
        {
            if(flux[x] > fluxoMax)
            {
                fluxoMax = flux[x];
            }
        }
        p.txtSolucoes.append("O maior fluxo possivel é " + String.valueOf(fluxoMax));
    }
        
}
