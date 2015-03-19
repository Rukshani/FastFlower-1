package dataStructures;

public class dlinklist {
	public int info;
	public dlinklist next,prev;
	public dlinklist(int el){
		this(el,null,null);
	}
	public dlinklist(int el, dlinklist p, dlinklist n) {
		info=el;
		next=n;
		prev=p;
	}
	

	
}
class intdlist{
	protected  dlinklist tail,head;
	
	public intdlist(){
		head =tail =null;
	}
	
	public void insertToTail(int el){
		if (!isEmpty()) {
			
			tail=new dlinklist(el,tail,null);
			tail.prev.next=tail;
			
		}else{
			tail=head=new dlinklist(el);
		}
	}
	
	public boolean isEmpty(){
		return head == null;
	}
	public int deleteFromTail(){
		int temp=tail.info;
		if (head==tail) {
			head=tail=null;
			
		}else{
			tail.prev.next=null;
			tail=tail.prev;
			
		}
		return temp;
	}
}