package roguelike.utils.input;

import roguelike.utils.Singleton;

/**
 * デバイスからの入力を管理する
 * シングルトンパターン
 * @author UNLUCKY0314
 *
 */
public final class InputManager implements Singleton {
	private static InputManager _instance = null;
	private InputKeyboard _keyListener = null;

	private InputManager() {
		_keyListener = new InputKeyboard();
	}
	
	/**
	 * 初期化
	 */
	public static void Initialize() {
		if (isNullInstance()) {
			_instance = new InputManager();
		}
	}

	/**
	 * 終了時に呼び出す
	 */
	public static void Finalize() {
		_instance = null;
	}

	/**
	 * instanceを取得
	 * @return
	 */
	public static InputManager getInstance() {
		// TODO: _instanceがnullなら例外を投げる
		return _instance;
	}

	/**
	 * KeyListenerを取得
	 * @return
	 */
	public InputKeyboard getKeyListener() {
		return _keyListener;
	}

	/**
	 * nullチェック
	 * @return
	 */
	private static boolean isNullInstance() {
		return (_instance == null);
	}

	public boolean IsKeyPressed(int keyCode) {
		return _keyListener.IsKeyPressed(keyCode);
	}
}
