package roguelike.game;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

import roguelike.utils.input.InputManager;
import roguelike.utils.logger.SingletonSimpleLogger;

/**
 * GameWindowクラス
 * Windowを管理する
 * @author UNLUCKY0314
 *
 */
public class GameWindow extends JFrame implements Runnable, WindowListener {
	boolean gameActive = true;

	/**
	 * コンストラクタ
	 * @param title タイトル
	 * @param width 画面幅
	 * @param height 画面高さ
	 */
	public GameWindow(String title, int width, int height) {
		super(title);
		super.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		super.addWindowListener(this);
		super.setSize(width, height);
		super.setLocationRelativeTo(null);
		super.setResizable(false);

		this.setName("GameWindow");

		//InputManager.Initialize();
		this.addKeyListener(InputManager.getInstance().getKeyListener());
		
		Container contentPane = this.getContentPane();
		contentPane.setBackground(Color.BLACK);
	}

	@Override
	public void run() {
		var logger = SingletonSimpleLogger.getLogger();
		while (gameActive) {
			try {
				Thread.sleep(5);
				if (InputManager.getInstance().IsKeyPressed(KeyEvent.VK_ESCAPE)) {
					logger.info("Pressed Key : [ESCAPE] Key");
				}
				this.repaint();
			} catch (Exception e) {
				e.printStackTrace();
				logger.exception("Exception occured.", e);
			}
		}
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
		InputManager.Finalize();
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
