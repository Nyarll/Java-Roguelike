package roguelike.game;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Game {
	private String title;
	private String version = "";

	private int width = 0;
	private int height = 0;

	JsonNode config_json = null;

	public Game(String config_path) throws Exception {
		importConfig(config_path);
		GameWindow main_window = new GameWindow(title + " " + version, width, height);
		main_window.setVisible(true);

		main_window.run();
	}

	private void importConfig(String config_path) throws IOException {
		Path path = Paths.get(config_path);
		ObjectMapper obj_mapper = new ObjectMapper();

		config_json = obj_mapper.readTree(path.toFile());
		settingConfig();
	}
	
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
