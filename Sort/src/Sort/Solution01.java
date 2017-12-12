package Sort;

import java.util.Arrays;
// ��ü�� ���� : ����� ���� ��ü
// Comparable - 1���� �������� ����
public class Solution01 implements Comparable<Solution01> {
	public String name;
	public int quantity;
	
	public Solution01(String name, int quantity) {
		this.name = name;
		this.quantity = quantity;
	}
	
	@Override
	public int compareTo(Solution01 o) {
		// TODO Auto-generated method stub
		return name.compareTo(o.name);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution01 [] fruits = new Solution01[4];
		fruits[0] = new Solution01("Pineapple", 70);
		fruits[1] = new Solution01("Apple", 100);
		fruits[2] = new Solution01("Orange", 80);
		fruits[3] = new Solution01("Banana", 90);
		
		Arrays.sort(fruits);
		
		for(int i=0; i<fruits.length; i++) {
			System.out.println(fruits[i].name +" "+ fruits[i].quantity);
		}
	}

	

}
