package Model;
import java.awt.Font;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import View.Board;
import View.Winner;
/**
 * Deck class that has to do with cards
 */
public class Deck {
	/*Our Cards in one array list */
	public int turn;
	private JLabel[] backup;
	private JLabel[] redsquares;
	private JLabel[] yellowsquares;
	private JLabel[] greensquares;
	private JLabel[] bluesquares;
	public Deck(Board game)
	{
		this.backup=game.getsquares();
		this.redsquares=game.getredsquares();
		this.yellowsquares=game.getyellowsquares();
		this.greensquares=game.getgreensquares();
		this.bluesquares=game.getbluesquares();
		this.turn=1;
	}
	
	
	/**
	 * Main Constructor that makes the card creates the cards
	 * @pre should be called only once
	 * @post 44 cards will be created
	 */
	/**
	 *Method that shuffle our deck if all cards are played
	 *@pre No more cards to be played before calling this method
	 *@post shuffle all the cards again 
	 */
	public void shuffleCards(ArrayList<Card>cards)
	{
		Collections.shuffle(cards);
	}
	
	public void changeturn(int totalplayers)
	{
		this.turn++;
		if(this.turn>totalplayers)
		{
			this.turn=1;
		}
	}

	

	
	
	

	
	public int getturn()
	{
		return this.turn;
	}

	

	public void update(Board game,int index,int playernumber)
	{
		String playerinfo="";
		int found=0;
		if(playernumber==1)
		{
			playerinfo="Images\\redPawn1.png";
		}
		else if(playernumber==2)
		{
			playerinfo="Images\\redPawn2.png";
		}
		if(playernumber==3)
		{
			playerinfo="Images\\yellowPawn1.png";
		}
		else if(playernumber==4)
		{
			playerinfo="Images\\yellowPawn2.png";
		}
		else if(playernumber==5)
		{
			playerinfo="Images\\GreenPawn1.png";
		}
		else if(playernumber==6)
		{
			playerinfo="Images\\GreenPawn2.png";
		}
		else if(playernumber==7)
		{
			playerinfo="Images\\BluePawn1.png";
		}
		else if(playernumber==8)
		{
			playerinfo="Images\\BluePawn2.png";
		}
		String current;
		 if(playernumber==1 || playernumber==2)
		{
			for(int i=0;i<5;i++)
			{
				if(game.redsquares[i].getIcon()!=null)
				{
					current=game.redsquares[i].getIcon().toString();
				}
				else
				{
					current="";
				}
				if(index!=i &&playerinfo.equals(current))
				{
					found=1;
					game.redsquares[i].setIcon(this.redsquares[i].getIcon());
					game.redsquares[i].setVisible(true);
					game.redsquares[i].setOpaque(true);
				}
			}
			
		}
		
		 else if(playernumber==3 || playernumber==4)
		 {
				for(int i=0;i<5;i++)
				{
					if(game.yellowsquares[i].getIcon()!=null)
					{
						current=game.yellowsquares[i].getIcon().toString();
					}
					else
					{
						current="";
					}
					if(index!=i &&playerinfo.equals(current))
					{
						found=1;
						game.yellowsquares[i].setIcon(this.yellowsquares[i].getIcon());
						game.yellowsquares[i].setVisible(true);
						game.yellowsquares[i].setOpaque(true);
					}
				} 
		 }
		
		else if(playernumber==5 || playernumber==6)
		{
			for(int i=0;i<5;i++)
			{
				if(game.greensquares[i].getIcon()!=null)
				{
					current=game.greensquares[i].getIcon().toString();
				}
				else
				{
					current="";
				}
				if(index!=i &&playerinfo.equals(current))
				{
					found=1;
					game.greensquares[i].setIcon(this.greensquares[i].getIcon());
					game.greensquares[i].setVisible(true);
					game.greensquares[i].setOpaque(true);
				}
			}
		}
		else if(playernumber==7 || playernumber==8)
		{
			for(int i=0;i<5;i++)
			{
				if(game.bluesquares[i].getIcon()!=null)
				{
					current=game.bluesquares[i].getIcon().toString();
				}
				else
				{
					current="";
				}
				if(index!=i &&playerinfo.equals(current))
				{
					found=1;
					game.bluesquares[i].setIcon(this.bluesquares[i].getIcon());
					game.bluesquares[i].setVisible(true);
					game.bluesquares[i].setOpaque(true);
				}
			}
		}
		 if(found==1)
		 {
			 index=-1;
		 }
		 for(int i=0;i<60;i++)
			{
				if(game.squares[i].getIcon()!=null)
				{
					current=game.squares[i].getIcon().toString();
				}
				else
				{
					current="";
				}
				if(index!=i && playerinfo.equals(current))
				{
					game.squares[i].setIcon(backup[i].getIcon());
					game.squares[i].setVisible(true);
					game.squares[i].setOpaque(true);
				}
			}
	} 
	
	
	public void findwinner(Board game,Winner window,ArrayList<Player> players)
	{
		for(int i=0;i<players.size();i++)
		{
			int stepspawn1=players.get(i).Pawn1.getsteps();
			int stepspawn2=players.get(i).Pawn2.getsteps();
			int getindex1=players.get(i).Pawn1.getindex();
			int getindex2=players.get(i).Pawn2.getindex();
			if(stepspawn1==65 && getindex1==65 &&stepspawn2==65 && getindex2==65)
			{
				window=new Winner();
				game.setMouseListeners(null);
				game.setActionListeners(null);
				window.msg.setText("Winner is:"+players.get(i).Getname());
				window.msg.setFont(new Font("Tahoma", Font.PLAIN, 18));
				window.msg.setHorizontalAlignment(SwingConstants.CENTER);
			}
		}
	}
	
