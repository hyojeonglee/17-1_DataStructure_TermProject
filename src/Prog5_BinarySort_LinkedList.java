import java.util.Scanner;

class LinkedListBin {
	Node first;
	int size;
	
	public LinkedListBin() {
		first = new Node(null);
		size = 0;
	}
	
	class Node {
		Integer value;
		Node next;
		
		public Node(Integer value) {
			this.value = value;
			this.next = null;
		}
	}
	
	Node getNode(int index) {
		if (index < 0 || index >= size) {
			System.out.println("Error : getNode");
			return null;
		}
		
		Node node = first.next;
		for(int i = 0 ; i < index ; i++) {
			node = node.next;
		}
		return node;
	}
	
	void insertFront(Integer val) {
		Node node = new Node(val);
		node.next = first.next;
		first.next = node;
		size++;
	}
	
	void insertMiddle(int index, Integer val) {
		if (index == 0) {
			insertFront(val);
			return;
		}
		Node post = getNode(index - 1);
		Node next = post.next;
		
		Node node = new Node(val);
		post.next = node;
		node.next = next;
		size++;
	}
	
	void insertRear(Integer val) {
		insertMiddle(size, val);
	}
	
	int size() {
		return size;
	}
	
	void print_list() {
		Node node = first.next;
		
		if (node != null) {
			System.out.printf("( %d", node.value);
			node = node.next;
			while(node != null) {
				System.out.printf(", %d", node.value);
				node = node.next;
			}
		}
		System.out.println(" )");
	}
	
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
			switch (compare(getNode(middle).value, searchnum)) {
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
}

public class Prog5_BinarySort_LinkedList {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("[리스트 요소 입력]");
		String input = scan.nextLine();
		String[] temp = input.split(" ");
		
		LinkedListBin listb = new LinkedListBin();
		for (String s : temp) {
			Integer value = Integer.parseInt(s);
			listb.insertRear(value);
		}
		System.out.println("[리스트 생성 완료]");
		listb.print_list();
		
		System.out.println(">>> 찾을 요소 입력");
		int searchnum = scan.nextInt();
		int result = listb.binsearch(searchnum, 0, listb.size()-1);
		if (result == -1) {
			System.out.println("해당하는 요소가 없습니다.");
		}
		else {
			System.out.printf("요소를 찾았습니다. 노드 위치 : %d", result);
		}
	}
}
