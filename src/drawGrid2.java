import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.geom.Line2D;
import java.util.Random;

public class drawGrid2 extends JComponent {
	int x,
		y,
		gridSize = 15,
		startRow,
		startCol,
		goalRow,
		goalCol;
	
	Node[][] grid = new Node[gridSize][gridSize];
	
	Random rand = new Random();
	
	public drawGrid2(Node[][] grid) {
		this.grid = grid;
	}
	
	public drawGrid2(Node[][] grid, int startRow, int startCol, int goalRow, int goalCol) {
		this.grid = grid;
		this.startRow = startRow;
		this.startCol = startCol;
		this.goalRow = goalRow;
		this.goalCol = goalCol;
	}
	
	public drawGrid2() {
		x = y = 0;
	}
	
	public void paintComponent(Graphics g) {
		int	width = 50,
			height = 50,
			color = 0;
		
		Graphics2D g2 = (Graphics2D) g;
		
		Color red = new Color(255, 0, 0);
		Color green = new Color(0, 255, 0);
		Color blue = new Color(0, 0, 255);
		Color purple = new Color(255, 0, 255);
		Color black = new Color(0, 0, 0);
		Color white = new Color(255, 255, 255);

		g2.setColor(white);
		
		g2.fill(new Rectangle(0, 0, 750, 750));
		
		x = 50;
		y = 50;
		g2.setColor(black);
		
		for(int i = 0; i < 15; i++) {
				g2.draw(new Line2D.Double(x, 0, x, 750));
				x += 50;
		}
		
		for(int i = 0; i < 15; i++) {
			g2.draw(new Line2D.Double(0, y, 750, y));
			y += 50;
		}
		
		g2.setColor(black);
		
		for(int i = 0; i < 15; i++) {
			y = i * 50;
			for(int j = 0; j < 15; j++) {
				x = j * 50;
				if(grid[i][j].getPathable() == false) {
					g2.fill(new Rectangle(x, y, width, height));
				}
			}
		}
		
		g2.setColor(green);
		
		y = (startRow) * 50;
		x = (startCol) * 50;
		
		g2.fill(new Rectangle(x, y, width, height));
		
		g2.setColor(red);
		
		y = (goalRow) * 50;
		x = (goalCol) * 50;
		
		g2.fill(new Rectangle(x, y, width, height));
	}
}