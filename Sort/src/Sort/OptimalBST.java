package Sort;
// 최적의 바이너리 검색 트리 문제의 귀납적 구현

public class OptimalBST {
	// 최적의 바이너리 검색 트리 비용 계산을 위한 순환 함수
	static int optCost(int freq[], int i, int j) {
		// 기본 case
		if(j<i) {	// 하위 요소가 없을때
			return 0;
		}
		if(j==i) {	// 하위 요소가 1개 있을때
			return freq[i];
		}
		// freq[i], freq[i+1], ... freq[j]의 합을 저장하기 위한 fsum 변수 선언
		int fsum = sum(freq, i, j);
		// 최소값 초기화
		int min = Integer.MAX_VALUE;
		// 하나는 모든 요소를 근본적으로 고려하고, BST의 비용을 절감하며, 필요한 경우 비용을 최소화하고 필요한 경우 업데이트 최소화
		for(int r=i; r<=j; ++r) {
			int cost = optCost(freq, i, r-1) + optCost(freq, r+1, j);
			if(cost < min) {
				min = cost;
			}
		}
		// 최소값 리턴
		return min+fsum;
	}
	// 이진 검색 트리의 최소 비용을 계산, optCost()는 최적의 비용 찾기
	static int optimalSearchTree(int keys[], int freq[], int n) {
		// key[] 배열은 순서대로 정렬된 것으로 간주.
		// key[]가 정렬되어있지 않으면 키를 정렬하고 정렬하기 위해 코드 추가
		return optCost(freq, 0, n-1);
	}
	// 배열 요소의 합 구하는 기능
	static int sum(int freq[], int i, int j) {
		int s = 0;
		for(int k=i; k<=j; k++) {
			s += freq[k];
		}
		return s;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 예제 값
		int keys[] = {10, 12, 20};
		int freq[] = {34, 8, 50};
		int n = keys.length;
		System.out.println("Cost of Optimal BST is "+optimalSearchTree(keys, freq, n));
	}

}




