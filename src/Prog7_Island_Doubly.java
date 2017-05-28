class DoublyCircularLinkedList {
	Node first;
	Node last;
	int size;
	
	public DoublyCircularLinkedList() {
		first = new Node(null);
		last = new Node(null);
		size = 0;
	}
	
	class Node {
		String value;
		int number;
		int index;
		Node next;
		Node post;
		
		public Node(String value) {
			this.value = value;
			this.number = size + 1;
			this.index = 0;
			this.next = null;
			this.post = null;
		}
	}
	
	void setLast() {
		Node currentLast = getNode(size-1);
		currentLast.next = first.next;
		first.post = currentLast;
		last = currentLast;
	}
	
	void updateIndex() {
		int i = 0;
		if (last != null) {
			Node temp = last;
			temp = temp.next;
			temp.index = i++;
			do {
				temp = temp.next;
				temp.index = i++;
			} while(temp != last);
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
	
	void insertFront(String val) {
		Node node = new Node(val);
		node.next = first.next;
		first.next = node;
		size++;
		setLast();
		updateIndex();
	}
	
	void insertMiddle(int index, String val) {
		if (index == 0) {
			insertFront(val);
			return;
		}
		Node postNode = getNode(index - 1);
		Node nextNode = postNode.next;
		
		Node node = new Node(val);
		postNode.next = node;
		node.post = postNode;
		node.next = nextNode;
		nextNode.post = node;
		size++;
		setLast();
		updateIndex();
	}
	
	void insertRear(String val) {
		insertMiddle(size, val);
	}
	
	String deleteFront() {
		Node frontNode = getNode(0);
		first.next = frontNode.next;
		size--;
		setLast();
		updateIndex();
		return frontNode.value;
	}
	
	String deleteMiddle(int index) {
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
		nextNode.post = post;
		size--;
		setLast();
		updateIndex();
		return deleteNode.value;
	}
	
	String deleteRear() {
		return deleteMiddle(size - 1);
	}
	
	int size() {
		return size;
	}
	
	void print_list() {
		if (last != null) {
			Node temp = last;
			temp = temp.next;
			System.out.printf("%d - %s\n", temp.number, temp.value);
			do {
				temp = temp.next;
				System.out.printf("%d - %s\n", temp.number, temp.value);
			} while(temp != last);
		}
	}
	
	Node turnRight(Node temp) {
		System.out.println("[����]");
		for (int i = 0 ; i < 5 ; i++)
			temp = temp.next;
		System.out.println("[�˸�]"+temp.number+"���� "+temp.value+"���� �����ڿ��� ���ܵǾ����ϴ�.");
		deleteMiddle(temp.index);
		return temp.next;
	}
	
	Node turnLeft(Node temp) {
		System.out.println("[����]");
		for (int i = 0 ; i < 8 ; i++)
			temp = temp.post;
		System.out.println("[�˸�]"+temp.number+"���� "+temp.value+"���� �����ڿ��� ���ܵǾ����ϴ�.");
		deleteMiddle(temp.index);
		return temp.post;
	}
	
	void printResult(int count) {
		if (size == 7) {
			System.out.println("[���� 7�� ����Ʈ]");
			print_list();
			return;
		}
		System.out.printf("[%d�� ° ������ ����Ʈ]\n", count++);
		print_list();
		System.out.println();
	}
	
	void selectPerson() {
		int random = (int) (Math.random() * 30) + 1;
		Node temp = getNode(random - 1);
		System.out.println("[����̱� ���]");
		System.out.println(temp.number+"���� "+temp.value+"���� ���õǾ����ϴ�.");
		System.out.println();
		int count = 1;
		while (size > 7) {
			temp = turnRight(temp);
			printResult(count++);
			temp = turnLeft(temp);
			printResult(count++);
		}
	}
}

public class Prog7_Island_Doubly {
	static String[] inputArray = {"Hyojeong", "Jiwan", "Yeongeun",
			"Jongsuk", "Jeonghun", "Heewon",
			"Youngho", "Minji", "Hojun",
			"Sumin", "Yoonsang", "Yerin",
			"Jina", "Gayoung", "Jeongyoung",
			"Junho", "Youngwoo", "Yoonhee",
			"Bonghee", "Sanggu", "Bruno",
			"Samkim", "Eddykim", "Dongguen",
			"Samuel", "Saeyoung", "Minseon",
			"Suyeon", "Sunghun", "Ayeon",
			"John"};
	
	
	public static void main(String[] args) {
		DoublyCircularLinkedList dclist = new DoublyCircularLinkedList();
		
		for (String s : inputArray) {
			dclist.insertRear(s);
		}
		System.out.println("[������ ����Ʈ ���� �Ϸ�]");
		dclist.print_list();
		
		dclist.selectPerson();
		
	}
}
