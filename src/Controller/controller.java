package Controller;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import Model.Card;
import Main.Main;
import Model.Deck;
import Model.ExitGame;
import Model.Player;
import Model.WelcomeModel;
import View.Board;
import View.Welcome;
import View.Winner;


/**
 * Our main controller which controls everything
 */
public class controller 
{
	/*Same viarables we need to start our game */
	Board game;
	Welcome welcome;
	ArrayList<String> PlayerNames;
	ArrayList<Player> Players;
	ArrayList<Card> cards;
	Deck deck;
	int numbofcard=43;
	int TotalPlayers=0;
	int turn=0;
	int result;
	int repeat=0;
	int finalmove=-1;
	int draw=1;
	int check=0;
	int redraw=0;
	int fold=0;
	int result2=0;
	int options=0;
	int trader=0;
	int tobetraded=0;
	int pawn=0;
	int eleven=0;
	Winner window;



	
	private void changeturn()
	{
		this.turn++;
		if(this.turn>this.TotalPlayers)
		{
			turn=1;
		}
	}
	
	/**
	 * A method which transfer us from Welcome window to our Game 
	 * @param Board which is our main window(view)
	 * @param numofplayers is number of players playing this time
	 * @return ArrayList<Player> All our players info!
	 * @pre numofplayers should be >=2 and the Board field should be set correctly
	 * @post All players info will be return!
	 */
	private ArrayList<Player>  makeGame(Board field,int numofplayers)
	{
		/*Collect all the players info one by one */ 
		ArrayList<Player> newplayers=new ArrayList<Player>();
		Player player1=new Player("RED",1,PlayerNames.get(0));
		String msg="Info Box \nTurn:Player " +player1.returnturn()+" ("+player1.getPlayerColor()+")"+ " name:"+PlayerNames.get(0);
		msg=msg+"\nCards Left:44";
		msg=msg+"\nPlease Receive A Card";
		turn++;
		field.Info.setText(msg);
		field.Info.setEditable(false);
		field.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
		Player player2=new Player("YELLOW",2,PlayerNames.get(1));
		newplayers.add(player1);
		newplayers.add(player2);
		/*If PLayers are three (red,yellow,green) then setvisible blue Pawns also */
		if(numofplayers==3)
		{
			Player player3=new Player("GREEN",3,PlayerNames.get(2));
			newplayers.add(player3);
			field.BluePawn1.setVisible(false);
			field.BluePawn2.setVisible(false);
		}
		/*If 4 don't set visible anything(They are by default visible!*/ 
		else if(numofplayers==4)
		{
			Player player3=new Player("GREEN",3,PlayerNames.get(2));
			newplayers.add(player3);
			Player player4=new Player("BLUE",4,PlayerNames.get(3));
			newplayers.add(player4);
		}
		else
		{
			/*Else we are playing 1vs1 so set visible to Blue Pawns and Green ones! */
			field.BluePawn1.setVisible(false);
			field.BluePawn2.setVisible(false);
			field.GreenPawn1.setVisible(false);
			field.GreenPawn2.setVisible(false);
		}
		
		return newplayers;
	}
	/**
	 * Constructor which will start eveything
	 */
	public controller()
	{
		/*Create A welcome window first and set action listeners to our welcome graphics*/
		welcome=new Welcome();
		welcome.setActionListeners(new ButtonHandlerforwelcome());
		
	}
	/**
	 * Class which is responsible for Welcome window buttons only!
	 */
	class buttonHandler implements ActionListener
	{
		/*Action if Quit button is pressed */
		public void actionPerformed(ActionEvent e) 
		{
			
			if(e.getSource()==game.ExitGame)
			{
				ExitGame.gameend(game);
			}
			/*Or if start new game is pressed */
			else if(e.getSource()==game.NewGameButton)
			{
				/*Start Everything from start !*/
				game.window.dispose();
				Main.main(null);
			}
			/*if Somebody start Playing the card he/she draw */
			else if(e.getSource()==game.CurrectCard)
			{
				if(turn==deck.getturn()&& check==1)
				{
						check=0;
						String msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
						if(cards.get(numbofcard).getDescription()==10)
						{
							result=deck.checkmoves(cards.get(numbofcard),Players.get(turn-1),game, Players,1);
							if(result!=0)
							{

								 msg+="\nYou can choose 10 forward!\nBy clicking 10";
								game.Option1.setText("10");
								game.Option1.setVisible(true);
								options=1;
							}
							result2=deck.checkmoves(cards.get(numbofcard),Players.get(turn-1),game, Players,2);
							if(result2!=0)
							{
								msg+="\nYou can choose -1 Backwards\nBy clicking -1!";
								game.Option2.setText("-1");
								game.Option2.setVisible(true);
								options=1;
							}
							if(result==0 &&result2==0)
							{
								msg=msg+"\nCards Left:"+(numbofcard+1);
								fold=1;
								msg+="\nYou can't play anything\nPlease end your turn\nBy pressing fold!";
								options=0;
							}
							game.Info.setEditable(false);
							game.Info.setText(msg);
							game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
							return;
							
						}
						else if(cards.get(numbofcard).getDescription()==11)
						{
							result=deck.checkmoves(cards.get(numbofcard),Players.get(turn-1),game, Players,1);
							if(result!=0)
							{
								if(result==1)
								{
									fold=0;
									 msg+="\nYou can move Pawn1 11 forward";
								}
								else if(result==2)
								{
									fold=0;
									 msg+="\nYou can move Pawn2 11 forward";
								}
								else if(result==3)
								{
									fold=0;
									 msg+="\nYou can move Pawn2 or Pawn1 11 forward";
								}
								 msg+="\nYou can choose 11 forward by clicking 11";
								game.Option1.setText("11");
								game.Option1.setVisible(true);
							}
							result2=deck.checkmoves(cards.get(numbofcard),Players.get(turn-1),game, Players,2);
							if(result2!=0)
							{
								if(result!=0)
								{
									eleven=1;
								}
								int total=0;
								for(int i=0;i<Players.size();i++)
								{
									if(i!=turn-1)
									{
										int indexpawn1=Players.get(i).Pawn1.getindex();
										int indexpawn2=Players.get(i).Pawn2.getindex();
										if(indexpawn1<=59 && indexpawn1!=-1)
										{
											if(i==0)
											{
												msg+="\nYou can replace with Pawn1 Red";
											}
											else if(i==1)
											{
												msg+="\nYou can replace with Pawn1 Yellow";
											}
											else if(i==2)
											{
												msg+="\nYou can replace with Pawn1 Green";
											}
											else if(i==3)
											{
												msg+="\nYou can replace with Pawn1 Blue";
											}
											total++;
										}
										if(indexpawn2<=59 && indexpawn2!=-1)
										{
											if(i==0)
											{
												msg+="\nYou can replace with Pawn2 Red";
											}
											else if(i==1)
											{
												msg+="\nYou can replace with Pawn2 Yellow";
											}
											else if(i==2)
											{
												msg+="\nYou can replace with Pawn2 Green";
											}
											else if(i==3)
											{
												msg+="\nYou can replace with Pawn2 Blue";
											}
											total++;
										}
										
										}
									}
								if(total!=0)
								{
									if(result2==1)
									{
										msg+="\nYou can replace Pawn1";
										msg+="\nYou can choose to replace \nBy clicking R!";
										game.Option2.setText("R");
										game.Option2.setVisible(true);
									}
									else if(result2==2)
									{
										msg+="\nYou can replace Pawn2";
										msg+="\nYou can choose to replace by clicking R!";
										game.Option2.setText("R");
										game.Option2.setVisible(true);
									}
									else
									{
										msg+="\nYou can replace Pawn1 or Pawn2";
										msg+="\nYou can choose to replace \nBy clicking R!";
										game.Option2.setText("R");
										game.Option2.setVisible(true);
									}
								}				
							}
							if(result==0 &&result2==0)
							{
								msg=msg+"\nCards Left:"+(numbofcard+1);
								fold=1;
								msg+="\nYou can't play anything\nPlease end your turn\nBy pressing fold!";
								options=0;
							}
							if(eleven==1)
							{
								msg+="\nYou can also fold";
							}
							game.Info.setEditable(false);
							game.Info.setText(msg);
							game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
							return;
						}
						
						else if(cards.get(numbofcard).getDescription()==13)
						{
							result=deck.checkmoves(cards.get(numbofcard),Players.get(turn-1),game, Players,0);
							trader=1;
							int total=0;
							if(result==0)
							{
								msg=msg+"\nCards Left:"+(numbofcard+1);
								fold=1;
								trader=0;
								finalmove=0;
								msg+="\nYou can't play anything\nPlease end your turn\nBy pressing fold!";
								game.Info.setEditable(false);
								game.Info.setText(msg);
								game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
								return;
							}
							
							else if(result!=0)
							{
								for(int i=0;i<Players.size();i++)
								{
									if(i!=turn-1)
									{
										int indexpawn1=Players.get(i).Pawn1.getindex();
										int indexpawn2=Players.get(i).Pawn2.getindex();
										if(indexpawn1<=59 && indexpawn1!=-1)
										{
											if(i==0)
											{
												msg+="\nYou can replace with Pawn1 Red";
											}
											else if(i==1)
											{
												msg+="\nYou can replace with Pawn1 Yellow";
											}
											else if(i==2)
											{
												msg+="\nYou can replace with Pawn1 Green";
											}
											else if(i==3)
											{
												msg+="\nYou can replace with Pawn1 Blue";
											}
											total++;
										}
										if(indexpawn2<=59 && indexpawn2!=-1)
										{
											if(i==0)
											{
												msg+="\nYou can replace with Pawn2 Red";
											}
											else if(i==1)
											{
												msg+="\nYou can replace with Pawn2 Yellow";
											}
											else if(i==2)
											{
												msg+="\nYou can replace with Pawn2 Green";
											}
											else if(i==3)
											{
												msg+="\nYou can replace with Pawn2 Blue";
											}
											total++;
										}
										
										}
									}
								if(total!=0)
								{
									if(result==1)
									{
										msg+="\nYou should replace Pawn1";
									}
									else if(result==2)
									{
										msg+="\nYou should replace Pawn2";
									}
									else
									{
										msg+="\nYou can replace Pawn1 or Pawn2";
									}
									trader=1;
									result=0;
									finalmove=0;
								}
								else
								{
									msg=msg+"\nCards Left:"+(numbofcard+1);
									fold=1;
									msg+="\nYou can't play anything\nPlease end your turn\nBy pressing fold!";
									options=0;
									trader=0;
									result=0;
									game.Info.setEditable(false);
									game.Info.setText(msg);
									game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
									return;
								}
							}
							game.Info.setEditable(false);
							game.Info.setText(msg);
							game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
							return ;
						}
						result=deck.checkmoves(cards.get(numbofcard),Players.get(turn-1),game, Players,0);
						if(result==1)
						{
							msg=msg+"\nCards Left:"+(numbofcard+1);
							finalmove=cards.get(numbofcard).getDescription();
							if(cards.get(numbofcard).getDescription()==4)
							{
								finalmove=-4;
							}
							msg+="\nYou can play only the Pawn 1\nPlease click on it and end your turn";
							
						}
						else if(result==2)
						{
							msg=msg+"\nCards Left:"+(numbofcard+1);
							finalmove=cards.get(numbofcard).getDescription();
							if(cards.get(numbofcard).getDescription()==4)
							{
								finalmove=-4;
							}
							msg+="\nYou can play only the Pawn 2\nPlease click on it and end your turn";
						}
						else if(result==3)
						{
							if(cards.get(numbofcard).getDescription()==3 || cards.get(numbofcard).getDescription()==5)
							{
								msg=msg+"\nCards Left:"+(numbofcard+1);
								finalmove=cards.get(numbofcard).getDescription();
								msg+="\nYou Should Play Both Pawns\nPlease click on both(one each time)!";
								repeat=3;
								result=0;
								
							}
							else
							{
								msg=msg+"\nCards Left:"+(numbofcard+1);
								finalmove=cards.get(numbofcard).getDescription();
								if(cards.get(numbofcard).getDescription()==4)
								{
									finalmove=-4;
								}
								msg+="\nYou can Play Both Pawns\nPlease click on which one\nyou want and end your turn";
							}
							
						}
						else if(result==0)
						{
							msg=msg+"\nCards Left:"+(numbofcard+1);
							fold=1;
							msg+="\nYou can't play anything\nPlease end your turn\nBy pressing fold!";
						}
						if(cards.get(numbofcard).getDescription()==8 || cards.get(numbofcard).getDescription()==12)
						{
							redraw=1;
							if(result==0)
							{
								msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
								msg=msg+"\nCards Left:"+(numbofcard+1);
								msg+="\nYou can't play your pawns,\nYou should forcefully draw";
							}
							else
							{
								msg+="\nYou can also draw\n";
							}
							
						}
						game.Info.setEditable(false);
						game.Info.setText(msg);
						game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
				}
			
			}
			/*If somebody press the Foldbutton */
			else if(e.getSource()==game.FoldButton)
			{
				if((turn==deck.getturn() && result==0 && redraw!=1 && fold==1)|| eleven==1)
				{
					if(eleven==1)
					{
						game.Option1.setVisible(false);
						game.Option2.setVisible(false);
					}
					deck.changeturn(TotalPlayers);
					changeturn();
					String msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
					msg=msg+"\nCards Left:"+(numbofcard+1);
					msg+="\nPlease Draw a Card\n";
					game.Info.setEditable(false);
					game.Info.setText(msg);
					game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
					draw=1;
					eleven=0;
					result=0;
					finalmove=0;
					fold=0;
				}
				else
				{
					String msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
					msg=msg+"\nCards Left:"+(numbofcard+1);
					msg=msg+"\nYou can't do that!";
					game.Info.setEditable(false);
					game.Info.setText(msg);
					game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
				} 
			}
			
			
			
			
			/*if Somebody start drawing */
			else if(e.getSource()==game.ReceiveCard)
			{
					 if(turn==deck.getturn() && draw==1)
					{
						numbofcard--;
						if(numbofcard<0)
						{
							numbofcard=43;
						}
						game.CurrectCard.setVisible(true);
						game.CurrectCard.setIcon(new ImageIcon(cards.get(numbofcard).GetTexture()));
						String msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
						msg=msg+"\nCards Left:"+(numbofcard+1);
						msg=msg+"\nYou draw:"+cards.get(numbofcard).getDescription()+"\nPlease click the Current Card Button \nto check if you can play!";
						game.Info.setEditable(false);
						game.Info.setText(msg);
						game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
						draw=0;
						check=1;
						redraw=0;
					}
					 else if(redraw==1)
					 {
						 numbofcard--;
							if(numbofcard<0)
							{
								numbofcard=43;
							}
							game.CurrectCard.setVisible(true);
							game.CurrectCard.setIcon(new ImageIcon(cards.get(numbofcard).GetTexture()));
							String msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
							msg=msg+"\nCards Left:"+(numbofcard+1);
							msg=msg+"\nYou draw:"+cards.get(numbofcard).getDescription()+"\nPlease click the Current Card Button \nto check if you can play!";
							game.Info.setEditable(false);
							game.Info.setText(msg);
							game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
							check=1;
							redraw=0;
							draw=0;
					 }
					 else
					 {
						 String msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
						msg=msg+"\nCards Left:"+(numbofcard+1);
						 msg+="\nYou can't do that!\n";
						game.Info.setEditable(false);
						game.Info.setText(msg);
						game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
					 }
				
			}
			/*If someone stop playing this game and continue where he left */
			else if(e.getSource()==game.ContinueSavedGame)
			{
				
			}
			/*If someone leave the game but saves it for next  time */
			else if(e.getSource()==game.SaveGameButton)
			{
				
			}
			else if(e.getSource()==game.Option1)
			{
				game.Option1.setVisible(false);
				game.Option2.setVisible(false);
				if(cards.get(numbofcard).getDescription()==10)
				{
					finalmove=10;
					options=0;
					String msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
					msg=msg+"\nCards Left:"+(numbofcard+1);
					msg+="\nYou choose 10 forward\n";
					if(result==1)
					{
						msg+="\nYou can playPawn1";
					}
					else if(result==2)
					{
						msg+="\nYou can PlayPawn2";
					}
					else
					{
						msg+="\nYou can play both Pawns";
					}
					game.Info.setEditable(false);
					game.Info.setText(msg);
					game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
				}
				else if(cards.get(numbofcard).getDescription()==11)
				{
					finalmove=11;
					options=0;
					eleven=0;
					trader=0;
					String msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
					msg=msg+"\nCards Left:"+(numbofcard+1);
					msg+="\nYou choose 11 forward\n";
					if(result==1)
					{
						msg+="\nYou can playPawn1";
					}
					else if(result==2)
					{
						msg+="\nYou can PlayPawn2";
					}
					else
					{
						msg+="\nYou can play both Pawns";
					}
					game.Info.setEditable(false);
					game.Info.setText(msg);
					game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
				}
			}
			else if(e.getSource()==game.Option2)
			{
				game.Option2.setVisible(false);
				game.Option1.setVisible(false);
				if(cards.get(numbofcard).getDescription()==10)
				{
					finalmove=-1;
					result=result2;
					result2=0;
					options=0;
					String msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
					msg=msg+"\nCards Left:"+(numbofcard+1);
					msg+="\nYou choose -1 backwards\n";
					if(result==1)
					{
						msg+="\nYou can playPawn1";
					}
					else if(result==2)
					{
						msg+="\nYou can PlayPawn2";
					}
					else
					{
						msg+="\nYou can play both Pawns";
					}
					game.Info.setEditable(false);
					game.Info.setText(msg);
					game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
				}
				if(cards.get(numbofcard).getDescription()==11)
				{
					trader=1;
					fold=0;
					eleven=0;
					draw=0;
					finalmove=0;
					result=result2;
					String msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
					msg=msg+"\nCards Left:"+(numbofcard+1);
					msg+="\nYou choose Trading\n";
					if(result==1)
					{
						msg+="\nYou can playPawn1";
					}
					else if(result==2)
					{
						msg+="\nYou can PlayPawn2";
					}
					else
					{
						msg+="\nYou can play both Pawns";
					}
					result=0;
					result2=0;
					game.Info.setEditable(false);
					game.Info.setText(msg);
					game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
				}
			}
		}
	}
	
