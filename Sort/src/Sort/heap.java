package Sort;
// 힙 정렬 알고리즘 구현
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
			downHeap(data, 1, len); // len -> 정렬의 위치를 나타냄
		} while(len > 1);
		
		return data;
	}
	
	private void downHeap(int[] data, int i, int len) {
		int j;
		int temp = data[i-1];
		while(i <= len/2) { // 자식의 존재여부를 확인
			j = 2*i; // j -> 오른쪽 자식
			if((j<len) && (data[j-1] < data[j])) { // 왼쪽 자식과 오른쪽 자식을 비교해 더 큰 값을 가지는 자식들
				j++;
			}
			if(temp >= data[j-1]) { // temp와 비교한다. temp가 크면 적절한 위치 이므로 조건문 끝
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
		// 힙 정렬 전
		System.out.println("# 힙 정렬 전");
		for(int i=0; i<data.length; i++) {
			System.out.print(data[i]+" ");
		}
		System.out.println();
		// 힙 정렬 후
		heap test = new heap();
		test.heapsort(data);
		System.out.println("# 힙 정렬 후");
		for(int i=0; i<data.length; i++) {
			System.out.print(data[i]+" ");
		}
	}

}
