package Sort;
//���� ���� �˰��� ����
public class select {
	int [] selectionsort(int [] data) {
		int min; //�ּҰ��� ���� �������� �ε��� ����
		int temp = 0;
		for(int i=0; i<data.length-1; i++) { // data.length-1 : ������ ��Ҵ� �ڿ������� ���ĵ�
			min = i;
			for(int j=i+1; j<data.length; j++) {
				if(data[min] > data[j]) {
					min = j;
				}
			}
			temp = data[min];
			data[min] = data[i];
			data[i] = temp;
		}
		return data;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] data = {4, 54, 2, 8, 63, 7, 55, 56};
		select test = new select();
		// ���� ���� �� ���
		System.out.println("# ���� ���� ��");
		for(int i=0; i<data.length; i++) {
			System.out.print(data[i]+" ");
		}
		System.out.println();
		//���� ���� �� ���
		System.out.println("# ���� ���� ��");
		test.selectionsort(data);
		for(int i=0; i<data.length; i++) {
			System.out.print(data[i]+" ");
		}
	}

}

