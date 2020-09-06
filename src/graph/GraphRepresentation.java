package graph;

import linkedlist.List;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class GraphRepresentation {

    static void sparseMatrixRep(Scanner sc) {


        int n, u, v, e;
        System.out.println("Sparse Matrix ###################");

        System.out.println("Enter number of vertices: ");
        n = sc.nextInt();
        System.out.println("\nEnter number of edges: ");
        e = sc.nextInt();

        int[][] matrix = new int[n][n];

        for (int i = 1; i <= e; i++) {
            System.out.println("Enter edge no. : " + i + " from= ");
            u = sc.nextInt();
            System.out.println("To: ");
            v = sc.nextInt();

            matrix[u][v] = 1;
            matrix[v][u] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    static void adjacencyListRep(Scanner sc) {
        int n, u, v, e;
        System.out.println("Adjacency List ###################");

        System.out.println("Enter number of vertices: ");
        n = sc.nextInt();
        System.out.println("\nEnter number of edges: ");
        e = sc.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(n);

        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<Integer>());

        for (int i = 1; i <= e; i++) {
            System.out.println("Enter start and end vertex of edge : " + i);
            u = sc.nextInt();
            v = sc.nextInt();

            addEdge(graph, u, v);
        }

        for (int i = 0; i < graph.size(); i++) {
            System.out.println("\nAdjacency list of vertex" + i);
            System.out.print("head");
            for (int j = 0; j < graph.get(i).size(); j++) {
                System.out.print(" -> "+graph.get(i).get(j));
            }
            System.out.println();
        }
    }

    private static void addEdge(ArrayList<ArrayList<Integer>> graph, int u, int v) {

        graph.get(u).add(v);
        graph.get(v).add(u);
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //sparseMatrixRep(sc);

        System.out.println();

        adjacencyListRep(sc);
    }
}
