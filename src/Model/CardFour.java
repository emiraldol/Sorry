package Model;

import java.util.ArrayList;

/**
 * Main class for CardFour
 */
public class CardFour extends Card{

	/**
	 * Main constructor for Card four
	 */
	public CardFour()
	{
		setDescription(4);
		setTexture("Images//card4.png");
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
		if(steps==0 && nowindex==-1)
		{
			return 0;
		}
		if(steps<=59 && newindex!=otherindex)
		{
			return 1;
		}
		
		return 0;
	}
	

	
}
