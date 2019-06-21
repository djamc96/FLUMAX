/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FordFulkerson;

import java.util.LinkedList;

import java.util.*; 

import java.lang.*; 

import java.io.*;


/**
 *
 * @author gabri
 */
public class ProjetoES 
{
    public static void main(String[] args) 
    { 
        
        //AQUI VAMOS SUPOR QUE O OBJETIVO DO USUÁRIO SEJA DESENVOLVER UMA LINHA FERROVIÁRIA QUE AINDA NAO FOI CONSTRUIDA
        //DESSA FORMA, ELE INSERE QUAIS AS CIDADES QUE ESTÃO LIGADAS ENTRE SI E O PROGRAMA RODA UMA SIMULAÇÃO PARA MOSTRAR
        //QUAL SERIA O FLUXO MÁXIMO SAINDO DE UMA CIDADE DE ORIGEM E CHEGANDO EM UM DESTINO PARA ASSIM ELE INSTALAR 
        //A MELHOR MALHA FERROVIÁRIA POSSÍVEL
        //ELE TAMBÉM PODERÁ ESCOLHER MANUALMENTE AS CIDADES NATAIS E DESTINOS QUE QUISER A FIM DE ACHAR O MAIOR FLUXO
        //E POR FIM ELE PODE INSERIR UMA MALHA JÁ PRONTA E PERGUNTAR QUAL SERIA A MELHOR CONFIGURAÇÃO PARA SE OBTER O FLUXO MAXIMO
        //SUBSTUINDO APENAS A CIDADE DE ORIGEM E MANTENDO O DESTINO OU ALTERANDO O DESTINO E MANTENDO A MESMA CIDADE DE ORIGEM
        
        //IMPLEMENTAR UM PROGRAMA QUE GERA VALORES ALEATÓRIOS PARA AS ARESTAS QUE CONECTAM OS VERTICES DO GRAFO
        //E COLOQUE EM UM TXT QUE VAI SER LIDO POR ESSE PROGRAMA AQUI
        //OS VERTICES TEM QUE TER NOME DE CIDADE (NO CASO DA SIMULAÇÃO DA MALHA FERROVIARIA)
        //OS VERTICES PARA A LINHA DE ONIBUS PODE SER PONTO1, PONTO2, PONTO3,..., PONTO_N (ONDE N É O ULTIMO PONTO)
        //DEIXAR O SOFTWARE COMO UM EXECUTAVEL
        /* FAZER UMA INTERFACE GRAFICA QUE VAI OFERECER AS SEGUINTES OPÇOES:
            INTERFACE GRÁFICA PARA A MALHA FERROVIARIA:
 1)Apenas simular, ou seja, se o usuario escolher essa opção ele vai receber apenas o fluxo máximo saindo de uma cidade e chegando a um destino     
 2)Escolhe uma cidade de origem e uma cidade de destino e recebe o fluxo maximo entre elas (o programa tem que mostrar outras sugestões de fluxo máximo)
 3)Escolhe uma cidade de origem e o programa escolhe o melhor o melhor destino ou escolhe o destino e deixa o programa escolher a melhor origem           
            
        */
        
        
        
        
        
        // Grafo exemplo
        int Grafo[][] =new int[][] { {0, 16, 13, 0, 0, 0},{0, 0, 10, 12, 0, 0}, {0, 4, 0, 0, 14, 0},{0, 0, 9, 0, 0, 20}, {0, 0, 0, 7, 0, 4}, {0, 0, 0, 0, 0, 0}  }; 
        MaxFlow m = new MaxFlow(0); 
        int fluxos_max[]=new int[6];
        //System.out.println("Digite o nome do arquivo a ser lido:     ");
        //leia o grafo do .txt aqui
        System.out.println("Digite o vertice de saida:     ");
        Scanner sc= new Scanner(System.in);
        int vertice_saida=sc.nextInt();
        System.out.println("Digite o vertice de chegada:     ");
        int vertice_chegada=sc.nextInt();
        int fluxo_max=m.fordFulkerson(Grafo, vertice_saida, vertice_chegada);
        System.out.println("\nO fluxo máximo possível é: "+fluxo_max+" "+"Saindo de: "+vertice_saida+" "+"Chegando em: "+vertice_chegada); 
        //m.imprimir();
        
        /*for(int y=0;y<fluxos_max.length;y++)
        {
            if(fluxos_max[y]>fluxo_max)
            {
                System.out.println("Fluxo recomendado é: "+fluxos_max[y]);
            }
        }*/
    }
    
}
