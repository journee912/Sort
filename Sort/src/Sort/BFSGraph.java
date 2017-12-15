package Sort;

import java.util.Iterator;
import java.util.LinkedList;

// BFS(Breadth-First Search), �ʺ�켱��ȸ ����
// BFS�� ������ �ִ� ������������ �̵�
// Graph Ŭ������ ������ ����� ǥ���Ͽ� �׷����� ��Ÿ����.
class BFSGraph {
	private int V;	// V�� �迭�� ũ�⸦ ���� ����
	private LinkedList<Integer> adj[];	// ���� ����Ʈ �迭 ����
	
	BFSGraph(int v){
		V = v;
		adj = new LinkedList[v];	
		for(int i=0; i<v; ++i) {
			adj[i] = new LinkedList();
		}
	}
	// �׷�������  ���� �ڸ��� �߰��ϴ� ���
	void addEdge(int v, int w) {
		adj[v].add(w);
	}
	// BFS ����ϱ� ���� 
	void BFS(int s) {
		// �湮���� ���� ��� Verticle ǥ��, �⺻�� false ����
		boolean visited[] = new boolean[V];
		// BFS�� ����ϱ� ���� queue ����
		LinkedList<Integer> queue = new LinkedList<Integer>();
		// ���� ��带 �湮�� ���·� ǥ���ϰ� ť�� �߰�
		visited[s] = true;
		queue.add(s);
		
		while(queue.size() != 0) {
			// ť�� ������ ��⿭�� �ְ� ���
			s = queue.poll();
			System.out.print(s+" ");
			// ��� ������ ���ϱ�
			// �湮���� ���� ��� ǥ��
			Iterator<Integer> i = adj[s].listIterator();
			while(i.hasNext()) {
				int n= i.next();
				if(!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BFSGraph g = new BFSGraph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		System.out.println("Following is Breath First Traversal "+ "(starting from vertex 2)");
		
		g.BFS(2);
	}

}
