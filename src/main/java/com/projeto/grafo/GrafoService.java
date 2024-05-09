package com.projeto.grafo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GrafoService {

    // Método para verificar se dois vértices são adjacentes
    public boolean isAdjacent(int v1, int v2, MatrizAdjacente m) {
        int[][] matrizAdjacente = m.getMatrizAdjacente();
        return matrizAdjacente[v1][v2] == 1;
    }

    // Método para calcular o grau de um vértice
    public int calcularGrau(int vertice, MatrizAdjacente m) {
        int numVertices = m.getNumVertices();
        int[][] matrizAdjacente = m.getMatrizAdjacente();
        int grau = 0;
        for (int i = 0; i < numVertices; i++) {
            if (matrizAdjacente[vertice][i] == 1) {
                grau++;
            }
        }
        return grau;
    }

    // Método para buscar todos os vizinhos de um vértice
    public List<Integer> buscarVizinhos(int vertice, MatrizAdjacente m) {
        int numVertices = m.getNumVertices();
        int[][] matrizAdjacente = m.getMatrizAdjacente();
        List<Integer> vizinhos = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            if (matrizAdjacente[vertice][i] == 1) {
                vizinhos.add(i);
            }
        }
        return vizinhos;
    }

    // Método para percorrer o grafo em profundidade
    public void buscaProfundidade(int verticeInicial, MatrizAdjacente m) {
        int numVertices = m.getNumVertices();
        boolean[] visitado = new boolean[numVertices];
        Stack<Integer> pilha = new Stack<>();

        pilha.push(verticeInicial);
        while (!pilha.isEmpty()) {
            int vertice = pilha.pop();
            if (!visitado[vertice]) {
                visitado[vertice] = true;
                System.out.println("Visitando vértices por profundidade " + vertice);
                List<Integer> vizinhos = buscarVizinhos(vertice, m);
                for (int vizinho : vizinhos) {
                    if (!visitado[vizinho]) {
                        pilha.push(vizinho);
                    }
                }
            }
        }
    }

    // Método para visitar todas as arestas do grafo
    public void percorrerGrafo(MatrizAdjacente m) {
        int[][] matrizAdjacente = m.getMatrizAdjacente();
        int numVertices = m.getNumVertices();
        System.out.println("Visitando todas as arestas do grafo:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (matrizAdjacente[i][j] == 1) {
                    System.out.println("Aresta de " + i + " para " + j);
                }
            }
        }
    }
}