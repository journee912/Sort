package Sort;
//���� ���� �˰��� ����
public class bubble {
	int[] bubblesort(int data[]) {
		int temp = 0;
		for(int i=0; i<data.length; i++) {
			for(int j=0; j<data.length-1; j++) {
				if(data[j]>data[j+1]) {
					temp = data[j];
					data[j] = data[j+1];
					data[j+1] = temp;
				}
			}
		}
		return data;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		bubble test = new bubble();
		int [] data = {4, 54, 2, 8, 63, 7, 55, 56};
		// �������� �� ���
		System.out.println("# ���� ���� ��");
		for(int i=0; i<data.length; i++) {
			System.out.print(data[i]+" ");
		}
		System.out.println();
		// ���� ���� �� ���
		test.bubblesort(data);
		System.out.println("# ���� ���� ��");
		for(int i=0; i<data.length; i++) {
			System.out.print(data[i]+" ");
		}
	}

}