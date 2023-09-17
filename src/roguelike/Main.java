package roguelike;

import roguelike.game.GameWindow;
import roguelike.utils.logger.SingletonSimpleLogger;

public class Main {

	public static void main(String[] args) {
		// ロガー初期化：ログ出力ディレクトリ指定
		SingletonSimpleLogger.Initialize("logs/");
		var logger = SingletonSimpleLogger.getLogger();
		logger.info(Main.class.getName() + " : This game is starting...");
		
		GameWindow main_window = new GameWindow("Develop Window", 1280, 640);
		main_window.setVisible(true);
		main_window.run();
		
		logger.info(Main.class.getName() + " : Exit the game.");
		SingletonSimpleLogger.Finalize();
	}

}
