package dataStructures;

public class stack {
	private int maxsize;
	private double[] stackArray;
	private int top;

	public stack(int i) {
		maxsize = i;
		stackArray = new double[maxsize];
		top = -1;

	}

	public void push(double d) {
		stackArray[++top] = d;
		System.out.println(stackArray[top]);

	}

	public double peek() {

		return stackArray[top];

	}

	public double pop() {
		return stackArray[top--];

	}

	public boolean isEmpty() {

		if (top == -1) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isFull(){
		if (top == maxsize-1) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public void clear(){
		
		top=-1;
	}
	
	public static void main(String[] args) {
		stack st=new stack(5);
		System.out.println(st.isEmpty());
		System.out.println(st.isFull());
		double d=20.5;
		for (int i = 0; i < 7; i++,d++) {
			if (!st.isFull()) {
				
				st.push(d);
								
				System.out.println(st.isEmpty());
				System.out.println(st.isFull());
				
				System.out.println(st.peek());
			}
			
		}
		
		System.out.println(st.pop());
		System.out.println(st.peek());
		
	}

}
