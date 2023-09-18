package roguelike.utils.input;

import roguelike.utils.Singleton;

public final class InputManager implements Singleton {
	private static InputManager _instance = null;
	private InputKeyboard _keyListener = null;

	private InputManager() {
		_keyListener = new InputKeyboard();
	}

	public static void Initialize() {
		if (isNullInstance()) {
			_instance = new InputManager();
		}
	}

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
