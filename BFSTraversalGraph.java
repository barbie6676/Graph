//bfs traversal, start from the vetex of s
//coloring algorithm

static int WHITE = 1;
static int GRAY = 0;
static in BLACK = -1;

public void BFS(Graph g, Vertex s) {
    Queue<Vertex> q = new LinkedList<Vertex>();
    for (Vertex u : g.Vset()){              //for each vertex u in V[G] except s.
         if (u!=s){
            u.color = WHITE;
            u.dist =  Integer.MAX_VALUE;
            u.succ =  null;
          }
    }
    s.color = GRAY;                 //Source vertex discovered
    s.dist = 0;                   // initialize
    s.succ = null;               //initialize

    q.add(s);
    while (!q.isEmpty()){
        u = q.poll();
        for (Vertex v : g.adj.get(u)) {             //for loop for every node along with edge.
            if (v.color == WHITE) {        //if color is white you've never seen it before
               v.color = GRAY;
               v.dist = u.dist + 1;
               v.succ =  u;
               q.add(v);
            }

        u.color = BLACK;
    }
}



//a bipartite graph (or bigraph) is a graph whose vertices can be divided into two disjoint sets U and V 
        //such that every edge connects a vertex in U to one in V.
//Equivalently, a bipartite graph is a graph that does not contain any odd-length cycles.
//http://en.wikipedia.org/wiki/Bipartite_graph

public boolean isBipartite (Graph g, Vertex s){

    for (Vertexh u : g.Vset()){              //for each vertex u in V[G] except s.
         if (u!=s){
            u.color = WHITE;
            u.dist =  Integer.MAX_VALUE;
            u.partition =  0;
          }
    }
    
    Queue<Vertex> q = new LinkedList<Vertex>();
    s.color =  GRAY;
    s.partition = 1;
    s.dist = 0;
    q.add(s);
    while (!q.isEmpty()){
        u = q.poll();
        for (Vertex v : g.adj.get(u)) {             //for loop for every node along with edge.
                if (u.partition == v.partition){
                   return false;
                } else if (v.color == WHITE){ 
                      v.color = GRAY;
                      v.dist = u.dist + 1;
                      v.partition = 3 − u.partition;
                      q.add(v);
                }
        }

        u.Color[u] = BLACK;
    }
    return true;
}

// by the same setting, decide whether two vertices are connected 
public boolean isConnected (Graph g, Vertex start, Vertex end) {
    Queue<Vertex> q = new LinkedList<Vertex>();
    
    for (Vertex u : g.Vset()){
        u.color = WHITE;
    }
    
    start.color = GRAY;
    q.add(start);
    Vertex u;
    while (!q.isEmpty()){
        u = q.poll();
        if (u != null) { //directed graph, some of the vertex may be null
            for (Vertex v : g.adj.get(u)) {
                if (v.color == WHITE) {
                    if (v == end) {
                        return true;
                    } else {
                        v.color = GRAY;
                        q.add(v);
                    }
                }
            } 
        }
        u.color = BLACK;
    }
    
    return false;
}

public void  dijkstra(Graph g , Vertex s){
       for (Vertex u : g.Veset(){                           // Initializations
           
            u.color = WHITE;
            u.dist =  Integer.MAX_VALUE;
            u.succ =  null;
                                   // Previous node in optimal path from source
       }
       
        s.dist  = 0;    
        s.color = GRAY;    // Distance from source to itself is zero
        Queue<Vertex> q = new PriorityQueue<Vertex>(Vertex.dist);
        q.add(s);                                 // Start off with the source node
        
        Vertex u = null;                                                     
        while (!q.isEmpty()){                                // The main loop
            u = q.poll();//vertex in Q with smallest distance in dist[] and has not been visited;  /

            for (Vertex v : g.adj.get(u) ){     
                int alt = u.dist + dist_between(u, v);          // accumulate shortest dist from source
                if (alt < v.dist && v.color == WHITE ){   
                    v.color = GRAY;
                    v.dist  = alt;                          // keep the shortest dist from src to v
                    v.succ = u;
                    q.add(v);                          // Add unvisited v into the Q to be processed
                }
            }
            
            u.color = BLACK; // mark this node as visited
        }
}
