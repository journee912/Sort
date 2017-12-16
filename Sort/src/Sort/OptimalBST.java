package Sort;
// ������ ���̳ʸ� �˻� Ʈ�� ������ �ͳ��� ����

public class OptimalBST {
	// ������ ���̳ʸ� �˻� Ʈ�� ��� ����� ���� ��ȯ �Լ�
	static int optCost(int freq[], int i, int j) {
		// �⺻ case
		if(j<i) {	// ���� ��Ұ� ������
			return 0;
		}
		if(j==i) {	// ���� ��Ұ� 1�� ������
			return freq[i];
		}
		// freq[i], freq[i+1], ... freq[j]�� ���� �����ϱ� ���� fsum ���� ����
		int fsum = sum(freq, i, j);
		// �ּҰ� �ʱ�ȭ
		int min = Integer.MAX_VALUE;
		// �ϳ��� ��� ��Ҹ� �ٺ������� ����ϰ�, BST�� ����� �����ϸ�, �ʿ��� ��� ����� �ּ�ȭ�ϰ� �ʿ��� ��� ������Ʈ �ּ�ȭ
		for(int r=i; r<=j; ++r) {
			int cost = optCost(freq, i, r-1) + optCost(freq, r+1, j);
			if(cost < min) {
				min = cost;
			}
		}
		// �ּҰ� ����
		return min+fsum;
	}
	// ���� �˻� Ʈ���� �ּ� ����� ���, optCost()�� ������ ��� ã��
	static int optimalSearchTree(int keys[], int freq[], int n) {
		// key[] �迭�� ������� ���ĵ� ������ ����.
		// key[]�� ���ĵǾ����� ������ Ű�� �����ϰ� �����ϱ� ���� �ڵ� �߰�
		return optCost(freq, 0, n-1);
	}
	// �迭 ����� �� ���ϴ� ���
	static int sum(int freq[], int i, int j) {
		int s = 0;
		for(int k=i; k<=j; k++) {
			s += freq[k];
		}
		return s;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ���� ��
		int keys[] = {10, 12, 20};
		int freq[] = {34, 8, 50};
		int n = keys.length;
		System.out.println("Cost of Optimal BST is "+optimalSearchTree(keys, freq, n));
	}

}




