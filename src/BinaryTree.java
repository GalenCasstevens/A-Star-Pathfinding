public class BinaryTree {
	treeNode root;
	
	public void addNode(int key, String name) {
		treeNode newNode = new treeNode(key, name);
		
		if(root == null) root = newNode;
		else {
			treeNode focusNode = root,
				 parent;
			
			while(true) {
				parent = focusNode;
				
				if(key < focusNode.key) {
					focusNode = focusNode.leftChild;
					
					if(focusNode == null) {
						parent.leftChild = newNode;
						return;
					}
				} else {
					focusNode = focusNode.rightChild;
					
					if(focusNode  == null) {
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}
	
	public treeNode findNode(int key) {
		treeNode focusNode = root;
		
		while(focusNode.key != key) {
			if(key < focusNode.key) focusNode = focusNode.leftChild;
			else focusNode = focusNode.rightChild;
			if(focusNode == null) return null;
		}
		
		return focusNode;
	}
	
	//public boolean
	
	public void inOrderTraverseTree(treeNode focusNode) {
		if(focusNode != null) {
			inOrderTraverseTree(focusNode.leftChild);
			
			System.out.println(focusNode);
			
			inOrderTraverseTree(focusNode.rightChild);
		}
	}
	
	public void preorderTraverseTree(treeNode focusNode) {
		if(focusNode != null) {
			System.out.println(focusNode);
			
			inOrderTraverseTree(focusNode.leftChild);
			
			inOrderTraverseTree(focusNode.rightChild);
		}
	}
	
	public void postOrderTraverseTree(treeNode focustreeNode) {
		if(focustreeNode != null) {
			inOrderTraverseTree(focustreeNode.leftChild);
			
			inOrderTraverseTree(focustreeNode.rightChild);
			
			System.out.println(focustreeNode);
		}
	}
}

class treeNode {
	int key;
	String name;
	
	treeNode leftChild,
		 	 rightChild;
	
	treeNode(int key, String name) {
		this.key = key;
		this.name = name;
	}
	
	public String toString() {
		return name + " has a key " + key;
	}
}