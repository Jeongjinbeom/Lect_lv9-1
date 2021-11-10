package horseRun;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class Expanel extends MyUtil {
	Random ran = new Random();
	private JLabel label = new JLabel();
	private int SIZE = 5;
	final int GoalLine = 700;
	Horse[] horse = new Horse[SIZE];
	private JButton btn = new JButton();
	private JButton btn2 = new JButton();

//	private Image im = new ImageIcon("images/horse1.png").getImage().getScaledInstance(80, 50, Image.SCALE_SMOOTH);
//	private Image im2 = new ImageIcon("images/horse2.png").getImage().getScaledInstance(80, 50, Image.SCALE_SMOOTH);
//	private Image im3 = new ImageIcon("images/horse3.png").getImage().getScaledInstance(80, 50, Image.SCALE_SMOOTH);
//	private Image im4 = new ImageIcon("images/horse4.png").getImage().getScaledInstance(80, 50, Image.SCALE_SMOOTH);
//	private Image im5 = new ImageIcon("images/horse5.png").getImage().getScaledInstance(80, 50, Image.SCALE_SMOOTH);
//
//	private JLabel image = new JLabel(new ImageIcon(im));
// private JLabel image = new JLabel(); // new JLabel(

//	private ImageIcon icon = new ImageIcon("images/horse1.png");

	private int cnt = 1;

	public Expanel() {
		setLayout(null);
		setBounds(0, 0, 1000, 800);
		label.setBounds(0, 0, 1000, 800);
//		label.setText("text");
		add(label);
		btnSet();
//		image.setBounds(20, 0, 100, 100);
//		image.setIcon(new ImageIcon("images/horse1.png"));
//		image.setVisible(true);

//		add(image, 0);

	}

	private void setHorses() {
		for (int i = 0; i < this.SIZE; i++) {
			horse[i] = new Horse();
			horse[i].setW(120);
			horse[i].setH(90);
			horse[i].setX(100);
			horse[i].setY(100 + i * 100);
			horse[i].setNum(i + 1);

			horse[i].setSpeed(ran.nextInt(5) + 1);

			horse[i].setState(horse[i].STOP);

			horse[i].setFilename(String.format("images/horse%d.png", i + 1));
			Image image = new ImageIcon(horse[i].getFilename()).getImage().getScaledInstance(horse[i].getW(),
					horse[i].getH(), Image.SCALE_SMOOTH);
			horse[i].setImage(new ImageIcon(image));

		}

	}

	private void btnSet() {
		btn.setBounds(350, 620, 100, 50);
		btn.setBackground(Color.white);
		btn.setText("START");
		btn.addActionListener(this);
		add(btn);

		btn2.setBounds(500, 620, 100, 50);
		btn2.setBackground(Color.white);
		btn2.setText("RESET");
		btn2.addActionListener(this);
		add(btn2);

		setHorses();
	}

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);

//			g.drawImage(im, x, 20, null);
//			g.drawImage(im2, x, 70, null);
//			g.drawImage(im3, x, 120, null);
//			g.drawImage(im4, x, 170, null);
//			g.drawImage(im5, x, 220, null);
		for (int i = 0; i < this.SIZE; i++) {
			g.drawImage(horse[i].getImage().getImage(), horse[i].getX(), horse[i].getY(), null);
			if (horse[i].getState() == horse[i].GOAL) {
				Font font = new Font("", Font.BOLD, 50);
				g.setFont(font);
				g.drawString(horse[i].getRank() + "", 850, horse[i].getY() + 60);
			}
		}
		g.drawLine(this.GoalLine + 120, 100, this.GoalLine + 120, 580);

		try {
			Thread.sleep(20);

		} catch (Exception e) {
			// TODO: handle exception
		}

		update();
		repaint();
	}

	private void update() {
		for (int i = 0; i < this.SIZE; i++) {
			this.horse[i].getSpeed();
		}
		for (int i = 0; i < this.SIZE; i++) {
			if (this.horse[i].getState() == this.horse[i].RUN) {
				this.horse[i].setX(this.horse[i].getX() + this.horse[i].getSpeed());
			}
			if (horse[i].getX() >= this.GoalLine && this.horse[i].getState() == horse[i].RUN) {
				this.horse[i].setRank(cnt);
				this.horse[i].setX(this.GoalLine);
				this.horse[i].setSpeed(0);
				this.horse[i].setState(this.horse[i].GOAL);
				this.cnt++;
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == this.btn) {
			for (int i = 0; i < this.SIZE; i++) {
				horse[i].setState(horse[i].RUN);
			}
		}
		if (e.getSource() == this.btn2) {
			btn2Set();
		}
	}

	private void btn2Set() {

		this.cnt = 1;
		for (int i = 0; i < this.SIZE; i++) {
			horse[i] = new Horse();

			horse[i].setW(120);
			horse[i].setH(90);
			horse[i].setX(100);
			horse[i].setY(100 + i * 100);
			horse[i].setNum(i + 1);

			horse[i].setSpeed(ran.nextInt(5) + 1);
			horse[i].setState(horse[i].STOP);

			horse[i].setFilename(String.format("images/horse%d.png", i + 1));
			Image image = new ImageIcon(horse[i].getFilename()).getImage().getScaledInstance(horse[i].getW(),
					horse[i].getH(), Image.SCALE_SMOOTH);
			horse[i].setImage(new ImageIcon(image));

		}
	}
}

class ExFrame extends JFrame {
	public ExFrame() {
		super("말달리기");
		int w = 1000;
		int h = 800;
		setLayout(null);
		setBounds(100, 100, w, h);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new Expanel());

		setVisible(true);
		revalidate();
	}
}

public class Main {
	public static void main(String[] args) {
		ExFrame frame = new ExFrame();

	}

}
