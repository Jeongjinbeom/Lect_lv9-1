package snake_gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;

class SnakePanel extends MyUtil {
	Random rn = new Random();
	private int mapSize = 10;
	private int snakeSize = 4;
	private Rect[][] map = new Rect[mapSize][mapSize];
	private int Size;
	private Rect[] snake;
	private JButton[] btn = new JButton[4];
	private JButton reset = new JButton();

	public SnakePanel() {
		setLayout(null);
		setBounds(0, 0, 700, 700);
//		setBackground(Color.green);

		snake = new Rect[snakeSize];
		int x[] = new int[snakeSize];
		int y[] = new int[snakeSize];
		addMouseListener(this);
		setMap();
		setBtn();
		setBtnMove();
		resetBtn();
	}

	private void resetBtn() {
		reset = new JButton();
		reset.setText("RESET!");
		reset.setBounds(600, 80, 80, 80);
		reset.setBackground(Color.white);
		reset.addActionListener(this);
		add(reset);
	}

	private void setBtnMove() {

	}

	private void setBtn() {
		String[] text = { "¡ç", "¡é", "¡æ", "¡è" };

		int size = 50;
		int x = 700 - 200;
		int y = 700 - 100;
		for (int i = 0; i < this.btn.length; i++) {
			this.btn[i] = new JButton();
			this.btn[i].setBounds(x, y, size, size);
			this.btn[i].setText(text[i]);
			this.btn[i].setBackground(Color.white);
			this.btn[i].addMouseListener(this);
			add(this.btn[i]);
			x += size;
			if (i == this.btn.length - 1 - 1) {
				x = 700 - 200 + size;
				y -= size;
			}
		}
	}

	public void setMap() {
		int x = 530 / 2 - 50 * 10 / 2;
		int y = 530 / 2 - 35 * 10 / 2;

		for (int i = 0; i < this.map.length; i++) {
			for (int j = 0; j < this.map[i].length; j++) {
				this.map[i][j] = new Rect(x, y, 50, 50);
				x += 50;
			}
			x = 530 / 2 - 50 * 10 / 2;
			y += 50;
		}
		
		x = 530 / 2 - 50 * 4 / 2;
		y = 530 / 2 - 50 * 4 / 2;
		for(int i=0; i<this.snakeSize; i++) {
			this.snake[i] = new Rect(x,y,50,50);
			x += 50;
		}
		x = 530 / 2 - 50*10 / 2;
		y += 50;
	}


	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// °ÔÀÓ ÁÙ
		for (int i = 0; i < this.map.length; i++) {
			for (int j = 0; j < this.map[i].length; j++) {
				Rect rect = this.map[i][j];
				setBackground(Color.WHITE);
				g.drawRect(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight());
			}
		}
		
		for(int i=0; i<this.snakeSize; i++) {
			Rect rect = this.snake[i];	
			g.drawRect(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight());

		}

		repaint();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}

public class Game extends JFrame {

	private SnakePanel panel = new SnakePanel();

	public Game() {
		super("Snake Game");
		setLayout(null);
		setBounds(50, 50, 700, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		add(panel);

		setVisible(true);
		revalidate();

	}
}
