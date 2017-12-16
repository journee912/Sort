package Sort;

import java.util.Arrays;
// 연결되지 않고 가중치 그래프의 MST트리를 찾아내기 위한 크루스칼 알고리즘
public class KruskalMSTGraph {
	// Edge를 나타내는 클래스
	class Edge implements Comparable<Edge>{
		int src, dest, weight;
		// 가중치를 기준으로 edge를 정렬하는데 사용되는 Comparable
		@Override
		public int compareTo(Edge compareEdge) {
			// TODO Auto-generated method stub
			return this.weight - compareEdge.weight;
		}
		
	};
	// 합집합을 나타내는 하위 집합을 나타내는 클래스
	class subset{
		int parent, rank;
	}
	int V, E;	// V 는 점이 없다, E는 선이 없다.
	Edge edge[];	// edge 배열 선언
	// V, E를 사용해 그래프 생성
	KruskalMSTGraph(int v, int e) {
		// TODO Auto-generated constructor stub
		V = v;
		E = e;
		edge = new Edge[E];
		for(int i=0; i<e; ++i) {
			edge[i] = new Edge();
		}
	}
	// i -> 원소 집합을 찾기위한 함수(경로 압축기법 활용)
	int find(subset subsets[], int i) {
		// 부모를 찾아서 i로 루트로 만듬
		if(subsets[i].parent != i) {
			subsets[i].parent = find(subsets, subsets[i].parent);
		}
		
		return subsets[i].parent;
	}
	// x와 y의 조합을 조합한 기능(계급별로 조합)
	void Union(subset subsets[], int x, int y) {
		int xroot = find(subsets, x);
		int yroot = find(subsets, y);
		// 하위 트리 아래에 있는 작은 등급의 트리 부착
		if(subsets[xroot].rank < subsets[yroot].rank) {
			subsets[xroot].parent = yroot;
		} else if(subsets[xroot].rank > subsets[yroot].rank) {
			subsets[yroot].parent = xroot;
		} else {	// 등급이 동일한 경우 루트 및 증분으로 만든다.
			subsets[yroot].parent = xroot;
			subsets[xroot].rank++;
		}
	}
	// 크루스칼 알고리즘을 이용한 MST를 만드는 메인 함수
	void KruskalMST() {
		Edge result[] = new Edge[V];	// MST 저장 배열
		int e=0;	// 결과에 사용되는 변수
		int i=0;	// edge에 저장되는 index 변수
		for(i=0; i<V; ++i) {
			result[i] = new Edge();
		}
		// 1단계 : 모든 가장자리를 비결합적인 순서로 정렬
		// 주어진 그래프를 변경할 수 없는 경우, edge 복사본 생성
		Arrays.sort(edge);
		// V 하위 집합을 생성하기 위한 메모리 할당
		subset subsets[] = new subset[V];
		// 단일 요소로 V 하위집합 생성
		for(i=0; i<V; ++i) {
			subsets[i] = new subset();
		}
		for(int v=0; v<V; ++v) {
			subsets[v].parent = v;
			subsets[v].rank = 0;
		}
		i = 0; // 다음 edge를 선택하는데 사용되는 index 변수
		// 에지의 수는 V-1
		while(e < V-1) {
			// 2단계 : 가장 작은 edge를 선택
			// 다음 반복에 대한 i변수 증가
			Edge next_edge = new Edge();
			next_edge = edge[i++];
			int x = find(subsets, next_edge.src);
			int y = find(subsets, next_edge.dest);
			// edge가 사이클이 안되는 경우, 결과에 포함된 결과를 포함하고 다음 edge에 대한 결과를 증가시킨다.
			if(x != y) {
				result[e++] = next_edge;
				Union(subsets, x, y);
			}
		}
		System.out.println("Following are the edges in the constructed MST");
		
		for(i=0; i<e; ++i) {
			System.out.println(result[i].src+" -- "+result[i].dest+" == "+result[i].weight);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 다음과 같은 가중치 그래프 생성
		/*      10
            0--------1
            |  \     |
           6|   5\   |15
            |      \ |
            2--------3
                4       */
		int V = 4;	// 그래프에서 점의 수
		int E = 5;	// 그래프에서 선의 수
		KruskalMSTGraph graph = new KruskalMSTGraph(V, E);
		
		// add edge 0-1
		graph.edge[0].src = 0;
		graph.edge[0].dest = 1;
		graph.edge[0].weight = 10;
		
		// add edge 0-2
		graph.edge[1].src = 0;
		graph.edge[1].dest = 2;
		graph.edge[1].weight = 6;
		
		// add edge 0-3
		graph.edge[2].src = 0;
		graph.edge[2].dest = 3;
		graph.edge[2].weight = 5;
		
		// add edge 1-3
		graph.edge[3].src = 1;
		graph.edge[3].dest = 3;
		graph.edge[3].weight = 15;
		
		// add edge 2-3
		graph.edge[4].src = 2;
		graph.edge[4].dest = 3;
		graph.edge[4].weight = 4;
		
		graph.KruskalMST();
	}

}
