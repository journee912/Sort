package Sort;

import java.util.Iterator;
import java.util.LinkedList;

// ���� Ž�� ���� �ʴ� �׷������� �ֱ� ã��
// �� Ŭ������ ������ �׷��� ����Ʈ ǥ���� ����Ͽ� ���õ� �׷����� ��Ÿ����.
public class DFSundirectedGraph2 {
	private int V;	// V�� ���� ����
	private LinkedList<Integer> adj[];	// ��������Ʈ ����
	
	DFSundirectedGraph2(int v) {
		// TODO Auto-generated constructor stub
		V = v;
		adj = new LinkedList[v];
		for(int i=0; i<v; ++i) {
			adj[i] = new LinkedList();
		}
	}
	// �׷������� ���� �ڸ��� �߰��ϴ� ���
	void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
	}
	// visited �迭�� parent�� ����Ͽ� ���� v�� ������ �� �ִ� ���� �ֱ⸦ Ž���ϴ� ����
	boolean isCyclicUtil(int v, boolean visited[], int parent) {
		// ���� ��带 �湮�� ��� ǥ��
		visited[v] = true;
		Integer i;
		// �� ������ ������ ��� ���� ���� ��������� ȣ��
		Iterator<Integer> it = adj[v].iterator();
		while(it.hasNext()) {
			i = it.next();
			// ������ ���� ���� ��� ������ ������ �̵�
			if(!visited[i]) {
				if(isCyclicUtil(i, visited, v)) {
					return true;
				}
				// ������ ��� parent�� ���Ͽ� ������ ������ ��� ����Ŭ�� �ִ�.
			} else if(i != parent) {
				return true;
			}
		}
		return false;
	}
	// �׷����� ����Ŭ�� ���ԵǾ� ������ true ��ȯ
	boolean isCyclic() {
		// ��� ������ �Ϻΰ� �ƴ� ��� ���� ǥ��
		boolean visited[] = new boolean[V];
		// ��ȯ ����� �̿��Ͽ� �پ��� DFS Ʈ������ ����Ŭ ����
		for(int i=0; i<V; i++) {
			visited[i] = false;
		}
		for(int u=0; u<V; u++) {
			if(!visited[u]) {	// �̹� �湮�� ��� �ǵ��� ���� ����
				if(isCyclicUtil(u, visited, -1)) {
					return true;
				}
			}
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DFSundirectedGraph2 g1 = new DFSundirectedGraph2(5);
		g1.addEdge(1, 0);
		g1.addEdge(0, 2);
		g1.addEdge(2, 0);
		g1.addEdge(0, 3);
		g1.addEdge(3, 4);
		if(g1.isCyclic()) {
			System.out.println("DFS undirect Graph contains cycle");
		} else {
			System.out.println("DFS undirect Graph doesn't contains cycle");
		}
		
		DFSundirectedGraph2 g2 = new DFSundirectedGraph2(3);
		g2.addEdge(0, 1);
		g2.addEdge(1, 2);
		if(g2.isCyclic()) {
			System.out.println("DFS undirect Graph contains cycle");
		} else {
			System.out.println("DFS undirect Graph doesn't contains cycle");
		}
	}

}
