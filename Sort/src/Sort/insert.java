package Sort;
//삽입 정렬 알고리즘 구현
public class insert {
	int [] insertionsort(int [] data) {
		int temp = 0;
		int j = 0;
		for(int i=1; i<data.length; i++) {
			temp = data[i];
			for(j=i-1; j>=0 && data[j]>temp; j--) {
				data[j+1] = data[j];
			}
			data[j+1] = temp;
		}
		return data;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] data = {4, 54, 2, 8, 63, 7, 55, 56};
		
		// 삽입 정렬 전
		System.out.println("# 삽입 정렬 전");
		for(int i=0; i<data.length; i++) {
			System.out.print(data[i]+" ");
		}
		System.out.println();
		// 삽입 정렬 후
		insert test = new insert();
		test.insertionsort(data);
		System.out.println("# 삽입 정렬 후");
		for(int i=0; i<data.length; i++) {
			System.out.print(data[i]+" ");
		}
	}

}
