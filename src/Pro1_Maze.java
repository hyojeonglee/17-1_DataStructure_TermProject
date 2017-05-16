class StackObject {
	public short r;
	public short c;
}

public class Pro1_Maze {
	final static int MAX_STACK_SIZE = 100;
	static StackObject[] stack;
	static int top;
	static StackObject here;
	static StackObject entry;
	static char[][] maze = {
			{'1', '1', '1', '1', '1', '1'},
			{'e', '0', '1', '0', '0', '1'},
			{'1', '0', '0', '0', '1', '1'},
			{'1', '0', '1', '0', '1', '1'},
			{'1', '0', '1', '0', '0', 'x'},
			{'1', '1', '1', '1', '1', '1'}
	};
	
	public Pro1_Maze() {
		stack = new StackObject[MAX_STACK_SIZE];
		here = new StackObject();
		entry = new StackObject();
		
		top = -1;
		here.r = 1;
		here.c = 0;
		entry.r = 1;
		entry.c = 0;
	}

	static void pushLoc(int r, int c) {
		if (r < 0 || c < 0) return;
		if (maze[r][c] != '1' && maze[r][c] != '.') {
			StackObject tmp = new StackObject();
			tmp.r = (short) r;
			tmp.c = (short) c;
			push(tmp);
		}
	}
	
	static void printMaze(char[][] m) { 
		for(char[] i : m) {
			for(char j : i)
				System.out.print(j);
			System.out.println();
		}
	}
	
	static void printStack() {
		for (int i = 5 ; i > top ; i--) {
			System.out.println("|      |");
		}
		for (int i = top ; i >= 0 ; i--) {
			System.out.printf("|(%01d, %01d)|\n", stack[i].r, stack[i].c);
		}
		System.out.println("--------");
	}
	
	static boolean isEmpty() {
		if (top == -1) 
			return true;
		else
			return false;
	}
	
	static boolean isFull() {
		if (top == MAX_STACK_SIZE - 1)
			return true;
		else
			return false;
	}
	
	static void push(StackObject element) {
		if (isFull())
			System.out.println("Overflow");
		else
			stack[++top] = element;
	}
	
	static StackObject pop() {
		if (isEmpty()) {
			System.out.println("Underflow");
			return null;
		}
		else {
			StackObject tmp = stack[top--];
			return tmp;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Pro1_Maze();
		int r, c;
		here = entry;
		printMaze(maze);
		printStack();
		while (maze[here.r][here.c] != 'x') {
			printMaze(maze);
			r = here.r;
			c = here.c;
			maze[r][c] = '.';
			pushLoc(r-1, c);
			pushLoc(r+1, c);
			pushLoc(r, c-1);
			pushLoc(r, c+1);
			printStack();
			if (isEmpty()) {
				System.out.println("실패!");
				return;
			}
			else
				here = pop();
			printMaze(maze);
			printStack();
			// getch();
		}
		System.out.println("성공!");
	}
}
