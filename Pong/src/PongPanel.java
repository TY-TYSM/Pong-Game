import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.BasicStroke;



public class PongPanel extends JPanel implements ActionListener, KeyListener{
	
	private final static Color BACKGROUND_COLOR = Color.BLACK;
	private final static int TIMER_DELAY = 5;
	GameState gameState = GameState.INITIALISING;
	Ball ball;
	Paddle paddle1, paddle2;
	
	
	
	public void createObjects() {
		  ball = new Ball(getWidth(), getHeight());
		  paddle1 = new Paddle(getWidth(), getHeight(), Player.One);
		  paddle2 = new Paddle(getWidth(), getHeight(), Player.Two);
				  // int panelWidth, int panelHeight, Player player
		   }
	private void update() {
			switch(gameState) {
			case INITIALISING: {
				createObjects();
				gameState = GameState.PLAYING;
				break;
			}
			case PLAYING: {
				break;
			}
			case GAMEOVER: {
				break;
			}
			}
	}
	
	private void paintSprite(Graphics g, Sprite sprite) {
	     g.setColor(sprite.getColor());
	     g.fillRect(sprite.getXPosition(), sprite.getYPosition(), sprite.getWidth(), sprite.getHeight());
	}
	
	public PongPanel() {
		 setBackground(BACKGROUND_COLOR);
		 
		 Timer timer = new Timer(TIMER_DELAY, this);
		 timer.start();
	}
	
	private void paintDottedLine(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
		g2d.setStroke(dashed);
		g2d.setPaint(Color.WHITE);
		g2d.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight());
		g2d.dispose();
		}
	
	 @Override
	 public void paintComponent(Graphics g) {
		 super.paintComponent(g);
		 paintDottedLine(g);
		 if(gameState != GameState.INITIALISING) {
			 paintSprite(g, ball);
			 paintSprite(g, paddle1);
			 paintSprite(g, paddle2);
		 }
		 
	 }

	@Override
	public void keyTyped(KeyEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		update();
		repaint();
		
	}
	
	

}
