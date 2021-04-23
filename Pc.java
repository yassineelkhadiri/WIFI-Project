import java.awt.*;
import javax.swing.*;
import java.awt.geom.Rectangle2D;
import java.util.Random;
public class Pc
{
   public int x;
   public int y;
   public int num;

   public Pc(int x,int y,int num)
   {
       this.x=x;
       this.y=y;
       this.num=num;

   }
   public void drawPc(Graphics2D ga ,int x,int y)
   {
  
                Random rn = new Random();
                Shape circle = new Rectangle2D.Float(x - 20, y - 20, 20 * 2, 20 * 2);
                ga.draw(circle);
                Color C = new Color(128, rn.nextInt(200), rn.nextInt(200), rn.nextInt(200));
                ga.setPaint(C);
                ga.fill(circle);
   }

}