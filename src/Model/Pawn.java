package Model;



/**
 * Our Pawn class everything that has with Pawn
 */
public class Pawn implements PlayerPawn{
	/*Some variables we need (i will need more in B phase )*/
	public int steps;
	public int index;
	/**
	 * Main overloaded constructor
	 * @param String color
	 * @pre color should be String and valid
	 * @post calling all the setters!
	 */
	Pawn(String color)
	{
		GetFirstPawnImageSource(color);
		GetSecondPawnImageSource(color);
		setzero();
	}
	
	public int getsteps()
	{
		return this.steps;
	}
	public int getindex()
	{
		return this.index;
	}
	
	public void setzero()
	{
		this.steps=0;
		this.index=-1;
	}
	

	public void setindex(int index)
	{
		
		this.index=index;
		
	}
	
	public void setsteps(int steps)
	{
		this.steps+=steps;
	}
	

	
	/*Ovveride methods from interface */
	public String GetFirstPawnImageSource(String color) {
		if(color.equals("RED"))
		{
			return "Images\\redPawn1.png";
		}
		else if(color.equals("YELLOW"))
		{
			return "Images\\yellowPawn1.png";
		}
		else if(color.equals("GREEN"))
		{
			return "Images\\GreenPawn1.png";
		}
		else
		{
			return "Images\\BluePawn1.png";
		}
		
	}
	/**
	 * Setter method setting the player to a specific square
	 * @param index
	 * @pre index shouldnt be over 60!
	 * @post that pawn will be set to that index
	 */

	/*Second ovverride method */
	public String GetSecondPawnImageSource(String color) {
		if(color.equals("RED"))
		{
			return "Images\\redPawn2.png";
		}
		else if(color.equals("YELLOW"))
		{
			return "Images\\yellowPawn2.png";
		}
		else if(color.equals("GREEN"))
		{
			return "Images\\GreenPawn2.png";
		}
		else
		{
			return "Images\\BluePawn2.png";
		}
		
	}
	
	


}
