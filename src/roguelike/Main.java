package roguelike;

import roguelike.game.Game;
import roguelike.utils.logger.SingletonSimpleLogger;

public class Main {

	public static void main(String[] args) {
		// ロガー初期化：ログ出力ディレクトリ指定
		SingletonSimpleLogger.Initialize("logs/");
		var logger = SingletonSimpleLogger.getLogger();
		logger.info(Main.class.getName() + " : This game is starting...");
		
		try {
			Game game = new Game("./config/config.json");
		} catch (Exception e) {
			e.printStackTrace();
			logger.exception("An exception has occurred. ", e);
		}
		logger.info(Main.class.getName() + " : Exit the game.");
		SingletonSimpleLogger.Finalize();
	}

}
