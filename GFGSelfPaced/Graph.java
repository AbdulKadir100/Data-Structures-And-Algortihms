package GFGSelfPaced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    public static void main(String[] args) {
        int v=5;
        boolean visit[] = new boolean[v+1];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(v);
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<Integer>());
        }
        addEdgeInAdjacancyList(adj,0,1);
        addEdgeInAdjacancyList(adj,0,2);
        addEdgeInAdjacancyList(adj,1,0);
        addEdgeInAdjacancyList(adj,1,4);
        addEdgeInAdjacancyList(adj,1,3);

        //BFS(adj,v,0);
        shortestPath(adj,v,0);


    }
    public void topologicalSorting(){
        /*
        Algorithm :
        1. Store integer of every vertex.
        2. Create a queue.
        3. Add all 0 integer vertices to queue.
        4. while q is not empty
           a. u = q.pop() 
           b. print u.
           c. for every adjacent v of u
              - reduce int of v by 1.
              - if in_degree of v become 0, add v to q.
         */
    }

    public static boolean DFSRecCycDetection(ArrayList<ArrayList<Integer>>
                               adj,int s,boolean[] visited,boolean[] recStk){
        /*
        Cycle Detection In Directed edges graph.
        If there is any edge in the Stack there is cycle in the graph.
        */
        visited[s] = true;
        System.out.print(s+" ");
        for(int u : adj.get(s)){
            if (!visited[u] && DFSRecCycDetection(adj,u,visited,recStk)){
                return true;
            }else if(recStk[u]){
                return false;
            }
        }
        recStk[s] = false;
        return false;
    }
    public static boolean DFS2(ArrayList<ArrayList<Integer>> adj,int v){
        boolean[] visited = new boolean[v];
        boolean[] recStk = new boolean[v];
        //   int count=0;  // If we want count total component
        for (int i = 0; i < v; i++) {
            if (!visited[i]){
                DFSRecCycDetection(adj,i,visited,recStk);
                return true;
                //count++;
            }
        }
        //return count;
        return false;
    }
    public static boolean DFSCD(ArrayList<ArrayList<Integer>> adj,int v){
        // DFS for checking connecting or not, also Cycle Detection in Undirected graph.
        boolean[] visited = new boolean[v+1];
        //   int count=0;    If we want count the total component
        for (int i = 0; i < v; i++) {
            if (!visited[i]){
                if(DFSRecCycleDetection(adj,i,visited,-1)){
                    return true;
                }
                //count++;
            }
        }
        return false;
    }
    public static boolean DFSRecCycleDetection(ArrayList<ArrayList<Integer>> adj,
                                            int s,boolean[] visited,int parent){
        /*
        Detecting cycle in an undirected graph using DFS(we can use BFS too).
        Parent var is used to check cycle if we have two vertex there is only one
        edge in case it will handle.
         */
        visited[s] = true;
        System.out.print(s+" ");
        for(int u : adj.get(s)){
            if (!visited[u]){
                if(DFSRecCycleDetection(adj, u, visited,s)){
                       return true;
                }
            }else if (u != parent){
                return true;
            }
        }
        return false;
    }
    public static void shortestPath(ArrayList<ArrayList<Integer>> adj,int v,int s){
        /* Finding shortest path using BFS*/
        boolean[] visited = new boolean[v+1];
        int[] dist = new int[v];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[s]=0;
        Queue<Integer> q = new LinkedList<>();
        visited[s] = true;
        q.add(s);
        while (!q.isEmpty()){
            int u = q.poll();
           // System.out.print(u+" ");
            for(int v1 : adj.get(u)){
                if (!visited[v1]){
                    dist[v1] = dist[u]+1;
                    visited[v1] = true;
                    q.add(v1);
                }
            }
        }
        System.out.println(Arrays.toString(dist));
    }
    public static void DFSRec(ArrayList<ArrayList<Integer>> adj,int s,boolean[] visited){
        visited[s] = true;
        System.out.print(s+" ");
        for(int u : adj.get(s)){
            if (!visited[u]){
                DFSRec(adj, u, visited);
            }
        }
    }
    public static void DFS(ArrayList<ArrayList<Integer>> adj,int v){
        boolean[] visited = new boolean[v+1];
     //   int count=0;  // If we want count total component
        for (int i = 0; i < v; i++) {
            if (!visited[i]){
                DFSRec(adj,i,visited);
                //count++;
            }
        }
        //return count;
    }
    public static int BFSDistinictGraph(ArrayList<ArrayList<Integer>> adj,int v){
        /*BFS for distinct graph or not connected graph.
        * And counting how many not connected component in the graph*/
        boolean[] visited = new boolean[v+1];
        int count=0;
        for (int i = 0; i < v; i++) {
            if (!visited[i]){
                BFS(adj,i,0,visited);
                count++;
            }
        }
        return count;
    }
    public static void BFS(ArrayList<ArrayList<Integer>>
                                   adj,int v,int s,boolean[] visited){
        //boolean[] visited = new boolean[v+1];
        Queue<Integer> q = new LinkedList<>();
        visited[s] = true;
        q.add(s);
        while (!q.isEmpty()){
            int u = q.poll();
            System.out.print(u+" ");
            for(int v1 : adj.get(u)){
                if (!visited[v1]){
                    visited[v1] = true;
                    q.add(v1);
                }
            }
        }
    }
    public static void addEdgeInAdjacancyList(ArrayList<ArrayList<Integer>> adj,int u,int v){
       /*
         Using Adjacency List( Linked List impl)
         Insertion and deletion is better then adj matrix
        */
        adj.get(u).add(v); // Vertex
        adj.get(v).add(u); // Edge 
    }
    public static void printGraph(ArrayList<ArrayList<Integer>> adj){
        for (int i = 0; i < adj.size(); i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }

}
