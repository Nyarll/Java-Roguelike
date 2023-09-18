package roguelike.game;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * ゲーム本体クラス
 * @author UNLUCKY0314
 *
 */
public class Game {
	private String title;
	private String version = "";

	private int width = 0;
	private int height = 0;

	JsonNode config_json = null;

	/**
	 * コンストラクタ
	 * @param config_path コンフィグファイルのパス
	 * @throws Exception
	 */
	public Game(String config_path) throws Exception {
		importConfig(config_path);
		GameWindow main_window = new GameWindow(title + " " + version, width, height);
		main_window.setVisible(true);

		main_window.run();
	}

	/**
	 * コンフィグファイルを読み込み、設定する
	 * @param config_path
	 * @throws IOException
	 */
	private void importConfig(String config_path) throws IOException {
		Path path = Paths.get(config_path);
		ObjectMapper obj_mapper = new ObjectMapper();

		config_json = obj_mapper.readTree(path.toFile());
		settingConfig();
	}
	
	/**
	 * 読み込んだ設定を反映
	 */
	private void settingConfig() {
		JsonNode window_config = config_json.get("GameWindowConfig");
		title = window_config.get("title").asText();
		version = window_config.get("version").asText();
		width = window_config.get("width").asInt();
		height = window_config.get("height").asInt();
	}
	
	public void finalize() {
		// 終了時にしなければいけないことをする
	}
}
