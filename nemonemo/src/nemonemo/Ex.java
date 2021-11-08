package nemonemo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

class Rect {
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

class nemoPanel extends Util {

	JButton btn = new JButton();

	private int x1;
	private int y1;
	private int x2;
	private int y2;

	private int shiftX;
	private int shiftY;
	
	
	private boolean boo = false;
	Rect rc = new Rect(0, 0, 0, 0);

	public nemoPanel() {
		setBounds(50, 50, 500, 500);
		setBackground(Color.orange);

		setbtn();
		addMouseListener(this);
		addMouseMotionListener(this);
		setFocusable(true);
		addKeyListener(this);
	}

	

	private void setbtn() {
		this.btn.setBounds(100, 100, 100, 100);
		this.btn.setText("CLOSE");
		this.btn.addActionListener(this);
		this.btn.setBackground(Color.white);
		add(this.btn);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println(e.getKeyChar());
		System.out.println("쉬프트클릭");
		
		if (e.isShiftDown() == true){
			boo = true;
		} else {
			boo = false;
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		System.out.println("드래그중");

//		this.x2 = e.getX() - rc.getWidth();
//		this.y2 = e.getY() - rc.getHeight();
		this.rc.setWidth(e.getX() - x1);
		this.rc.setHeight(e.getY() - y1);

		x2 = e.getX() - rc.getX();

		y2 = e.getY() - rc.getY();

		System.out.println(rc.getWidth() + ":" + rc.getHeight());

	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("클");

		this.x1 = e.getX();
		this.y1 = e.getY();

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("릭");
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawRect(x1, y1, rc.getWidth(), rc.getHeight());
		g.drawRect(x2, y2, -rc.getWidth(), -rc.getHeight());
		g.drawRect(x1, y2, rc.getWidth(), -rc.getHeight());
		g.drawRect(x2, y1, -rc.getWidth(), rc.getHeight());

		requestFocusInWindow(); // 포커스 다시요청
		repaint();
	}

}

class nemoFrame extends JFrame implements ActionListener {
	public nemoFrame() {
		super("사각형 그리기");
		setLayout(null);
		setBounds(100, 100, 800, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		add(new nemoPanel());

		setVisible(true);
		revalidate();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}

public class Ex {
	public static void main(String[] args) {
		nemoFrame nemo = new nemoFrame();
	}

}
