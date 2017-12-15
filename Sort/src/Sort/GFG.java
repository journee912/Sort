package Sort;

import java.util.LinkedList;
// ��������Ʈ�� ���� �׷��� ����
public class GFG {
	// Graph Ŭ���� ����
	// ��������Ʈ�� ���� �׷��� ���
	// V�� �迭�� ũ��
	static class Graph{	
		int V;
		LinkedList<Integer> adjListArray[];

		Graph(int V){
			this.V = V;
			// �迭 ũ�� ����
			// verticle ��
			adjListArray = new LinkedList[V];
			// �� ������ ���� list ����
			// adjListArray[i]�� ���� ��� ����
			for(int i=0; i<V; i++) {
				adjListArray[i] = new LinkedList<>();
			}
		}
	}
	// ��Ȯ���� ���� �׷����� addEdge �߰�
	static void addEdge(Graph graph, int src, int dest) {
		// src���� dest�� �߰�
		graph.adjListArray[src].addFirst(dest);
		// �׷����� ��Ȯ���� �����Ƿ� dest���� src���� �߰�
		graph.adjListArray[dest].addFirst(src);
	}
	// �׷��� ������ ��� ���
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
	// main �Լ��� �׽�Ʈ
	public static void main(String[] args) {
		// V������ �׷��� ����
		int V=5;
		Graph graph = new Graph(V);
		addEdge(graph, 0, 1);
		addEdge(graph, 0, 4);
		addEdge(graph, 1, 2);
		addEdge(graph, 1, 3);
		addEdge(graph, 1, 4);
		addEdge(graph, 2, 3);
		addEdge(graph, 3, 4);
		// ������ ��� ���
		printGraph(graph);
	}
}
