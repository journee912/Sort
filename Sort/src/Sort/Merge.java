package Sort;
//합병 정렬 알고리즘 구현
public class Merge {
	public static int[] temp = new int[30];
	void mergesort(int left, int right, int[] data) {
		int mid;
		if(left < right) {
			mid = (left+right)/2;
			mergesort(left, mid, data);
			mergesort(mid+1, right, data);
			merge(left, mid, right, data);
		}
	}
	
	void merge(int left, int mid, int right, int[] data) {
		int l = left;
		int m = mid+1;
		int k = left;
		
		while(l<=mid || m<=right) {
			if(l<=mid && m<=right) {
			if(data[l] <= data[m]) {
				temp[k++] = data[l++];
			} else {
				temp[k++] = data[m++];
			}
			} else if(l<=mid && m>right) {
				temp[k++] = data[l++];
			} else {
				temp[k++] = data[m++];
			}
		}
		
		for(int i=left; i<=right; i++) {
			data[i] = temp[i];
		}
		
		for(int i=0; i<data.length; i++) {
			System.out.print(data[i]+" ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] data = {4, 54, 2, 8, 63, 7, 55, 56};
		// 합병 정렬 전
		System.out.println("# 합병 정렬 전");
		for(int i=0; i<data.length; i++) {
			System.out.print(data[i]+" ");
		}
		System.out.println();
		// 합병 정렬 후
		System.out.println("# 합병 정렬 후");
		Merge test = new Merge();
		int left = 0;
		int right = data.length-1;
		test.mergesort(left, right, data);
	}

}