	public void swap(int pawn,int pawn2,Board game,Player tobetraded,Player trader,ArrayList<Player>players,MouseListener test)
	{
		int newstart=0;
		String colour="";
		if(pawn==1 || pawn==2)
		{
			if(pawn==1)
			{
				colour=trader.Pawn1.GetFirstPawnImageSource("RED");
			}
			else
			{
				colour=trader.Pawn1.GetSecondPawnImageSource("RED");
			}
			 newstart=4;
		}
		else if(pawn==7 || pawn==8)
		{
			if(pawn==7)
			{
				colour=trader.Pawn1.GetFirstPawnImageSource("BLUE");
			}
			else
			{
				colour=trader.Pawn1.GetSecondPawnImageSource("BLUE");
			}
			newstart=19;
		}
		else if(pawn==3 || pawn==4)
		{
			if(pawn==3)
			{
				colour=trader.Pawn1.GetFirstPawnImageSource("YELLOW");
			}
			else
			{
				colour=trader.Pawn1.GetSecondPawnImageSource("YELLOW");
			}
			newstart=34;
		}
		else if(pawn==5 || pawn==6)
		{
			if(pawn==5)
			{
				colour=trader.Pawn1.GetFirstPawnImageSource("GREEN");
			}
			else
			{
				colour=trader.Pawn1.GetSecondPawnImageSource("GREEN");
			}
			newstart=49;
		}
		int finalindex=0;
		int Pawn=0;
		if(pawn2==1 || pawn2==3 || pawn2==5 || pawn2==7)
		{
			finalindex=tobetraded.Pawn1.getindex();
			if(pawn==1 || pawn==3 || pawn==5 || pawn==7)
			{
				Pawn=1;
			}
			else if(pawn==2 || pawn==4 || pawn==6 || pawn==8)
			{
				Pawn=2;
			}
			tobetraded.Pawn1.setzero();;
		}
		else if(pawn2==2 || pawn2==4 || pawn2==6 || pawn2==8)
		{
			finalindex=tobetraded.Pawn2.getindex();
			if(pawn==1 || pawn==3 || pawn==5 || pawn==7)
			{
				Pawn=1;
			}
			else if(pawn==2 || pawn==4 || pawn==6 || pawn==8)
			{
				Pawn=2;
			}
			tobetraded.Pawn2.setzero();
		}
		int steps=1;
		int found=0;
		while(found!=1)
		{
			if(finalindex==newstart)
			{
				break;
			}
			newstart++;
			steps++;
			if(steps>=60)
			{
				steps=0;
			}
			if(newstart>59)
			{
				newstart=0;
			}
			else if(newstart<0)
			{
				newstart=59;
			}
		}
		if(Pawn==1)
		{
			trader.Pawn1.setzero();
			trader.Pawn1.setsteps(steps);
			trader.Pawn1.setindex(finalindex);
		}
		else
		{
			trader.Pawn2.setzero();
			trader.Pawn2.setsteps(steps);
			trader.Pawn2.setindex(finalindex);
		}
			if(pawn2==1)
			{
				players.get(0).Pawn1.setzero();
				game.RedPawn1 = new JLabel("");
				game.RedStartZone.setVisible(false);
				game.RedPawn1.setOpaque(true);
				game.RedPawn1.setIcon(new ImageIcon("Images\\redPawn1.png"));
				game.RedPawn1.setVisible(true);
				game.RedPawn1.addMouseListener(test);
				game.RedStartZone.add(game.RedPawn1);
				game.RedStartZone.setVisible(true);
				this.update(game,-1,1);

				
			}
			else if(pawn2==3)
			{
				players.get(1).Pawn1.setzero();
				game.YellowStartZone.setVisible(false);
				game.YellowPawn1 = new JLabel("");
				game.YellowPawn1.setOpaque(true);
				game.YellowPawn1.setIcon(new ImageIcon("Images\\yellowPawn1.png"));
				game.YellowPawn1.setVisible(true);
				game.YellowPawn1.addMouseListener(test);
				game.YellowStartZone.add(game.YellowPawn1);
				game.YellowStartZone.setVisible(true);
				this.update(game,-1,3);
				
			}
			else if(pawn2==5)
			{
				players.get(2).Pawn1.setzero();
				game.GreenStartZone.setVisible(false);
				game.GreenPawn1 = new JLabel("");
				game.GreenPawn1.setOpaque(true);
				game.GreenPawn1.setIcon(new ImageIcon("Images\\GreenPawn1.png"));
				game.GreenPawn1.setVisible(true);
				game.GreenPawn1.addMouseListener(test);
				game.GreenStartZone.add(game.GreenPawn1);
				game.GreenStartZone.setVisible(true);
				this.update(game,-1,5);
			}
			 if(pawn2==7)
			 {
				players.get(3).Pawn1.setzero();
				game.BlueStartZone.setVisible(false);
				game.BluePawn1 = new JLabel("");
				game.BluePawn1.setOpaque(true);
				game.BluePawn1.setIcon(new ImageIcon("Images\\BluePawn1.png"));
				game.BluePawn1.setVisible(true);
				game.BluePawn1.addMouseListener(test);
				game.BlueStartZone.add(game.BluePawn1);
				game.BlueStartZone.setVisible(true);
				this.update(game,-1,7);
			 }
			 else if(pawn2==2)
			{	
				players.get(0).Pawn2.setzero();
				game.RedStartZone.setVisible(false);
				game.RedPawn2 = new JLabel("");
				game.RedPawn2.setOpaque(true);
				game.RedPawn2.setIcon(new ImageIcon("Images\\redPawn2.png"));
				game.RedPawn2.setVisible(true);
				game.RedPawn2.addMouseListener(test);
				game.RedStartZone.add(game.RedPawn2);
				game.RedStartZone.setVisible(true);
				this.update(game,-1,2);
				
			}
			else if(pawn2==4)
			{
				players.get(1).Pawn2.setzero();
				game.YellowStartZone.setVisible(false);
				game.YellowPawn2 = new JLabel("");
				game.YellowPawn2.setOpaque(true);
				game.YellowPawn2.setIcon(new ImageIcon("Images\\yellowPawn2.png"));
				game.YellowPawn2.setVisible(true);
				game.YellowPawn2.addMouseListener(test);
				game.YellowStartZone.add(game.YellowPawn2);
				game.YellowStartZone.setVisible(true);
				this.update(game,-1,4);
			}
			else if(pawn2==6)
			{
				players.get(2).Pawn2.setzero();
				game.GreenStartZone.setVisible(false);
				game.GreenPawn2 = new JLabel("");
				game.GreenPawn2.setOpaque(true);
				game.GreenPawn2.setIcon(new ImageIcon("Images\\GreenPawn2.png"));
				game.GreenPawn2.setVisible(true);
				game.GreenPawn2.addMouseListener(test);
				game.GreenStartZone.add(game.GreenPawn2);
				game.GreenStartZone.setVisible(true);
				this.update(game,-1,6);
			}
			else if(pawn2==8)
			{
				players.get(3).Pawn2.setzero();
				game.BlueStartZone.setVisible(false);
				game.BluePawn2 = new JLabel("");
				game.BluePawn2.setOpaque(true);
				game.BluePawn2.setIcon(new ImageIcon("Images\\BluePawn2.png"));
				game.BluePawn2.setVisible(true);
				game.BluePawn2.addMouseListener(test);
				game.BlueStartZone.add(game.BluePawn2);
				game.BlueStartZone.setVisible(true);
				this.update(game,-1,8);
			}

			 
			if(pawn==1)
			{	
				game.RedStartZone.setVisible(false);
				game.RedStartZone.remove(game.RedPawn1);
				game.RedPawn1.setVisible(false);
				if(game.RedStartZone.getComponentCount()!=0)
				{
					game.RedStartZone.setVisible(true);
				}
				game.RedStartZone.setVisible(true);
				game.squares[finalindex].setIcon(new ImageIcon(colour));
				game.RedPawn1.addMouseListener(test);
				game.RedPawn1=game.squares[finalindex];
				this.update(game, finalindex, 1);

			}
			else if(pawn==2)
			{
				game.RedStartZone.setVisible(false);
				game.RedStartZone.remove(game.RedPawn2);
				game.RedPawn2.setVisible(false);
				if(game.RedStartZone.getComponentCount()!=0)
				{
					game.RedStartZone.setVisible(true);
				}
				game.RedStartZone.setVisible(true);
				game.squares[finalindex].setIcon(new ImageIcon(colour));
				game.RedPawn2.addMouseListener(test);
				game.RedPawn2=game.squares[finalindex];
				this.update(game, finalindex, 2);

			}
			else if(pawn==3)
			{
				game.YellowStartZone.setVisible(false);
				game.YellowStartZone.remove(game.YellowPawn1);
				game.YellowPawn1.setVisible(false);
				if(game.RedStartZone.getComponentCount()!=0)
				{
					game.YellowStartZone.setVisible(true);
				}
				game.YellowStartZone.setVisible(true);
				game.squares[finalindex].setIcon(new ImageIcon(colour));
				game.YellowPawn1.addMouseListener(test);
				game.YellowPawn1=game.squares[finalindex];
				this.update(game, finalindex, 3);
			}
			else if(pawn==4)
			{
				game.YellowStartZone.setVisible(false);
				game.YellowStartZone.remove(game.YellowPawn2);
				game.YellowPawn2.setVisible(false);
				if(game.RedStartZone.getComponentCount()!=0)
				{
					game.YellowStartZone.setVisible(true);
				}
				game.YellowStartZone.setVisible(true);
				game.squares[finalindex].setIcon(new ImageIcon(colour));
				game.YellowPawn2.addMouseListener(test);
				game.YellowPawn2=game.squares[finalindex];
				this.update(game, finalindex, 4);
			}
			else if(pawn==5)
			{
				game.GreenStartZone.setVisible(false);
				game.GreenStartZone.remove(game.GreenPawn1);
				game.GreenPawn1.setVisible(false);
				if(game.GreenStartZone.getComponentCount()!=0)
				{
					game.GreenStartZone.setVisible(true);
				}
				game.GreenStartZone.setVisible(true);
				game.squares[finalindex].setIcon(new ImageIcon(colour));
				game.GreenPawn1.addMouseListener(test);
				game.GreenPawn1=game.squares[finalindex];
				this.update(game, finalindex, 5);

			}
			else if(pawn==6)
			{
				game.GreenStartZone.setVisible(false);
				game.GreenStartZone.remove(game.GreenPawn2);
				game.GreenPawn2.setVisible(false);
				if(game.GreenStartZone.getComponentCount()!=0)
				{
					game.GreenStartZone.setVisible(true);
				}
				game.GreenStartZone.setVisible(true);
				game.squares[finalindex].setIcon(new ImageIcon(colour));
				game.GreenPawn2.addMouseListener(test);
				game.GreenPawn2=game.squares[finalindex];
				this.update(game, finalindex, 6);

			}
			else if(pawn==7)
			{
				game.BlueStartZone.setVisible(false);
				game.BlueStartZone.remove(game.BluePawn1);
				game.BluePawn1.setVisible(false);
				if(game.BlueStartZone.getComponentCount()!=0)
				{
					game.BlueStartZone.setVisible(true);
				}
				game.BlueStartZone.setVisible(true);
				game.squares[finalindex].setIcon(new ImageIcon(colour));
				game.BluePawn1.addMouseListener(test);
				game.BluePawn1=game.squares[finalindex];
				this.update(game, finalindex, 7);

			}
			else if(pawn==8)
			{
				game.BlueStartZone.setVisible(false);
				game.BlueStartZone.remove(game.BluePawn2);
				game.BluePawn2.setVisible(false);
				if(game.BlueStartZone.getComponentCount()!=0)
				{
					game.BlueStartZone.setVisible(true);
				}
				game.BlueStartZone.setVisible(true);
				game.squares[finalindex].setIcon(new ImageIcon(colour));
				game.BluePawn2.addMouseListener(test);
				game.BluePawn2=game.squares[finalindex];
				this.update(game, finalindex, 8);

			}
			
			
			 
			 
	}
	
	
	

			
			
	
	
