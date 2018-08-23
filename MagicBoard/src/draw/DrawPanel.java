package draw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageProducer;
import java.util.ArrayList;

import javax.swing.JPanel;

public class DrawPanel extends JPanel implements MouseListener,MouseMotionListener{
	  private Toolkit tk = getToolkit();
	  private Point pt = new Point();
	  @SuppressWarnings("unchecked")
	  private ArrayList<Point> list = new ArrayList();
	  private Color c = Color.red;
	  private Morph m = Morph.ROND;
	  
	  public DrawPanel() {
			tk.createCustomCursor(tk.createImage("/images/rouge.jpg"),new java.awt.Point(), "cursor");
			
	  }
	  
	  public void setColor(Color r) {
		  c = r;
	  }
	  
	  public void setMorph(Morph r) {
		  m = r;
	  }
	  
	  public void effacer() {
		  list = new ArrayList();
	  }
	  
	  
	  public void paintComponent(Graphics g){
		  if(m.equals(Morph.ROND)) {
	    g.setColor(c);
	    g.fillOval(pt.getPosX(), pt.getPosY(), 10, 10);
	    }else {
		    g.setColor(c);
		    g.fillRect(pt.getPosX(), pt.getPosY(), 10, 10);
	    }
	    
	    for(Point pts : list) {
	    	if(pts.getMorph().equals(Morph.ROND)) {
	    	g.setColor(pts.getColor());
		    g.fillOval(pts.getPosX(), pts.getPosY(), 10, 10);
	    	}
	    	else {
	    		g.setColor(pts.getColor());
			    g.fillRect(pts.getPosX(), pts.getPosY(), 10, 10);
	    	}
	    }
	  }
	  

	@Override
	public void mouseClicked(MouseEvent e) {
		list.add(new Point(e.getX()-3,e.getY()-103,c,m));

	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {

			
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		list.add(new Point(e.getX()-3,e.getY()-103,c,m));

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		this.pt.setPosX(e.getX()-3);
		this.pt.setPosY(e.getY()-103);		
	}        
	}
	
