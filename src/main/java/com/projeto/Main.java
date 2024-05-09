package com.projeto;

import com.projeto.grafo.*;
import com.projeto.visualizacao.GraphVisualizationJUNG;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        FileService fileService = new FileService();

        try {
            // Ler o arquivo de entrada para o grafo não dirigido
           MatrizAdjacente matrizAdjacente = fileService.lerArquivo("grafo.txt");
            if(matrizAdjacente.getTipoGrafo().equals("D")) {
                System.out.println("Realizar operações desejadas com o grafo dirigido ");
                realizarOperacoes(matrizAdjacente);
            }else {
                System.out.println("Realizar operações desejadas com o grafo não dirigido ");
                realizarOperacoes(matrizAdjacente);
            }

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo do grafo não dirigido: " + e.getMessage());
        }
    }

    public static void realizarOperacoes(MatrizAdjacente matrizAdjacente){
        GrafoService grafoService = new GrafoService();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o primeiro vértice: ");
        int v1 = scanner.nextInt();
        System.out.print("Digite o segundo vértice: ");
        int v2 = scanner.nextInt();

        // Verifica se os vértices são adjacentes
        if (grafoService.isAdjacent(v1, v2, matrizAdjacente)) {
            System.out.println("Os vértices " + v1 + " e " + v2 + " são adjacentes.");
        } else {
            System.out.println("Os vértices " + v1 + " e " + v2 + " não são adjacentes.");
        }

        // Calcula e exibe o grau de um vértice
        System.out.print("Digite o vértice para calcular o grau: ");
        int vertice = scanner.nextInt();
        int grau = grafoService.calcularGrau(vertice, matrizAdjacente);
        System.out.println("O grau do vértice " + vertice + " é: " + grau);

        // Busca e exibe todos os vizinhos de um vértice
        System.out.print("Digite o vértice para buscar vizinhos: ");
        int verticeVizinho = scanner.nextInt();
        List<Integer> vizinhos = grafoService.buscarVizinhos(verticeVizinho, matrizAdjacente);
        System.out.println("Vizinhos do vértice " + verticeVizinho + ": " + vizinhos);

        grafoService.percorrerGrafo(matrizAdjacente);

        grafoService.buscaProfundidade(verticeVizinho, matrizAdjacente);

        int[][] ma = matrizAdjacente.getMatrizAdjacente();
        GraphVisualizationJUNG graphVisualization = new GraphVisualizationJUNG(ma);
        graphVisualization.visualize();

        scanner.close();
    }
}
