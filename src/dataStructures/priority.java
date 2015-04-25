package dataStructures;

public class priority {

	int front,rear,numel,queue[],max;
	
	public priority(int maximum){
		max=maximum;
		queue=new int[max];
		rear=-1;
		front=0;
		numel=0;
	}
	
	
	public int insert(int num){
		
		if (isEmpty()) {
			queue[++rear]=num;
			numel++;
			
		} 
		else if(isFull()) {
			System.out.println("The Queue is full");

		}
		else{

				int i;
				for ( i = rear; i !=-1  && queue[i] > num  ; i--) {
					
					int temp=queue[i];
					queue[i+1]=temp;
					
				}
				queue[i+1]=num;
				rear++;
				numel++;
				return i+1;
			
		}
		
		return -1;
	}
	
	public void print(){
		for (int i = 0; i < queue.length; i++) {
			System.out.print(queue[i] +" , ");
			
		}
		
		System.out.println(".................");
	}
	
	public boolean isEmpty(){
		return (numel==0);
	}
	
	public boolean isFull(){
		return (numel==max);
	}
	
	public static void main(String[] args) {
		priority pp=new priority(5);
		pp.insert(5);
		pp.print();
		pp.insert(9);
		pp.print();
		pp.insert(1);
		pp.print();
		pp.insert(2);
		pp.print();
	}
}
