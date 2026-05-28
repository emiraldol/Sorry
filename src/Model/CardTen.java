package Model;

import java.util.ArrayList;

/**
 * Main class for card ten
 */
public class CardTen extends Card{

	/**
	 * Main Constructor for card ten
	 */
	public CardTen()
	{
		setDescription(10);
		setTexture("Images/card10.png");
	}
	public void hello()
	{
		System.out.println("geia?");
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
	public int getDescription() {
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
		if(steps<=55 && newindex!=otherindex)
		{
			return 1;
		}
		
		return 0;
	}
	
	
	public  int checkmovement2(int newindex,int otherindex,int steps,int othersteps,ArrayList<Player> players,int nowindex)
	{
		if(steps==0)
		{
			return 0;
		}
		else if(newindex==65)
		{
			return 1;
		}
		if(steps<=59 && newindex!=otherindex)
		{
			return 1;
		}
		
		return 0;
	}
	
}
