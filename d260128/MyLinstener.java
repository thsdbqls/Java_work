package d260128;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MyLinstener extends WindowAdapter implements WindowListener {

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
	
}
