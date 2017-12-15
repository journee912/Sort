package Sort;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
// DAG�� ��������
// ������ �׷��� ����Ʈ ǥ���� ����Ͽ� ���õ� �׷����� ��Ÿ���ϴ�.
class TopologicalGraph {
	private int V;
	private LinkedList<Integer> adj[];	// ��������Ʈ
	
	TopologicalGraph(int v){
		V = v;
		adj = new LinkedList[v];
		for(int i=0; i<v; ++i) {
			adj[i] = new LinkedList();
		}
	}
	// �׷����� �����ڸ��� �߰��ϴ� ���
	void addEdge(int v, int w) {
		adj[v].add(w);
	}
	// topologicalSort���� ����ϴ� ����Լ�
	void topologicalSortUtil(int v, boolean visited[], Stack stack) {
		// ���� ��带 �湮�� ��� ǥ��
		visited[v] = true;
		Integer i;
		// �� ������ ������ ��� ���� ���� ��� �Լ� ȣ��
		Iterator<Integer> it = adj[v].iterator();
		while(it.hasNext()) {
			i = it.next();
			if(!visited[i]) {
				topologicalSortUtil(i, visited, stack);
			}
		}
		// ���� ������ ����ϴ� ������ ����
		stack.push(new Integer(v));
	}
	// ���� ������ ����, topologicalSortUtil()�� ���� ����Լ� ȣ��
	void topologicalSort() {
		Stack stack = new Stack();
		// �湮���� ���� ��� �� ǥ��
		boolean visited[] = new boolean[V];
		for(int i=0; i<V; i++) {
			visited[i] = false;
		}
		// ��ȯ ȣ��, ��� ������ �����ϴ� ���� ����
		for(int i=0; i<V; i++) {
			if(visited[i] == false) {
				topologicalSortUtil(i, visited, stack);
			}
		}
		// ���� ���
		while(stack.empty() == false) {
			System.out.print(stack.pop()+" ");
		}
	}
	
	public static void main(String[] args) {
		TopologicalGraph g = new TopologicalGraph(6);
		g.addEdge(5, 2);
		g.addEdge(5, 0);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 1);
		
		System.out.println("Following is a Topological sort of the given graph");
		g.topologicalSort();
	}

}
