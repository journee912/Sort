package Sort;
// Prim�� �ּ� ���д� Ʈ��(MST) �˰��� ����
// ���� ����� ���� ����
public class PrimMSTGraph {
	// �׷����� ���� ��
	private static final int V = 5;
	// MST�� ���� ���Ե��� ���� ���� ���տ��� �ּ� Ű������ �������� ã�� �Լ�
	int minKey(int key[], boolean mstSet[]) {
		// �ּҰ� �ʱ�ȭ
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
	// ������ ����� ����� MST�� print
	void printMST(int parent[], int n, int graph[][]) {
		System.out.println("Edge Weight");
		for(int i=1; i<V; i++) {
			System.out.println(parent[i]+" - "+i+"\t"+graph[i][parent[i]]);
		}
	}
	// ���� ����� �̿��� �׷����� ��Ÿ���� MST�� �����ϰ� printMST�� ����
	void primMST(int graph[][]) {
		// ������ MST�� ������ �迭 parent
		int parent[] = new int[V];
		// cut �� �ּ� ����ġ ���� ������ edge�� �����ϴµ� ����ϴ� key ��
		int key[] = new int[V];
		// MST�� ���� ���Ե��� ���� ������ ��Ÿ���� ���� mstSet �迭
		boolean mstSet[] = new boolean[V];
		// ��� Ű�� ���Ѵ�� �ʱ�ȭ
		for(int i=0; i<V; i++) {
			key[i] = Integer.MAX_VALUE;
			mstSet[i] = false;
		}
		// �׻� MST�� ù���� 1�� ������ ����
		key[0] = 0;	// �� ������ ù��° �������� �����ϵ��� Ű �� 0���� ����
		parent[0] = -1;	// ù���� ���� �׻� MST�� ��Ʈ�� ��Ÿ����.
		// MST�� V ������ ������
		for(int count=0; count<V-1; count++) {
			// MST�� ���� ���Ե��� ���� ���鿡�� �ּ� Ű ������ ����
			int u = minKey(key, mstSet);
			// MST�� ���õ� ���� �߰�
			mstSet[u] = true;
			// ���õ� ������ ������ ���鿡 ���� Ű ���� ���� �ε����� ������Ʈ
			// ���� MST�� ���Ե��� ���� ���鸸 ���
			for(int v=0; v<V; v++) {
				// graph[u][v]�� ���� �����鿡 ���ؼ� 0���� �ƴϴ�.
				// mstSet[v] = false�� MST�� ���� ���Ե��� ���� �������̴�.
				// key[v]���� ���� graph[u][v] Ű���� ������Ʈ �Ѵ�.
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
		 * ������ ���� �׷����� �����.
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


