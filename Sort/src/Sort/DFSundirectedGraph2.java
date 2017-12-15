package Sort;

import java.util.Iterator;
import java.util.LinkedList;

// 방향 탐지 되지 않는 그래프에서 주기 찾기
// 이 클래스는 인접한 그래픽 리스트 표현을 사용하여 지시된 그래프를 나타낸다.
public class DFSundirectedGraph2 {
	private int V;	// V는 점이 없음
	private LinkedList<Integer> adj[];	// 인접리스트 선언
	
	DFSundirectedGraph2(int v) {
		// TODO Auto-generated constructor stub
		V = v;
		adj = new LinkedList[v];
		for(int i=0; i<v; ++i) {
			adj[i] = new LinkedList();
		}
	}
	// 그래프에서 가장 자리를 추가하는 기능
	void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
	}
	// visited 배열과 parent를 사용하여 점점 v에 도달할 수 있는 하위 주기를 탐지하는 과정
	boolean isCyclicUtil(int v, boolean visited[], int parent) {
		// 현재 노드를 방문한 대로 표시
		visited[v] = true;
		Integer i;
		// 이 정점에 인접한 모든 점에 대해 재귀적으로 호출
		Iterator<Integer> it = adj[v].iterator();
		while(it.hasNext()) {
			i = it.next();
			// 인접해 있지 않은 경우 인접한 곳으로 이동
			if(!visited[i]) {
				if(isCyclicUtil(i, visited, v)) {
					return true;
				}
				// 인접한 경우 parent와 비교하여 정점에 도달한 경우 사이클이 있다.
			} else if(i != parent) {
				return true;
			}
		}
		return false;
	}
	// 그래프에 사이클이 포함되어 있으면 true 반환
	boolean isCyclic() {
		// 재귀 스택의 일부가 아닌 모든 점에 표시
		boolean visited[] = new boolean[V];
		// 순환 기능을 이용하여 다양한 DFS 트리에서 사이클 감지
		for(int i=0; i<V; i++) {
			visited[i] = false;
		}
		for(int u=0; u<V; u++) {
			if(!visited[u]) {	// 이미 방문한 경우 되돌아 오지 않음
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
