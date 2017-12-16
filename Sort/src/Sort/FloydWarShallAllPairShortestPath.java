package Sort;

import java.awt.FlowLayout;
// Folyd Warshall All Pairs Shortest ��� �˰��� ����
public class FloydWarShallAllPairShortestPath {
	final static int INF = 99999;
	final static int V = 4;
	
	void floydWarshall(int graph[][]) {
		int dist[][] = new int[V][V];
		int i, j, k;
		/* �Է� �׷��� ��Ʈ������ ������ �ַ�� ��Ʈ������ �ʱ�ȭ
		 * �Ǵ� �ִ� �Ÿ��� �ʱ� ���� �߰� ������ ������� ���� �ִ� ��ο� �����Ѵٰ� ���Ѵ�.
		 */
		for(i=0; i<V; i++) {
			for(j=0; j<V; j++) {
				dist[i][j] = graph[i][j];
			}
		}
		/* ��� �������� �ϳ��� �߰� ������ �߰��Ѵ�.
		 * --> �ݺ��� �����ϱ� �� ���� ª�� �Ÿ��� {0,1,2, ... , k-1} ������ ����ϵ��� ��� ������ �� ������ �Ÿ��� ���� ª��.
		 * --> �ݺ��� ������ ���� ��ȣ k�� ���� ���տ� �߰��ǰ� {0,1,2,...k}�� ��.
		 */
		for(k=0; i<V; i++) {
			// ��� �������� �ҽ��� �ϳ��� ����
			for(i=0; i<V; i++) {
				// ������ �ҽ��� ������� ��� �������� ����
				for(j=0; j<V; j++) {
					// ���� k���� j���� �ִ� ����� �ִ� ��� dist[i][j] ���� ������Ʈ�Ѵ�.
					if(dist[i][k] + dist[k][j] < dist[i][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}
		// ���
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
		// ������ ���� ���� �׷��� ����
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
