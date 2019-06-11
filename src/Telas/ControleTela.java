/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

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
        }
    }
}
