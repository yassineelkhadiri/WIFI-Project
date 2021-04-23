import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.Random;

public class App extends JFrame implements MouseListener, ItemListener,ActionListener
{
	ArrayList<AccessPoint> APs ;
    ArrayList<Pc> Pcs ;
	ArrayList<Obstacle> Obstacles ;
    static JLabel l1,l2,l3;
    static JComboBox c1,c2;
    Button bouton,bouton1 ;
	JFrame frame;
	int i=0;


	public App()
    {
        super("Application Wifi");
        addMouseListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        APs = new ArrayList<AccessPoint>();
        Pcs=  new ArrayList<Pc>() ;
        Obstacles = new ArrayList<Obstacle>() ;
        Create();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        create_frame() ;
	}
	
	void Create()
	{
    String s1[] = { "Access point", "Pc", "Obstacle"};
    c1 = new JComboBox(s1);
	c1.addItemListener(this);
	String s2[] = { "Bois", "Plastique", "Verre","Verre teinte","Eau","Etres vivants","Briques","Platre","Ceramique","Papier","Beton","Verre Blinde","Metal"};
    c2 = new JComboBox(s2);
    c2.addItemListener(this);
    l1 = new JLabel("Add ");
    l2 = new JLabel("Change obstacle type");
    l1.setForeground(Color.black);
	l2.setForeground(Color.black);
	JPanel p = new JPanel();
    JPanel p1 = new JPanel() ;
    add(p1,BorderLayout.SOUTH);
    bouton= new Button("Show Pcs") ;
    bouton.addActionListener(this);
	bouton.setBackground(Color.white);
	p.add(l1);
	p1.add(bouton);
	p.add(c1);
	p.add(c2);
	p.add(l2);
	add(p);
	}

	public void create_frame() 
	{
		frame = new JFrame("PCs :");
		frame.setLayout(new FlowLayout());
		l2= new JLabel();
		l2.setText(connections());
		frame.add(l2) ;
		frame.setSize(400,400);
		frame.setVisible(true);
	}