	public void findandeliminateinslides(int startedindex,int finalindex,ArrayList<Player>players,Board game,int playerpawn,MouseListener test)
	{
		int index = 0;
		int max=players.size()*2;
		int start=startedindex;
		int last=finalindex;
		for(int i=start;i<=last;i++)
		{
			for(int j=1;j<=max;j++)
			{
				if(j==1)
				{
					index=players.get(0).Pawn1.getindex();
				}
				else if(j==2)
				{
					index=players.get(0).Pawn2.getindex();
				}
				else if(j==3)
				{
					index=players.get(1).Pawn1.getindex();
				}
				else if(j==4)
				{
					index=players.get(1).Pawn2.getindex();
				}
				else if(j==5)
				{
					index=players.get(2).Pawn1.getindex();
				}
				else if(j==6)
				{
					index=players.get(2).Pawn2.getindex();
				}
				else if(j==7)
				{
					index=players.get(3).Pawn1.getindex();
				}
				else if(j==8)
				{
					index=players.get(3).Pawn2.getindex();
				}
				if(playerpawn!=j && index==i )
				{
					if(j==1)
					{
						players.get(0).Pawn1.setzero();
						game.RedPawn1 = new JLabel("");
						game.RedStartZone.setVisible(false);
						game.RedPawn1.setOpaque(true);
						game.RedPawn1.setIcon(new ImageIcon("Images\\redPawn1.png"));
						game.RedPawn1.setVisible(true);
						game.RedPawn1.addMouseListener(test);
						game.RedStartZone.add(game.RedPawn1);
						game.RedStartZone.setVisible(true);
						this.update(game,-1,1);

						
					}
					else if(j==3)
					{
						players.get(1).Pawn1.setzero();
						game.YellowStartZone.setVisible(false);
						game.YellowPawn1 = new JLabel("");
						game.YellowPawn1.setOpaque(true);
						game.YellowPawn1.setIcon(new ImageIcon("Images\\yellowPawn1.png"));
						game.YellowPawn1.setVisible(true);
						game.YellowPawn1.addMouseListener(test);
						game.YellowStartZone.add(game.YellowPawn1);
						game.YellowStartZone.setVisible(true);
						this.update(game,-1,3);
						
					}
					else if(j==5)
					{
						players.get(2).Pawn1.setzero();
						game.GreenStartZone.setVisible(false);
						game.GreenPawn1 = new JLabel("");
						game.GreenPawn1.setOpaque(true);
						game.GreenPawn1.setIcon(new ImageIcon("Images\\GreenPawn1.png"));
						game.GreenPawn1.setVisible(true);
						game.GreenPawn1.addMouseListener(test);
						game.GreenStartZone.add(game.GreenPawn1);
						game.GreenStartZone.setVisible(true);
						this.update(game,-1,5);
					}
					else if(j==7)
					{
						players.get(3).Pawn1.setzero();
						game.BlueStartZone.setVisible(false);
						game.BluePawn1 = new JLabel("");
						game.BluePawn1.setOpaque(true);
						game.BluePawn1.setIcon(new ImageIcon("Images\\BluePawn1.png"));
						game.BluePawn1.setVisible(true);
						game.BluePawn1.addMouseListener(test);
						game.BlueStartZone.add(game.BluePawn1);
						game.BlueStartZone.setVisible(true);
						this.update(game,-1,7);
					}
					else if(j==2)
					{	
						players.get(0).Pawn2.setzero();
						game.RedStartZone.setVisible(false);
						game.RedPawn2 = new JLabel("");
						game.RedPawn2.setOpaque(true);
						game.RedPawn2.setIcon(new ImageIcon("Images\\redPawn2.png"));
						game.RedPawn2.setVisible(true);
						game.RedPawn2.addMouseListener(test);
						game.RedStartZone.add(game.RedPawn2);
						game.RedStartZone.setVisible(true);
						this.update(game,-1,2);
						
					}
					else if(j==4)
					{
						players.get(1).Pawn2.setzero();
						game.YellowStartZone.setVisible(false);
						game.YellowPawn2 = new JLabel("");
						game.YellowPawn2.setOpaque(true);
						game.YellowPawn2.setIcon(new ImageIcon("Images\\yellowPawn2.png"));
						game.YellowPawn2.setVisible(true);
						game.YellowPawn2.addMouseListener(test);
						game.YellowStartZone.add(game.YellowPawn2);
						game.YellowStartZone.setVisible(true);
						this.update(game,-1,4);
					}
					else if(j==6)
					{
						players.get(2).Pawn2.setzero();
						game.GreenStartZone.setVisible(false);
						game.GreenPawn2 = new JLabel("");
						game.GreenPawn2.setOpaque(true);
						game.GreenPawn2.setIcon(new ImageIcon("Images\\GreenPawn2.png"));
						game.GreenPawn2.setVisible(true);
						game.GreenPawn2.addMouseListener(test);
						game.GreenStartZone.add(game.GreenPawn2);
						game.GreenStartZone.setVisible(true);
						this.update(game,-1,6);
					}
					else if(j==8)
					{
						players.get(3).Pawn1.setzero();
						game.BlueStartZone.setVisible(false);
						game.BluePawn2 = new JLabel("");
						game.BluePawn2.setOpaque(true);
						game.BluePawn2.setIcon(new ImageIcon("Images\\BluePawn2.png"));
						game.BluePawn2.setVisible(true);
						game.BluePawn2.addMouseListener(test);
						game.BlueStartZone.add(game.BluePawn2);
						game.BlueStartZone.setVisible(true);
						this.update(game,-1,8);
					}
				}
			}
		}
	}
	
