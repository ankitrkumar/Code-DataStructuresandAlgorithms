import java.util.*;
 
 
public class Traversals { 
	public enum State { 
		Unvisited, Visited, Visiting;
	}  
 
 
	public static void main(String a[])
	{ 
		Graph g = createNewGraph();
		Node[] n = g.getNodes();
		Node start = n[3];
		Node end = n[5];
		System.out.println(isConnected(g, n[3], n[4]));
		System.out.println("search(g, start, end)");
		System.out.println(search(g, start, end));
		dfs(n[0]);
		System.out.println("_________");
		markUnvisited(g);
		dfs(n[1]);
		System.out.println("_________");
		markUnvisited(g);
		dfs(n[2]);
		System.out.println("_________");
		markUnvisited(g);
		dfs(n[3]);
		System.out.println("_________");
		markUnvisited(g);
		dfs(n[4]);
		System.out.println("_________");
		markUnvisited(g);
		dfs(n[5]);
		System.out.println("_________");
		markUnvisited(g);
		dfs(n[6]);
		System.out.println("_________");
		markUnvisited(g);
		dfs(n[7]);
		System.out.println("_________");
		markUnvisited(g);
		bfs(n[1]);
	} 
	 
	public static void markUnvisited(Graph g)
	{
		for(Node u : g.getNodes())
		{
			u.state = State.Unvisited;
		}
	}

	public static Graph createNewGraph() 
	{ 
		Graph g = new Graph();        
		Node[] temp = new Node[8];
 
 
		temp[0] = new Node("0", 1);
		temp[1] = new Node("1", 2);
		temp[2] = new Node("2", 2);
		temp[3] = new Node("3", 2);
		temp[4] = new Node("4", 2);
		temp[5] = new Node("5", 1);
		temp[6] = new Node("6", 1);
		temp[7] = new Node("7", 1);
 
 
		temp[0].addAdjacent(temp[2]);
		
		temp[1].addAdjacent(temp[0]);
		temp[1].addAdjacent(temp[3]);
		
		temp[2].addAdjacent(temp[1]);
		temp[2].addAdjacent(temp[4]);

		temp[3].addAdjacent(temp[5]);
		temp[3].addAdjacent(temp[7]);

		temp[4].addAdjacent(temp[6]);
		temp[4].addAdjacent(temp[7]);

		temp[5].addAdjacent(temp[1]);

		temp[6].addAdjacent(temp[5]);

		temp[7].addAdjacent(temp[5]);

		for (int i = 0; i < 8; i++) {
			g.addNode(temp[i]);
		} 
		return g;
	} 
 
public static boolean isConnected(Graph g, Node start, Node end)
{
	if(start == end)
		return true;
	Queue<Node> q = new LinkedList<Node>();
	
	start.state = State.Visiting;
	q.add(start);
	while(!q.isEmpty())
	{
		Node r = q.remove();
		for(Node u : r.getAdjacent())
		{
			if(u.state == State.Unvisited)
			{
				u.state = State.Visiting;
				if(u == end)
					return true;
				q.add(u);
			}
		}
		r.state = State.Visited;
	}
	return false;
}


 	public static void dfs(Node root)
	{
		if(root == null)
			return;
		System.out.print(root.getVertex()+ "\t");
		root.state = State.Visited;

		for( Node r : root.getAdjacent())
		{
			if(r.state != State.Visited )
				dfs(r);
		}
	}

	public static void bfs(Node root)
	{
		if(root == null)
			return;

		Queue<Node> queue = new LinkedList<Node>();
		root.state = State.Visited;
		queue.add(root);
		while(!queue.isEmpty())
		{
			Node r = queue.remove();
			
			for(Node u : r.getAdjacent())
			{
				if(u.state != State.Visited)
				{
					u.state = State.Visited;
					System.out.print(u.getVertex() + "\t");
					queue.add(u);
				}
			}
		}
	}

    public static boolean search(Graph g,Node start,Node end) {  
        LinkedList<Node> q = new LinkedList<Node>();
        for (Node u : g.getNodes()) {
            u.state = State.Unvisited;
        } 
        start.state = State.Visiting;
        q.add(start);
        Node u;
        while(!q.isEmpty()) {
            u = q.removeFirst();
            if (u != null) {
	            for (Node v : u.getAdjacent()) {
	                if (v.state == State.Unvisited) {
	                    if (v == end) {
	                        return true; 
	                    } else { 
	                        v.state = State.Visiting;
	                        q.add(v);
	                    } 
	                } 
	            } 
	            u.state = State.Visited;
            } 
        } 
        return false; 
    } 
} 