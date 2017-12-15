package Sort;

import java.util.Iterator;
import java.util.LinkedList;
// DFS(Depth-First Seach) �׷��� ����
// ������ ����� ����Ͽ� ���õ� �׷����� ���
public class DFSGraph {
	private int V;
	private LinkedList<Integer> adj[];
	
	DFSGraph(int v){
		V = v;
		// ���� ���
		adj = new LinkedList[v];
		for(int i=0; i<v; ++i) {
			adj[i] = new LinkedList();
		}
	}
	// �׷����� �����ڸ��� �߰��ϴ� ���
	void addEdge(int v, int w) {
		// v�� w �߰�
		adj[v].add(w);
	}
	// DFS���� ����ϴ� ���
	void DFSUtil(int v, boolean visited[]) {
		// ���� ��带 �湮�� ���·� ǥ��
		visited[v] = true;
		System.out.print(v+" ");
		// �� ������ ������ v�� ���ؼ� ��������� ȣ��
		Iterator<Integer> i = adj[v].listIterator();
		while(i.hasNext()) {
			int n = i.next();
			if(!visited[n]) {
				DFSUtil(n, visited);
			}
		}
	}
	// DFS ����� �����ϴ� ���, DFSUtil()�� ���� ����� ȣ��
	void DFS(int v) {
		// �湮���� ���� ��� vǥ�� , �⺻������ false�� ����
		boolean visited[] = new boolean[V];
		// DFS�� ����ϰ� ������� ���� ��ȯ ȣ��
		DFSUtil(v, visited);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DFSGraph g = new DFSGraph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		
		System.out.println("Following is Depth First Traversal "+"(starting from vertex 2)");
		g.DFS(2);
	}

}