	public int inslide(int index,String colour)
	{
		if(index==0)
		{
			return 0;
		}

		if(colour.equals("RED"))
		{
			if(index==16)
			{
				return 3;
			}
			else if(index==24)
			{
				return 4;
			}
			else if(index==31)
			{
				return 3;
			}
			else if(index==39)
			{
				return 4;
			}
			else if(index==46)
			{
				return 3;
			}
			else if(index==54)
			{
				return 4;
			}
			else
			{
				return 0;
			}
		}
		else if(colour.equals("BLUE"))
		{
			if(index==1)
			{
				return 3;
			}
			else if(index==9)
			{
				return 4;
			}
			else if(index==31)
			{
				return 3;
			}
			else if(index==39)
			{
				return 4;
			}
			else if(index==46)
			{
				return 3;
			}
			else if(index==54)
			{
				return 4;
			}
			else
			{
				return 0;
			}
		}
		
		else if(colour.equals("YELLOW"))
		{
			if(index==1)
			{
				return 3;
			}
			else if(index==9)
			{
				return 4;
			}
			else if(index==16)
			{
				return 3;
			}
			else if(index==24)
			{
				return 4;
			}
			else if(index==46)
			{
				return 3;
			}
			else if(index==54)
			{
				return 4;
			}
			else
			{
				return 0;
			}
		}
		
		else if(colour.equals("GREEN"))
		{
			if(index==1)
			{
				return 3;
			}
			else if(index==9)
			{
				return 4;
			}
			else if(index==16)
			{
				return 3;
			}
			else if(index==24)
			{
				return 4;
			}
			else if(index==31)
			{
				return 3;
			}
			else if(index==39)
			{
				return 4;
			}
			else
			{
				return 0;
			}
		}
		return 0;
	}
	
	
	public void findcollision(int finalindex,ArrayList<Player>players,Board game,int turn,MouseListener test)
	{
		for (int i=0;i<players.size();i++)
		{
			if(i!=turn)
			{
				if(players.get(i).Pawn1.getindex()==finalindex)
				{
					players.get(i).Pawn1.setzero();
					String colour=players.get(i).getPlayerColor();
					if(colour.equals("RED"))
					{
						game.RedStartZone.setVisible(false);
						game.RedPawn1 = new JLabel("");
						game.RedPawn1.setOpaque(true);
						game.RedPawn1.setIcon(new ImageIcon("Images\\redPawn1.png"));
						game.RedPawn1.setVisible(true);
						game.RedPawn1.addMouseListener(test);
						game.RedStartZone.add(game.RedPawn1);
						game.RedStartZone.setVisible(true);
						this.update(game, -1, 1);

						
					}
					else if(colour.equals("YELLOW"))
					{
						game.YellowStartZone.setVisible(false);
						game.YellowPawn1 = new JLabel("");
						game.YellowPawn1.setOpaque(true);
						game.YellowPawn1.setIcon(new ImageIcon("Images\\yellowPawn1.png"));
						game.YellowPawn1.setVisible(true);
						game.YellowPawn1.addMouseListener(test);
						game.YellowStartZone.add(game.YellowPawn1);
						game.YellowStartZone.setVisible(true);
						this.update(game, -1, 3);
						
					}
					else if(colour.equals("GREEN"))
					{
						game.GreenStartZone.setVisible(false);
						game.GreenPawn1 = new JLabel("");
						game.GreenPawn1.setOpaque(true);
						game.GreenPawn1.setIcon(new ImageIcon("Images\\GreenPawn1.png"));
						game.GreenPawn1.setVisible(true);
						game.GreenPawn1.addMouseListener(test);
						game.GreenStartZone.add(game.GreenPawn1);
						game.GreenStartZone.setVisible(true);
						this.update(game, -1, 5);
					}
					else if(colour.equals("BLUE"))
					{
						game.BlueStartZone.setVisible(false);
						game.BluePawn1 = new JLabel("");
						game.BluePawn1.setOpaque(true);
						game.BluePawn1.setIcon(new ImageIcon("Images\\BluePawn1.png"));
						game.BluePawn1.setVisible(true);
						game.BluePawn1.addMouseListener(test);
						game.BlueStartZone.add(game.BluePawn1);
						game.BlueStartZone.setVisible(true);
						this.update(game, -1, 7);
					}
				}
				else if(players.get(i).Pawn2.getindex()==finalindex)
				{
					players.get(i).Pawn2.setzero();
					String colour=players.get(i).getPlayerColor();
					if(colour.equals("RED"))
					{	
						game.RedStartZone.setVisible(false);
						game.RedPawn2 = new JLabel("");
						game.RedPawn2.setOpaque(true);
						game.RedPawn2.setIcon(new ImageIcon("Images\\redPawn2.png"));
						game.RedPawn2.setVisible(true);
						game.RedPawn2.addMouseListener(test);
						game.RedStartZone.add(game.RedPawn2);
						game.RedStartZone.setVisible(true);
						this.update(game, -1, 2);
						
					}
					else if(colour.equals("YELLOW"))
					{
						game.YellowStartZone.setVisible(false);
						game.YellowPawn2 = new JLabel("");
						game.YellowPawn2.setOpaque(true);
						game.YellowPawn2.setIcon(new ImageIcon("Images\\yellowPawn2.png"));
						game.YellowPawn2.setVisible(true);
						game.YellowPawn2.addMouseListener(test);
						game.YellowStartZone.add(game.YellowPawn2);
						game.YellowStartZone.setVisible(true);
						this.update(game, -1, 4);
					}
					else if(colour.equals("GREEN"))
					{
						game.GreenStartZone.setVisible(false);
						game.GreenPawn2 = new JLabel("");
						game.GreenPawn2.setOpaque(true);
						game.GreenPawn2.setIcon(new ImageIcon("Images\\GreenPawn2.png"));
						game.GreenPawn2.setVisible(true);
						game.GreenPawn2.addMouseListener(test);
						game.GreenStartZone.add(game.GreenPawn2);
						game.GreenStartZone.setVisible(true);
						this.update(game, -1, 6);
					}
					else if(colour.equals("BLUE"))
					{
						game.BlueStartZone.setVisible(false);
						game.BluePawn2 = new JLabel("");
						game.BluePawn2.setOpaque(true);
						game.BluePawn2.setIcon(new ImageIcon("Images\\BluePawn2.png"));
						game.BluePawn2.setVisible(true);
						game.BluePawn2.addMouseListener(test);
						game.BlueStartZone.add(game.BluePawn2);
						game.BlueStartZone.setVisible(true);
						this.update(game, -1, 8);
					}
				}
			}
		}
	}
	

	
	public void println(ArrayList <Player> players)
	{
		for(int i=0;i<players.size();i++)
		{
			System.out.println("Round:"+players.get(i).getPlayerColor());
			System.out.println("First Pawn:steps index "+players.get(i).Pawn1.getsteps()+" "+players.get(i).Pawn1.getindex());
			System.out.println("Second Pawn:steps index "+players.get(i).Pawn2.getsteps()+" "+players.get(i).Pawn2.getindex());
			System.out.println("");
		}
	}
	
