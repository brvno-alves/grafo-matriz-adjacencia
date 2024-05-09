package com.projeto.grafo;

import javax.swing.filechooser.FileSystemView;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileService {

    public MatrizAdjacente lerArquivo(String nomeArquivo) throws IOException {

        FileSystemView view = FileSystemView.getFileSystemView();
        File file = view.getHomeDirectory();
        String desktopPath = file.getPath();
        try (BufferedReader reader = new BufferedReader(new FileReader(desktopPath + "\\" + nomeArquivo))) {
            String tipoGrafo = reader.readLine();

            String line;
            List<int[]> edges = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int v1 = Integer.parseInt(parts[0]);
                int v2 = Integer.parseInt(parts[1]);
                edges.add(new int[]{v1, v2});
            }

            // Determina o número de vértices
            int numVertices = edges.stream()
                    .flatMapToInt(java.util.Arrays::stream)
                    .max().orElse(0) + 1;


            // Cria a matriz de adjacência e adiciona as arestas
            return this.criarMatriz(tipoGrafo, numVertices, edges);
        }
    }

    private MatrizAdjacente criarMatriz(String tipoGrafo, int numVertices, List<int[]> edges){

        MatrizAdjacente matrizCompleta = new MatrizAdjacente();
        int[][] matrizAdjacente = new int[numVertices][numVertices];

            for (int[] edge : edges) {
                int v1 = edge[0];
                int v2 = edge[1];
                matrizAdjacente[v1][v2] = 1;
                if(tipoGrafo.toUpperCase().equals("ND"))
                    matrizAdjacente[v2][v1] = 1;
            }

        matrizCompleta.setTipoGrafo(tipoGrafo);
        matrizCompleta.setNumVertices(numVertices);
        matrizCompleta.setMatrizAdjacente(matrizAdjacente);
        return matrizCompleta;
    }
}