	public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }
    public void mousePressed(MouseEvent e) { }
    public void mouseClicked(MouseEvent e) { }
    public void mouseReleased(MouseEvent e)
    {
		if(e.getButton() == MouseEvent.BUTTON1) 
		{

			
            if (c1.getSelectedItem() == "Access point")
            {
				int x = e.getX();
                int y = e.getY();
                Graphics g;
                Graphics2D ga;
                g = this.getGraphics();
                ga= (Graphics2D)g;
				AccessPoint AP = new AccessPoint(x,y,i);
				APs.add(AP);
				ga.drawString(String.valueOf(APs.size()-1),x,y);
                AP.drawAp(ga,x,y, AP.rc);
				if(Check(ga,x,y,AP.rc)) 
				AP.rc= 50;
			}
			else if (c1.getSelectedItem() == "Pc")
            {
                int x = e.getX();
				int y = e.getY();
				Graphics g;
                Graphics2D ga;
                g = this.getGraphics();
				ga = (Graphics2D) g;
				Pc p = new Pc(x,y,++i);
				Pcs.add(p);
				ga.drawString(String.valueOf(Pcs.size()),x,y);
				p.drawPc(ga,x,y);
            
			}
			else if (c1.getSelectedItem() == "Obstacle") 
			{
                int x = e.getX();
                int y = e.getY();
                Graphics g;
                Graphics2D ga;
                g = this.getGraphics();
				ga = (Graphics2D) g;
				
				if (c2.getSelectedItem() == "Bois")
				{
					Bois b = new Bois(x,y,0.1);
					Obstacles.add(b);
					b.drawObstacle(ga,x, y);
                	APverif(ga,x,y,0.1) ;
				}
				else if(c2.getSelectedItem() == "Plastique")
				{
					Plastique p = new Plastique(x,y,0.2);
					Obstacles.add(p);
                	p.drawObstacle(ga,x, y);
                	APverif(ga,x,y,0.2) ;
				}
				else if(c2.getSelectedItem() == "Verre")
				{
					Verre v = new Verre(x,y,0.3);
					Obstacles.add(v);
                	v.drawObstacle(ga,x, y);
                	APverif(ga,x,y,0.3) ;
				}
				else if(c2.getSelectedItem() == "Verre teinte")
				{
					VerreTeinte vt = new VerreTeinte(x,y,0.5);
					Obstacles.add(vt);
                	vt.drawObstacle(ga,x, y);
                	APverif(ga,x,y,0.5) ;
				}
				else if(c2.getSelectedItem() == "Eau")
				{
					Eau ea = new Eau(x,y,0.5);
					Obstacles.add(ea);
                	ea.drawObstacle(ga,x, y);
                	APverif(ga,x,y,0.5) ;
				}
				else if(c2.getSelectedItem() == "Etres vivants")
				{
					EtreVivant ev = new EtreVivant(x,y,0.5);
					Obstacles.add(ev);
                	ev.drawObstacle(ga,x, y);
                	APverif(ga,x,y,0.5) ;
				}
				else if(c2.getSelectedItem() == "Briques")
				{
					Briques b = new Briques(x,y,0.5);
					Obstacles.add(b);
                	b.drawObstacle(ga,x, y);
                	APverif(ga,x,y,0.5) ;
				}
				else if(c2.getSelectedItem() == "Platre")
				{
					Platre p = new Platre(x,y,0.5);
					Obstacles.add(p);
                	p.drawObstacle(ga,x, y);
                	APverif(ga,x,y,0.5) ;
				}
				else if(c2.getSelectedItem() == "Ceramique")
				{
					Ceramique c = new Ceramique(x,y,0.7);
					Obstacles.add(c);
                	c.drawObstacle(ga,x, y);
                	APverif(ga,x,y,0.7) ;
				}
				else if(c2.getSelectedItem() == "Papier")
				{
					Papier p = new Papier(x,y,0.7);
					Obstacles.add(p);
                	p.drawObstacle(ga,x, y);
                	APverif(ga,x,y,0.7) ;
				}
				else if(c2.getSelectedItem() == "Beton")
				{
					Beton b = new Beton(x,y,0.85);
					Obstacles.add(b);
                	b.drawObstacle(ga,x, y);
                	APverif(ga,x,y,0.85) ;
				}
				else if(c2.getSelectedItem() == "Verre blinde")
				{
					VerreBlinde vb = new VerreBlinde(x,y,0.85);
					Obstacles.add(vb);
                	vb.drawObstacle(ga,x, y);
                	APverif(ga,x,y,0.85) ;
				}
				else if(c2.getSelectedItem() == "Metal")
				{
					Metal m = new Metal(x,y,0.9);
					Obstacles.add(m);
                	m.drawObstacle(ga,x, y);
                	APverif(ga,x,y,0.9) ;
				}
               
            }
            
            l2.setText(connections());
		}
		
	}
	public void dessiner(Graphics2D ga,int x, int y,int q)
        { 
			Shape circle = new Ellipse2D.Float(x - q, y - q,  q* 2, q * 2);
            Color C =  new Color(255, 0, 0,50) ;
            ga.setPaint(C);
            ga.draw(circle);
            ga.fill(circle);
    	}
    public void APverif (Graphics2D ga,int x ,int y,double w)
    	{ 
			for(int i=0;i<APs.size(); i++ ) 
			{
        	int APx=APs.get(i).x ;
        	int APy=APs.get(i).y;
       		double distance = Math.sqrt((x-APx)*(x-APx) + (y-APy)*(y-APy)) ;
			if(distance<=APs.get(i).rc) 
			{
			APs.get(i).rc=(APs.get(i).rc)-(int)(w*APs.get(i).rc);
			dessiner(ga,APx,APy,APs.get(i).rc);
        	}
   		 	}

    	}
		public boolean Check (Graphics2D ga, int x,int y,int Rc) {
			boolean a=false ;
			for (int i = 0; i < Obstacles.size(); i++) {
				int Ox = Obstacles.get(i).x;
				int Oy = Obstacles.get(i).y;
				double distance = Math.sqrt((x - Ox) * (x - Ox) + (y - Oy) * (y - Oy));
				if (distance <= Rc) {
					dessiner(ga,x,y,APs.get(i).rc);
					a= true ;
				}
			}
			return a ;
		}
		
		public String connections()
		{
			String res = "<html>";
			for (int i = 0; i <Pcs.size(); i++)
			{
				double minDistance = Double.MAX_VALUE;
				int minAPIndex = -1;
				for(int j = 0; j<APs.size();j++)
				{
					int APx = APs.get(j).x;
					int APy = APs.get(j).y;
					int Hx = Pcs.get(i).x;
					int Hy = Pcs.get(i).y;
					double distance = Math.sqrt((APx - Hx)*(APx - Hx) +(APy - Hy)*(APy - Hy) );
					if(distance<APs.get(j).rc && distance<minDistance)
					{
						minDistance = distance;
						minAPIndex = j;
					}
				}
				//System.out.println(i);
				if(minAPIndex == -1){
					res += "Pc number "+ Pcs.get(i).num + " is not connected<BR>";
				}
				else {
					res += "Pc number "+ Pcs.get(i).num + " is connected to acces point number : " + minAPIndex+"<BR>";
				}
			}
			res+= "</html>";
			if (Pcs.size()== 0) res="there is no Pcs  " ;
			return res;
		}	
		public void itemStateChanged(ItemEvent e)
    	{
			if (e.getSource() == c1) 
			{
            l1.setText(c1.getSelectedItem() + " selected");
        	}
    	}
	public void actionPerformed(ActionEvent e) 
		{
			if (e.getSource() == bouton) 
			{
            frame.setVisible(true);
        	}

    	}
	

	public static void main(String[] args)
    { 
        new App();
    }

}