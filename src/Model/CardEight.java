package Model;

import java.util.ArrayList;

/**
 * Main class for CardEight
 */
public class CardEight extends Card{
	
	/**
	 * Main constructor that creates the card and put the description
	 */
	CardEight()
	{
		setDescription(8);
		setTexture("Images//card8.png");
		
	}
	
	/*Override methods */
	@Override
	public
	void setTexture(String texture) {
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


	@Override
	public String GetTexture() {
		return this.Texture;
	}

	@Override
	public  int checkmovement(int newindex,int otherindex,int steps,int othersteps,ArrayList<Player> players,int nowindex)
	{
		if(steps==0 && nowindex==-1)
		{
			return 0;
		}
		else if(newindex==65)
		{
			return 1;
		}
		if(steps<=57 && newindex!=otherindex)
		{
			return 1;
		}
		
		return 0;
	}
	

}
