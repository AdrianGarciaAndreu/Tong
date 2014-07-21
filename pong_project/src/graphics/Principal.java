package graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
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
	
	
	private boolean w_pressed = false;
	private boolean s_pressed = false;
	
	private boolean up_pressed = false;
	private boolean down_pressed = false;
	
	private int vel = 6;


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

		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {




				frame.addKeyListener(new KeyAdapter() {	


					public void keyPressed(KeyEvent arg0){



						if (arg0.getKeyCode() != 0) {System.out.println("Key Pressed");}

						// mueve el j2 hacía abajo
						if (arg0.getKeyCode() == arg0.VK_DOWN) {	
							down_pressed=true;	
						}

						//mueve el j2 hacía arriba
						if (arg0.getKeyCode() == arg0.VK_UP) {  
							up_pressed=true;
						}

						//mueve el j1 hacía abajo
						if (arg0.getKeyCode() == arg0.VK_S) {  
							s_pressed=true;		
						}

						//mueve el j1 hacía arriba
						if (arg0.getKeyCode() == arg0.VK_W) {  
							w_pressed = true;			
						}


						// captura el movimiento 
						// cuando hay varias teclas pulsadas

						if (arg0.getKeyCode() != 0) {

							if (s_pressed==true && w_pressed==false) {
								if (game_panel.cantMoveDown(j1)==false) {

									moveComponentDown(j1, vel);
								}
							}
							if (down_pressed==true && up_pressed==false) {
								if (game_panel.cantMoveDown(j2)==false) {
									moveComponentDown(j2, vel);
								}
							}
							if (up_pressed==true && down_pressed==false) {
								if (game_panel.cantMoveUp(j2)==false) {
									moveComponentUp(j2, vel);
								}
							}
							if (w_pressed==true && s_pressed==false) {
								if (game_panel.cantMoveUp(j1)==false) {
									moveComponentUp(j1, vel);
								}
							}

						}



					}


					public void keyReleased(KeyEvent arg0) {

						// mueve el j2 hacía abajo
						if (arg0.getKeyCode() == arg0.VK_DOWN) {	
							down_pressed = false;					
						}

						// mueve el j1 hacía abajo
						if (arg0.getKeyCode() == arg0.VK_S) {	
							s_pressed = false;					
						}

						//mueve el j2 hacía arriba
						if (arg0.getKeyCode() == arg0.VK_UP) {  
							up_pressed=false;
						}

						//mueve el j2 hacía arriba
						if (arg0.getKeyCode() == arg0.VK_W) {  
							w_pressed=false;
						}


					}



				});


			}
		});


	}


	
	public void seconds () {
		double crono = 0.00;
		boolean f = true;
		
		while (true) {
			
			double s = System.currentTimeMillis();
			while (true){
				if (System.currentTimeMillis()>=s+1000) {
					crono++;
					System.out.println(crono+" segundos transcurridos");
					break;
				}
			}
		}
	}
	
	
	
	
	
/**
 * Método con el movimiento hacía abajo de un Componente
 * @param comp:  Componente a mover (JComponent)
 */
	public void moveComponentDown(JComponent comp,int vel){
		comp.setLocation
			(comp.getLocation().x , (comp.getLocation().y)+(vel*2) );
		comp.repaint();
	}
	
/**
 * Método con el movimiento hacía arriba de un Componente
 * @param comp:  Componente a mover (JComponent)
 */
	public void moveComponentUp(JComponent comp, int vel){
		comp.setLocation
			(comp.getLocation().x , (comp.getLocation().y)-(vel*2) );
		comp.repaint();
	}
	

	
}
