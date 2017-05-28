import java.util.Scanner;

public class Prog4_BinarySearch {
	int[] array = {3, 7, 8, 11, 12, 15, 24, 26, 42, 43, 49, 48, 75, 96, 99};
	
	int compare(int x, int y) {
		if (x < y)
			return -1;
		else if (x == y)
			return 0;
		else
			return 1;
	}
	
	int binsearch(int searchnum, int left, int right) {
		int middle;
		if (left <= right) {
			middle = (left + right) / 2;
			switch (compare(array[middle], searchnum)) {
			case 0 :
				return middle;
			case -1 :
				return binsearch(searchnum, middle+1, right);
			case 1:
				return binsearch(searchnum, left, middle-1);
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Prog4_BinarySearch bs = new Prog4_BinarySearch();
		
		System.out.printf("찾을 숫자를 입력하세요 : ");
		int key = scan.nextInt();
		int result = bs.binsearch(key, 0, bs.array.length-1);
		if (result == -1) {
			System.out.println("해당하는 값이 없습니다.");
		}
		else {
			System.out.printf("값을 찾았습니다. 인덱스 : %d", result);
		}
	}
}
