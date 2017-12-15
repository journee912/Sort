package Sort;

import java.util.LinkedList;
// 인접리스트를 통한 그래프 구현
public class GFG {
	// Graph 클래스 정의
	// 인접리스트를 통한 그래프 목록
	// V는 배열의 크기
	static class Graph{	
		int V;
		LinkedList<Integer> adjListArray[];

		Graph(int V){
			this.V = V;
			// 배열 크기 정의
			// verticle 수
			adjListArray = new LinkedList[V];
			// 각 정점에 대해 list 생성
			// adjListArray[i]에 인접 노드 저장
			for(int i=0; i<V; i++) {
				adjListArray[i] = new LinkedList<>();
			}
		}
	}
	// 정확하지 않은 그래프에 addEdge 추가
	static void addEdge(Graph graph, int src, int dest) {
		// src에서 dest로 추가
		graph.adjListArray[src].addFirst(dest);
		// 그래프가 정확하지 않으므로 dest에서 src까지 추가
		graph.adjListArray[dest].addFirst(src);
	}
	// 그래프 인접성 목록 출력
	static void printGraph(Graph graph) {
		for(int v=0; v<graph.V; v++) {
			System.out.println("Adjacency list of vertex "+v);
			System.out.print("head");
			for(Integer pCrawl: graph.adjListArray[v]) {
				System.out.print(" -> "+pCrawl);
			}
			System.out.println();
		}
	}
	// main 함수에 테스트
	public static void main(String[] args) {
		// V값으로 그래프 생성
		int V=5;
		Graph graph = new Graph(V);
		addEdge(graph, 0, 1);
		addEdge(graph, 0, 4);
		addEdge(graph, 1, 2);
		addEdge(graph, 1, 3);
		addEdge(graph, 1, 4);
		addEdge(graph, 2, 3);
		addEdge(graph, 3, 4);
		// 인접성 목록 출력
		printGraph(graph);
	}
}
