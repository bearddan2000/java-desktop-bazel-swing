package example;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Main extends JFrame {
	int clicks = 0;
	private JButton button;
	public Main() {
		setTitle("JButton Text Change");
		setLayout(new FlowLayout());
		button = new JButton("Clicks " + clicks);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String text = button.getText();
				text = text.replaceAll("\\d+", "" + (++clicks));
				button.setText(text);
			}
		});
		add(button);
		setSize(400, 75);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Main();
	}
}
