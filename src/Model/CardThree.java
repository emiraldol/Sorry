package Model;

import java.util.ArrayList;

/**
 * Class for our card three
 */
public class CardThree extends Card{
	
	/**
	 * Main constructor for card three
	 */
	public CardThree()
	{
		setDescription(3);
		setTexture("Images//card3.png");
	}
	
	/*Override methods */
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

	@Override
	public
	int getDescription() {
		return this.Description;
	}

	@Override
	public
	String GetTexture() {
		return this.Texture;
	}

	@Override
	public  int checkmovement(int newindex,int otherindex,int steps,int othersteps,ArrayList<Player> players,int nowindex)
	{
		if(steps==0 &&nowindex==-1)
		{
			return 0;
		}
		else if(newindex==65)
		{
			return 1;
		}
		if(steps<=62 && newindex!=otherindex)
		{
			return 1;
		}
		
		return 0;
	}
 
}
