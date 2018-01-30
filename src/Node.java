
public class Node {
	private int row,
				col,
			    F, // total score
				G, // cost to move to this node from the starting node
				H; // heuristic - estimation of how close to the goal this node is 
	private boolean pathable;
	Node parent;
	
	public Node(int row, int col, boolean pathable) {
		this.row = row;
		this.col = col;
		this.pathable = pathable;
		parent = null;
	}

	public void setF() {
		F = G + H;
	}
	
	public void setF(int F) {
		this.F = F;
	}
	
	public void setG(int G) {
		this.G = G;
	}
	
	public void setH(int H) {
		this.H = H;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
	
	public int getF() {
		return F;
	}
	
	public int getG() {
		return G;
	}
	
	public int getH() {
		return H;
	}
	
	public boolean getPathable() {
		return pathable;
	}
	
	public Node getParent() {
		return parent;
	}
	
	public boolean equals(Object in) {
		Node n = (Node) in;
		
		return row == n.getRow() && col == n.getCol();
	}
}
