import java.awt.event.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class AccessPoint 
{
    int x; 
    int y;
    int rc=100;
    int num;
    int channel=0;
    String ssid;


    AccessPoint(int x,int y ,int num)
    {
        this.x=x;
        this.y=y;
        this.num=num;
        this.ssid="Réseau "+num+" ";
    
    }

    void drawAp(Graphics2D ga, int xc, int yc, int r)
    {
        Random rn = new Random();
        int colorR=rn.nextInt(200);
        int colorG=rn.nextInt(200);
        int colorB =rn.nextInt(200);
        Shape circle = new Ellipse2D.Float(xc-r, yc-r, r*2, r*2);
        ga.draw(circle);
        for (int i=0; i<2*r; i+=2)
            for (int j=0; j<2*r;j+=2)
            {   int x=(xc-r)+ i;
                int y= (yc-r)+ j;
                double f=Facteur_Attinuation (xc, yc ,r, x, y);
                int G=(int) (255.0-f*255.0);
                if (f!=0)
                {
                    Color C= new Color( colorR,colorG,colorB,255-G);
                    Shape square = new Rectangle2D.Double(x, y,1, 1);
                    ga.setPaint(C);
                    ga.fill(square);
                }
            }
        ga.setPaint(Color.black);
        
    }
    int SiNull (double f)
    { if (f==0) return (0); 
    else return(1); }
    double distance (int x1,int y1, int x, int y)
    { return Math.sqrt( (x1-x)*(x1-x)+(y1-y)*(y1-y)); }
    double Facteur_Attinuation (int xc, int yc ,int r, int x, int y)
    {
    double f= 1.0-distance(xc,yc,x,y)/((double) r);
        if (f<0) 
        return(0);
        return(f);
    }

    
}