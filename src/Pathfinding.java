import javax.swing.JFrame;
import java.util.Scanner;
import java.util.Random;
import static java.lang.Math.abs;

public class Pathfinding {
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		int gridSize = 15;
		
		Pathfinding grid = new Pathfinding();
		
		Node[][] startGrid = grid.generateGrid();
		Node currentNode;
		
		JFrame window1 = new JFrame();
		window1.setSize(768, 797);
		window1.setTitle("A* Pathfinding Field");
		window1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		window1.setVisible(true);
		
		drawGrid dg = new drawGrid(startGrid);
		
		window1.add(dg);
		
		System.out.print("Which row would you like the start node to be in?: ");
		int startRow = input.nextInt() - 1;
		
		System.out.print("Which column would you like the start node to be in?: ");
		int startCol = input.nextInt() - 1;
		
		System.out.print("Which row would you like the goal node to be in?: ");
		int goalRow = input.nextInt() - 1;
		
		System.out.print("Which column would you like the goal node to be in?: ");
		int goalCol = input.nextInt() - 1;
		
		grid.calculateHeuristic(goalRow, goalCol, startGrid, gridSize);
		
		grid.calculateG(startRow, startCol, startGrid, gridSize);
		
		System.out.println(startGrid[0][0].getG());
		
		JFrame window2 = new JFrame();
		window2.setSize(768, 797);
		window2.setTitle("A* Pathfinding Field");
		window2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		window1.setVisible(false);
		window2.setVisible(true);
		
		drawGrid2 dg2 = new drawGrid2(startGrid, startRow, startCol, goalRow, goalCol);
		
		window2.add(dg2);
		
		grid.aStar(startRow, startCol, goalRow, goalCol, startGrid, gridSize);
	}
	
	// A* algorithm
	public void aStar(int startRow, int startCol, int goalRow, int goalCol, Node[][] startGrid, int gridSize) {
		Heap openList = new Heap();
		
		openList.insert(startGrid[startRow][startCol]);
	}
	
	public Node[][] generateGrid() {
		int blockChance = 0;
		
		Node[][] grid = new Node[15][15];
		
		Random gen = new Random();
		
		for(int i = 0; i < 15; i++) {
			for(int j = 0; j < 15; j++) {
				blockChance = gen.nextInt(10) + 1;
				if(blockChance == 1) grid[i][j] = new Node(i, j, false);
				else grid[i][j] = new Node(i, j, true);
			}
		}
		
		return grid;
	}
	
	public void generateNeighbors(Node currentNode) {
		
	}
	
	// calculates the heuristic for the entire board
	public void calculateHeuristic(int goalRow, int goalCol, Node[][] startGrid, int gridSize) {
		int dx = 0,
			dy = 0;
		
		for(int i = 0; i < gridSize; i++) {
			for(int j = 0; j < gridSize; j++) {
				if(startGrid[i][j].getPathable()) {
					dx = abs(i + goalCol);
					dy = abs(j + goalRow);
					
					startGrid[i][j].setH(10 * (dx + dy));
				}
			}
		}
	}
	
	// calculates the G score for the entire board
	public void  calculateG(int startRow, int startCol, Node[][] startGrid, int gridSize) {
		int dx = 0,
			dy = 0,
			G;
		
		for(int i = 0; i < gridSize; i++) {
			for(int j = 0; j < gridSize; j++) {
				if(startGrid[i][j].getPathable()) {
					if(i == startRow || j == startCol) {
						dx = abs(i + startCol);
						dy = abs(j + startRow);
						
						startGrid[i][j].setG(10 * (dx + dy));
					}
					
					if(i < startRow && j < startRow) {
						int iTemp = i,
							jTemp = j;
						
						G = 0;
						
						while(iTemp != startRow && jTemp != startCol) {
							iTemp++;
							jTemp++;
							
							G += 14;
						}
						
						startGrid[i][j].setG(G);
					}
				}
			}
		}
	}
}