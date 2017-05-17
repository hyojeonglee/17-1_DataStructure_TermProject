class LinkedList {
	Node first;
	Node trace;
	int size;
	
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
			System.out.println("Error");
		}
		
		Node node = first.next;
		for(int i = 0 ; i < index ; i++) {
			node = node.next;
		}
		return node;
	}
	
	void addFirst(Integer val) {
		Node node = new Node(val);
		node.next = first.next;
		first.next = node;
		size++;
	}
	
	void add(int index, Integer val) {
		if (index == 0) {
			addFirst(val);
			return;
		}
		Node post = getNode(index - 1);
		Node next = post.next;
		
		Node node = new Node(val);
		post.next = node;
		node.next = next;
		size++;
	}
	
	public void addLast(Integer val) {
		add(size, val);
	}
	
	public void add(Integer val) {
		addLast(val);
	}
	
	void delete() {
		
	}
	
	void print_list() {
		
	}
}

public class Prog3_Selection_List {
	static Integer[] input = {75, 43, 99, 12, 11, 8, 42, 24, 96, 7, 15, 3, 26, 49, 48};

	public Prog3_Selection_List() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList list = new LinkedList();
	}
}
