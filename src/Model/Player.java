package Model;

/**
 * Player class which us help us with players info
 */
public class Player {
	/*All our variables we need */
	private String Name;
	private String Colour;
	public Pawn Pawn1;
	public Pawn Pawn2;
	private int turn;
	/**
	 * Main constructor
	 * @param String Color which represent which team he is on
	 * @param turns is the turn he plays(1 for first ,2 for second etc..)
	 * @param name is his name 
	 */
	public Player(String color,int turns,String name)
	{
		/*All setters set the values */
		setTurn(turns);
		setcolour(color);
		Setname(name);
		Pawn1=new Pawn(color);
		Pawn2=new Pawn(color);
	}
	/**
	 * Accessor method return the name
	 * @return
	 * @pre -
	 * @post return the name
	 */
	
	public int returnturn()
	{
		return this.turn;
	}
	
	
	
	String Getname()
	{
		return this.Name;
	}
	/**
	 * Setter method setting the name 
	 * @param String name
	 * @pre Name should be String
	 * @post player will have that name
	 */
	public void Setname(String name)
	{
		this.Name=name;
	}
	/**
	 * Setter method setting which color he represent
	 * @param color
	 * @pre color must be String
	 * @post player will represent that color
	 */
	public void setcolour(String color)
	{
		this.Colour=color;
	}
	/**
	 * Accessor method returning the color of the player
	 * @return Color
	 * @pre -
	 * @post return the color 
	 */
	public String getPlayerColor()
	{
		return this.Colour;
	}
	/**
	 * Setter method for setting what turn the player plays
	 * @param int turn 
	 * @pre turn must be int 
	 * @post set that turn to the player
	 */
	public void setTurn(int turn)
	{
		this.turn=turn;
	}
	/**
	 * Observer method checking if it that player turn
	 * @param int turn to compare with
	 * @return boolean
	 * @pre turn must be int and not bigger than 4 or smaller than 0
	 */
	public Boolean Myturn(int turn)
	{
		if(turn==this.turn)
		{
			return true;
		}
		return false;
	}
	
	
	
	
	
}
