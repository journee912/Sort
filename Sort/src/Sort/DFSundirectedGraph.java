package Sort;
// 그래프에서 사이클을 감지하기 위한 Union-find 알고리즘
public class DFSundirectedGraph {
	int V, E;	// V 는 점이 없음, E는 선이 없음을 나타낸다.
	Edge edge[];	// 모든 선들을 edge[] 배열에 저장
	
	class Edge{
		int src, dest;
	};
	// 수직 및 가장자리가 있는 그래프를 생성
	DFSundirectedGraph(int v, int e) {
		V = v;
		E = e;
		edge = new Edge[E];
		for(int i=0; i<e; ++i) {
			edge[i] = new Edge();
		}
	}
	// 요소의 하위집합을 찾는다.
	int find(int parent[], int i) {
		if(parent[i] == -1) {
			return i;
		}
		return find(parent, parent[i]);
	}
	// 두 개의 하위집합을 결합
	void Union(int parent[], int x, int y) {
		int xset = find(parent, x);
		int yset = find(parent, y);
		parent[xset] = yset;
	}
	// 특정 그래프에 사이클이 포함되어 있는지 여부를 확인
	int isCycle(DFSundirectedGraph graph) {
		// 하위집합을 생성하기 위한 메모리 할당
		int parent[] = new int[graph.V];
		// 모든 하위 집합을 단일 요소로 초기화
		for(int i=0; i<graph.V; ++i) {
			parent[i] = -1;
		}
		// 그래프의 모든 가장자리를 반복하고, 두 개의 하위집합이 모두 동일한 경우,
		// 두 개의 하위 집합이 모두 동일한 점을 찾는다.
		for(int i=0; i<graph.E; ++i) {
			int x = graph.find(parent, graph.edge[i].src);
			int y = graph.find(parent, graph.edge[i].dest);
			
			if(x == y) {
				return 1;
			}
			graph.Union(parent, x, y);
		}
		return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 다음 그래프를 만들자
		/*
		 0
        |  \
        |    \
        1-----2
		 */
		int V = 3, E = 3;
		DFSundirectedGraph graph = new DFSundirectedGraph(V, E);
		
		// add edge 0-1
		graph.edge[0].src = 0;
		graph.edge[0].dest = 1;
		
		// add edge 1-2
		graph.edge[1].src = 1;
		graph.edge[1].dest = 2;
		
		// add edge 0-2
		graph.edge[2].src = 0;
		graph.edge[2].dest = 2;
		
		if(graph.isCycle(graph) == 1) {
			System.out.println("graph contains cycle");
		} else {
			System.out.println("graph doesn't contain cycle");
		}
	}

}
