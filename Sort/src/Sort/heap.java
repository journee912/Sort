package Sort;
// �� ���� �˰��� ����
public class heap {
	int [] heapsort(int[] data) {
		int len = data.length;
		for(int i=len/2; i>0; i--) {
			downHeap(data, i, len);
		}
		do {
			int temp = data[0];
			data[0] = data[len-1];
			data[len-1] = temp;
			len = len-1;
			downHeap(data, 1, len); // len -> ������ ��ġ�� ��Ÿ��
		} while(len > 1);
		
		return data;
	}
	
	private void downHeap(int[] data, int i, int len) {
		int j;
		int temp = data[i-1];
		while(i <= len/2) { // �ڽ��� ���翩�θ� Ȯ��
			j = 2*i; // j -> ������ �ڽ�
			if((j<len) && (data[j-1] < data[j])) { // ���� �ڽİ� ������ �ڽ��� ���� �� ū ���� ������ �ڽĵ�
				j++;
			}
			if(temp >= data[j-1]) { // temp�� ���Ѵ�. temp�� ũ�� ������ ��ġ �̹Ƿ� ���ǹ� ��
				break;
			}
			data[i-1] = data[j-1];
			i = j;
		}
		data[i-1] = temp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] data = {4, 54, 2, 8, 63, 7, 55, 56};
		// �� ���� ��
		System.out.println("# �� ���� ��");
		for(int i=0; i<data.length; i++) {
			System.out.print(data[i]+" ");
		}
		System.out.println();
		// �� ���� ��
		heap test = new heap();
		test.heapsort(data);
		System.out.println("# �� ���� ��");
		for(int i=0; i<data.length; i++) {
			System.out.print(data[i]+" ");
		}
	}

}
