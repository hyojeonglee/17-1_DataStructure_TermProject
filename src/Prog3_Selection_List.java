class LinkedList {
	Node first;
	static int size;
	
	public LinkedList() {
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
	
	Integer deleteFront() {
		Node frontNode = getNode(0);
		first.next = frontNode.next;
		size--;
		return frontNode.value;
	}
	
	Integer deleteMiddle(int index) {
		if (index < 0 || index >= size) {
			System.out.println("Error : deleteMiddle");
			return null;
		}
		else if (index == 0) {
			return deleteFront();
		}
		
		Node post = getNode(index - 1);
		Node deleteNode = post.next;
		Node nextNode = deleteNode.next;
		post.next = nextNode;
		size--;
		
		return deleteNode.value;
	}
	
	Integer deleteRear() {
		return deleteMiddle(size - 1);
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
	
	void swapNode(int first, int second) {
		if (first < 0 || first >= size || second < 0 || second >= size) {
			System.out.println("Error : swapNode");
			return;
		}
		
		Integer firstValue = deleteMiddle(first);
		Integer secondValue = deleteMiddle(second - 1);
		insertMiddle(first, secondValue);
		insertMiddle(second, firstValue);
	}
	
	void selectionSortList() {
		for (int i = 0 ; i < size ; i++) {
			int min = i;
			for (int j = i+1 ; j < size ; j++) {
				if (getNode(j).value < getNode(min).value)
					min = j;
			}
			if (min != i)
				swapNode(i, min);
		}
	}
}

public class Prog3_Selection_List {
	static Integer[] input = {75, 43, 99, 12, 11, 8, 42, 24, 96, 7, 15, 3, 26, 49, 48};
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
		for (Integer i : input) {
			list.insertRear(i);
		}
		System.out.println("[����Ʈ ���� �Ϸ�]");
		list.print_list();
		
		System.out.println("[����Ʈ ���� �Ϸ�]");
		list.selectionSortList();
		list.print_list();
	}
}
