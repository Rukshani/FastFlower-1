package dataStructures;

public class linkedlist {

	public int info;
	public linkedlist next;
	public linkedlist(int i){
		this(i,null);
	}

	public linkedlist(int i,linkedlist n){
		info=i;
		next=n;
	}
}
class intsllist{
	 
	 protected linkedlist head, tail;
	 public intsllist(){
		 head=tail=null;
	 }
	 
	 public boolean isEmpty(){
		 return head==null;
	 }
	 // Insert to head
	 public void addTohead(int el){
		 head=new linkedlist(el,head);
		 if (tail==null) {
			 tail=head;
			
		}
	 }
	 
	 public void addToTail(int el){
		 if (!isEmpty()) {
			 tail.next=new linkedlist(el);
			 tail=tail.next;
		}else{
			tail=head=new linkedlist(el);
		}
		 
	 }
	 public int deleteFromHead(){
		 int temp=head.info;
		 if (head==tail) {
			head=tail=null;
		}else
		 head=head.next;
		 
		 return temp;
	 }
	 
	 public int deleteFromTail(){
		 int temp=tail.info;
		 if (head==tail) {
			head=tail=null;
			
		}else{
			linkedlist tempo;
			for (tempo=head; tempo. next !=tail; tempo=tempo.next) {
				
			}
			tail=tempo;
			tail.next=null;
		}
		 return temp;
	 }
	 
	 public void deleteFromAnyPlace(int el){
		 if (head==tail && head.info==el) {
			 head=tail=null;

		 }
		 else if(head.info==el){
			 head=head.next;
		 }
		 else{
			linkedlist temp,pred;
			for (pred=head,temp=head.next;temp !=null && temp.info !=el ; pred=pred.next,temp=temp.next) {
				
			}
			if (tail!=null) {
				pred.next=temp.next;
			}
		}
	 }
 }