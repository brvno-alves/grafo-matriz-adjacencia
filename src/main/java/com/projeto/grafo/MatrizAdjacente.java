package com.projeto.grafo;

public class MatrizAdjacente {
    private int[][] matrizAdjacente;
    private int numVertices;
    private String tipoGrafo;

    public int[][] getMatrizAdjacente() {
        return matrizAdjacente;
    }

    public void setMatrizAdjacente(int[][] matrizAdjacente) {
        this.matrizAdjacente = matrizAdjacente;
    }

    public int getNumVertices() {
        return numVertices;
    }

    public void setNumVertices(int numVertices) {
        this.numVertices = numVertices;
    }

    public String getTipoGrafo() {
        return tipoGrafo;
    }

    public void setTipoGrafo(String tipoGrafo) {
        this.tipoGrafo = tipoGrafo;
    }
}
