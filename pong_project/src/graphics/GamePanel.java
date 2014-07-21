package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.JPanel;


public class GamePanel extends JPanel{

	private int initDistance = 5; //distancia de inicio de la creacion del limite del escenario
	private int XLimit; // limite de ancho del escenaio
	private int YLimit; // limite de altura del escenario
	
	
	public GamePanel() {
		this.XLimit = 785;
		this.YLimit = 460;
	}
	
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		g.setColor(Color.RED);
		
		
		
		g.drawRect(5, 5, this.XLimit, this.YLimit);
		
	
	}
	
	
	/**
	 * retorna el limite de anchura del panel de juego
	 * @return
	 */
	public int getXLimit() { return (this.XLimit); }
	
	/**
	 * retorna el límite de altura del panel de juego
	 * @return
	 */
	public int getYLimit() { return (this.YLimit); }
	
	
	public boolean cantMoveX(JComponent comp){
		boolean locked = false;
		
		if(comp.getLocation().x + (comp.getWidth()/2) >= this.XLimit ){
			locked = true;
		}
		
		return(locked);
	}
	
	
	/**
	 * Comprueba cuando un JComponent esta en el limite bajo 
	 * del panel de juego
	 * @param comp
	 * @return
	 */
	public boolean cantMoveDown(JComponent comp){
		boolean locked = false;
		if (comp != null) {	
			if( (comp.getLocation().y + (comp.getHeight()) >= this.YLimit ) ){
				locked = true;
			}
		}
		else {System.out.println("Jugador Null");}

		return(locked);

	  
	}
	
	
	/**
	 * Compueba cuando un JComponent esta en el limite alto 
	 * del panel de juego
	 * @param comp
	 * @return
	 */
	public boolean cantMoveUp(JComponent comp){
		boolean locked = false;
		if(comp.getLocation().y <= this.initDistance+5 ){
			locked = true;
		}
		return(locked);
	}


}
