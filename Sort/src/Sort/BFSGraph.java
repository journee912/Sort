package Sort;

import java.util.Iterator;
import java.util.LinkedList;

// BFS(Breadth-First Search), 너비우선순회 구현
// BFS가 닿을수 있는 수직방향으로 이동
// Graph 클래스는 인접성 목록을 표현하여 그래프를 나타낸다.
class BFSGraph {
	private int V;	// V는 배열의 크기를 위해 선언
	private LinkedList<Integer> adj[];	// 인접 리스트 배열 선언
	
	BFSGraph(int v){
		V = v;
		adj = new LinkedList[v];	
		for(int i=0; i<v; ++i) {
			adj[i] = new LinkedList();
		}
	}
	// 그래프에서  가장 자리를 추가하는 기능
	void addEdge(int v, int w) {
		adj[v].add(w);
	}
	// BFS 출력하기 위해 
	void BFS(int s) {
		// 방문하지 않은 모든 Verticle 표시, 기본값 false 설정
		boolean visited[] = new boolean[V];
		// BFS를 사용하기 위한 queue 생성
		LinkedList<Integer> queue = new LinkedList<Integer>();
		// 현재 노드를 방문한 상태로 표시하고 큐에 추가
		visited[s] = true;
		queue.add(s);
		
		while(queue.size() != 0) {
			// 큐에 정점을 대기열에 넣고 출력
			s = queue.poll();
			System.out.print(s+" ");
			// 모든 인접점 구하기
			// 방문하지 않은 경우 표시
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
