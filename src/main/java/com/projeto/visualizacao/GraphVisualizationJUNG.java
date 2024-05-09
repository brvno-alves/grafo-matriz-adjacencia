package com.projeto.visualizacao;

import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseGraph;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import javax.swing.*;
import java.awt.*;

public class GraphVisualizationJUNG {
    private Graph<Integer, String> graph;

    public GraphVisualizationJUNG(int[][] matrizAdjacencia) {
        this.graph = new SparseGraph<>();


        // Adiciona vértices ao grafo
        for (int i = 0; i < matrizAdjacencia.length; i++) {
            for (int j = i + 1; j < matrizAdjacencia.length; j++) {
                if (matrizAdjacencia[i][j] == 1) {
                    graph.addVertex(i);
                }
            }
        }


        // Adiciona arestas ao grafo
        for (int i = 0; i < matrizAdjacencia.length; i++) {
            for (int j = i + 1; j < matrizAdjacencia.length; j++) {
                if (matrizAdjacencia[i][j] == 1) {
                    graph.addEdge("Edge-" + i + "-" + j, i, j);
                }
            }
        }
    }

    public void visualize() {
        SwingUtilities.invokeLater(() -> {
            // Cria um visualizador do JUNG
            BasicVisualizationServer<Integer, String> visualizer = new BasicVisualizationServer<>(
                    new CircleLayout<>(graph), new Dimension(650, 650));

            // Define o decorador de rótulos para exibir os rótulos dos vértices
            visualizer.getRenderContext()
                    .setVertexLabelTransformer(new ToStringLabeller());



            // Configura o visualizador em um frame
            JFrame frame = new JFrame("JUNG Graph Visualization");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(visualizer);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
