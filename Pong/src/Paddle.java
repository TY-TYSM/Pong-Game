import java.awt.Color;

public class Paddle extends Sprite {
	
	final static int PADDLE_WIDTH = 10;
	final static int PADDLE_HEIGHT = 100;
	final static Color PADDLE_COLOR = Color.WHITE;
	final static int DISTANCE_FROM_EDGE = 40;
	
	public Paddle(int panelWidth, int panelHeight, Player player) {
		setWidth(PADDLE_WIDTH);
		setHeight(PADDLE_HEIGHT);
		setColor(PADDLE_COLOR);
		int xPos;
		if(player == Player.One) {
			xPos = DISTANCE_FROM_EDGE;
		} else {
			xPos = panelWidth - DISTANCE_FROM_EDGE - getWidth();
		}
		setInitialPosition(xPos, panelHeight / 2 - (getHeight() / 2));
		resetToInitialPosition();
	}

}
