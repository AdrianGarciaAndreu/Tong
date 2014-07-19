package graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;


public class Principal {

	private JFrame frame;
	private JPanel main_pane;
	private GamePanel game_panel;
	
	private int x,y; //pos of player
	private int x2,y2; //pos of enemy
	
	private JLabel j1;
	private JLabel j2;
	

	/**
	 * Método de creación de la ventana principal sus paneles 
	 * y la instanciación de los 2 pongs
	 * 
	 * @wbp.parser.entryPoint
	 */
	public void window(){
		
		this.frame = new JFrame();
		this.frame.setSize(800, 600);
		this.main_pane = new JPanel();
		LayoutManager  main_layout = new BorderLayout();
		this.main_pane.setLayout(main_layout);
		
		this.detalles();
		
		
		this.j1 = 
				this.GeneratePlayer(this.j1,15 ,
			 (this.game_panel.getYLimit()/2)-20);
		
		this.j2 = 
				this.GeneratePlayer(this.j2,this.frame.getWidth()-35,
				(this.game_panel.getYLimit()/2)-20);
		
		this.game_panel.add(this.j1);
		this.game_panel.add(this.j2);
		
		JPanel points_panel = new JPanel();
		this.frame.getContentPane().add(points_panel, BorderLayout.NORTH);
		
		
		this.frame.setTitle("P_Adrian");
		this.frame.setResizable(false);
		this.frame.setVisible(true);
		
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		


		this.PlayerControls();
		this.Player2Controls();
	}
	

	
	public void detalles() { 
		
		this.game_panel = new GamePanel();
		this.game_panel.setBorder(new CompoundBorder(null, new LineBorder(new Color(153, 180, 209), 2)));
		this.frame.getContentPane().add(this.game_panel, BorderLayout.CENTER);
		this.game_panel.setLayout(null);
		
		}
	
	
	

	
	/**
	 * Genera el JLabel con el PONG del jugador 
	 * que se determine en las coordenadas determinadas
	 */
	public JLabel GeneratePlayer(JLabel j1, int x, int y) {
		
		j1 = new JLabel();
		
		j1.setBounds(x, y, 12, 64);
		j1.setVerticalAlignment(JLabel.CENTER);
		
		ImageIcon img = new ImageIcon(Principal.class.getResource("/images/pong_1.png"));
		Image img2 = img.getImage();
		img = new ImageIcon(img2.getScaledInstance(12, 64, 0));
		
		j1.setIcon(img);
		
		return (j1);
		

		
	}
	
	
	
	/**
	 * Método que implementa los Event Handler necesarios para
	 * que le jugador obtenga controles 
	 */

	public void PlayerControls() {
		
		this.main_pane.addKeyListener(new KeyAdapter() {
			
			boolean w_pressed = false;
			boolean s_pressed = false;
			
			boolean up_pressed = false;
			boolean down_pressed = false;
			
			
			//////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////
			
			
			
			
			/////////////////////////////////////////////////////////////
			/////////////////////////////////////////////////////////////
			public void keyPressed(KeyEvent arg0){
				// mueve el j2 hacía arriba
				if (arg0.getKeyCode() == arg0.VK_DOWN) {	
					if (game_panel.cantMoveDown(j1)==false) {
						down_pressed = true;
					}
				}
				
				//mueve el j2 hacía abajo
				else if (arg0.getKeyCode() == arg0.VK_UP) {  
					if (game_panel.cantMoveUp(j1)==false) {
					
				  }
					
				}
				
			}
			
		});
		
	}
	
	public void Player2Controls(){
		
		this.frame.addKeyListener(new KeyAdapter() {
			
			public void keyPressed(KeyEvent arg0) {

				
			}
		});
	}


	

	
	
	
	
/**
 * Método con el movimiento hacía abajo de un Componente
 * @param comp:  Componente a mover (JComponent)
 */
	public void moveComponentDown(JComponent comp,int vel){
		comp.setLocation
			(comp.getLocation().x , (comp.getLocation().y)+vel );
		comp.repaint();

	}
	
/**
 * Método con el movimiento hacía arriba de un Componente
 * @param comp:  Componente a mover (JComponent)
 */
	public void moveComponentUp(JComponent comp, int vel){
		comp.setLocation
			(comp.getLocation().x , (comp.getLocation().y)-vel );
		comp.repaint();
	}
	

	
}
