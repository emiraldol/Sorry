package Model;

import java.util.ArrayList;

import View.Welcome;
/**
 * Class Made for collecting all the info from the welcome window
 */
public class WelcomeModel implements Info{
	
	/**
	 * Method for terminated the proggram if user pressed quit
	 * @param Our main welcome view
	 * @pre the view should be valid and called this function only if players presses Quit
	 * @post terminate the proggram
	 */
	public void delete(Welcome field)
	{
		field.window.setVisible(false);
		field.window.dispose();
		System.exit(1);
	}
	/**
	 * Helper method making the Welcome window work propertly
	 * @param field
	 * @pre should be used only if player press the start button
	 * @post hide some jlabel and button and set some other on
	 */
	public void start(Welcome field)
	{
		field.QuitGame.setVisible(false);
		field.Logo.setVisible(false);
		field.StartGame.setVisible(false);
		field.WelcomeText.setVisible(false);
		field.Players.setVisible(true);
		field.ok.setVisible(true);
		field.fillText.setVisible(true);
		field.Howmany.setVisible(true);
		field.window.setVisible(true);
	}
	
	/**
	 * Method for checking how many players will play this time
	 * @return how many players
	 * @pre Should be used only if user press the enter button
	 * @post Hide some info and show some other and get us the players size
	 */
	public int GetPlayers(Welcome field)
	{
		int k;
		field.ok.setVisible(false);
		field.fillText.setVisible(false);
		field.Howmany.setVisible(false);
		field.Players.setVisible(false);
		field.window.setVisible(true);
		k=(int) field.Players.getValue();
		field.Player1.setVisible(true);
		field.Player2.setVisible(true);
		field.enter.setVisible(true);
		if(k==3)
		{
			field.Player3.setVisible(true);
		}
		else if(k==4)
		{
			field.Player3.setVisible(true);
			field.Player4.setVisible(true);
		}
		return k;
	}
	/**
	 * Method which get us info in players name and that colour are they
	 * @return ArrayList strings with players names
	 * @pre numofplayers should be valid(2 or 3 or 4) and this method called only if ok is pressed
	 * @post will get players info but will destroy our Welcome window 
	 */
	public ArrayList<String> GetNames(Welcome field,int numofplayers) {
		ArrayList<String> names=new ArrayList<String>();
		String name=field.Player1.getText();
		names.add(name);
		name=field.Player2.getText();
		names.add(name);
		if(numofplayers==3)
		{
			name=field.Player3.getText();
			names.add(name);
		}
		else if(numofplayers==4)
		{
			name=field.Player3.getText();
			names.add(name);
			name=field.Player4.getText();
			names.add(name);
		}
		field.window.dispose();
		return names;
	}
	
	
	
}
