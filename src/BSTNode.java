
public class BSTNode {

	int key;
	String name;

	BSTNode leftChild;
	BSTNode rightChild;

	public BSTNode(int key, String name) {
		this.key = key;
		this.name = name;
	}

	public String toString() {
		return name + " -> " + key;
	}

}

class BstTree {

	BSTNode root;

	public void addNode(int key, String name) {
		BSTNode newNode = new BSTNode(key, name);
		if (root == null) {
			root = newNode;
		} else {
			BSTNode currentNode = root;
			BSTNode parent;
			while (true) {
				parent = currentNode;
				if (key < currentNode.key) {
					currentNode = currentNode.leftChild;
					if (currentNode == null) {
						parent.leftChild = newNode;
						return;
					}
				} else {
					currentNode = currentNode.rightChild;
					if (currentNode == null) {
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}

	public BSTNode findNode(int key) {
		BSTNode currentNode = root;
		while (currentNode.key != key) {
			if (key < currentNode.key) {
				currentNode = currentNode.leftChild;
			} else {
				currentNode = currentNode.rightChild;
			}
			if (currentNode == null) {
				return null;
			}
		}
		return currentNode;
	}

	public void inOrderTraversal(BSTNode currentNode) {
		if (currentNode != null) {
			inOrderTraversal(currentNode.leftChild);
			System.out.println(currentNode);
			inOrderTraversal(currentNode.rightChild);
		}
	}
	
	public void preOrderTraversal(BSTNode currentNode) {
		if (currentNode != null) {
			System.out.println(currentNode);
			preOrderTraversal(currentNode.leftChild);			
			preOrderTraversal(currentNode.rightChild);
		}
	}
	
	public void postOrderTraversal(BSTNode currentNode) {
		if (currentNode != null) {			
			postOrderTraversal(currentNode.leftChild);			
			postOrderTraversal(currentNode.rightChild);
			System.out.println(currentNode);
		}
	}

	public static void main(String[] args) {
		BstTree tree = new BstTree();
		tree.addNode(50, "A");
		tree.addNode(10, "B");
		tree.addNode(40, "C");
		tree.addNode(60, "D");
		tree.addNode(90, "E");
		tree.addNode(70, "F");
		tree.inOrderTraversal(tree.root);
		System.out.println("Search for 40");
		System.out.print(tree.findNode(40));
	}

}
