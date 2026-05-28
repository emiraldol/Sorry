package Model;

import java.util.ArrayList;

/**
 * Main class for Card two
 */
public class CardTwo extends Card{

	/**
	 * Main constructor for card two
	 */
	public CardTwo()
	{
		setDescription(2);
		setTexture("Images//card2.png");
	}
	@Override
	public
	void setTexture(String texture) 
	{
		this.Texture=texture;
	}

	@Override
	void setDescription(int des) {
		this.Description=des;
		
	}

	public
	int getDescription() {
		return this.Description;

	}

	public String GetTexture() 
	{
		return this.Texture;
	}
	@Override
	public  int checkmovement(int newindex,int otherindex,int steps,int othersteps,ArrayList<Player> players,int nowindex)
	{
		if(steps==0 &&newindex!=otherindex)
		{
			return 1;
		}
		else if(newindex==65)
		{
			return 1;
		}
		else if(steps<=63 && newindex!=otherindex)
		{
			return 1;
		}
		return 0;
	}
	
	
}
