package Sort;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
// DAG의 위상정렬
// 인접한 그래픽 리스트 표현을 사용하여 지시된 그래프를 나타냅니다.
class TopologicalGraph {
	private int V;
	private LinkedList<Integer> adj[];	// 인접리스트
	
	TopologicalGraph(int v){
		V = v;
		adj = new LinkedList[v];
		for(int i=0; i<v; ++i) {
			adj[i] = new LinkedList();
		}
	}
	// 그래프에 가장자리를 추가하는 기능
	void addEdge(int v, int w) {
		adj[v].add(w);
	}
	// topologicalSort에서 사용하는 재귀함수
	void topologicalSortUtil(int v, boolean visited[], Stack stack) {
		// 현재 노드를 방문한 대로 표시
		visited[v] = true;
		Integer i;
		// 이 정점에 인접한 모든 점에 대해 재귀 함수 호출
		Iterator<Integer> it = adj[v].iterator();
		while(it.hasNext()) {
			i = it.next();
			if(!visited[i]) {
				topologicalSortUtil(i, visited, stack);
			}
		}
		// 현재 정점을 통과하는 스택을 저장
		stack.push(new Integer(v));
	}
	// 위상 정렬을 수행, topologicalSortUtil()을 통해 재귀함수 호출
	void topologicalSort() {
		Stack stack = new Stack();
		// 방문하지 않은 모든 점 표시
		boolean visited[] = new boolean[V];
		for(int i=0; i<V; i++) {
			visited[i] = false;
		}
		// 순환 호출, 모든 점에서 시작하는 위상 정렬
		for(int i=0; i<V; i++) {
			if(visited[i] == false) {
				topologicalSortUtil(i, visited, stack);
			}
		}
		// 스택 출력
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
