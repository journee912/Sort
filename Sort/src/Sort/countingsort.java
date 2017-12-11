package Sort;

import java.util.Arrays;
import java.util.Random;

public class countingsort {
	public int[] sort(int[] data, int maxNumber) {
		/*
		 * 1. 들어간 숫자 세기
		 * 2. 배열 동일하게 하나 추가
		 * 3. 배열 수 누적합
		 * 4. 기존 배열의 끝에서부터 누적합 위치 참조해서 넣어주고 누적합 -1 해주기
		 */
		int [] countData = new int[maxNumber];
		for(int i=0; i<data.length; i++) {
			countData[data[i]]++;
		}
		
		for(int i=1; i<countData.length; i++) {
			countData[i] = countData[i-1]+countData[i];
		}
		
		int [] sortedData = new int[data.length];
		for(int i=data.length-1; i>=0; i--) {
			sortedData[countData[data[i]] - 1] = data[i];
			countData[data[i]]--;
		}
		return sortedData;
	}
	
	public static boolean isSorted(int[] data) {
		int count = data.length-1;
		for(int i=0; i<count; i++) {
			if(data[i] > data[i+1]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 15;
		int maxNumber = 100;
		Random random = new Random();
		int[] sortedArray = new int[count];
		for(int i=0; i<count; i++) {
			sortedArray[i] = random.nextInt(maxNumber);
		}
		
		System.out.println("Before : ");
		System.out.println(Arrays.toString(sortedArray));
		System.out.println();
		
		countingsort quickSort = new countingsort();
		sortedArray = quickSort.sort(sortedArray, maxNumber);
		
		System.out.println("After : ");
		System.out.println(Arrays.toString(sortedArray));
		System.out.println();
		
		System.out.println("isSorted : "+isSorted(sortedArray));
		
	}

}
