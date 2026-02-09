package d260128;

import java.awt.Button;
import java.awt.FlowLayout;

import javax.swing.JFrame;

public class Main9 {

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setBounds(1000, 0, 300, 500);
		f.setTitle("");
		f.setLayout(new FlowLayout());
		f.setVisible(true);
		
		f.add(new Button("열기"));

	}

}