	public void addinsafezone(String colour,int pawn,Board game)
	{
		if(colour.equals("RED"))
		{
			if(pawn==1)
			{
				game.RedPawn1 = new JLabel("");
				game.RedPawn1.setOpaque(true);
				game.RedPawn1.setIcon(new ImageIcon("Images\\redPawn1.png"));
				game.RedHomeZone.setVisible(false);
				game.RedHomeZone.add(game.RedPawn1);
				game.RedPawn1.setVisible(true);
				game.RedHomeZone.setVisible(true);
				this.update(game, -1, 1);
			}
			else
			{
				game.RedPawn2 = new JLabel("");
				game.RedPawn2.setOpaque(true);
				game.RedPawn2.setIcon(new ImageIcon("Images\\redPawn2.png"));
				game.RedHomeZone.setVisible(false);
				game.RedHomeZone.add(game.RedPawn2);
				game.RedPawn2.setVisible(true);
				game.RedHomeZone.setVisible(true);
				this.update(game, -1, 2);

			}
		}
		else if(colour.equals("YELLOW"))
		{
			if(pawn==1)
			{
				game.YellowPawn1 = new JLabel("");
				game.YellowPawn1.setOpaque(true);
				game.YellowPawn1.setIcon(new ImageIcon("Images\\yellowPawn1.png"));
				game.YellowHomeZone.setVisible(false);
				game.YellowHomeZone.add(game.YellowPawn1);
				game.YellowPawn1.setVisible(true);
				game.YellowHomeZone.setVisible(true);
				this.update(game, -1, 3);
			}
			else
			{	
				game.YellowPawn2 = new JLabel("");
				game.YellowPawn2.setOpaque(true);
				game.YellowPawn2.setIcon(new ImageIcon("Images\\yellowPawn2.png"));
				game.YellowHomeZone.setVisible(false);
				game.YellowHomeZone.add(game.YellowPawn2);
				game.YellowPawn2.setVisible(true);
				game.YellowHomeZone.setVisible(true);
				this.update(game, -1, 4);
			}
		}
		else if(colour.equals("GREEN"))
		{
			if(pawn==1)
			{
				game.GreenPawn1 = new JLabel("");
				game.GreenPawn1.setOpaque(true);
				game.GreenPawn1.setIcon(new ImageIcon("Images\\GreenPawn1.png"));
				game.GreenHomeZone.setVisible(false);
				game.GreenHomeZone.add(game.GreenPawn1);
				game.GreenPawn1.setVisible(true);
				game.GreenHomeZone.setVisible(true);
				this.update(game, -1, 5);
			}
			else
			{
				game.GreenPawn2 = new JLabel("");
				game.GreenPawn2.setOpaque(true);
				game.GreenPawn2.setIcon(new ImageIcon("Images\\GreenPawn2.png"));
				game.GreenHomeZone.setVisible(false);
				game.GreenHomeZone.add(game.GreenPawn2);
				game.GreenPawn2.setVisible(true);
				game.GreenHomeZone.setVisible(true);
				this.update(game, -1, 6);
			}
		}
		else if(colour.equals("BLUE"))
		{
			if(pawn==1)
			{
				game.BluePawn1 = new JLabel("");
				game.BluePawn1.setOpaque(true);
				game.BluePawn1.setIcon(new ImageIcon("Images\\BluePawn1.png"));
				game.BlueHomeZone.setVisible(false);
				game.BlueHomeZone.add(game.BluePawn1);
				game.BluePawn1.setVisible(true);
				game.BlueHomeZone.setVisible(true);
				this.update(game, -1, 7);
			}
			else
			{
				game.BluePawn2 = new JLabel("");
				game.BluePawn2.setOpaque(true);
				game.BluePawn2.setIcon(new ImageIcon("Images\\BluePawn2.png"));
				game.BlueHomeZone.setVisible(false);
				game.BlueHomeZone.add(game.BluePawn2);
				game.BluePawn2.setVisible(true);
				game.BlueHomeZone.setVisible(true);
				this.update(game, -1, 8);
			}
		}
	}
	
