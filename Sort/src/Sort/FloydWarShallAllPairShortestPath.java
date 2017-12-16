package Sort;

import java.awt.FlowLayout;
// Folyd Warshall All Pairs Shortest 경로 알고리즘 구현
public class FloydWarShallAllPairShortestPath {
	final static int INF = 99999;
	final static int V = 4;
	
	void floydWarshall(int graph[][]) {
		int dist[][] = new int[V][V];
		int i, j, k;
		/* 입력 그래프 매트릭스와 동일한 솔루션 매트릭스를 초기화
		 * 또는 최단 거리의 초기 값은 중간 정점을 고려하지 않은 최단 경로에 기초한다고 말한다.
		 */
		for(i=0; i<V; i++) {
			for(j=0; j<V; j++) {
				dist[i][j] = graph[i][j];
			}
		}
		/* 모든 정점들을 하나씩 중간 정점에 추가한다.
		 * --> 반복을 시작하기 전 가장 짧은 거리가 {0,1,2, ... , k-1} 정점만 고려하도록 모든 정점들 쌍 사이의 거리가 가장 짧다.
		 * --> 반복이 끝나면 정점 번호 k가 정점 집합에 추가되고 {0,1,2,...k}가 됨.
		 */
		for(k=0; i<V; i++) {
			// 모든 정점들을 소스로 하나씩 선택
			for(i=0; i<V; i++) {
				// 선택한 소스의 대상으로 모든 정점들을 선택
				for(j=0; j<V; j++) {
					// 정점 k에서 j까지 최단 경로이 있는 경우 dist[i][j] 값을 업데이트한다.
					if(dist[i][k] + dist[k][j] < dist[i][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}
		// 출력
		printSolution(dist);
	}
	
	void printSolution(int dist[][]) {
		System.out.println("Following matrix shows the shortest distances between every pair of vertices");
		for(int i=0; i<V; ++i) {
			for(int j=0; j<V; ++j) {
				if(dist[i][j] == INF) {
					System.out.print("INF ");
				} else {
					System.out.print(dist[i][j]+"  ");
				}	
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 다음과 같은 가중 그래프 생성
		/*
		 * 	 10
        (0)------->(3)
        |         /|\
        5 |          |
        |          | 1
        \|/         |
        (1)------->(2)
              3          
		 */
		int graph[][] = {{0,	5,	INF, 10},
						 {INF,	0,	3,	INF},
						 {INF, INF, 0,	 1},
						 {INF, INF, INF, 0}};
		
		FloydWarShallAllPairShortestPath f = new FloydWarShallAllPairShortestPath();
		f.floydWarshall(graph);
	}

}
