package Sort;

import java.util.Arrays;

// 기수 정렬 알고리즘 구현
public class radix {
	// 배열에서 최대값을 얻기 위한 메서드
	static int getMax(int[] data) {
		int mx = data[0];
		for(int i=1; i<data.length; i++) {
			if(data[i] > mx) {
				mx = data[i];
			}
		}
		return mx;
	}
	// exp 변수의 수에 따라 숫자를 정렬
	static void countSort(int[] data, int exp) {
		int[] output = new int[data.length];
		int[] count = new int[10];
		Arrays.fill(count, 0);
		
		// count 값 count배열에 저장
		for(int i=0; i<data.length; i++) {
			count[(data[i]/exp)%10]++;
		}
		// count 값이 포함시켜 count배열에 저장
		for(int i=1; i<10; i++) {
			count[i] += count[i-1];
		}
		// output배열 빌드
		for(int i=data.length-1; i>=0; i--) {
			output[count[(data[i]/exp)%10]-1] = data[i];
			count[(data[i]/exp)%10]--;
		}
		// output 배열에 저장된 값을 data 배열에 저장
		for(int i=0; i<data.length; i++) {
			data[i] = output[i];
		}
	}
	static void radixsort(int[] data) {
		// 최대값 찾기
		int m = getMax(data);
		for(int exp=1; m/exp>0; exp*=10) {
			countSort(data, exp);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] data = {4, 54, 2, 8, 63, 7, 55, 56};
		// 기수 정렬 전
		System.out.println("# 기수 정렬 전");
		for(int i=0; i<data.length; i++) {
			System.out.print(data[i]+" ");
		}
		System.out.println();
		
		radixsort(data);
		// 기수 정렬 후
		System.out.println("# 기수 정렬 후");
		for(int i=0; i<data.length; i++) {
			System.out.print(data[i]+" ");
		}
	}

}
