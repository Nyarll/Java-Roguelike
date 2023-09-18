package roguelike.utils.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * KeyboardListener
 * @author UNLUCKY0314
 *
 */
public class InputKeyboard implements KeyListener {
	private boolean isAnyKeyPressed = false;
	private boolean[] isKeyPressed = new boolean[KeyEvent.KEY_LAST];

	/**
	 * コンストラクタ
	 */
	public InputKeyboard() {
		super();
		for (int i = 0; i < isKeyPressed.length; i++) {
			isKeyPressed[i] = false;
		}
	}

	/**
	 * 特定のキーが押されているか
	 * @param keyCode
	 * @return
	 */
	public boolean IsKeyPressed(int keyCode) {
		if (keyCode >= KeyEvent.KEY_LAST)
			return false;

		return isKeyPressed[keyCode];
	}
	
	/**
	 * 何かのキーが押されているか
	 * @return
	 */
	public boolean IsAnyKeyPressed() {
		return isAnyKeyPressed;
	}

	// 押したとき
	@Override
	public void keyPressed(KeyEvent e) {
		isAnyKeyPressed = true;
		isKeyPressed[e.getKeyCode()] = true;
	}

	// 押されている間
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	// 離したとき
	@Override
	public void keyReleased(KeyEvent e) {
		isAnyKeyPressed = false;
		isKeyPressed[e.getKeyCode()] = false;
	}

}
