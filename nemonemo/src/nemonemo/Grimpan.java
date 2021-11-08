package nemonemo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class Grimpan extends JFrame implements ActionListener {

	private Content con = new Content();

	public Grimpan() {
		super("±×¸²ÆÇ");
		setLayout(null);
		setBounds(100, 100, 900, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		add(con);

		setVisible(true);
		revalidate();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == con.close)
			this.dispose();
	}

}
