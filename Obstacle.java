import java.awt.*;
import javax.swing.*;
import java.awt.geom.RoundRectangle2D;
import java.util.Random;
public class Obstacle {

	int x,y ;
	double attinuation=0.0;
	
	
	public Obstacle(int x, int y) {
		
		this.x = x;
		this.y = y;
		
	}
	
	public int getxPoint() {
		return (this.x);
	}
	
	public int getyPoint() {
		return (this.y);
	}
	public void drawObstacle(Graphics2D ga, int x, int y) 
	{
        Random rn = new Random();
        Shape rectangle = new RoundRectangle2D.Float(x - 30, y - 15, 60, 30, 10, 10);
        ga.draw(rectangle);
        Color C = new Color(128, rn.nextInt(200), rn.nextInt(200), rn.nextInt(200));
        ga.setPaint(C);
        ga.fill(rectangle);

    }
}