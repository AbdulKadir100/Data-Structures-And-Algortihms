package CodeChef;

import java.util.LinkedList;

public class Graph {
    private int V,E;
    Edge[] edge;
    private final LinkedList<Integer>[] adj;

    Graph(int v, int e, LinkedList<Integer>[] adj) {
        V = v;
        E = e;
        this.adj = adj;
        edge = new Edge[E];
        for (int i = 0; i < e; i++) {
            edge[i] = new Edge();
        }
    }

    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList();
        }
    }

    static class Edge implements Comparable<Edge>{

        int src,dest,weight;

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
    static class subset{
        int parent,rank;
    }

    int find(subset[] subset,int i){
        if (subset[i].parent != i)
            subset[i].parent = find(subset,subset[i].parent);
        return subset[i].parent;
    }

    //Function to add an edge into the graph
    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void DFSUtil(int v, boolean[] visited) {
        //Mark current node and print it.
        visited[v] = true;
        System.out.print(v + " ");
        for (int n : adj[v]) {
            if (!visited[n]) {
                DFSUtil(n, visited);
            }
        }
    }

    public void DFS(int v) {
        boolean[] visited = new boolean[V];
        DFSUtil(v, visited);
    }
}