	public int move(int startmove,Board game,Player player,int result,ArrayList<Player>players,MouseListener mouse)
	{
		String colour="";
		int finalmove=0;
		if(result==1)
		{
			colour=player.Pawn1.GetFirstPawnImageSource(player.getPlayerColor());
			finalmove=this.calculate(startmove,player.Pawn1.getindex(),player.Pawn1.getsteps(),player.getPlayerColor());
			int index=0;
			if(player.Pawn1.getindex()!=-1)
			{
				index=startmove+player.Pawn1.getindex();
			}
			int x=this.inslide(index, player.getPlayerColor());
			if(x!=0 && player.Pawn1.getsteps()+startmove<59)
			{
				int playerpawn=0;
				if(player.getPlayerColor().equals("RED"))
				{
					playerpawn=1;
				}
				else if(player.getPlayerColor().equals("YELLOW"))
				{
					playerpawn=3;
				}
				else if(player.getPlayerColor().equals("GREEN"))
				{
					playerpawn=5;
				}
				else if(player.getPlayerColor().equals("BLUE"))
				{
					playerpawn=7;
				}

				this.findandeliminateinslides(finalmove-x, finalmove, players, game,playerpawn,mouse);
				player.Pawn1.setsteps(x);
			}
			else
			{
				if(player.Pawn1.getsteps()+startmove<=59)
				{
					this.findcollision(finalmove, players, game, player.returnturn()-1, mouse);
				}
			}
		
			if(player.Pawn1.getindex()==-1)
			{
				player.Pawn1.setsteps(1);
			}
			else
			{
				player.Pawn1.setsteps(startmove);
			}
			if(player.Pawn1.getsteps()<60)
			{
				player.Pawn1.setindex(finalmove);
				game.squares[finalmove].setIcon(new ImageIcon(colour));
				if(player.getPlayerColor().equals("RED"))
				{
					game.RedPawn1=game.squares[finalmove];
					game.RedPawn1.addMouseListener(mouse);
				}
				else if(player.getPlayerColor().equals("YELLOW"))
				{
					game.YellowPawn1=game.squares[finalmove];
					game.YellowPawn1.addMouseListener(mouse);
				}
				else if(player.getPlayerColor().equals("GREEN"))
				{
					game.GreenPawn1=game.squares[finalmove];
					game.GreenPawn1.addMouseListener(mouse);
				}
				else if(player.getPlayerColor().equals("BLUE"))
				{
					game.BluePawn1=game.squares[finalmove];
					game.BluePawn1.addMouseListener(mouse);
				}
			}
			else if(player.Pawn1.getsteps()>=60 &&player.Pawn1.getsteps()<65)
			{
				player.Pawn1.setindex(player.Pawn1.getsteps());
				if(player.getPlayerColor().equals("RED"))
				{
					game.redsquares[finalmove].setIcon(new ImageIcon(colour));
					game.RedPawn1=game.redsquares[finalmove];
					game.RedPawn1.addMouseListener(mouse);
				}
				else if(player.getPlayerColor().equals("YELLOW"))
				{
					game.yellowsquares[finalmove].setIcon(new ImageIcon(colour));
					game.YellowPawn1=game.yellowsquares[finalmove];
					game.YellowPawn1.addMouseListener(mouse);
				}
				else if(player.getPlayerColor().equals("GREEN"))
				{
					game.greensquares[finalmove].setIcon(new ImageIcon(colour));
					game.GreenPawn1=game.greensquares[finalmove];
					game.GreenPawn1.addMouseListener(mouse);
				}
				else if(player.getPlayerColor().equals("BLUE"))
				{
					game.bluesquares[finalmove].setIcon(new ImageIcon(colour));
					game.BluePawn1=game.bluesquares[finalmove];
					game.BluePawn1.addMouseListener(mouse);
				}
			}
			else 
			{
				player.Pawn1.setindex(65);
				this.addinsafezone(player.getPlayerColor(),1, game);
			}
		}
		else if(result==2)
		{
			colour=player.Pawn2.GetSecondPawnImageSource(player.getPlayerColor());
			finalmove=this.calculate(startmove,player.Pawn2.getindex(),player.Pawn2.getsteps(),player.getPlayerColor());
			int index=0;
			if(player.Pawn2.getindex()!=-1)
			{
				index=startmove+player.Pawn2.getindex();
			}
			int x=this.inslide(index, player.getPlayerColor());
			if(x!=0 && player.Pawn2.getsteps()+startmove<59)
			{
				int playerpawn = 0;
				if(player.getPlayerColor().equals("RED"))
				{
					playerpawn=2;
				}
				else if(player.getPlayerColor().equals("YELLOW"))
				{
					playerpawn=4;
				}
				else if(player.getPlayerColor().equals("GREEN"))
				{
					playerpawn=6;
				}
				else if(player.getPlayerColor().equals("BLUE"))
				{
					playerpawn=8;
				}
				this.findandeliminateinslides(finalmove-x, finalmove, players, game,playerpawn,mouse);
				player.Pawn2.setsteps(x);
			}
			else
			{
				if(player.Pawn2.getsteps()+startmove<=59)
				{
					this.findcollision(finalmove, players, game, player.returnturn()-1, mouse);
				}
				
			}
			if(player.Pawn2.getindex()==-1)
			{
				player.Pawn2.setsteps(1);
			}
			else
			{
					player.Pawn2.setsteps(startmove);
			}
			if(player.Pawn2.getsteps()<60)
			{
				player.Pawn2.setindex(finalmove);
				game.squares[finalmove].setIcon(new ImageIcon(colour));
				if(player.getPlayerColor().equals("RED"))
				{
					game.RedPawn2=game.squares[finalmove];
					game.RedPawn2.addMouseListener(mouse);
				}
				else if(player.getPlayerColor().equals("YELLOW"))
				{
					game.YellowPawn2=game.squares[finalmove];
					game.YellowPawn2.addMouseListener(mouse);
				}
				else if(player.getPlayerColor().equals("GREEN"))
				{
					game.GreenPawn2=game.squares[finalmove];
					game.GreenPawn2.addMouseListener(mouse);
				}
				else if(player.getPlayerColor().equals("BLUE"))
				{
					game.BluePawn2=game.squares[finalmove];
					game.BluePawn2.addMouseListener(mouse);
				}
			}
			else if(player.Pawn2.getsteps()>=60 && player.Pawn2.getsteps()<65)
			{
				player.Pawn2.setindex(player.Pawn2.getsteps());
				if(player.getPlayerColor().equals("RED"))
				{
					game.redsquares[finalmove].setIcon(new ImageIcon(colour));
					game.RedPawn2=game.redsquares[finalmove];
					game.RedPawn2.addMouseListener(mouse);
				}
				else if(player.getPlayerColor().equals("YELLOW"))
				{
					game.yellowsquares[finalmove].setIcon(new ImageIcon(colour));
					game.YellowPawn2=game.yellowsquares[finalmove];
					game.YellowPawn2.addMouseListener(mouse);
				}
				else if(player.getPlayerColor().equals("GREEN"))
				{
					game.greensquares[finalmove].setIcon(new ImageIcon(colour));
					game.GreenPawn2=game.greensquares[finalmove];
					game.GreenPawn2.addMouseListener(mouse);
				}
				else if(player.getPlayerColor().equals("BLUE"))
				{
					game.bluesquares[finalmove].setIcon(new ImageIcon(colour));
					game.BluePawn2=game.bluesquares[finalmove];
					game.BluePawn2.addMouseListener(mouse);
				}
			}
			else if(finalmove==65)
			{
				player.Pawn2.setindex(65);
				this.addinsafezone(player.getPlayerColor(),2, game);
			}
		}
		return finalmove;
	}
	
