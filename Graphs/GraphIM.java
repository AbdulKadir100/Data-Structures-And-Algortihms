package Graphs;


import java.util.HashMap;
import java.util.*;

public class GraphIM {
    public static void main(String[] args) {
        GraphImplement<Integer> g = new GraphImplement<>();
        g.addEdge(0,1,true);
        g.addEdge(0,4,true);
        g.addEdge(1,2,true);
        g.addEdge(1,3,true);
        g.addEdge(1,4,true);
        g.addEdge(2,3,true);
        g.addEdge(2,4,true);
        System.out.println("Graph: "+g.toString());
        g.getVertexCount();
        g.getEdgeCount(true);
        g.hasVertex(1);
        g.addEdge(1,4,true);


    }

}
class GraphImplement<T>{
    // We use Hashmap to store the edges in the graph

    private Map<T, List<T>> map = new HashMap<>();
    int BFSDisscon(ArrayList<ArrayList<Integer>> adj,int v){
         boolean[] visited = new boolean[v+1];
         int count=0;
        for (int i = 0; i < v; i++) {
            if (visited[i] == false){
                BFS(adj,v,i,visited);
                count++;
            }
        }
        return count;
    }
    public void BFS(ArrayList<ArrayList<Integer>> adj,int v,int s,boolean[] visited){
       Queue<Integer> q = new LinkedList<>();
       visited[s]=true;
       q.add(s);
       while (!q.isEmpty()){
           int u = q.poll();
           System.out.println(u+" ");
           for(int v1 : adj.get(u)){
               if (!visited[v1]){
                   visited[v1] = true;
                   q.add(v1);
               }
           }
       }
    }
    // This function adds a new vertex to the graph
    public void addVertex(T s) {
        map.put(s, new LinkedList<>());
    }

    public void addEdge(T src, T dest, boolean bidirect) {
        if (!map.containsKey(src))
            addVertex(src);
        if (!map.containsKey(dest))
            addVertex(dest);
        map.get(src).add(dest);
        if (bidirect)
            map.get(dest).add(src);
    }

    public void getVertexCount() {
        System.out.println("The graph has "
                + map.keySet().size() + " vertex");
    }

    public void getEdgeCount(boolean bidirect) {
        int count = 0;
        for (T v : map.keySet()) {
            count += map.get(v).size();
        }
        if (bidirect)
            count /= 2;
        System.out.println("The Graph has " + count + " Edges");
    }
    // Vertex present or not
    public void hasVertex(T s){
        if (map.containsKey(s))
            System.out.println("Vertex at " + s + " is Contain");
        else
            System.out.println("There is no vertex");
    }
    // This function gives whether an edge is present or not.
    public void hasEdge(T s,T d){
        if (map.get(s).contains(d))
            System.out.println("The graph has edge betwen "+s+" and "+d);
        else
            System.out.println("The graph has no edge between "
                    + s + " and " + d + ".");
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (T v : map.keySet()) {
            builder.append(v.toString()).append(": ");
            for (T w : map.get(v)) {
                builder.append(w.toString()).append(" ");
            }
            builder.append("\n");
        }

        return (builder.toString());
    }
}