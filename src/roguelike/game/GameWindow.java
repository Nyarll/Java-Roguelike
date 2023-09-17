package roguelike.game;

import javax.swing.JFrame;

public class GameWindow extends JFrame implements Runnable {

	public GameWindow(String title, int width, int height) {
		super(title);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.setSize(width, height);
		super.setLocationRelativeTo(null);
		super.setResizable(false);

		this.setName("GameWindow");
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(5);
				this.repaint();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//System.exit(0);
	}

}