	/**
	 *  Class which is responsible for Welcome window buttons only!
	 */
	class ButtonHandlerforwelcome implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			/*Helper class from model to modify our data */
			WelcomeModel info=new WelcomeModel();
			/*If quit game is pressed */
			if(e.getSource()==welcome.QuitGame)
			{
				info.delete(welcome);
			}
			/*Else if start game is pressed */
			else if(e.getSource()==welcome.StartGame)
			{
				info.start(welcome);
			}
			/*We take how many players are in */
			else if(e.getSource()==welcome.ok)
			{
				TotalPlayers=info.GetPlayers(welcome);
			}
			/*We take players real info (names and which team is they are */
			else if(e.getSource()==welcome.enter)
			{
				/*We delete our Welcome screen and we start our original game with the data we got! */
				PlayerNames=info.GetNames(welcome,TotalPlayers);
				game=new Board();
				deck=new Deck(game);
				cards=deck.createcards();
				deck.shuffleCards(cards);
				game.setoptions(new buttonHandler());
				game.setActionListeners(new buttonHandler());
				game.setMouseListeners(new Mouse());
				Players=makeGame(game,TotalPlayers);
			}
		}
	}
	class Mouse implements MouseListener
	{
		
		public void mouseClicked(MouseEvent e) {
			
			
			if(e.getSource()==game.RedPawn1)
			{	
				if(deck.getturn()==1 &&(check==0 && draw==0) &&options==0 &&trader==0 && (result==1 || result==3))
				{
					if(Players.get(0).Pawn1.getindex()==-1)
					{
						game.RedStartZone.remove(game.RedPawn1);
						game.RedPawn1.setVisible(false);
						if(game.RedStartZone.getComponentCount()==0)
						{
							game.RedStartZone.setVisible(false);
						}
					}
					int move;
					move=deck.move(finalmove, game, Players.get(0), 1, Players,this);
					deck.changeturn(TotalPlayers);
					changeturn();
					result=0;
					finalmove=0;
					draw=1;
					String msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
					msg=msg+"\nCards Left:"+(numbofcard+1);
					msg+="\nPlease Draw a Card\n";
					game.Info.setEditable(false);
					game.Info.setText(msg);
					game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
					deck.update(game, move,1);
				}
				else if(repeat==3 || repeat==1 && deck.getturn()==1)
				{
					int move=deck.move(finalmove, game, Players.get(0), 1, Players,this);
					result=0;
					repeat--;
					String msg="";
					if(repeat==0)
					{
						deck.changeturn(TotalPlayers);
						changeturn();
						msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
						msg=msg+"\nCards Left:"+(numbofcard+1);
						result=0;
						finalmove=0;
						msg+="\nPlease Draw a Card\n";
						draw=1;
					}
					else
					{
						msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
						msg=msg+"\nCards Left:"+(numbofcard+1);
						msg+="\nPlease Play Pawn2 also\n";
					}
					game.Info.setEditable(false);
					game.Info.setText(msg);
					game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
					deck.update(game, move,1);
				}
				
				
				else if(trader==1 &&deck.turn==1)
				{
					if(cards.get(numbofcard).getDescription()==11 &&Players.get(0).Pawn1.getindex()!=-1 &&Players.get(0).Pawn1.getsteps()!=0)
					{
						String msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
						msg=msg+"\nCards Left:"+(numbofcard+1);
						msg+="\nChoose to replace with!\n(Press current card to see options)!";
						check=1;
						game.Info.setEditable(false);
						game.Info.setText(msg);
						game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
						pawn=1;
						tobetraded=1;
					}
					else if(cards.get(numbofcard).getDescription()==11)
					{
						String msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
						msg=msg+"\nCards Left:"+(numbofcard+1);
						msg+="\nYou can't replace that pawn!\n";
						game.Info.setEditable(false);
						game.Info.setText(msg);
						game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
						trader=1;
					}
					
					 if(cards.get(numbofcard).getDescription()==13 &&Players.get(0).Pawn1.getindex()!=-1 &&Players.get(0).Pawn1.getsteps()!=0)
					{
						String msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
						msg=msg+"\nCards Left:"+(numbofcard+1);
						msg+="\nYou can't replace that pawn!\n";
						game.Info.setEditable(false);
						game.Info.setText(msg);
						game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
						trader=1;
					}
					else
					{
						String msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
						msg=msg+"\nCards Left:"+(numbofcard+1);
						msg+="\nChoose to replace with!\n(Press current card to see options)!";
						check=1;
						game.Info.setEditable(false);
						game.Info.setText(msg);
						game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
						pawn=1;
						tobetraded=1;
					}
				}
				else if(tobetraded==1 &&trader==1)
				{
					if(Players.get(0).Pawn1.getindex()!=-1 && Players.get(0).Pawn1.getindex()<=59)
					{
						deck.swap(pawn, 1, game,Players.get(0),Players.get(turn-1), Players, this);
						deck.changeturn(TotalPlayers);
						changeturn();
						String msg;
						msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
						msg=msg+"\nCards Left:"+(numbofcard+1);
						result=0;
						finalmove=0;
						tobetraded=0;
						msg+="\nPlease Draw a Card\n";
						draw=1;
						trader=0;

						game.Info.setEditable(false);
						game.Info.setText(msg);
						game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
					}
					else
					{
						String msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
						msg=msg+"\nCards Left:"+(numbofcard+1);
						msg+="\nYou can't replace that pawn!\n";
						game.Info.setEditable(false);
						game.Info.setText(msg);
						game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
					}
					
				}
					
			} 
			else if(e.getSource()==game.RedPawn2)
			{
				if(deck.getturn()==1 &&(check==0 && draw==0)&&options==0 &&trader==0 &&(result==2 || result==3))
				{
					if(Players.get(0).Pawn2.getindex()==-1)
					{
						game.RedStartZone.remove(game.RedPawn2);
						game.RedPawn2.setVisible(false);
						if(game.RedStartZone.getComponentCount()==0)
						{
							game.RedStartZone.setVisible(false);
						}
					}
					int move;
					move=deck.move(finalmove, game, Players.get(0), 2, Players,this);
					deck.changeturn(TotalPlayers);
					changeturn();
					result=0;
					finalmove=0;
					draw=1;
					String msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
					msg=msg+"\nCards Left:"+(numbofcard+1);
					msg+="\nPlease Draw a Card\n";
					game.Info.setEditable(false);
					game.Info.setText(msg);
					game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
					deck.update(game, move,2);
				}
				else if(repeat==3 || repeat==2 && deck.getturn()==1)
				{
					int move;
					move=deck.move(finalmove, game, Players.get(0), 2, Players,this);
					result=-1;
					repeat=repeat-2;
					String msg="";
					if(repeat==0)
					{
						deck.changeturn(TotalPlayers);
						changeturn();
						msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
						msg=msg+"\nCards Left:"+(numbofcard+1);
						msg+="\nPlease Draw a Card\n";
						result=0;
						finalmove=0;
						draw=1;
					}
					else
					{
						msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
						msg=msg+"\nCards Left:"+(numbofcard+1);
						msg+="\nPlease Play Pawn1 also\n";
					}
					game.Info.setEditable(false);
					game.Info.setText(msg);
					game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
					deck.update(game, move,2);
					
				}
				else if(trader==1 &&deck.turn==1)
				{
					if(cards.get(numbofcard).getDescription()==11 &&Players.get(0).Pawn2.getindex()!=-1 &&Players.get(0).Pawn2.getsteps()!=0)
					{
						String msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
						msg=msg+"\nCards Left:"+(numbofcard+1);
						msg+="\nChoose to replace with!\n(Press current card to see options)!";
						check=1;
						game.Info.setEditable(false);
						game.Info.setText(msg);
						game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
						pawn=2;
						tobetraded=1;
					}
					else if(cards.get(numbofcard).getDescription()==11)
					{
						String msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
						msg=msg+"\nCards Left:"+(numbofcard+1);
						msg+="\nYou can't replace that pawn!\n";
						game.Info.setEditable(false);
						game.Info.setText(msg);
						game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
					}
					
				 if(cards.get(numbofcard).getDescription()==13 &&Players.get(0).Pawn2.getindex()!=-1 &&Players.get(0).Pawn2.getsteps()!=0)
					{
						String msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
						msg=msg+"\nCards Left:"+(numbofcard+1);
						msg+="\nYou can't replace that pawn!\n";
						game.Info.setEditable(false);
						game.Info.setText(msg);
						game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
					}
					else
					{
						String msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
						msg=msg+"\nCards Left:"+(numbofcard+1);
						msg+="\nChoose to replace with!\n(Press current card to see options)!";
						check=1;
						game.Info.setEditable(false);
						game.Info.setText(msg);
						game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
						pawn=2;
						tobetraded=1;
					}
				}
				else if(tobetraded==1 &&trader==1)
				{
					if(Players.get(0).Pawn2.getindex()!=-1 && Players.get(0).Pawn2.getindex()<=59)
					{
						deck.swap(pawn, 2, game,Players.get(0),Players.get(turn-1), Players, this);
						deck.changeturn(TotalPlayers);
						changeturn();
						String msg;
						msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
						msg=msg+"\nCards Left:"+(numbofcard+1);
						result=0;
						finalmove=0;
						tobetraded=0;
						msg+="\nPlease Draw a Card\n";
						draw=1;
						trader=0;

						game.Info.setEditable(false);
						game.Info.setText(msg);
						game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
					}
					else
					{
						String msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
						msg=msg+"\nCards Left:"+(numbofcard+1);
						msg+="\nYou can't replace that pawn!\n";
						game.Info.setEditable(false);
						game.Info.setText(msg);
						game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
					}
					
				}
				
				
			} 
			else if(e.getSource()==game.YellowPawn1)
			{
				
				if(deck.getturn()==2 &&(check==0 && draw==0)&&options==0 &&trader==0 &&(result==1 || result==3))
				{
					if(Players.get(1).Pawn1.getindex()==-1)
					 {
						game.YellowStartZone.remove(game.YellowPawn1);
						game.YellowPawn1.setVisible(false);
						if(game.YellowStartZone.getComponentCount()==0)
						{
							game.YellowStartZone.setVisible(false);
						}
					} 
					int move;
					move=deck.move(finalmove, game, Players.get(1), 1, Players,this);
					deck.changeturn(TotalPlayers);
					changeturn();
					result=0;
					finalmove=0;
					draw=1;
					String msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
					msg=msg+"\nCards Left:"+(numbofcard+1);
					msg+="\nPlease Draw a Card\n";
					game.Info.setEditable(false);
					game.Info.setText(msg);
					game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
					deck.update(game, move,3);
				}
				else if(repeat==1 || repeat==3 && deck.getturn()==2)
				{
					int move=deck.move(finalmove, game, Players.get(1), 1, Players,this);
					repeat--;
					String msg="";
					if(repeat==0)
					{
						deck.changeturn(TotalPlayers);
						changeturn();
						msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
						msg=msg+"\nCards Left:"+(numbofcard+1);
						msg+="\nPlease Draw a Card\n";
						draw=1;
						result=0;
						finalmove=0;
					}
					else
					{
						msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
						msg=msg+"\nCards Left:"+(numbofcard+1);
						msg+="\nPlease Play Pawn2 also\n";
					}
					game.Info.setEditable(false);
					game.Info.setText(msg);
					game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
					deck.update(game, move,3);
					
				}
				else if(trader==1 &&deck.turn==2)
				{
					if(cards.get(numbofcard).getDescription()==11&&Players.get(1).Pawn1.getindex()!=-1 &&Players.get(1).Pawn1.getsteps()!=0)
					{
						String msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
						msg=msg+"\nCards Left:"+(numbofcard+1);
						msg+="\nChoose to replace with!\n(Press current card to see options)!";
						check=1;
						game.Info.setEditable(false);
						game.Info.setText(msg);
						game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
						pawn=3;
						tobetraded=1;
					}
					else if(cards.get(numbofcard).getDescription()==11)
					{
						String msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
						msg=msg+"\nCards Left:"+(numbofcard+1);
						msg+="\nYou can't replace that pawn!\n";
						game.Info.setEditable(false);
						game.Info.setText(msg);
						game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
					}
					
					 if(cards.get(numbofcard).getDescription()==13 &&  Players.get(1).Pawn1.getindex()!=-1 &&Players.get(1).Pawn1.getsteps()!=0)
					{
						String msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
						msg=msg+"\nCards Left:"+(numbofcard+1);
						msg+="\nYou can't replace that pawn!\n";
						game.Info.setEditable(false);
						game.Info.setText(msg);
						game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
					}
					else
					{
						String msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
						msg=msg+"\nCards Left:"+(numbofcard+1);
						msg+="\nChoose to replace with!\n(Press current card to see options)!";
						check=1;
						game.Info.setEditable(false);
						game.Info.setText(msg);
						game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
						pawn=3;
						tobetraded=1;
					}
				}
				else if(tobetraded==1 &&trader==1)
				{
					if(Players.get(1).Pawn1.getindex()!=-1 && Players.get(1).Pawn1.getindex()<=59)
					{
						deck.swap(pawn, 3, game,Players.get(1),Players.get(turn-1), Players, this);
						deck.changeturn(TotalPlayers);
						changeturn();
						String msg;
						msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
						msg=msg+"\nCards Left:"+(numbofcard+1);
						result=0;
						finalmove=0;
						tobetraded=0;
						msg+="\nPlease Draw a Card\n";
						draw=1;
						trader=0;

						game.Info.setEditable(false);
						game.Info.setText(msg);
						game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
					}
					else
					{
						String msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
						msg=msg+"\nCards Left:"+(numbofcard+1);
						msg+="\nYou can't replace that pawn!\n";
						game.Info.setEditable(false);
						game.Info.setText(msg);
						game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
					}
					
				}
				
				
			}
			else if(e.getSource()==game.YellowPawn2)
			{
				if(deck.getturn()==2 &&(check==0 && draw==0)&&options==0 &&trader==0 &&(result==2 || result==3))
				{
					int move;
					if(Players.get(1).Pawn2.getindex()==-1)
					{
						game.YellowStartZone.remove(game.YellowPawn2);
						game.YellowPawn2.setVisible(false);
						if(game.YellowStartZone.getComponentCount()==0)
						{
							game.YellowStartZone.setVisible(false);
						}
					}
					move=deck.move(finalmove, game, Players.get(1), 2, Players,this);
					deck.changeturn(TotalPlayers);
					changeturn();
					result=0;
					draw=1;
					String msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
					msg=msg+"\nCards Left:"+(numbofcard+1);
					msg+="\nPlease Draw a Card\n";
					game.Info.setEditable(false);
					game.Info.setText(msg);
					game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
					deck.update(game, move,4);
				}
				else if(repeat==3 || repeat==2 && deck.getturn()==2)
				{
					int move=deck.move(finalmove, game, Players.get(1), 2, Players,this);
					result=0;
					repeat=repeat-2;
					String msg="";
					if(repeat==0)
					{
						deck.changeturn(TotalPlayers);
						changeturn();
						msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
						msg=msg+"\nCards Left:"+(numbofcard+1);
						msg+="\nPlease Draw a Card\n";
						draw=1;
					}
					else
					{
						msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
						msg=msg+"\nCards Left:"+(numbofcard+1);
						msg+="\nPlease Play Pawn1 also\n";
					}
					game.Info.setEditable(false);
					game.Info.setText(msg);
					game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
					deck.update(game, move,4);
					
				}
				else if(trader==1 &&deck.turn==2)
				{
					if(cards.get(numbofcard).getDescription()==11 &&Players.get(1).Pawn2.getindex()!=-1 &&Players.get(1).Pawn2.getsteps()!=0)
					{
						String msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
						msg=msg+"\nCards Left:"+(numbofcard+1);
						msg+="\nChoose to replace with!\n(Press current card to see options)!";
						check=1;
						game.Info.setEditable(false);
						game.Info.setText(msg);
						game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
						pawn=4;
						tobetraded=1;
					}
					else if(cards.get(numbofcard).getDescription()==11)
					{
						String msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
						msg=msg+"\nCards Left:"+(numbofcard+1);
						msg+="\nYou can't replace that pawn!\n";
						game.Info.setEditable(false);
						game.Info.setText(msg);
						game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
					}
					
					 if(cards.get(numbofcard).getDescription()==13 && Players.get(1).Pawn2.getindex()!=-1 &&Players.get(1).Pawn2.getsteps()!=0)
					{
						String msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
						msg=msg+"\nCards Left:"+(numbofcard+1);
						msg+="\nYou can't replace that pawn!\n";
						game.Info.setEditable(false);
						game.Info.setText(msg);
						game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
					}
					else
					{
						String msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
						msg=msg+"\nCards Left:"+(numbofcard+1);
						msg+="\nChoose to replace with!\n(Press current card to see options)!";
						check=1;
						game.Info.setEditable(false);
						game.Info.setText(msg);
						game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
						pawn=4;
						tobetraded=1;
					}
				}
				else if(tobetraded==1 &&trader==1)
				{
					if(Players.get(1).Pawn2.getindex()!=-1 && Players.get(1).Pawn2.getindex()<=59)
					{
						deck.swap(pawn, 4, game,Players.get(1),Players.get(turn-1), Players, this);
						deck.changeturn(TotalPlayers);
						changeturn();
						String msg;
						msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
						msg=msg+"\nCards Left:"+(numbofcard+1);
						result=0;
						finalmove=0;
						tobetraded=0;
						msg+="\nPlease Draw a Card\n";
						draw=1;
						trader=0;

						game.Info.setEditable(false);
						game.Info.setText(msg);
						game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
						System.out.println("edo mpike?");
					}
					else
					{
						String msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
						msg=msg+"\nCards Left:"+(numbofcard+1);
						msg+="\nYou can't replace that pawn!\n";
						game.Info.setEditable(false);
						game.Info.setText(msg);
						game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
					}
					
				}
				
				
			}
			if(TotalPlayers>3)
			{
				 if(e.getSource()==game.GreenPawn1)
				 {
					 if(deck.getturn()==3 &&(check==0 && draw==0)&&options==0 &&trader==0 &&(result==1 || result==3))
					 {
						 if(Players.get(2).Pawn1.getindex()==-1)
						 {
								game.GreenStartZone.remove(game.GreenPawn1);
								game.GreenPawn1.setVisible(false);
								if(game.GreenStartZone.getComponentCount()==0)
								{
									game.GreenStartZone.setVisible(false);
								}
								
						 }
						 int move;
						 move=deck.move(finalmove, game, Players.get(2), 1, Players,this);
						 deck.changeturn(TotalPlayers);
						 changeturn();
						 result=0;
						 draw=1;
						 String msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
						 msg=msg+"\nCards Left:"+(numbofcard+1);
						 msg+="\nPlease Draw a Card\n";
						 game.Info.setEditable(false);
						 game.Info.setText(msg);
						 game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
						 deck.update(game, move,5);
					 }
						else if(repeat==3 || repeat==1 && deck.getturn()==3)
						{
							int move;
							move=deck.move(finalmove, game, Players.get(2), 1, Players,this);
							repeat--;
							result=0;
							String msg="";
							if(repeat==0)
							{
								deck.changeturn(TotalPlayers);
								changeturn();
								msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
								msg=msg+"\nCards Left:"+(numbofcard+1);
								msg+="\nPlease Draw a Card\n";
								draw=1;
								result=0;
								finalmove=0;
							}
							else
							{
								msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
								msg=msg+"\nCards Left:"+(numbofcard+1);
								msg+="\nPlease Play Pawn2 also\n";
							}
							game.Info.setEditable(false);
							game.Info.setText(msg);
							game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
							deck.update(game, move,5);
							
						}
						else if(trader==1 &&deck.turn==3)
						{
							if(cards.get(numbofcard).getDescription()==11 &&  Players.get(2).Pawn1.getindex()!=-1 &&Players.get(2).Pawn1.getsteps()!=0)
							{
								String msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
								msg=msg+"\nCards Left:"+(numbofcard+1);
								msg+="\nChoose to replace with!\n(Press current card to see options)!";
								check=1;
								game.Info.setEditable(false);
								game.Info.setText(msg);
								game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
								pawn=5;
								tobetraded=1;
							}
							else if(cards.get(numbofcard).getDescription()==11)
							{
								String msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
								msg=msg+"\nCards Left:"+(numbofcard+1);
								msg+="\nYou can't replace that pawn!\n";
								game.Info.setEditable(false);
								game.Info.setText(msg);
								game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
							}
							
							if(cards.get(numbofcard).getDescription()==13 &&Players.get(2).Pawn1.getindex()!=-1 &&Players.get(2).Pawn1.getsteps()!=0)
							{
								String msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
								msg=msg+"\nCards Left:"+(numbofcard+1);
								msg+="\nYou can't replace that pawn!\n";
								game.Info.setEditable(false);
								game.Info.setText(msg);
								game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
							}
							else
							{
								String msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
								msg=msg+"\nCards Left:"+(numbofcard+1);
								msg+="\nChoose to replace with!\n(Press current card to see options)!";
								check=1;
								game.Info.setEditable(false);
								game.Info.setText(msg);
								game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
								pawn=5;
								tobetraded=1;
							}
						}
						else if(tobetraded==1 &&trader==1)
						{
							if(Players.get(2).Pawn1.getindex()!=-1 && Players.get(2).Pawn1.getindex()<=59)
							{
								deck.swap(pawn, 5, game,Players.get(2),Players.get(turn-1), Players, this);
								deck.changeturn(TotalPlayers);
								changeturn();
								String msg;
								msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
								msg=msg+"\nCards Left:"+(numbofcard+1);
								result=0;
								finalmove=0;
								tobetraded=0;
								msg+="\nPlease Draw a Card\n";
								draw=1;
								trader=0;

								game.Info.setEditable(false);
								game.Info.setText(msg);
								game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
							}
							else
							{
								String msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
								msg=msg+"\nCards Left:"+(numbofcard+1);
								msg+="\nYou can't replace that pawn!\n";
								game.Info.setEditable(false);
								game.Info.setText(msg);
								game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
							}
							
						}
				 }
				 else if(e.getSource()==game.GreenPawn2)
				 {
					 if(deck.getturn()==3 &&(check==0 && draw==0)&&options==0 &&trader==0 &&(result==2 || result==3))
					{
						if(Players.get(2).Pawn2.getindex()==-1)
						{
							game.GreenStartZone.remove(game.GreenPawn2);
							game.GreenPawn2.setVisible(false);
							if(game.GreenStartZone.getComponentCount()==0)
							{
								game.GreenStartZone.setVisible(false);
							}
						}
						 int move;
						 move= deck.move(finalmove, game, Players.get(2),2, Players,this);
						 deck.changeturn(TotalPlayers);
						changeturn();
						result=0;
						finalmove=0;
						draw=1;
						String msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
						msg=msg+"\nCards Left:"+(numbofcard+1);
						msg+="\nPlease Draw a Card\n";
						game.Info.setEditable(false);
						game.Info.setText(msg);
						game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
						deck.update(game, move,6);
					}
						else if(repeat==3 || repeat==2 && deck.getturn()==3)
						{
							int move;
							move= deck.move(finalmove, game, Players.get(2),2, Players,this);
							result=0;
							repeat=repeat-2;
							String msg="";
							if(repeat==0)
							{
								deck.changeturn(TotalPlayers);
								changeturn();
								msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
								msg=msg+"\nCards Left:"+(numbofcard+1);
								msg+="\nPlease Draw a Card\n";
								draw=1;
							}
							else
							{
								msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
								msg=msg+"\nCards Left:"+(numbofcard+1);
								msg+="\nPlease Play Pawn1 also\n";
							}
							game.Info.setEditable(false);
							game.Info.setText(msg);
							game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
							deck.update(game, move,6);
							
						}
						else if(trader==1 &&deck.turn==3)
						{
							if(cards.get(numbofcard).getDescription()==11 &&  Players.get(2).Pawn2.getindex()!=-1 &&Players.get(2).Pawn2.getsteps()!=0)
							{
								String msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
								msg=msg+"\nCards Left:"+(numbofcard+1);
								msg+="\nChoose to replace with!\n(Press current card to see options)!";
								check=1;
								game.Info.setEditable(false);
								game.Info.setText(msg);
								game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
								pawn=6;
								tobetraded=1;
							}
							else if(cards.get(numbofcard).getDescription()==11)
							{
								String msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
								msg=msg+"\nCards Left:"+(numbofcard+1);
								msg+="\nYou can't replace that pawn!\n";
								game.Info.setEditable(false);
								game.Info.setText(msg);
								game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
							}
							
							if(cards.get(numbofcard).getDescription()==13 &&  Players.get(2).Pawn2.getindex()!=-1 &&Players.get(2).Pawn2.getsteps()!=0)
							{
								String msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
								msg=msg+"\nCards Left:"+(numbofcard+1);
								msg+="\nYou can't replace that pawn!\n";
								game.Info.setEditable(false);
								game.Info.setText(msg);
								game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
							}
							else
							{
								String msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
								msg=msg+"\nCards Left:"+(numbofcard+1);
								msg+="\nChoose to replace with!\n(Press current card to see options)!";
								check=1;
								game.Info.setEditable(false);
								game.Info.setText(msg);
								game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
								pawn=6;
								tobetraded=1;
							}
						}
						else if(tobetraded==1 &&trader==1)
						{
							if(Players.get(2).Pawn2.getindex()!=-1 && Players.get(2).Pawn2.getindex()<=59)
							{
								deck.swap(pawn, 6, game,Players.get(2),Players.get(turn-1), Players, this);
								deck.changeturn(TotalPlayers);
								changeturn();
								String msg;
								msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
								msg=msg+"\nCards Left:"+(numbofcard+1);
								result=0;
								finalmove=0;
								msg+="\nPlease Draw a Card\n";
								draw=1;
								tobetraded=0;
								trader=0;
								game.Info.setEditable(false);
								game.Info.setText(msg);
								game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
							}
							else
							{
								String msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
								msg=msg+"\nCards Left:"+(numbofcard+1);
								msg+="\nYou can't replace that pawn!\n";
								game.Info.setEditable(false);
								game.Info.setText(msg);
								game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
							}
							
						}
					 	
				 }
				 else if(e.getSource()==game.BluePawn1)
				 {
					 if(deck.getturn()==4 &&(check==0 && draw==0)&&options==0 &&trader==0 &&(result==1 || result==3))
					 {
						 if(Players.get(3).Pawn1.getindex()==-1)
						 {
							game.BlueStartZone.remove(game.BluePawn1);
							game.BluePawn1.setVisible(false);
							if(game.BlueStartZone.getComponentCount()==0)
							{
								game.BlueStartZone.setVisible(false);
							}
						 }
						 int move;
						 move=deck.move(finalmove, game, Players.get(3), 1, Players,this);
						 deck.changeturn(TotalPlayers);
						changeturn();
						result=0;
						draw=1;
						String msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
						msg=msg+"\nCards Left:"+(numbofcard+1);
						msg+="\nPlease Draw a Card\n";
						game.Info.setEditable(false);
						game.Info.setText(msg);
						game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
						deck.update(game, move,7);
					 }
						else if(repeat==1 || repeat==3 && deck.getturn()==4)
						{
							int move;
							move=deck.move(finalmove, game, Players.get(0), 2, Players,this);
							result=-1;
							repeat--;
							String msg="";
							if(repeat==0)
							{
								deck.changeturn(TotalPlayers);
								changeturn();
								msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
								msg=msg+"\nCards Left:"+(numbofcard+1);
								msg+="\nPlease Draw a Card\n";
								result=0;
								finalmove=0;
								draw=1;
							}
							else
							{
								msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
								msg=msg+"\nCards Left:"+(numbofcard+1);
								msg+="\nPlease Play Pawn2 also\n";
							}
							game.Info.setEditable(false);
							game.Info.setText(msg);
							game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
							deck.update(game, move,7);
							
						}
					 
						else if(trader==1 &&deck.turn==4)
						{
							if(cards.get(numbofcard).getDescription()==11 && Players.get(3).Pawn1.getindex()!=-1 &&Players.get(3).Pawn1.getsteps()!=0)
							{
								String msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
								msg=msg+"\nCards Left:"+(numbofcard+1);
								msg+="\nChoose to replace with!\n(Press current card to see options)!";
								check=1;
								game.Info.setEditable(false);
								game.Info.setText(msg);
								game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
								pawn=7;
								tobetraded=1;
							}
							else if(cards.get(numbofcard).getDescription()==11 )
							{
								String msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
								msg=msg+"\nCards Left:"+(numbofcard+1);
								msg+="\nYou can't replace that pawn!\n";
								game.Info.setEditable(false);
								game.Info.setText(msg);
								game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
							}
							
							
							if(cards.get(numbofcard).getDescription()==13 &&Players.get(3).Pawn1.getindex()!=-1 &&Players.get(3).Pawn1.getsteps()!=0)
							{
								String msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
								msg=msg+"\nCards Left:"+(numbofcard+1);
								msg+="\nYou can't replace that pawn!\n";
								game.Info.setEditable(false);
								game.Info.setText(msg);
								game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
							}
							else
							{
								String msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
								msg=msg+"\nCards Left:"+(numbofcard+1);
								msg+="\nChoose to replace with!\n(Press current card to see options)!";
								check=1;
								game.Info.setEditable(false);
								game.Info.setText(msg);
								game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
								pawn=7;
								tobetraded=1;
							}
						}
						else if(tobetraded==1 &&trader==1)
						{
							if(Players.get(3).Pawn1.getindex()!=-1 && Players.get(3).Pawn1.getindex()<=59)
							{
								deck.swap(pawn, 7, game,Players.get(3),Players.get(turn-1), Players, this);
								deck.changeturn(TotalPlayers);
								changeturn();
								String msg;
								msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
								msg=msg+"\nCards Left:"+(numbofcard+1);
								result=0;
								finalmove=0;
								msg+="\nPlease Draw a Card\n";
								draw=1;
								tobetraded=0;
								trader=0;
								game.Info.setEditable(false);
								game.Info.setText(msg);
								game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
							}
							else
							{
								String msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
								msg=msg+"\nCards Left:"+(numbofcard+1);
								msg+="\nYou can't replace that pawn!\n";
								game.Info.setEditable(false);
								game.Info.setText(msg);
								game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
							}
							
						}

				 }
				 else if(e.getSource()==game.BluePawn2)
				 {
					 if(deck.getturn()==4 &&(check==0 && draw==0)&&options==0 &&trader==0 &&(result==2 || result==3))
					 {
						if(Players.get(3).Pawn2.getindex()==-1)
						{
							game.BlueStartZone.remove(game.BluePawn2);
							game.BluePawn2.setVisible(false);
							if(game.BlueStartZone.getComponentCount()==0)
							{
								game.BlueStartZone.setVisible(false);
							}
						}
						int move;
						move=deck.move(finalmove, game, Players.get(3), 2, Players,this);
						deck.changeturn(TotalPlayers);
						changeturn();
						result=-1;
						draw=1;
						String msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
						msg=msg+"\nCards Left:"+(numbofcard+1);
						msg+="\nPlease Draw a Card\n";
						game.Info.setEditable(false);
						game.Info.setText(msg);
						game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
						deck.update(game, move,8);
					 	}
						else if(repeat==3 || repeat==2 && deck.getturn()==4)
						{
							int move;
							move=deck.move(finalmove, game, Players.get(0), 2, Players,this);
							result=0;
							repeat=repeat-2;
							String msg="";
							if(repeat==0)
							{
								deck.changeturn(TotalPlayers);
								changeturn();
								msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
								msg=msg+"\nCards Left:"+(numbofcard+1);
								msg+="\nPlease Draw a Card\n";
								result=0;
								finalmove=0;
								draw=1;
							}
							else
							{
								msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
								msg=msg+"\nCards Left:"+(numbofcard+1);
								msg+="\nPlease Play Pawn1 also\n";
							}
							game.Info.setEditable(false);
							game.Info.setText(msg);
							game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
							deck.update(game, move,8);
							
						}
					 
						else if(trader==1 &&deck.turn==4)
						{
							if(cards.get(numbofcard).getDescription()==11 && Players.get(3).Pawn2.getindex()!=-1 &&Players.get(3).Pawn2.getsteps()!=0)
							{
								String msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
								msg=msg+"\nCards Left:"+(numbofcard+1);
								msg+="\nChoose to replace with!\n(Press current card to see options)!";
								check=1;
								game.Info.setEditable(false);
								game.Info.setText(msg);
								game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
								pawn=8;
								tobetraded=1;
							}
							else if(cards.get(numbofcard).getDescription()==11)
							{
								String msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
								msg=msg+"\nCards Left:"+(numbofcard+1);
								msg+="\nYou can't replace that pawn!\n";
								game.Info.setEditable(false);
								game.Info.setText(msg);
								game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
							}
							
							if(cards.get(numbofcard).getDescription()==13 && Players.get(3).Pawn2.getindex()!=-1 &&Players.get(3).Pawn2.getsteps()!=0)
							{
								String msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
								msg=msg+"\nCards Left:"+(numbofcard+1);
								msg+="\nYou can't replace that pawn!\n";
								game.Info.setEditable(false);
								game.Info.setText(msg);
								game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
							}
							else
							{
								String msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
								msg=msg+"\nCards Left:"+(numbofcard+1);
								msg+="\nChoose to replace with!\n(Press current card to see options)!";
								check=1;
								game.Info.setEditable(false);
								game.Info.setText(msg);
								game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
								pawn=8;
								tobetraded=1;
							}
						}
						else if(tobetraded==1 &&trader==1)
						{
							if(Players.get(3).Pawn2.getindex()!=-1 && Players.get(3).Pawn2.getindex()<=59)
							{
								deck.swap(pawn, 8, game,Players.get(3),Players.get(turn-1), Players, this);
								deck.changeturn(TotalPlayers);
								changeturn();
								String msg;
								msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
								msg=msg+"\nCards Left:"+(numbofcard+1);
								result=0;
								finalmove=0;
								msg+="\nPlease Draw a Card\n";
								draw=1;
								tobetraded=0;
								trader=0;
								game.Info.setEditable(false);
								game.Info.setText(msg);
								game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
							}
							else
							{
								String msg="Info Box \nTurn:Player " +Players.get(turn-1).returnturn()+" ("+Players.get(turn-1).getPlayerColor()+")"+ " name:"+PlayerNames.get(turn-1);
								msg=msg+"\nCards Left:"+(numbofcard+1);
								msg+="\nYou can't replace that pawn!\n";
								game.Info.setEditable(false);
								game.Info.setText(msg);
								game.Info.setFont(new Font("Tahoma", Font.BOLD, 10));
							}
							
						}
				 }
			}
			deck.println(Players);
			deck.findwinner(game, window, Players);
		}
		

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
	



