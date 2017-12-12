package Sort;
// �켱���� ť �˰��� ����
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
		
		// �켱 ���� ť ��
		System.out.println("# �켱���� ť ��");
		for(int i=0; i<data.length; i++) {
			System.out.print(data[i]+" ");
		}
		System.out.println();
		// �켱 ���� ť ��
		priorityqueue test = new priorityqueue();
		test.element(data);
		
		System.out.println("# �켱���� ť ��");
		for(int i=0; i<data.length; i++) {
			System.out.print(data[i]+" ");
		}
		
	}

}
