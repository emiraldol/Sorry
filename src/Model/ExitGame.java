package Model;

import View.Board;
/**
 * Small class that end the game window only
 */
public class ExitGame {
	/**
	 * Static method for terminating the game window
	 * @param the game
	 * @pre should be used only if user pressed quit game!
	 * @post terminate the proggram
	 */
	public static  void gameend (Board game)
	{
		game.window.setVisible(false);
		game.window.dispose();
		System.exit(0);
	}
	
}
