package controller;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;

import models.Horse;
import models.MyUtil;
import models.Race;

public class RacingPanel extends MyUtil implements Runnable {

	private Random random = new Random();

	private int ms;
	private boolean isRun;
	private JLabel timer = new JLabel();

	private JButton reset = new JButton("start");

	private final int SIZE = 5;
	private Horse[] horses = new Horse[SIZE];

	private int rank;

	public RacingPanel() {
		setLayout(null);
		setBounds(0, 0, Race.WIDTH, Race.HEIGHT);

		setTimer();
		setBtn();
		setGame();
	}

	private void setGame() {
		this.rank = 1;
		this.ms = 0;
		this.timer.setText("ready");

		int x = 30;
		int y = 120;

		for (int i = 0; i < this.SIZE; i++) {
			this.horses[i] = new Horse(i + 1, x, y, 120, 90, String.format("images/horse%d.png", i + 1));
			y += 100;
		}
	}

	private void setBtn() {
		this.reset.setBounds(30, 50, 100, 50);
		this.reset.addActionListener(this);
		add(this.reset);
	}

	private void setTimer() {

		this.timer.setBounds(135, 50, 100, 50);

		add(this.timer);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JButton) {
			JButton target = (JButton) e.getSource();

			if (target == this.reset) {
				this.isRun = !this.isRun; // this.isRun ? false : true;
				this.reset.setText(this.isRun ? "reset" : "start");

				if (this.isRun)
					setGame();
			}
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		// horses
		g.drawLine(30, 120, Race.WIDTH - 30, 120);
		for (int i = 0; i < this.SIZE; i++) {
			Horse h = this.horses[i];
			g.drawImage(h.getImage().getImage(), h.getX(), h.getY(), null);

			g.drawLine(30, h.getY() + h.getH(), Race.WIDTH - 30, h.getY() + h.getH());

			// rank
			if (h.getState() == h.GOAL) {
				g.setFont(new Font("", Font.PLAIN, 10));
				g.drawString(h.getRecord(), Race.WIDTH - 180, h.getY() + h.getH() / 2);
				g.setFont(new Font("", Font.BOLD, 20));
				g.drawString(h.getRank() + "등", Race.WIDTH - 180 - 30, h.getY() + h.getH() / 2);

			}

		}

		try {
			Thread.sleep(50);
		} catch (Exception e) {
			// TODO: handle exception
		}
		update();

		repaint();
	}

	private void update() {

		boolean goal = false;
		if (this.isRun) {
			// run
			for (int i = 0; i < this.SIZE; i++) {
				Horse h = this.horses[i];

				int jump = random.nextInt(10) * 3 + 3;
				int tempX = h.getX() + jump;

				if (h.getState() == h.Run) {

					// goal
					if (tempX >= Race.WIDTH - 30 - h.getW() && !goal) {
						h.setState(h.GOAL);
						h.setRecord(String.format("%4d.%3d", this.ms / 1000, this.ms % 1000));
						h.setRank(this.rank);
						this.rank++;
						goal = !goal;

					} else if (tempX >= Race.WIDTH - 30 - h.getW()) {
						i--;
						// 되돌아가는 말이 발생할 경우 -> ms 홀딩하는 별수 활용하기
						break;
					}
					h.setX(tempX);
				}

			}

		}

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {

			if (isRun) {
				this.ms++;
				this.timer.setText(String.format("%3d,%3d", this.ms / 1000, this.ms % 1000));
			}

			try {
				Thread.sleep(1);
			} catch (Exception e) {
				// TODO: handle exception
			}

		}
	}

}
