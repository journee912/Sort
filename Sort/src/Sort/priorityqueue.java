package Sort;
// 우선순위 큐 알고리즘 구현
import java.util.PriorityQueue;
import Sort.Element;

public class priorityqueue {
	int [] element (int [] data) {
		PriorityQueue<Element> q = new PriorityQueue<Element>();
		
		for(int i=0; i<data.length; i++) {
			q.add(new Element(data[i]));
		}
		int size = q.size();
		for(int i=0; i<size; i++) {
			data[i] = q.poll().getNum();
		}
		return data;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] data = {4, 54, 2, 8, 63, 7, 55, 56};
		
		// 우선 순위 큐 전
		System.out.println("# 우선순위 큐 전");
		for(int i=0; i<data.length; i++) {
			System.out.print(data[i]+" ");
		}
		System.out.println();
		// 우선 순위 큐 후
		priorityqueue test = new priorityqueue();
		test.element(data);
		
		System.out.println("# 우선순위 큐 후");
		for(int i=0; i<data.length; i++) {
			System.out.print(data[i]+" ");
		}
		
	}

}
