package Sort;
// Comparable
public class Element implements Comparable<Element>{
	private int num; // ������ ������ �� ��
	
	public Element(int num) {
		this.num = num;
	}
	public int getNum() {
		return num;
	}
	
	@Override // Comparable �������̽��� compareTo �޼ҵ� ����
	public int compareTo(Element o) {	// ��������
		// TODO Auto-generated method stub
		return num-o.num;
	}
	
}
