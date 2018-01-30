import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.geom.Line2D;

public class drawGrid extends JComponent {
	int x,
		y,
		gridSize = 15;
	Node[][] grid = new Node[gridSize][gridSize];
	
	public drawGrid(Node[][] grid) {
		this.grid = grid;
	}
	
	public drawGrid() {
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
	}
}