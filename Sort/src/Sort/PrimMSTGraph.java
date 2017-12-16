package Sort;
// Prim의 최소 스패닝 트리(MST) 알고리즘 구현
// 인접 행렬을 통한 구현
public class PrimMSTGraph {
	// 그래프의 점의 수
	private static final int V = 5;
	// MST에 아직 포함되지 않은 정점 집합에서 최소 키값으로 꼭지점을 찾는 함수
	int minKey(int key[], boolean mstSet[]) {
		// 최소값 초기화
		int min = Integer.MAX_VALUE;
		int min_index = -1;
		
		for(int v=0; v<V; v++) {
			if(mstSet[v] == false && key[v] < min) {
				min = key[v];
				min_index = v;
			}
		}
		return min_index;
	}
	// 상위에 저장된 내장된 MST를 print
	void printMST(int parent[], int n, int graph[][]) {
		System.out.println("Edge Weight");
		for(int i=1; i<V; i++) {
			System.out.println(parent[i]+" - "+i+"\t"+graph[i][parent[i]]);
		}
	}
	// 인접 행렬을 이용해 그래프를 나타내는 MST를 구성하고 printMST로 리턴
	void primMST(int graph[][]) {
		// 구성된 MST를 저장할 배열 parent
		int parent[] = new int[V];
		// cut 시 최소 가중치 값을 가지는 edge를 선택하는데 사용하는 key 값
		int key[] = new int[V];
		// MST에 아직 포함되지 않은 정점을 나타내기 위한 mstSet 배열
		boolean mstSet[] = new boolean[V];
		// 모든 키를 무한대로 초기화
		for(int i=0; i<V; i++) {
			key[i] = Integer.MAX_VALUE;
			mstSet[i] = false;
		}
		// 항상 MST에 첫번쨰 1차 정점을 포함
		key[0] = 0;	// 이 정점을 첫번째 정점으로 선택하도록 키 값 0으로 선언
		parent[0] = -1;	// 첫번쨰 노드는 항상 MST의 루트를 나타낸다.
		// MST는 V 변수를 가진다
		for(int count=0; count<V-1; count++) {
			// MST에 아직 포함되지 않은 점들에서 최소 키 정점을 선택
			int u = minKey(key, mstSet);
			// MST에 선택된 정점 추가
			mstSet[u] = true;
			// 선택된 정점의 인접한 점들에 대한 키 값과 상위 인덱스를 업데이트
			// 아직 MST에 포함되지 않은 점들만 고려
			for(int v=0; v<V; v++) {
				// graph[u][v]는 인접 정점들에 대해서 0값이 아니다.
				// mstSet[v] = false는 MST에 아직 포함되지 않은 정점들이다.
				// key[v]보다 작은 graph[u][v] 키값만 업데이트 한다.
				if(graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) {
					parent[v] = u;
					key[v] = graph[u][v];
				}
			}
		}
		printMST(parent, V, graph);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 다음과 같은 그래프를 만든다.
		   2    3
        (0)--(1)--(2)
        |    / \   |
        6| 8/   \5 |7
        | /      \ |
        (3)-------(4)
             9        
		 */
		PrimMSTGraph t = new PrimMSTGraph();
		int graph[][] = new int[][] {{0, 2, 0, 6, 0}, 
									 {2, 0, 3, 8, 5}, 
									 {0, 3, 0, 0, 7}, 
									 {6, 8, 0, 0, 9}, 
									 {0, 5, 7, 9, 0}};
		t.primMST(graph);					 
		}
	}


