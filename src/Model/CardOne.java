package Model;

import java.util.ArrayList;

/**
 * Class for CardOne
 */
public class CardOne extends Card{
	/**
	 * Main constructor for card one
	 */
	public CardOne()
	{
		setDescription(1);
		setTexture("Images//card1.png");
	}
	public
	String GetTexture() 
	{
		return this.Texture;
	}

	public void setTexture(String texture) 
	{
		this.Texture=texture;
		
	}
	void setDescription(int des) {
		this.Description=des;
		
	}
	public int getDescription() 
	{
		return this.Description;
	}
	
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
		else if(steps<65 && newindex!=otherindex)
		{
			return 1;
		}
		return 0;
	}
}

