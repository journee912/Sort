package Sort;

import java.util.Arrays;
// ������� �ʰ� ����ġ �׷����� MSTƮ���� ã�Ƴ��� ���� ũ�罺Į �˰���
public class KruskalMSTGraph {
	// Edge�� ��Ÿ���� Ŭ����
	class Edge implements Comparable<Edge>{
		int src, dest, weight;
		// ����ġ�� �������� edge�� �����ϴµ� ���Ǵ� Comparable
		@Override
		public int compareTo(Edge compareEdge) {
			// TODO Auto-generated method stub
			return this.weight - compareEdge.weight;
		}
		
	};
	// �������� ��Ÿ���� ���� ������ ��Ÿ���� Ŭ����
	class subset{
		int parent, rank;
	}
	int V, E;	// V �� ���� ����, E�� ���� ����.
	Edge edge[];	// edge �迭 ����
	// V, E�� ����� �׷��� ����
	KruskalMSTGraph(int v, int e) {
		// TODO Auto-generated constructor stub
		V = v;
		E = e;
		edge = new Edge[E];
		for(int i=0; i<e; ++i) {
			edge[i] = new Edge();
		}
	}
	// i -> ���� ������ ã������ �Լ�(��� ������ Ȱ��)
	int find(subset subsets[], int i) {
		// �θ� ã�Ƽ� i�� ��Ʈ�� ����
		if(subsets[i].parent != i) {
			subsets[i].parent = find(subsets, subsets[i].parent);
		}
		
		return subsets[i].parent;
	}
	// x�� y�� ������ ������ ���(��޺��� ����)
	void Union(subset subsets[], int x, int y) {
		int xroot = find(subsets, x);
		int yroot = find(subsets, y);
		// ���� Ʈ�� �Ʒ��� �ִ� ���� ����� Ʈ�� ����
		if(subsets[xroot].rank < subsets[yroot].rank) {
			subsets[xroot].parent = yroot;
		} else if(subsets[xroot].rank > subsets[yroot].rank) {
			subsets[yroot].parent = xroot;
		} else {	// ����� ������ ��� ��Ʈ �� �������� �����.
			subsets[yroot].parent = xroot;
			subsets[xroot].rank++;
		}
	}
	// ũ�罺Į �˰����� �̿��� MST�� ����� ���� �Լ�
	void KruskalMST() {
		Edge result[] = new Edge[V];	// MST ���� �迭
		int e=0;	// ����� ���Ǵ� ����
		int i=0;	// edge�� ����Ǵ� index ����
		for(i=0; i<V; ++i) {
			result[i] = new Edge();
		}
		// 1�ܰ� : ��� �����ڸ��� ��������� ������ ����
		// �־��� �׷����� ������ �� ���� ���, edge ���纻 ����
		Arrays.sort(edge);
		// V ���� ������ �����ϱ� ���� �޸� �Ҵ�
		subset subsets[] = new subset[V];
		// ���� ��ҷ� V �������� ����
		for(i=0; i<V; ++i) {
			subsets[i] = new subset();
		}
		for(int v=0; v<V; ++v) {
			subsets[v].parent = v;
			subsets[v].rank = 0;
		}
		i = 0; // ���� edge�� �����ϴµ� ���Ǵ� index ����
		// ������ ���� V-1
		while(e < V-1) {
			// 2�ܰ� : ���� ���� edge�� ����
			// ���� �ݺ��� ���� i���� ����
			Edge next_edge = new Edge();
			next_edge = edge[i++];
			int x = find(subsets, next_edge.src);
			int y = find(subsets, next_edge.dest);
			// edge�� ����Ŭ�� �ȵǴ� ���, ����� ���Ե� ����� �����ϰ� ���� edge�� ���� ����� ������Ų��.
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
		// ������ ���� ����ġ �׷��� ����
		/*      10
            0--------1
            |  \     |
           6|   5\   |15
            |      \ |
            2--------3
                4       */
		int V = 4;	// �׷������� ���� ��
		int E = 5;	// �׷������� ���� ��
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
