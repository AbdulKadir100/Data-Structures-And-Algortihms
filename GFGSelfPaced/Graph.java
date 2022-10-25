package GFGSelfPaced;

import java.util.*;

public class Graph {
    class Pair {
        int row;
        int col;
        int tm;

        Pair(int _row, int _col, int _tm) {
            this.row = _row;
            this.col = _col;
            this.tm = _tm;
        }
    }

    class Pair2 {
        int first;
        int second;

        Pair2(int _first, int _second) {
            this.first = _first;
            this.second = _second;
        }

    }
    class Pair3{
        int first;
        int second;
        int third;
        Pair3(int _first,int _second,int _third){
            this.first = _first;
            this.second = _second;
            this.third = _third;
        }
    }

    public static void main(String[] args) {
        int v = 5;
        boolean visit[] = new boolean[v + 1];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        addEdgeInAdjacancyList(adj, 0, 1);
        addEdgeInAdjacancyList(adj, 0, 2);
        addEdgeInAdjacancyList(adj, 1, 0);
        addEdgeInAdjacancyList(adj, 1, 4);
        addEdgeInAdjacancyList(adj, 1, 3);

        //BFS(adj,v,0);
        shortestPath(adj, v, 0);


    }
    private int[] shortestPath(int[][] edges,int n,int m,int src){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        //Its undirected graph so it has both vertices edges
        for(int i=0;i<m;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        int[] dist = new int[n];
        for(int i=0;i<n;i++){
            dist[i] = (int)1e9;
        }

        dist[src]=0;
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        while (!q.isEmpty()){
            int node= q.peek();
            q.remove();
            for(int it: adj.get(node)){
                if(dist[node]+1<dist[it]){
                    dist[it] = 1+dist[node];
                    q.add(it);
                }
            }
        }
        for(int i=0;i<n;i++){
            if(dist[i]==(int)1e9){
                dist[i] = -1;
            }
        }
        return dist;
    }
    private void topoSort4ShortestPath(int node,ArrayList<ArrayList<Pair2>> adj,
                                        int[] vis,Stack<Integer> st){
        //Shortest path in the undirected graph
        //Traversal used DFS

        vis[node]=1;
        for(int i=0;i<adj.get(node).size();i++){
            int v = adj.get(node).get(i).first;
            if(vis[v]==0){
                topoSort4ShortestPath(i,adj,vis,st);
            }
        }
        st.add(node);

    }
    private int[] shortestPath(int N,int M,int[][] edges){
        ArrayList<ArrayList<Pair2>> adj = new ArrayList<>();
        // Building graph
        for(int i=0;i<N;i++){
            ArrayList<Pair2> temp = new ArrayList<>();
            adj.add(temp);
        }

        // Adding graph component to adj list
        for(int i=0;i<M;i++){
            int u = edges[i][0]; // Get the source edge
            int v = edges[i][1]; // Get the vertex
            int wt = edges[i][2]; // Get the weight associated with it
            adj.get(u).add(new Pair2(v,wt));
        }
        int[] vis = new int[N];
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<N;i++){
            if(vis[i]==0){
                topoSort4ShortestPath(i,adj,vis,st);
            }
        }
        int[] dist = new int[N];
        // Fill the dist array by Infinite( 1e9 )
        for(int i=0;i<N;i++){
            dist[i] = (int)1e9;
        }

        dist[0]=0;
        while (!st.isEmpty()){
            int node = st.peek();
            st.pop();

            for(int i=0;i<adj.get(node).size();i++){
                int v = adj.get(node).get(i).first;  // Get the vertex
                int wt = adj.get(node).get(i).second; // Vertex weight

                // Updating with new smaller distance
                if(dist[node]+ wt < dist[v]){
                    dist[v] = wt+dist[node];
                }
            }

        }
        return dist;

    }
    private String findOrder(String [] dict, int N, int K)
    {
        // Alien dictionary order using topological sort
        // If there is S1 is greater then S2 and everything matching and
        // hav cyclic dependencies then a<b<a
        // then only sorted order not possible
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<K;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<N-1;i++){
            String s1 = dict[i];
            String s2 = dict[i+1];
            int len = Math.min(s1.length(),s2.length());
            for(int ptr=0;ptr<len;ptr++){
                if(s1.charAt(ptr)!=s2.charAt(ptr)){
                    adj.get(s1.charAt(ptr)-'a').add(s2.charAt(ptr)-'a');
                    break;
                }
            }
        }
        int[] topo = kahanTopoSort(K,adj);
        String ans="";
        for(int it:topo){
            ans = ans + (char)(it+(int)('a'));
        }
        return ans;

    }
    private int[] courseScheduler2(int V, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<V;i++ ){
            adj.add(new ArrayList<>());
        }
        //Filling graph by given prereq

        int V2 = prerequisites.length;

        for(int[] req: prerequisites){
            adj.get(req[1]).add(req[0]);
        }
        int[] indegree = new int[V];

        //Count indegree of every vertex
        for(int i=0;i<V;i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int[] topo= new int[V];
        int i=0;
        while (!q.isEmpty()){
            int node = q.peek();
            q.remove();
            topo[i++]=node;
            //node in your topo sort
            // Just remove it from indegree

            for(int it : adj.get(node)){
                indegree[it]--;
                if((indegree[it])==0){
                    q.add(it);
                }
            }
        }
        if(topo.length==V) return topo;
        int[] arr = {};
        return arr;
    }
    private boolean courseScheduler(int V, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        //Filling graph by given prereq

        for(int[] e: prerequisites){
            adj.get(e[1]).add(e[0]);
        }

        int[] indegree = new int[V];

        for(int i=0;i<V;i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int[] topo= new int[V];
        int count=0;
        while (!q.isEmpty()){
            int node = q.peek();
            q.remove();
            count++;
            //node in your topo sort
            // Just remove it from indegree

            for(int it : adj.get(node)){
                indegree[it]--;
                if((indegree[it])==0){
                    q.add(it);
                }
            }
        }
        return count==V;

    }
    private boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // Detect cycle in a directed graph
        // If topo[] length is equal to total vertices V
        // then there is a cycle in Graph
        int[] indegree = new int[V];

        for(int i=0;i<V;i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int count=0;
        int i=0;
        while (!q.isEmpty()){
            int node = q.peek();
            q.remove();
            count++;
            //node in your topo sort
            // Just remove it from indegree

            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
            }
        }
        if(count==V)return false;
        return true;
    }
    private int[] kahanTopoSort(int V,ArrayList<ArrayList<Integer>> adj){
        int[] indegree = new int[V];

        //Counting Indegree
        for(int i=0;i<V;i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        // Adding edges to the queue of having in-degree 0.
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int[] topo= new int[V];
        int i=0;
        while (!q.isEmpty()){
            int node = q.peek();
            q.remove();
            topo[i++] = node;
            //node in your topo sort
            // Just remove it from indegree

            for(int it : adj.get(node)){
                indegree[it]--;
                if((indegree[it])==0){
                    q.add(it);
                }
            }
        }
        return topo;
    }
    private static void dfsForTopoSort(int node,int[] vis,Stack<Integer> st,ArrayList<ArrayList<Integer>> adj){
        vis[node] = 1;

        for(int it:adj.get(node)){
            if(vis[it]==0){
                dfsForTopoSort(it,vis,st,adj);
            }
        }
        st.push(node);
    }
    //Function to return list containing vertices in Topological order.
    private static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        Stack<Integer> st = new Stack<>();
        int[] vis = new int[V];

        for(int i =0;i<V;i++){
            if(vis[i]==0){
                dfsForTopoSort(i,vis,st,adj);
            }
        }
        int[] arr = new int[V];
        int i=0;
        while(!st.isEmpty()){
            arr[i++] = st.peek();
            st.pop();
        }
        return arr;
    }
    private boolean dfsforCycleDetecDirect(int node,int[] vis,int[] pathVis,
                                           ArrayList<ArrayList<Integer>> adj){
        /*
        Whenever pathVis[] cell is became 0 then it has no cycle
        TC -> O(V+2E)
        SC -> O(N)
        */
        vis[node] = 1;
        pathVis[node] = 1;

        //Traverse adjacent node
        for(int i : adj.get(node)){
            if(vis[i]  == 0 ){
                if(!dfsforCycleDetecDirect(i,vis,pathVis,adj)){
                    return true;
                }else if(pathVis[i]==1)
                    return true;
            }
        }
        pathVis[node] = 0;
        return false;
    }
    private boolean isCyclicDirected(int V,ArrayList<ArrayList<Integer>> adj){

        int[] vis = new int[V];
        int[] pathvis = new int[V];

        for(int i=0;i<V;i++){
              if(dfsforCycleDetecDirect(i,vis,pathvis,adj))
                  return true;
          }
          return false;
    }

    private boolean dfs(int node,int col,int[] color,ArrayList<ArrayList<Integer>> adj){
        color[node] = col;

        for(int i : adj.get(node)){
            if(color[i]==-1){
                if(!dfs(i,1-col,color,adj)){
                    return false;
                }
            }else if(color[i] == col){
                return false;
            }
        }
        return true;
    }
    private boolean bfs(int start,int V,int[][] graph,int[] color){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0;

        while(!q.isEmpty()){
            int curnode = q.peek();
            q.remove();

            for(int it : graph[curnode]){
                //If not colored yet
                //Colored with opposite color
                if(color[it]==-1){
                    color[it] = 1-color[curnode];
                    q.add(it);
                }

                //If it has same color
                else if(color[it]==color[curnode]){
                    return false;
                }
            }

        }
        return true;

    }
    private boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] color = new int[V];
        Arrays.fill(color,-1);

        for(int i=0;i<V;i++){
            if(color[i]==-1){
                ///Same call for dfs
                if(!bfs(i, V, graph, color)){
                    return false;
                }
            }
        }
        return true;
    }
    private void dfs(int row,int col,int[][] vis,int[][] grid,ArrayList<String> list,int row0,int col0)
    {
        vis[row][col] = 1;
        list.add(toString(row-row0,col-col0));
        int n = grid.length;
        int m = grid[0].length;
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,-1,0,1};

        for(int i=0;i<4;i++){
            //To goto up/down and left/right
            int nrow= row+drow[i];
            int ncol = col+dcol[i];
            if(nrow >= 0 && nrow < n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol] == 1){
                dfs(nrow,ncol,vis,grid,list,row0,col0);
            }
        }
    }
    private String toString(int r,int c){
        return r +" "+ c;
    }
    private int countDistinctIslands(int[][] grid) {
        /*
        TC -> N x M x Log(MxN) + dfs
        SC -> MxN
         */
        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];
        HashSet<ArrayList<String>> set = new HashSet<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j] == 0 && grid[i][j] == 1){
                    ArrayList<String> list = new ArrayList<>();
                    //time m x n x 4
                    dfs(i,j,vis,grid,list,i,j);
                    set.add(list);
                }
            }
        }
        return set.size();
    }

    private int[][] updateMatrix(int[][] grid) {
        /*
        Given an m x n binary matrix mat,
        return the distance of the nearest 0 for each cell.
        The distance between two adjacent cells is 1.

        TC -> (NxMx4) + NxM
        SC -> (NxM)
         */
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int[][] dist = new int[n][m];
        Queue<Pair3> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    q.add(new Pair3(i,j,0));
                    vis[i][j] = 1;
                }
            }
        }

        int[] drow = {-1, 0, 1, 0 };
        int[] dcol = { 0, 1, 0,-1 };

        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            int steps = q.peek().third;
            q.remove();
            dist[row][col] = steps;

            for(int i=0;i<4;i++){
                int nrow = row + drow[i];
                int ncol = col + dcol[i];
                if(nrow>=0 && nrow<n && ncol>= 0 && ncol <m && vis[nrow][ncol]==0){
                    vis[nrow][ncol] = 1;
                    q.add(new Pair3(nrow,ncol,steps+1));
                }
            }
        }
        return dist;
    }
    private boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] vis = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i])
                if (detectBFS(i, adj, vis)) return true;

        }
        return false;
    }

    private boolean detectDFS(int node, int parent, int[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = 1;
        for (int adjacent : adj.get(node)) {
            if (vis[adjacent] == 0) {
                if (detectDFS(adjacent, node, vis, adj)) {
                    return true;
                } else if (adjacent != parent) return true;
            }
        }
        return false;
    }

    private boolean detectBFS(int src, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
       //Cycle detection using bfs in undirected graph
        vis[src] = true;
        Queue<Pair2> q = new LinkedList<>();
        q.add(new Pair2(src, -1));
        while (!q.isEmpty()) {
            int node = q.peek().first;
            int parent = q.peek().second;
            q.remove();

            for (int adjacentNode : adj.get(node)) {
                if (!vis[adjacentNode]) {
                    vis[adjacentNode] = true;
                    q.add(new Pair2(adjacentNode, node));
                } else if (parent != adjacentNode) { //if parent already visited by other node
                    return true;
                }
            }
        }
        return false;
    }
    private void dfs(int row,int col,int[][] ans,int[][] image,int newColor,int[] drow,int[] dcol,int iniColor){
        ans[row][col] = newColor;
        int n = image.length;
        int m = image[0].length;

        for(int i=0;i<4;i++){
            int nrow = row+drow[i];
            int ncol = col+dcol[i];

            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m &&
                    image[nrow][ncol] == iniColor && ans[nrow][ncol] != newColor){
                dfs(nrow,ncol,ans,image,newColor,drow,dcol,iniColor);
            }
        }

    }
    private int[][] floodFill2aar(int[][] image, int sr, int sc, int color) {
        int iniColor = image[sr][sc];
        int[][] ans = image;
        int[] drow = {-1, 0, 1, 0 };
        int[] dcol = { 0, 1, 0,-1 };
        dfs(sr,sc,ans,image,color,drow,dcol,iniColor);
        return ans;
    }
    private int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if (color != newColor) dfs(image, sr, sc, color, newColor);
        return image;
    }

    private void dfs(int[][] image, int r, int c, int color, int newColor) {
        if (image[r][c] == color) {
            image[r][c] = newColor;
            if (r >= 1) dfs(image, r - 1, c, color, newColor);
            if (c >= 1) dfs(image, r, c - 1, color, newColor);
            if (r + 1 < image.length) dfs(image, r + 1, c, color, newColor);
            if (c + 1 < image[0].length) dfs(image, r, c + 1, color, newColor);
        }
    }

    private int orangesRotting(int[][] grid) {
        /*
        SC -> O(mxn)
        TC -> O(mxn)
        */
        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        int[][] vis = new int[n][m];
        int cntfrsh = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 2;
                }
                if (grid[i][j] == 1) cntfrsh++;
            }
        }

        int tm = 0;
        // To move all four directions
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        int cnt = 0;

        while (!q.isEmpty()) {
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().tm;

            tm = Math.max(t, tm);
            q.remove();

            for (int i = 0; i < 4; i++) {
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&
                        vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                    q.add(new Pair(nrow, ncol, t + 1));
                    vis[nrow][ncol] = 2;
                    cnt++;
                }
            }

        }

        if (cnt != cntfrsh) return -1;
        return tm;
    }

    private void dfs(int node, boolean[] vis, int[][] mat) {
        vis[node] = true;
        for (int i = 0; i < mat.length; i++) {
            if (mat[node][i] == 1 && !vis[i]) {
                dfs(i, vis, mat);
            }
        }
    }

    private int findCircleNumber(int[][] isConnected) {
        // Find circle of number in matrix
        // TC -> same as dfs (V+2E)
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                count++;
                dfs(i, vis, isConnected);
            }
        }
        return count;
    }

    private ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V + 1];
        vis[0] = true;
        ArrayList<Integer> list = new ArrayList<>();
        dfs(0, vis, adj, list);
        return list;
    }

    private void dfs(int startnode, boolean[] vis, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> list) {
        /*
        TC -> O(N) + O(2E)
        SC -> O(N)
         */
        //Marking current node as visited
        vis[startnode] = true;
        list.add(startnode);

        //Getting all neighbour node
        for (Integer it : adj.get(startnode)) {
            if (!vis[it]) {
                dfs(it, vis, adj, list);
            }
        }

    }

    private ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        /*
        TC -> O(N)going towards node + (2E) Total degree,
        SC -> O(3N) ~ N
         */
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] vis = new boolean[V];
        Queue<Integer> q = new LinkedList<>();

        q.add(0);  //adding starting node
        vis[0] = true;

        while (!q.isEmpty()) {
            Integer node = q.poll();
            bfs.add(node);
            //Get all the adjacency vertices of dequeued vertices
            //If it is not visited, visit and mark true and add it to queue.
            for (Integer it : adj.get(node)) {
                if (!vis[it]) {
                    vis[it] = true;
                    q.add(it);
                }
            }
        }
        return bfs;
    }

    public void topologicalSorting() {
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
                                                     adj, int s, boolean[] visited, boolean[] recStk) {
        /*
        Cycle Detection In Directed edges graph.
        If there is any edge in the Stack there is cycle in the graph.
        */
        visited[s] = true;
        System.out.print(s + " ");
        for (int u : adj.get(s)) {
            if (!visited[u] && DFSRecCycDetection(adj, u, visited, recStk)) {
                return true;
            } else if (recStk[u]) {
                return false;
            }
        }
        recStk[s] = false;
        return false;
    }

    public static boolean DFS2(ArrayList<ArrayList<Integer>> adj, int v) {
        boolean[] visited = new boolean[v];
        boolean[] recStk = new boolean[v];
        //   int count=0;  // If we want count total component
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                DFSRecCycDetection(adj, i, visited, recStk);
                return true;
                //count++;
            }
        }
        //return count;
        return false;
    }

    public static boolean DFSCD(ArrayList<ArrayList<Integer>> adj, int v) {
        // DFS for checking connecting or not, also Cycle Detection in Undirected graph.
        boolean[] visited = new boolean[v + 1];
        //   int count=0;    If we want count the total component
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                if (DFSRecCycleDetection(adj, i, visited, -1)) {
                    return true;
                }
                //count++;
            }
        }
        return false;
    }

    public static boolean DFSRecCycleDetection(ArrayList<ArrayList<Integer>> adj,
                                               int s, boolean[] visited, int parent) {
        /*
        Detecting cycle in an undirected graph using DFS(we can use BFS too).
        Parent var is used to check cycle if we have two vertex there is only one
        edge in case it will handle.
         */
        visited[s] = true;
        System.out.print(s + " ");
        for (int u : adj.get(s)) {
            if (!visited[u]) {
                if (DFSRecCycleDetection(adj, u, visited, s)) {
                    return true;
                }
            } else if (u != parent) {
                return true;
            }
        }
        return false;
    }

    public static void shortestPath(ArrayList<ArrayList<Integer>> adj, int v, int s) {
        /* Finding shortest path using BFS*/
        boolean[] visited = new boolean[v + 1];
        int[] dist = new int[v];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;
        Queue<Integer> q = new LinkedList<>();
        visited[s] = true;
        q.add(s);
        while (!q.isEmpty()) {
            int u = q.poll();
            // System.out.print(u+" ");
            for (int v1 : adj.get(u)) {
                if (!visited[v1]) {
                    dist[v1] = dist[u] + 1;
                    visited[v1] = true;
                    q.add(v1);
                }
            }
        }
        System.out.println(Arrays.toString(dist));
    }

    public static void DFSRec(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited) {
        visited[s] = true;
        System.out.print(s + " ");
        for (int u : adj.get(s)) {
            if (!visited[u]) {
                DFSRec(adj, u, visited);
            }
        }
    }

    public static void DFS(ArrayList<ArrayList<Integer>> adj, int v) {
        boolean[] visited = new boolean[v + 1];
        //   int count=0;  // If we want count total component
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                DFSRec(adj, i, visited);
                //count++;
            }
        }
        //return count;
    }

    public static int BFSDistinictGraph(ArrayList<ArrayList<Integer>> adj, int v) {
        /*BFS for distinct graph or not connected graph.
         * And counting how many not connected component in the graph*/
        boolean[] visited = new boolean[v + 1];
        int count = 0;
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                BFS(adj, i, 0, visited);
                count++;
            }
        }
        return count;
    }

    public static void BFS(ArrayList<ArrayList<Integer>>
                                   adj, int v, int s, boolean[] visited) {
        //boolean[] visited = new boolean[v+1];
        Queue<Integer> q = new LinkedList<>();
        visited[s] = true;
        q.add(s);
        while (!q.isEmpty()) {
            int u = q.poll();
            System.out.print(u + " ");
            for (int v1 : adj.get(u)) {
                if (!visited[v1]) {
                    visited[v1] = true;
                    q.add(v1);
                }
            }
        }
    }

    public static void addEdgeInAdjacancyList(ArrayList<ArrayList<Integer>> adj, int u, int v) {
       /*
         Using Adjacency List( Linked List impl)
         Insertion and deletion is better then adj matrix
        */
        adj.get(u).add(v); // Vertex
        adj.get(v).add(u); // Edge 
    }

    public static void printGraph(ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

}
