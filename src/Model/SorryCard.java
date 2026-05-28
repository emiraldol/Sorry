package Model;

import java.util.ArrayList;

/**
 * Main class for Sorry Card
 */
public class SorryCard extends Card{
	/**
	 * 
	 * Main Constructor for SorryCard
	 */
	public SorryCard()
	{
		setTexture("Images//cardSorry.png");
		setDescription(13);
	}
	/**
	 *Trade is a method helping us trade
	 * @param p is the player we want to trade with
	 * @param pawn is our pawn we will trade
	 * @pre we should get the right player and choose the right pawn before trading
	 * @post trade will be done
	 */
	public void trade(Player p,Pawn pawn)
	{
		
	}
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
	public  int checkmovement(int newindex,int otherindex,int steps,int othersteps,ArrayList<Player> players,int nowindex){
		if(nowindex==-1 && steps==0)
		{
			return 1;
			
		}
		return 0;
	}
	
}
