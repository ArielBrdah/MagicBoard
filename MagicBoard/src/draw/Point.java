package draw;

import java.awt.Color;

public class Point {
	  private int posX = 50;
	  private int posY = 50;
	  private Color color = Color.red;
	  private Morph m = Morph.ROND;

	  
	  public Point() {}
	  
	  public Point(int x, int y) {
		  posX = x;
		  posY = y;
	  }
	  
	  
	  public Point(int x, int y,Color c) {
		  posX = x;
		  posY = y;
		  color = c;
	  }
	  public Point(int x, int y, Color c, Morph morph) {
		  posX = x;
		  posY = y;
		  color = c;
		  m = morph;
	  }
	  
	  public void setMorph(Morph p) {
		  m = p;
	  }
	  
	  public Morph getMorph() {
		  return m;
	  }
	  
	  public void setColor(Color c) {
		  color = c;
	  }
	  
	  public Color getColor() {
	return color;	  
	  }
	  
	  public int getPosX() {
		    return posX;
		  }

		  public void setPosX(int posX) {
		    this.posX = posX;
		  }

		  public int getPosY() {
		    return posY;
		  }

		  public void setPosY(int posY) {
		    this.posY = posY;
		  }
}
