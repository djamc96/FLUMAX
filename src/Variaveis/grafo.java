/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Variaveis;

/**
 *
 * @author anderson
 */
public class grafo {
        
    public  int     mGrafo [][];
    public  String  nCidades [];
    private int     tam;    
    public  String  txtAres;

    public grafo(int tam) {
        this.mGrafo = new int[tam][tam];
        this.nCidades = new String[tam];
        this.tam = tam;
        this.txtAres = "";
    }

    public int getTam() {
        return tam;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }
    
    
    
}
