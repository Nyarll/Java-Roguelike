package roguelike.game;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

import roguelike.utils.logger.SingletonSimpleLogger;

public class GameWindow extends JFrame implements Runnable, WindowListener {
	boolean gameActive = true;

	public GameWindow(String title, int width, int height) {
		super(title);
		super.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		super.addWindowListener(this);
		super.setSize(width, height);
		super.setLocationRelativeTo(null);
		super.setResizable(false);

		this.setName("GameWindow");
	}

	@Override
	public void run() {
		var logger = SingletonSimpleLogger.getLogger();
		while (gameActive) {
			try {
				Thread.sleep(5);
				this.repaint();
			} catch (Exception e) {
				e.printStackTrace();
				logger.exception("Exception occured.", e);
			}
		}
		//System.exit(0);
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		gameActive = false;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

}
