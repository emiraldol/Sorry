package Model;

import java.util.ArrayList;

/**
 * Abstract class for Our Cards
 */
public abstract class Card {
	/*Variables we need */
	protected int Description;
	protected String Texture;
	
	
	/**
	 * Accessor method that check the movement of every card
	 * @param newindex
	 * @param otherindex
	 * @param steps
	 * @param othersteps
	 * @param players
	 * @param nowindex
	 * @return
	 */
	public abstract int checkmovement(int newindex,int otherindex,int steps,int othersteps,ArrayList<Player> players,int nowindex);

	/**
	 * Setter method for setting the texture
	 * @pre texutre should exist and be valid
	 * @post will set the texture to that texture
	 */
	abstract public void setTexture(String texture);
	
	/**
	 * Setter method for setting the description of the card
	 * @pre des should be string and short
	 * @post set this description to des
	 */
	abstract  void setDescription(int des);
	
	/**
	 * Accessor method that return that card description
	 * @post return the description
	 * @return short info about the card
	 */
	abstract public  int getDescription();
	
	/**
	 * Accessor method that return the path for the texture of the card
	 * @post return the path from images
	 * @return String
	 */
	abstract public String GetTexture();
}
