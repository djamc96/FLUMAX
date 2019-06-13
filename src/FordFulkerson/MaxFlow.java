/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FordFulkerson;

import java.util.Arrays;
import java.util.LinkedList;

/**
 *
 * @author gabri
 */
public class MaxFlow
{
    public static final int V = 6; // Número de vértices do grafo
    int rGrafo[][] = new int[V][V];
    //cria um grafo residua e preenche ele com o grafo residual
    // retorna verdadeiro se existe um caminho da fonte até o terminal
    // preenche pai[] que armazena o caminho
    public boolean BFS(int rGrafo[][], int s, int t, int pai[]) 
    { 
        //cria um vertice de visitados e marca todos os vertices como não visitados
        boolean visitado[] = new boolean[V]; 
        for(int i=0; i<V; ++i)
        {

            visitado[i]=false; 

        }
         //cria uma fila, enfileira o vertice fonte e marca como visitado
        LinkedList<Integer> fila = new LinkedList<>(); 
        fila.add(s); 
        // BFS  
        while (fila.size()!=0) 
        { 
            int u = fila.poll(); 
            for (int v=0; v<V; v++) 
            { 
                if (visitado[v]==false && rGrafo[u][v] > 0) 
                { 
                    fila.add(v); 
                    pai[v] = u; 
                    visitado[v] = true; 
                } 
            } 
        }
       //se chegar até o terminal pela BFS saindo da fonte então returna verdadeiro, senão retorna falso
        return (visitado[t] == true); 
    }  
    
     //retorna o valor máximo do fluxo da fonte s até o terminal t dado um grafo qualquer
    public int fordFulkerson(int grafo[][], int s, int t) 
    { 
        int u, v; 
         //dado as capacidades do grafo original  
         //elas se tornam as capacidades do grafo residual
         // o grafo residual é rGrafo que indica a capacidade residual da aresta i até j
         //se tiver aresta né, se rGrafo é 0, então não existe aresta de i até j 
        for (u = 0; u < V; u++)
        {
            for (v = 0; v < V; v++)
            {
                rGrafo[u][v] = grafo[u][v];
            }
        }
        // Esse vetor foi preenchido pela BFS para armazenar o caminho 
        int pai[] = new int[V]; 
        int max_fluxo = 0;  // Não há fluxo inicialmente 
         //Achar um fluxo enquanto tiver um caminho da fonte até o terminal
        while (BFS(rGrafo, s, t, pai)) 
        {
            //encontrar mminimo entre as arestas do grafo residual
            //enquanto o caminho é preenchido pela BFS, achar o fluxo máximo do caminho encontrado 
            int caminho_fluxo = Integer.MAX_VALUE; 
            for (v=t; v!=s; v=pai[v]) 
            { 
                u = pai[v]; 
                caminho_fluxo = Math.min(caminho_fluxo, rGrafo[u][v]); 
            } 
            //atualiza a capacidade residual das arestas e das "arestas reversas" ao longo do caminho  
            for (v=t; v != s; v=pai[v]) 
            { 
                u = pai[v]; 
                rGrafo[u][v] -= caminho_fluxo; 
                rGrafo[v][u] += caminho_fluxo; 
            } 
            //Adiciona o fluxo ao fluxo total
            max_fluxo += caminho_fluxo; 
        } 
        
        /*for(int y=0;y<pai.length;y++)
        {
            System.out.println(pai[y]);
        }
        for (int[] grafo1 : grafo) {
            System.out.println(Arrays.toString(grafo1));
        }*/
        //returna o fluxo máximo total
        return max_fluxo;
        
    }
    
    
    public void imprimir()
    {
        for(int[] rGrafo1 : rGrafo) 
        {
            System.out.println(Arrays.toString(rGrafo1));
        }
    }
}
    
