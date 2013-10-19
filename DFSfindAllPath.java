// an implementation of undirected graph

public class Graph{
  int V;
  int E;
  Set<Integer>[] adj;
  
  //...
  public Graph(int i){
    V = i;
  }
}


// it's a NP question
public void findAllPathUndirected (Graph g, Node source, Node dest){
    
    boolean[] visit = new boolean[n];
    
    int[] path = new int[n];
    for (int i = 0; i < n; i++) path[i] = -1;
	
	  DFS(g, visit, path, source, dest, 0); 
      
}

public void DFS(Graph g, boolean[] visit, int[] path, int u, int dest, int level) {

    if (level == path.length) return;
    
    path[level] = u;
    if (u == dest) {
      printPath(level+1);
      return;
    }
    visit[u] = true;
    for (int v : g.adj[u] ){
	 if (!visit[v]) 
	     DFS(g, visit, path, v, dest, level + 1);
    visit[u] = false;
    }
    
}

public void printPath(int len) {  
      for (int i=0; i< len; ++i) 
        System.out.print(path[i] + ' ');  
      System.out.println(); 
}
