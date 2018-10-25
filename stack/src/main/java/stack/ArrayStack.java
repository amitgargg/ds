package stack;

public class ArrayStack<T> {

	private int top;
	private int capacity;
	private Object[] stack;

	public ArrayStack() {
		this.top = -1;
		this.capacity = 10;
		this.stack = new Object[capacity];
	}

	public void push(T data) {
		if (isStackFull()) {
			System.out.println("Statck is Overflow");
			return;
		}
		this.top = top + 1;
		this.stack[top] = data;
	}

	@SuppressWarnings("unchecked")
	public T pop() {
		if (isStackEmpty()) {
			System.out.println(" Stack is Underflow");
			throw new ArrayIndexOutOfBoundsException();
		}
		T data = (T) this.stack[top];
		this.top = this.top - 1;
		return data;
	}

	public boolean isStackFull() {
		boolean isStackFull = false;
		if (this.top >= (capacity - 1))
			isStackFull = true;
		return isStackFull;
	}

	private boolean isStackEmpty() {
		boolean isStackEmpty = false;
		if (this.top == -1) {
			isStackEmpty = true;
		}
		return isStackEmpty;
	}

	public static void main(String[] args) {

		ArrayStack<Integer> arrayStack = new ArrayStack<Integer>();
		System.out.println("Is Stack Full : " + arrayStack.isStackFull());
		System.out.println("Is Stack Empty : " + arrayStack.isStackEmpty());
		arrayStack.push(100);
		arrayStack.push(200);
		arrayStack.push(300);
		arrayStack.push(400);
		arrayStack.push(500);
		arrayStack.push(600);
		arrayStack.push(700);
		arrayStack.push(800);
		arrayStack.push(900);
		arrayStack.push(1000);
		arrayStack.push(1100);
		System.out.println("Is Stack Full : " + arrayStack.isStackFull());
		System.out.println(arrayStack.pop());
		System.out.println(arrayStack.pop());
		System.out.println(arrayStack.pop());
		System.out.println(arrayStack.pop());
		System.out.println(arrayStack.pop());
		System.out.println(arrayStack.pop());
		System.out.println(arrayStack.pop());
		System.out.println(arrayStack.pop());
		System.out.println(arrayStack.pop());
		System.out.println(arrayStack.pop());
		System.out.println(arrayStack.pop());
		System.out.println(arrayStack.pop());

	}
}
