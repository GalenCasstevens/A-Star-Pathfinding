import java.util.ArrayList;

public class Heap {
	private ArrayList<Node> theHeap;
	private int itemsInArrayList = 0,
				maxSize;
	
	public Heap() {
		theHeap = new ArrayList<Node>();
	}
	
	public void insert(Node newNode) {
		theHeap.add(newNode);
		itemsInArrayList++;
	}
	
	public void delete() {
		theHeap.remove(0);
		itemsInArrayList--;
	}
	
	public Node pop() {
		if(itemsInArrayList != 0) {
			Node root = theHeap.get(0);
			theHeap.set(0, theHeap.get(--itemsInArrayList));
			heapTheArray(0);
			
			return root;
		}
		
		return null;
	}
	
	public void heapTheArray(int index) {
		int smallestChild;
		
		Node root = theHeap.get(0);
		
		while(index < itemsInArrayList / 2) {
			int leftChild = 2 * index + 1,
				rightChild = leftChild + 1;
			
			if(rightChild < itemsInArrayList &&
			   theHeap.get(leftChild).getF() > theHeap.get(rightChild).getF()) {
				smallestChild = rightChild;
			} else {
				smallestChild = leftChild;
			}
			
			if(root.getF() <= theHeap.get(smallestChild).getF()) break;
			
			theHeap.set(index, theHeap.get(smallestChild));
			
			index = smallestChild;
		}
		
		theHeap.set(index, root);
	}
	
	public void displayTheHeap() {
		for(int i = 0; i < itemsInArrayList; i++) {
			System.out.println(theHeap.get(i).getF());
		}
	}
	
	public int getSize() {
		return theHeap.size();
	}
}