package dataStructures;

import java.awt.HeadlessException;

public class pqueue {

	public int info;
	public pqueue next;
	
	
	public pqueue(int i){
		this(i,null);
	}

	public pqueue(int i, pqueue n) {
		this.info=i;
		this.next=n;
	}
}

class pqueueNode{
	
	public pqueue front ,rear;
	
	public void addNode(int el){
		pqueue pq=new pqueue(el);
		pqueue temp,pred;
	
			
		
			//no elements
			if (isEmpty()) {
				front=rear=pq;
			}
			
		else{
			
			for (pred=front, temp=front.next; pred.info <el;pred=pred.next,temp=temp.next) {
				
			}
			//at the end
			if (temp==rear) {
				rear=pq;
				
			}else{
				pred.next=pq;
				pq.next=temp;
			}
			
		}
			for (pqueue row=front; front !=rear ; front=front.next) {
				System.out.println(row.info);
			}
	}
	
	public void deleteNode(int i){
		//only one node
		if (front==rear && front.info ==i) {
			front=rear=null;
			
		}
		//found at head
		else if(front.info==i){
			front=front.next;
		}
		else{
			
			pqueue pred,temp;
			pred=front; temp=front.next;
			for (;temp !=null && temp.info !=i;pred=pred.next,temp=temp.next) {
				
			}
					
			if (temp != null) {
				pred.next=temp.next;
			}	
			
			
		}
		
		
	}
	
	public boolean isEmpty(){
		return (front==null);
	}
	
	public void sort(){
		
		if (!isEmpty()) {
			
		}
		
	}
	public static void main(String[] args) {
		pqueueNode que=new pqueueNode();
		que.addNode(10);
		que.addNode(20);
		que.addNode(12);
		que.addNode(8);
		
		
	}
}