	public int calculate(int move,int oldindex,int pawnstep,String colour)
	{
		if(move+pawnstep==65)
		{
			return 65;
		}
		if(pawnstep+move>=60 && pawnstep+move<65)
		{
			int result=pawnstep+move;
			int total=result-60;
			return total;
			
		}
		int index=oldindex+move;
		 if(oldindex==-1 && (move==1 || move==2))
		{
			if(colour.equals("RED"))
			{
				return 4;
			}
			else if(colour.equals("BLUE"))
			{
				return 19;
			}
			else if(colour.equals("YELLOW"))
			{
				return 34;
			}
			else if(colour.equals("GREEN"))
			{
				return 49;
			}
		}
		 if(index>59)
		{
			 index=oldindex;
			for(int i=0;i<Math.abs(move);i++)
			{
				index++;
				if(index>59)
				{
					index=0;
				}
			}
		}
		else if(index<0)
		{
			index=oldindex;
			for(int i=0;i<Math.abs(move);i++)
			{
				index--;
				if(index<0)
				{
					index=59;
				}
			}
		}
		if(colour.equals("RED"))
		{
			if(index==16)
			{
				return 19;
			}
			else if(index==24)
			{
				return 28;
			}
			else if(index==31)
			{
				return 34;
			}
			else if(index==39)
			{
				return 43;
			}
			else if(index==46)
			{
				return 49;
			}
			else if(index==54)
			{
				return 58;
			}
			else
			{
				return index;
			}
		}
		else if(colour.equals("BLUE"))
		{
			if(index==1)
			{
				return 4;
			}
			else if(index==9)
			{
				return 13;
			}
			else if(index==31)
			{
				return 34;
			}
			else if(index==39)
			{
				return 43;
			}
			else if(index==46)
			{
				return 49;
			}
			else if(index==54)
			{
				return 58;
			}
		}
		
		else if(colour.equals("YELLOW"))
		{
			if(index==1)
			{
				return 4;
			}
			else if(index==9)
			{
				return 13;
			}
			else if(index==16)
			{
				return 19;
			}
			else if(index==24)
			{
				return 28;
			}
			else if(index==46)
			{
				return 49;
			}
			else if(index==54)
			{
				return 58;
			}
		}
		
		else if(colour.equals("GREEN"))
		{
			if(index==1)
			{
				return 4;
			}
			else if(index==9)
			{
				return 13;
			}
			else if(index==16)
			{
				return 19;
			}
			else if(index==24)
			{
				return 28;
			}
			else if(index==31)
			{
				return 34;
			}
			else if(index==39)
			{
				return 43;
			}
		}
		return index;
	}
	
	
	
