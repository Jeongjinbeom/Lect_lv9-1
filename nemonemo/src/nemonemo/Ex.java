package nemonemo;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

class Rect{
	private int x, y, width, height;
	
	public Rect(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
class nemoPanel extends Util{
	
	
	public nemoPanel(){
		setBounds(50,50,500,500);
		setBackground(Color.white);
		
		addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener(this);
	}
	
	
	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println(e.getKeyChar());
		if(e.isShiftDown() == true) {
			
		}
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}

class nemoFrame extends JFrame{
	public nemoFrame() {
		super("사각형 그리기");
		setLayout(null);
		setBounds(100,100,800,800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(new nemoPanel());
		setVisible(true);
		revalidate();
	}
}

public class Ex {
	public static void main(String[] args) {
		nemoFrame nemo = new nemoFrame();
	}

}
