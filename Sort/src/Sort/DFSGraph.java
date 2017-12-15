package Sort;

import java.util.Iterator;
import java.util.LinkedList;
// DFS(Depth-First Seach) 그래프 구현
// 인접성 목록을 사용하여 지시된 그래프를 사용
public class DFSGraph {
	private int V;
	private LinkedList<Integer> adj[];
	
	DFSGraph(int v){
		V = v;
		// 인접 목록
		adj = new LinkedList[v];
		for(int i=0; i<v; ++i) {
			adj[i] = new LinkedList();
		}
	}
	// 그래프에 가장자리를 추가하는 기능
	void addEdge(int v, int w) {
		// v에 w 추가
		adj[v].add(w);
	}
	// DFS에서 사용하는 기능
	void DFSUtil(int v, boolean visited[]) {
		// 현재 노드를 방문한 상태로 표시
		visited[v] = true;
		System.out.print(v+" ");
		// 이 정점에 인접한 v에 대해서 재귀적으로 호출
		Iterator<Integer> i = adj[v].listIterator();
		while(i.hasNext()) {
			int n = i.next();
			if(!visited[n]) {
				DFSUtil(n, visited);
			}
		}
	}
	// DFS 통과를 수행하는 기능, DFSUtil()을 통해 재귀적 호출
	void DFS(int v) {
		// 방문하지 않은 모든 v표시 , 기본적으로 false로 설정
		boolean visited[] = new boolean[V];
		// DFS를 통과하고 출려갛기 위해 순환 호출
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
