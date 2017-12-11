package Sort;
//선택 정렬 알고리즘 구현
public class select {
	int [] selectionsort(int [] data) {
		int min; //최소값을 가진 데이터의 인덱스 저장
		int temp = 0;
		for(int i=0; i<data.length-1; i++) { // data.length-1 : 마지막 요소는 자연스럽게 정렬됨
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
		// 선택 정렬 전 출력
		System.out.println("# 선택 정렬 전");
		for(int i=0; i<data.length; i++) {
			System.out.print(data[i]+" ");
		}
		System.out.println();
		//삽입 정렬 후 출력
		System.out.println("# 선택 정렬 후");
		test.selectionsort(data);
		for(int i=0; i<data.length; i++) {
			System.out.print(data[i]+" ");
		}
	}

}

