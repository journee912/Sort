package Sort;
// Comparable
public class Element implements Comparable<Element>{
	private int num; // 정렬의 기준이 될 값
	
	public Element(int num) {
		this.num = num;
	}
	public int getNum() {
		return num;
	}
	
	@Override // Comparable 인터페이스의 compareTo 메소드 구현
	public int compareTo(Element o) {	// 오름차순
		// TODO Auto-generated method stub
		return num-o.num;
	}
	
}
