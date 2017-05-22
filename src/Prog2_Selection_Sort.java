import java.util.Scanner;

public class Prog2_Selection_Sort {
	int[] array = null;
	
	public Prog2_Selection_Sort() {
		Scanner scan = new Scanner(System.in);
		System.out.println("[정렬할 요소 입력(공백으로 구분)]");
		String input = scan.nextLine();
		String[] temp = input.split(" ");
		array = new int[temp.length];
		
		for (int i = 0 ; i < temp.length ; i++) {
			Integer value = Integer.parseInt(temp[i]);
			array[i] = value;
		}
	}
	
	void swap(int[] array, int first, int second) {
		int temp = array[first];
		array[first] = array[second];
		array[second] = temp;
	}
	
	void sort(int[] array) {
		for (int i = 0 ; i < array.length ; i++) {
			int min = i;
			for (int j = i+1 ; j < array.length ; j++) {
				if (array[j] < array[min])
					min = j;
			}
			if (min != i)
				swap(array, i, min);
		}
	}
	
	public static void main(String[] args) {
		Prog2_Selection_Sort s = new Prog2_Selection_Sort();
		
		System.out.println("[정렬 전]");
		for (int i : s.array)
			System.out.printf("%d ", i);
		System.out.println();
		
		s.sort(s.array);
		System.out.println("[정렬 후]");
		for (int i : s.array)
			System.out.printf("%d ", i);
	}
}