	public int checkmoves(Card card,Player player,Board game,ArrayList<Player> players,int option)
	{
		int cardinfo=card.getDescription();
		int result=0;
		if(cardinfo!=4 && cardinfo!=10 &&cardinfo!=13)
		{
			int spawn1=this.calculate(cardinfo, player.Pawn1.getindex(), player.Pawn1.getsteps(),player.getPlayerColor());
			if(player.Pawn1.getsteps()+cardinfo>59)
			{
				spawn1+=60;
			}
			int spawn2=this.calculate(cardinfo, player.Pawn2.getindex(), player.Pawn2.getsteps(),player.getPlayerColor());
			if(player.Pawn2.getsteps()+cardinfo>59)
			{
				spawn2+=60;
			}
			result=card.checkmovement(spawn1,player.Pawn2.getindex(), player.Pawn1.getsteps(), player.Pawn2.getsteps(), players,player.Pawn1.getindex());
			if(card.checkmovement(spawn2,player.Pawn1.getindex(), player.Pawn2.getsteps(), player.Pawn1.getsteps(), players,player.Pawn2.getindex())==1)
			{
				result+=2;
			}
			
			return result;
		}
		else if(cardinfo==4)
		{
			int spawn1=this.calculate(-4, player.Pawn1.index, player.Pawn1.steps,player.getPlayerColor());
			int spawn2=this.calculate(-4, player.Pawn2.index, player.Pawn2.steps,player.getPlayerColor());
			result=card.checkmovement(spawn1,player.Pawn2.getindex(), player.Pawn1.getsteps(), player.Pawn2.getsteps(), players,player.Pawn1.getindex());
			if(card.checkmovement(spawn2,player.Pawn1.getindex(), player.Pawn2.getsteps(), player.Pawn1.getsteps(), players,player.Pawn2.getindex())==1)
			{
				result+=2;
			}

			return result;
		}
		else if(cardinfo==10)
		{
			if(option==1)
			{
				int spawn1=this.calculate(10, player.Pawn1.index, player.Pawn1.steps,player.getPlayerColor());
				if(player.Pawn1.getsteps()+10>59)
				{
					spawn1+=60;
				}
				int spawn2=this.calculate(10, player.Pawn2.getindex(), player.Pawn2.getsteps(),player.getPlayerColor());
				if(player.Pawn2.getsteps()+10>59)
				{
					spawn2+=60;
				}
				result=card.checkmovement(spawn1,player.Pawn2.getindex(), player.Pawn1.getsteps(), player.Pawn2.getsteps(), players,player.Pawn1.getindex());
				if(card.checkmovement(spawn2,player.Pawn1.getindex(), player.Pawn2.getsteps(), player.Pawn1.getsteps(), players,player.Pawn2.getindex())==1)
				{
					result+=2;
				}

				return result;
			}
			else if(option==2)
			{
				int spawn1=this.calculate(-1, player.Pawn1.index, player.Pawn1.steps,player.getPlayerColor());
				int spawn2=this.calculate(-1, player.Pawn2.index, player.Pawn2.steps,player.getPlayerColor());
				result=((CardTen) card).checkmovement2(spawn1,player.Pawn2.getindex(), player.Pawn1.getsteps(), player.Pawn2.getsteps(), players,player.Pawn1.getindex());
				if(((CardTen) card).checkmovement2(spawn2,player.Pawn1.getindex(), player.Pawn2.getsteps(), player.Pawn1.getsteps(), players,player.Pawn2.getindex())==1)
				{
					result+=2;
				}

				return result;
			}
		}
		else if(cardinfo==11)
		{
			if(option==1)
			{
				int spawn1=this.calculate(11, player.Pawn1.index, player.Pawn1.steps,player.getPlayerColor());
				if(player.Pawn1.getsteps()+11>59)
				{
					spawn1+=60;
				}
				int spawn2=this.calculate(11, player.Pawn2.getindex(), player.Pawn2.getsteps(),player.getPlayerColor());
				if(player.Pawn2.getsteps()+11>59)
				{
					spawn2+=60;
				}
				result=card.checkmovement(spawn1,player.Pawn2.getindex(), player.Pawn1.getsteps(), player.Pawn2.getsteps(), players,player.Pawn1.getindex());
				if(card.checkmovement(spawn2,player.Pawn1.getindex(), player.Pawn2.getsteps(), player.Pawn1.getsteps(), players,player.Pawn2.getindex())==1)
				{
					result+=2;
				}

				return result;
			}
			else if(option==2)
			{
				int spawn1=this.calculate(0, player.Pawn1.index, player.Pawn1.steps,player.getPlayerColor());
				int spawn2=this.calculate(0, player.Pawn2.index, player.Pawn2.steps,player.getPlayerColor());
				result=((CardEleven) card).checkmovement2(spawn1,player.Pawn2.getindex(), player.Pawn1.getsteps(), player.Pawn2.getsteps(), players,player.Pawn1.getindex());
				if(((CardEleven) card).checkmovement2(spawn2,player.Pawn1.getindex(), player.Pawn2.getsteps(), player.Pawn1.getsteps(), players,player.Pawn2.getindex())==1)
				{
					result+=2;
				}

				return result;
			}
		}
		else if(cardinfo==13)
		{
			result=card.checkmovement(0,player.Pawn2.getindex(), player.Pawn1.getsteps(), player.Pawn2.getsteps(), players,player.Pawn1.getindex());
			if(card.checkmovement(0,player.Pawn1.getindex(), player.Pawn2.getsteps(), player.Pawn1.getsteps(), players,player.Pawn2.getindex())==1)
			{
				result+=2;
			}

			return result;
		}
		return result;
	}
	
	/**
	 * Create the 44 first cards
	 * @param cards arraylist for cards
	 * @pre should be called only once
	 * @post cards will be random each time
	 */
	public ArrayList<Card> createcards()
	{
		ArrayList<Card>cards=new ArrayList<Card>();
		
		for(int i=0;i<44;i++)
		{
			if(i<=3)
			{
				cards.add(new CardOne());
			} 
			else if(i<=7)
			{
				cards.add(new CardTwo());
			}
			else if(i<=11)
			{
				cards.add(new CardThree());
			}
			else if(i<=15)
			{
				cards.add(new CardFour());
			}
			else if(i<=19)
			{
				cards.add(new CardFive());
			}
			else if(i<=23)
			{
				cards.add(new CardSeven());
			}
			else if(i<=27)
			{
				cards.add(new CardEight());
			}
			else if(i<=31)
			{
				cards.add(new CardTen());
			}
			else if(i<=35)
			{
				cards.add(new CardEleven());
			}
			else if(i<=39)
			{
				cards.add(new CardTwelve());
			} 
			else if(i<=43)
			{
				cards.add(new SorryCard());
			} 
		} 
		return cards;
	}
}
	
	
	
	
	/**
	 * Moves the pawn
	 * @param pawn the pawn we want to move 
	 * @param index the index we want to put it
	 * @pre we should check if pawn can do that move
	 * @post if it is succesfull pawn will move ther
	 */
	
