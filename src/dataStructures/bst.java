package dataStructures;

public class bst {
	public int info;
	public bst left,rigth;
	public bst(int i){
		this.info=i;
	}
	
}

class bstTree{
	bst root;
	
	public void addNode(int i){
		System.out.println("test");
		
		bst node=new bst(i);
		if (root== null) {
			root=node;
		}else{
			bst currentNode=root;
			bst parentNode;
			while(true){
				parentNode=currentNode;
				if(i<currentNode.info){
					currentNode=currentNode.left;
					
					if (currentNode ==null) {
						parentNode.left=node;
						return;
					}
					
				}
				else{
					currentNode =currentNode.rigth;
					
					if (currentNode==null) {
						parentNode.rigth=node;
						return;
					}
				}
			}
		}
		
		
	}
	
	public int findValue(int i){
		int number=0;
		bst currentNode=root;
		while(true){
			System.out.println("test");
			number++;
			if (currentNode.info==i) {
				return number;
			}
			if (currentNode.info>i) {
				currentNode=currentNode.left;
			}
			if (currentNode.info<i) {
				currentNode=currentNode.rigth;
				
			}
		}
		
	}
	
	public static void main(String args[]) {
		bstTree tree=new bstTree();
		for (int i = 0; i < 100; i=+10) {
			tree.addNode(i);
		}
		
		System.out.println(tree.findValue(80));
	}
	
	}
	
	
