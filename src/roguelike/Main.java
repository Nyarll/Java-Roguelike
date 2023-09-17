package roguelike;

import roguelike.game.GameWindow;

public class Main {

	public static void main(String[] args) {
		GameWindow main_window = new GameWindow("Develop Window", 1280, 640);
		main_window.setVisible(true);
		main_window.run();
	}

}
