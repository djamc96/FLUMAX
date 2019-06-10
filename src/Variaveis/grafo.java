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
        
    public int      mGrafo [][];
    public String   nCidades [];

    public grafo(int tam) {
        this.mGrafo = new int[tam][tam];
        this.nCidades = new String[tam];
    }
    
}
