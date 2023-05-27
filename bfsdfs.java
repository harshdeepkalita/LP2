import java.util.*;

public class Main
{
    private int V;
    private LinkedList<Integer> [] adjList;
    
    public Main(int V)
    {
        this.V = V;
        adjList = new LinkedList[V];
        for(int i=0;i<V;++i)
        {
            adjList[i] = new LinkedList<>();
        }
    }
    void addEdge(int x,int y)
    {
        adjList[x].add(y);
        adjList[y].add(x);
    }
    
    void DFS(int v)
    {
        boolean [] visited = new boolean[V];
        DFSUtil(v,visited);
        
    }
    void DFSUtil(int v,boolean [] visited)
    {
        visited[v] = true;
        System.out.print(v + " ");
        for (int n:adjList[v])
        {
            if (!visited[n])
            {
                DFSUtil(n,visited);
            }
        }
    }
    void BFS(int v)
    {
        boolean [] visited = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();
        
        visited[v] = true;
        queue.add(v);
        
        while (!queue.isEmpty())
        {
            int currIndex = queue.poll();
            System.out.print(currIndex+" ");
            for (int n:adjList[currIndex])
            {
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
    public static void main(String[] args) {
        Main graph = new Main(4);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(3,0);
        graph.DFS(0);
        System.out.println();
        graph.BFS(0);
}
}
