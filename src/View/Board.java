package View;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import java.awt.Panel;
import java.awt.GridLayout;
import javax.swing.border.LineBorder;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;


/**
 * Main window for the game 
 */
public class Board extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*Our all variables we need so we can modify them from controller or model */
	public JTextArea Info;
	public JButton ReceiveCard;
	public JButton CurrectCard;
	public JButton FoldButton;
	public JButton NewGameButton;
	public JButton SaveGameButton;
	public JButton ContinueSavedGame;
	public JButton ExitGame;
	public JFrame window;
	public JLabel RedPawn1;
	public JLabel RedPawn2;
	public JLabel YellowPawn1;
	public JLabel YellowPawn2;
	public JLabel GreenPawn1;
	public JLabel GreenPawn2;
	public JLabel BluePawn1;
	public JLabel BluePawn2;
	public JPanel RedStartZone;
	public JPanel RedHomeZone;
	public JPanel GreenStartZone;
	public JPanel GreenHomeZone;
	public JPanel YellowStartZone;
	public JPanel YellowHomeZone;
	public JPanel BlueStartZone;
	public JPanel BlueHomeZone;
	public  JLabel squares[];
	public  JLabel redsquares[];
	public  JLabel yellowsquares[];
	public  JLabel bluesquares[];
	public JLabel greensquares[];
	public JButton Option1;
	public JButton Option2;
	public Panel upsquares;
	
	/**
	 * Main constructor which start the window
	 */
	public Board()
	{
		/*Creates the window with the buttons first */
		squares=new JLabel[60];
		redsquares=new JLabel[5];
		yellowsquares=new JLabel[5];
		bluesquares=new JLabel[5];
		greensquares=new JLabel[5];
		window=new JFrame();
		window.setResizable(false);
		window.setTitle("Sorry!");
		window.setSize(800, 545);
		setTitle("Sorry!");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		window.setLocationRelativeTo(null);
		
		CurrectCard = new JButton();
		CurrectCard.setVisible(false);
		CurrectCard.setOpaque(false);
		CurrectCard.setBounds(631, 84, 103, 154);
		window.getContentPane().add(CurrectCard);
		
		FoldButton = new JButton("Fold Button");
		FoldButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		FoldButton.setBackground(Color.red);
		FoldButton.setOpaque(true);
		FoldButton.setBounds(546, 285, 141, 47);
		window.getContentPane().add(FoldButton);
		
		/*The menu bar with the buttons on it */
		JMenuBar Menu = new JMenuBar();
		Menu.setFont(new Font("Segoe UI", Font.BOLD, 12));
		Menu.setBorderPainted(false);
		window.setJMenuBar(Menu);
		
		NewGameButton = new JButton("New Game");
		Menu.add(NewGameButton);
		
		 SaveGameButton = new JButton("Save Game");
		Menu.add(SaveGameButton);
		
		ContinueSavedGame = new JButton("Continued Saved Game");
		Menu.add(ContinueSavedGame);
		
		ExitGame = new JButton("Exit Game");
		Menu.add(ExitGame);
	
		/*Our logo in center and i started with up squares by passing them in GridLayout */
		JLabel Logo = new JLabel("");
		Logo.setIcon(new ImageIcon("Images\\sorryImage.png"));
		Logo.setBounds(162, 170, 133, 79);
		window.getContentPane().add(Logo);
		
		upsquares = new Panel();
		upsquares.setBounds(0, 0, 484, 29);
		window.getContentPane().add(upsquares);
		upsquares.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel up1 = new JLabel("");
		up1.setBackground(new Color(255, 255, 255));
		up1.setBorder(new LineBorder(new Color(0, 0, 0)));
		up1.setForeground(new Color(0, 0, 0));
		up1.setOpaque(true);
		upsquares.add(up1);
		squares[0]=up1;
		
		
		JLabel up2 = new JLabel("");
		up2.setBackground(new Color(255, 255, 255));
		up2.setIcon(new ImageIcon("Images\\redSlideStart.png"));
		up2.setBorder(new LineBorder(new Color(0, 0, 0)));
		up2.setOpaque(true);
		upsquares.add(up2);
		squares[1]=up2;

		
		JLabel up3 = new JLabel("");
		up3.setBackground(new Color(255, 255, 255));
		up3.setIcon(new ImageIcon("Images\\redSlideMedium.png"));
		up3.setBorder(new LineBorder(new Color(0, 0, 0)));
		up3.setOpaque(true);
		upsquares.add(up3);
		squares[2]=up3;

		
		JLabel up4 = new JLabel("");
		up4.setBackground(new Color(255, 255, 255));
		up4.setIcon(new ImageIcon("Images\\redSlideMedium.png"));
		up4.setBorder(new LineBorder(new Color(0, 0, 0)));
		up4.setOpaque(true);
		upsquares.add(up4);
		squares[3]=up4;
		
		JLabel up5 = new JLabel("");
		up5.setBackground(new Color(255, 255, 255));
		up5.setIcon(new ImageIcon("Images\\redSlideEnd.png"));
		up5.setBorder(new LineBorder(new Color(0, 0, 0)));
		up5.setOpaque(true);
		upsquares.add(up5);
		squares[4]=up5;
		
		JLabel up6 = new JLabel("");
		up6.setBackground(new Color(255, 255, 255));
		up6.setBorder(new LineBorder(new Color(0, 0, 0)));
		up6.setOpaque(true);
		upsquares.add(up6);
		squares[5]=up6;
		
		JLabel up7 = new JLabel("");
		up7.setBackground(new Color(255, 255, 255));
		up7.setBorder(new LineBorder(new Color(0, 0, 0)));
		up7.setOpaque(true);
		upsquares.add(up7);
		squares[6]=up7;
		
		JLabel up8 = new JLabel("");
		up8.setOpaque(true);
		up8.setBorder(new LineBorder(new Color(0, 0, 0)));
		up8.setBackground(Color.WHITE);
		upsquares.add(up8);
		squares[7]=up8;
		
		JLabel up9 = new JLabel("");
		up9.setBackground(new Color(255, 255, 255));
		up9.setBorder(new LineBorder(new Color(0, 0, 0)));
		up9.setOpaque(true);
		upsquares.add(up9);
		squares[8]=up9;
		
		JLabel up10 = new JLabel("");
		up10.setBackground(new Color(255, 255, 255));
		up10.setIcon(new ImageIcon("Images\\redSlideStart.png"));
		up10.setBorder(new LineBorder(new Color(0, 0, 0)));
		up10.setOpaque(true);
		upsquares.add(up10);
		squares[9]=up10;
		
		JLabel up11 = new JLabel("");
		up11.setBackground(new Color(255, 255, 255));
		up11.setIcon(new ImageIcon("Images\\redSlideMedium.png"));
		up11.setBorder(new LineBorder(new Color(0, 0, 0)));
		up11.setOpaque(true);
		upsquares.add(up11);
		squares[10]=up11;
		
		JLabel up12 = new JLabel("");
		up12.setBackground(new Color(255, 255, 255));
		up12.setIcon(new ImageIcon("Images\\redSlideMedium.png"));
		up12.setBorder(new LineBorder(new Color(0, 0, 0)));
		up12.setOpaque(true);
		upsquares.add(up12);
		squares[11]=up12;
		
		JLabel up13 = new JLabel("");
		up13.setBackground(new Color(255, 255, 255));
		up13.setIcon(new ImageIcon("Images\\redSlideMedium.png"));
		up13.setBorder(new LineBorder(new Color(0, 0, 0)));
		up13.setOpaque(true);
		upsquares.add(up13);
		squares[12]=up13;
		
		JLabel up14 = new JLabel("");
		up14.setBackground(new Color(255, 255, 255));
		up14.setIcon(new ImageIcon("Images\\redSlideEnd.png"));
		up14.setBorder(new LineBorder(new Color(0, 0, 0)));
		up14.setOpaque(true);
		upsquares.add(up14);
		squares[13]=up14;
		
		JLabel up15 = new JLabel("");
		up15.setBackground(new Color(255, 255, 255));
		up15.setIcon(null);
		up15.setBorder(new LineBorder(new Color(0, 0, 0)));
		up15.setOpaque(true);
		upsquares.add(up15);
		squares[14]=up15;
		
		JLabel up16 = new JLabel("");
		up16.setBackground(new Color(255, 255, 255));
		up16.setBorder(new LineBorder(new Color(0, 0, 0)));
		up16.setOpaque(true);
		upsquares.add(up16);
		squares[15]=up16;
		
		/*Then i continue with right squares also the same (14 however not 16 squares )*/
		JPanel rightsquares = new JPanel();
		rightsquares.setBounds(452, 25, 30, 398);
		window.getContentPane().add(rightsquares);
		rightsquares.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel right1 = new JLabel("");
		right1.setBackground(new Color(255, 255, 255));
		right1.setIcon(new ImageIcon("Images\\blueSlideStart.png"));
		right1.setOpaque(true);
		right1.setForeground(Color.BLACK);
		right1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		rightsquares.add(right1);
		squares[16]=right1;
		
		JLabel right2 = new JLabel("");
		right2.setBackground(new Color(255, 255, 255));
		right2.setIcon(new ImageIcon("Images\\blueSlideMedium.png"));
		right2.setOpaque(true);
		right2.setForeground(Color.BLACK);
		right2.setBorder(new LineBorder(new Color(0, 0, 0)));
		rightsquares.add(right2);
		squares[17]=right2;

		
		JLabel right3 = new JLabel("");
		right3.setBackground(new Color(255, 255, 255));
		right3.setIcon(new ImageIcon("Images\\blueSlideMedium.png"));
		right3.setOpaque(true);
		right3.setForeground(Color.BLACK);
		right3.setBorder(new LineBorder(new Color(0, 0, 0)));
		rightsquares.add(right3);
		squares[18]=right3;

		
		JLabel right4 = new JLabel("");
		right4.setBackground(new Color(255, 255, 255));
		right4.setIcon(new ImageIcon("Images\\blueSlideEnd.png"));
		right4.setOpaque(true);
		right4.setForeground(Color.BLACK);
		right4.setBorder(new LineBorder(new Color(0, 0, 0)));
		rightsquares.add(right4);
		squares[19]=right4;

		
		JLabel right5 = new JLabel("");
		right5.setBackground(new Color(255, 255, 255));
		right5.setOpaque(true);
		right5.setForeground(Color.BLACK);
		right5.setBorder(new LineBorder(new Color(0, 0, 0)));
		rightsquares.add(right5);
		squares[20]=right5;

		
		JLabel right6 = new JLabel("");
		right6.setBackground(new Color(255, 255, 255));
		right6.setOpaque(true);
		right6.setForeground(Color.BLACK);
		right6.setBorder(new LineBorder(new Color(0, 0, 0)));
		rightsquares.add(right6);
		squares[21]=right6;

		
		JLabel right7 = new JLabel("");
		right7.setBackground(new Color(255, 255, 255));
		right7.setOpaque(true);
		right7.setForeground(Color.BLACK);
		right7.setBorder(new LineBorder(new Color(0, 0, 0)));
		rightsquares.add(right7);
		squares[22]=right7;

		
		JLabel right8 = new JLabel("");
		right8.setBackground(new Color(255, 255, 255));
		right8.setOpaque(true);
		right8.setForeground(Color.BLACK);
		right8.setBorder(new LineBorder(new Color(0, 0, 0)));
		rightsquares.add(right8);
		squares[23]=right8;

		
		JLabel right9 = new JLabel("");
		right9.setBackground(new Color(255, 255, 255));
		right9.setIcon(new ImageIcon("Images\\blueSlideStart.png"));
		right9.setOpaque(true);
		right9.setForeground(Color.BLACK);
		right9.setBorder(new LineBorder(new Color(0, 0, 0)));
		rightsquares.add(right9);
		squares[24]=right9;

		
		JLabel right10 = new JLabel("");
		right10.setBackground(new Color(255, 255, 255));
		right10.setIcon(new ImageIcon("Images\\blueSlideMedium.png"));
		right10.setOpaque(true);
		right10.setForeground(Color.BLACK);
		right10.setBorder(new LineBorder(new Color(0, 0, 0)));
		rightsquares.add(right10);
		squares[25]=right10;

		
		JLabel right11 = new JLabel("");
		right11.setBackground(new Color(255, 255, 255));
		right11.setIcon(new ImageIcon("Images\\blueSlideMedium.png"));
		right11.setOpaque(true);
		right11.setForeground(Color.BLACK);
		right11.setBorder(new LineBorder(new Color(0, 0, 0)));
		rightsquares.add(right11);
		squares[26]=right11;

		
		JLabel right12 = new JLabel("");
		right12.setBackground(new Color(255, 255, 255));
		right12.setIcon(new ImageIcon("Images\\blueSlideMedium.png"));
		right12.setOpaque(true);
		right12.setForeground(Color.BLACK);
		right12.setBorder(new LineBorder(new Color(0, 0, 0)));
		rightsquares.add(right12);
		squares[27]=right12;

		
		JLabel right13 = new JLabel("");
		right13.setBackground(new Color(255, 255, 255));
		right13.setIcon(new ImageIcon("Images\\blueSlideEnd.png"));
		right13.setOpaque(true);
		right13.setForeground(Color.BLACK);
		right13.setBorder(new LineBorder(new Color(0, 0, 0)));
		rightsquares.add(right13);
		squares[28]=right13;

		
		JLabel right14 = new JLabel("");
		right14.setBackground(new Color(255, 255, 255));
		right14.setOpaque(true);
		right14.setForeground(Color.BLACK);
		right14.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		rightsquares.add(right14);
		squares[29]=right14;

		/*Then again same work but with down squares */
		Panel downsquares = new Panel();
		downsquares.setBounds(0, 422, 484, 29);
		window.getContentPane().add(downsquares);
		downsquares.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel down16 = new JLabel("");
		down16.setBackground(new Color(255, 255, 255));
		down16.setOpaque(true);
		down16.setForeground(Color.BLACK);
		down16.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		downsquares.add(down16);
		squares[45]=down16;

		
		JLabel down15 = new JLabel("");
		down15.setBackground(new Color(255, 255, 255));
		down15.setOpaque(true);
		down15.setBorder(new LineBorder(new Color(0, 0, 0)));
		downsquares.add(down15);
		squares[44]=down15;


		
		JLabel down14 = new JLabel("");
		down14.setBackground(new Color(255, 255, 255));
		down14.setIcon(new ImageIcon("Images\\yellowSlideEnd.jpg"));
		down14.setOpaque(true);
		down14.setBorder(new LineBorder(new Color(0, 0, 0)));
		downsquares.add(down14);
		squares[43]=down14;

		
		
		JLabel down13 = new JLabel("");
		down13.setBackground(new Color(255, 255, 255));
		down13.setIcon(new ImageIcon("Images\\yellowSlideMedium.png"));
		down13.setOpaque(true);
		down13.setBorder(new LineBorder(new Color(0, 0, 0)));
		downsquares.add(down13);
		squares[42]=down13;

		
		JLabel down12 = new JLabel("");
		down12.setBackground(new Color(255, 255, 255));
		down12.setIcon(new ImageIcon("Images\\yellowSlideMedium.png"));
		down12.setOpaque(true);
		down12.setBorder(new LineBorder(new Color(0, 0, 0)));
		downsquares.add(down12);
		squares[41]=down12;

		
		JLabel down11 = new JLabel("");
		down11.setBackground(new Color(255, 255, 255));
		down11.setIcon(new ImageIcon("Images\\yellowSlideMedium.png"));
		down11.setOpaque(true);
		down11.setBorder(new LineBorder(new Color(0, 0, 0)));
		downsquares.add(down11);
		squares[40]=down11;

		
		JLabel down10 = new JLabel("");
		down10.setBackground(new Color(255, 255, 255));
		down10.setIcon(new ImageIcon("Images\\yellowSlideStart.png"));
		down10.setOpaque(true);
		down10.setBorder(new LineBorder(new Color(0, 0, 0)));
		downsquares.add(down10);
		squares[39]=down10;

		
		JLabel down9 = new JLabel("");
		down9.setBackground(new Color(255, 255, 255));
		down9.setOpaque(true);
		down9.setBorder(new LineBorder(new Color(0, 0, 0)));
		downsquares.add(down9);
		squares[38]=down9;

				
		JLabel down8 = new JLabel("");
		down8.setBackground(new Color(255, 255, 255));
		down8.setOpaque(true);
		down8.setBorder(new LineBorder(new Color(0, 0, 0)));
		downsquares.add(down8);
		squares[37]=down8;

		
		JLabel down7 = new JLabel("");
		down7.setBackground(new Color(255, 255, 255));
		down7.setOpaque(true);
		down7.setBorder(new LineBorder(new Color(0, 0, 0)));
		downsquares.add(down7);
		squares[36]=down7;

		
		JLabel down6 = new JLabel("");
		down6.setOpaque(true);
		down6.setBorder(new LineBorder(new Color(0, 0, 0)));
		down6.setBackground(Color.WHITE);
		downsquares.add(down6);
		squares[35]=down6;

		
		JLabel down5 = new JLabel("");
		down5.setBackground(new Color(255, 255, 255));
		down5.setIcon(new ImageIcon("Images\\yellowSlideEnd.jpg"));
		down5.setOpaque(true);
		down5.setBorder(new LineBorder(new Color(0, 0, 0)));
		downsquares.add(down5);
		squares[34]=down5;

		
		JLabel	down4 = new JLabel("");
		down4.setBackground(new Color(255, 255, 255));
		down4.setIcon(new ImageIcon("Images\\yellowSlideMedium.png"));
		down4.setOpaque(true);
		down4.setBorder(new LineBorder(new Color(0, 0, 0)));
		downsquares.add(down4);
		squares[33]=down4;

		
		JLabel down3 = new JLabel("");
		down3.setBackground(new Color(255, 255, 255));
		down3.setIcon(new ImageIcon("Images\\yellowSlideMedium.png"));
		down3.setOpaque(true);
		down3.setBorder(new LineBorder(new Color(0, 0, 0)));
		downsquares.add(down3);
		squares[32]=down3;

		
		JLabel down2 = new JLabel("");
		down2.setBackground(new Color(255, 255, 255));
		down2.setIcon(new ImageIcon("Images\\yellowSlideStart.png"));
		down2.setOpaque(true);
		down2.setBorder(new LineBorder(new Color(0, 0, 0)));
		downsquares.add(down2);
		squares[31]=down2;

		
		JLabel down1 = new JLabel("");
		down1.setBackground(new Color(255, 255, 255));
		down1.setOpaque(true);
		down1.setBorder(new LineBorder(new Color(0, 0, 0)));
		downsquares.add(down1);
		squares[30]=down1;

		
		
		/*Lastly left squares */
		JPanel leftsquares = new JPanel();
		leftsquares.setBounds(2, 25, 30, 398);
		window.getContentPane().add(leftsquares);
		leftsquares.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel left14 = new JLabel("");
		left14.setBackground(new Color(255, 255, 255));
		left14.setOpaque(true);
		left14.setForeground(Color.BLACK);
		left14.setBorder(new LineBorder(new Color(0, 0, 0)));
		leftsquares.add(left14);
		squares[59]=left14;

				
		JLabel left13 = new JLabel("");
		left13.setIcon(new ImageIcon("Images\\greenSlideEnd.png"));
		left13.setOpaque(true);
		left13.setForeground(Color.BLACK);
		left13.setBorder(new LineBorder(new Color(0, 0, 0)));
		leftsquares.add(left13);
		squares[58]=left13;

		JLabel left12 = new JLabel("");
		left12.setIcon(new ImageIcon("Images\\greenSlideMedium.png"));
		left12.setOpaque(true);
		left12.setForeground(Color.BLACK);
		left12.setBorder(new LineBorder(new Color(0, 0, 0)));
		leftsquares.add(left12);
		squares[57]=left12;

		JLabel left11 = new JLabel("");
		left11.setIcon(new ImageIcon("Images\\greenSlideMedium.png"));
		left11.setOpaque(true);
		left11.setForeground(Color.BLACK);
		left11.setBorder(new LineBorder(new Color(0, 0, 0)));
		leftsquares.add(left11);
		squares[56]=left11;

				
		JLabel left10 = new JLabel("");
		left10.setIcon(new ImageIcon("Images\\greenSlideMedium.png"));
		left10.setOpaque(true);
		left10.setForeground(Color.BLACK);
		left10.setBorder(new LineBorder(new Color(0, 0, 0)));
		leftsquares.add(left10);
		squares[55]=left10;

				
				
		JLabel left9 = new JLabel("");
		left9.setIcon(new ImageIcon("Images\\greenSlideStart.png"));
		left9.setOpaque(true);
		left9.setForeground(Color.BLACK);
		left9.setBorder(new LineBorder(new Color(0, 0, 0)));
		leftsquares.add(left9);
		squares[54]=left9;

		
		
		JLabel left8 = new JLabel("");
		left8.setBackground(new Color(255, 255, 255));
		left8.setOpaque(true);
		left8.setForeground(Color.BLACK);
		left8.setBorder(new LineBorder(new Color(0, 0, 0)));
		leftsquares.add(left8);
		squares[53]=left8;

		
		
		JLabel left7 = new JLabel("");
		left7.setBackground(new Color(255, 255, 255));
		left7.setOpaque(true);
		left7.setForeground(Color.BLACK);
		left7.setBorder(new LineBorder(new Color(0, 0, 0)));
		leftsquares.add(left7);
		squares[52]=left7;

		
		
		JLabel left6 = new JLabel("");
		left6.setBackground(new Color(255, 255, 255));
		left6.setOpaque(true);
		left6.setForeground(Color.BLACK);
		left6.setBorder(new LineBorder(new Color(0, 0, 0)));
		leftsquares.add(left6);
		squares[51]=left6;

		
		
		JLabel left5 = new JLabel("");
		left5.setBackground(new Color(255, 255, 255));
		left5.setOpaque(true);
		left5.setForeground(Color.BLACK);
		left5.setBorder(new LineBorder(new Color(0, 0, 0)));
		leftsquares.add(left5);
		squares[50]=left5;


				
		JLabel left4 = new JLabel("");
		left4.setIcon(new ImageIcon("Images\\greenSlideEnd.png"));
		left4.setOpaque(true);
		left4.setForeground(Color.BLACK);
		left4.setBorder(new LineBorder(new Color(0, 0, 0)));
		leftsquares.add(left4);
		squares[49]=left4;

		
		
		JLabel left3 = new JLabel("");
		left3.setIcon(new ImageIcon("Images\\greenSlideMedium.png"));
		left3.setOpaque(true);
		left3.setForeground(Color.BLACK);
		left3.setBorder(new LineBorder(new Color(0, 0, 0)));
		leftsquares.add(left3);
		squares[48]=left3;

		
		JLabel left2 = new JLabel("");
		left2.setIcon(new ImageIcon("Images\\greenSlideMedium.png"));
		left2.setOpaque(true);
		left2.setForeground(Color.BLACK);
		left2.setBorder(new LineBorder(new Color(0, 0, 0)));
		leftsquares.add(left2);
		squares[47]=left2;
				
				
				
		JLabel left1=new JLabel();
		left1.setIcon(new ImageIcon("Images\\greenSlideStart.png"));
		left1.setOpaque(true);
		left1.setForeground(Color.BLACK);
		left1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		leftsquares.add(left1);
		squares[46]=left1;

				
		/*Then add all the players home zones */		
		BlueHomeZone = new JPanel();
		BlueHomeZone.setBackground(Color.WHITE);
		BlueHomeZone.setBounds(235, 55, 60, 30);
		window.getContentPane().add(BlueHomeZone);
		BlueHomeZone.setLayout(new GridLayout(1, 0, 0, 0));
		
		YellowHomeZone = new JPanel();
		YellowHomeZone.setBackground(Color.WHITE);
		YellowHomeZone.setBounds(374, 255, 60, 30);
		window.getContentPane().add(YellowHomeZone);
		YellowHomeZone.setLayout(new GridLayout(1, 0, 0, 0));
		
		GreenHomeZone = new JPanel();
		GreenHomeZone.setBackground(Color.WHITE);
		GreenHomeZone.setBounds(192, 364, 60, 30);
		window.getContentPane().add(GreenHomeZone);
		GreenHomeZone.setLayout(new GridLayout(1, 0, 0, 0));
		
		
		
		
		/*Each color has its own 5 squares before homezone */
		JLabel red1 = new JLabel("");
		red1.setBackground(new Color(255, 0, 0));
		red1.setOpaque(true);
		red1.setForeground(Color.BLACK);
		red1.setBorder(new LineBorder(new Color(0, 0, 0)));
		red1.setBounds(66, 29, 30, 28);
		window.getContentPane().add(red1);
		redsquares[0]=red1;
		
		JLabel red2 = new JLabel("");
		red2.setOpaque(true);
		red2.setForeground(Color.BLACK);
		red2.setBorder(new LineBorder(new Color(0, 0, 0)));
		red2.setBackground(Color.RED);
		red2.setBounds(66, 55, 30, 28);
		window.getContentPane().add(red2);
		redsquares[1]=red2;
		
		JLabel red3 = new JLabel("");
		red3.setOpaque(true);
		red3.setForeground(Color.BLACK);
		red3.setBorder(new LineBorder(new Color(0, 0, 0)));
		red3.setBackground(Color.RED);
		red3.setBounds(66, 83, 30, 28);
		window.getContentPane().add(red3);
		redsquares[2]=red3;
		
		JLabel red4 = new JLabel("");
		red4.setOpaque(true);
		red4.setForeground(Color.BLACK);
		red4.setBorder(new LineBorder(new Color(0, 0, 0)));
		red4.setBackground(Color.RED);
		red4.setBounds(66, 108, 30, 28);
		window.getContentPane().add(red4);
		redsquares[3]=red4;
		
		JLabel red5 = new JLabel("");
		red5.setOpaque(true);
		red5.setForeground(Color.BLACK);
		red5.setBorder(new LineBorder(new Color(0, 0, 0)));
		red5.setBackground(Color.RED);
		red5.setBounds(66, 136, 30, 28);
		window.getContentPane().add(red5);
		redsquares[4]=red5;
		
		RedStartZone = new JPanel();
		RedStartZone.setBackground(Color.WHITE);
		RedStartZone.setBounds(114, 33, 60, 30);
		window.getContentPane().add(RedStartZone);
		RedStartZone.setLayout(new GridLayout(1, 0, 0, 0));
		
		RedPawn1 = new JLabel("");
		RedPawn1.setIcon(new ImageIcon("Images\\redPawn1.png"));
		RedPawn1.setOpaque(true);
		RedStartZone.add(RedPawn1);
		RedPawn2 = new JLabel("");
		RedPawn2.setIcon(new ImageIcon("Images\\redPawn2.png"));
		RedPawn2.setOpaque(true);
		RedStartZone.add(RedPawn2);
		
		/*Also their start zone */
		JLabel StartRed = new JLabel("Start");
		StartRed.setVerticalAlignment(SwingConstants.BOTTOM);
		StartRed.setFont(new Font("Tahoma", Font.BOLD, 11));
		StartRed.setVerticalTextPosition(SwingConstants.TOP);
		StartRed.setBorder(new LineBorder(new Color(255, 0, 0), 3));
		StartRed.setHorizontalAlignment(SwingConstants.CENTER);
		StartRed.setBackground(new Color(255, 255, 255));
		StartRed.setOpaque(true);
		StartRed.setForeground(new Color(0, 0, 0));
		StartRed.setBounds(108, 29, 70, 63);
		window.getContentPane().add(StartRed);
		
		RedHomeZone = new JPanel();
		RedHomeZone.setBackground(Color.WHITE);
		RedHomeZone.setBounds(50, 170, 60, 30);
		window.getContentPane().add(RedHomeZone);
		RedHomeZone.setLayout(new GridLayout(1, 0, 0, 0));		
		
		
		JLabel HomeRed = new JLabel("Home");
		HomeRed.setVerticalAlignment(SwingConstants.BOTTOM);
		HomeRed.setFont(new Font("Tahoma", Font.BOLD, 11));
		HomeRed.setOpaque(true);
		HomeRed.setHorizontalAlignment(SwingConstants.CENTER);
		HomeRed.setForeground(new Color(0, 0, 0));
		HomeRed.setBorder(new LineBorder(new Color(255, 0, 0), 3));
		HomeRed.setBackground(Color.WHITE);
		HomeRed.setBounds(42, 163, 79, 54);
		window.getContentPane().add(HomeRed);

		JLabel yellow5 = new JLabel("");
		yellow5.setOpaque(true);
		yellow5.setForeground(Color.BLACK);
		yellow5.setBorder(new LineBorder(new Color(0, 0, 0)));
		yellow5.setBackground(new Color(255, 255, 0));
		yellow5.setBounds(392, 290, 30, 28);
		window.getContentPane().add(yellow5);
		yellowsquares[4]=yellow5;


		
		JLabel yellow4 = new JLabel("");
		yellow4.setOpaque(true);
		yellow4.setForeground(Color.BLACK);
		yellow4.setBorder(new LineBorder(new Color(0, 0, 0)));
		yellow4.setBackground(new Color(255, 255, 0));
		yellow4.setBounds(392, 315, 30, 28);
		window.getContentPane().add(yellow4);
		yellowsquares[3]=yellow4;

		
		JLabel yellow3 = new JLabel("");
		yellow3.setOpaque(true);
		yellow3.setForeground(Color.BLACK);
		yellow3.setBorder(new LineBorder(new Color(0, 0, 0)));
		yellow3.setBackground(new Color(255, 255, 0));
		yellow3.setBounds(392, 341, 30, 28);
		window.getContentPane().add(yellow3);
		yellowsquares[2]=yellow3;

		
		JLabel yellow2 = new JLabel("");
		yellow2.setOpaque(true);
		yellow2.setForeground(Color.BLACK);
		yellow2.setBorder(new LineBorder(new Color(0, 0, 0)));
		yellow2.setBackground(new Color(255, 255, 0));
		yellow2.setBounds(392, 368, 30, 28);
		window.getContentPane().add(yellow2);
		yellowsquares[1]=yellow2;

		
		JLabel yellow1 = new JLabel("");
		yellow1.setOpaque(true);
		yellow1.setForeground(Color.BLACK);
		yellow1.setBorder(new LineBorder(new Color(0, 0, 0)));
		yellow1.setBackground(new Color(255, 255, 0));
		yellow1.setBounds(392, 395, 30, 28);
		window.getContentPane().add(yellow1);
		yellowsquares[0]=yellow1;
		
		JLabel HomeYellow = new JLabel("Home");
		HomeYellow.setVerticalAlignment(SwingConstants.TOP);
		HomeYellow.setFont(new Font("Tahoma", Font.BOLD, 11));
		HomeYellow.setOpaque(true);
		HomeYellow.setHorizontalAlignment(SwingConstants.CENTER);
		HomeYellow.setForeground(new Color(0, 0, 0));
		HomeYellow.setBorder(new LineBorder(new Color(255, 255, 0), 3));
		HomeYellow.setBackground(Color.WHITE);
		HomeYellow.setBounds(365, 236, 77, 54);
		window.getContentPane().add(HomeYellow);
		
		YellowStartZone = new JPanel();
		YellowStartZone.setBackground(new Color(255, 255, 255));
		YellowStartZone.setBounds(300, 382, 60, 30);
		window.getContentPane().add(YellowStartZone);
		YellowStartZone.setLayout(new GridLayout(1, 0, 0, 0));
		
		YellowPawn1 = new JLabel("");
		YellowPawn1.setOpaque(true);
		YellowPawn1.setIcon(new ImageIcon("Images\\yellowPawn1.png"));
		YellowStartZone.add(YellowPawn1);
		
		YellowPawn2 = new JLabel("");
		YellowPawn2.setOpaque(true);
		YellowPawn2.setIcon(new ImageIcon("Images\\yellowPawn2.png"));
		YellowStartZone.add(YellowPawn2);
		
		
		
		JLabel StartYellow = new JLabel("Start");
		StartYellow.setVerticalTextPosition(SwingConstants.TOP);
		StartYellow.setVerticalAlignment(SwingConstants.TOP);
		StartYellow.setHorizontalAlignment(SwingConstants.CENTER);
		StartYellow.setOpaque(true);
		StartYellow.setForeground(new Color(0, 0, 0));
		StartYellow.setFont(new Font("Tahoma", Font.BOLD, 11));
		StartYellow.setBorder(new LineBorder(new Color(255, 255, 0), 3));
		StartYellow.setBackground(Color.WHITE);
		StartYellow.setBounds(293, 355, 77, 63);
		window.getContentPane().add(StartYellow);
		
		
		JLabel green1 = new JLabel("");
		green1.setBackground(new Color(0, 128, 64));
		green1.setOpaque(true);
		green1.setForeground(Color.BLACK);
		green1.setBorder(new LineBorder(new Color(0, 0, 0)));
		green1.setBounds(32, 364, 30, 28);
		window.getContentPane().add(green1);
		greensquares[0]=green1;
		
		JLabel green2 = new JLabel("");
		green2.setBackground(new Color(0, 128, 64));
		green2.setOpaque(true);
		green2.setForeground(Color.BLACK);
		green2.setBorder(new LineBorder(new Color(0, 0, 0)));
		green2.setBounds(61, 364, 30, 28);
		window.getContentPane().add(green2);
		greensquares[1]=green2;

		
		JLabel green3 = new JLabel("");
		green3.setBackground(new Color(0, 128, 64));
		green3.setOpaque(true);
		green3.setForeground(Color.BLACK);
		green3.setBorder(new LineBorder(new Color(0, 0, 0)));
		green3.setBounds(91, 364, 30, 28);
		window.getContentPane().add(green3);
		greensquares[2]=green3;

		
		JLabel green4 = new JLabel("");
		green4.setBackground(new Color(0, 128, 64));
		green4.setOpaque(true);
		green4.setForeground(Color.BLACK);
		green4.setBorder(new LineBorder(new Color(0, 0, 0)));
		green4.setBounds(121, 364, 30, 28);
		window.getContentPane().add(green4);
		greensquares[3]=green4;

		
		JLabel green5 = new JLabel("");
		green5.setBackground(new Color(0, 128, 64));
		green5.setOpaque(true);
		green5.setForeground(Color.BLACK);
		green5.setBorder(new LineBorder(new Color(0, 0, 0)));
		green5.setBounds(151, 364, 30, 28);
		window.getContentPane().add(green5);
		greensquares[4]=green5;

		
		
		BlueStartZone = new JPanel();
		BlueStartZone.setBackground(Color.WHITE);
		BlueStartZone.setBounds(382, 108, 60, 30);
		window.getContentPane().add(BlueStartZone);
		BlueStartZone.setLayout(new GridLayout(1, 0, 0, 0));
		
		BluePawn1 = new JLabel("");
		BluePawn1.setIcon(new ImageIcon("Images\\BluePawn1.png"));
		BluePawn1.setOpaque(true);
		BlueStartZone.add(BluePawn1);
		
		BluePawn2 = new JLabel("");
		BluePawn2.setIcon(new ImageIcon("Images\\BluePawn2.png"));
		BluePawn2.setOpaque(true);
		BlueStartZone.add(BluePawn2);
		
		JLabel GreenHome = new JLabel("Home");
		GreenHome.setVerticalAlignment(SwingConstants.TOP);
		GreenHome.setFont(new Font("Tahoma", Font.BOLD, 11));
		GreenHome.setHorizontalAlignment(SwingConstants.CENTER);
		GreenHome.setBorder(new LineBorder(new Color(0, 128, 64), 3));
		GreenHome.setOpaque(true);
		GreenHome.setBackground(new Color(255, 255, 255));
		GreenHome.setBounds(181, 339, 83, 63);
		window.getContentPane().add(GreenHome);
		
		GreenStartZone = new JPanel();
		GreenStartZone.setBackground(Color.WHITE);
		GreenStartZone.setBounds(42, 311, 60, 30);
		window.getContentPane().add(GreenStartZone);
		GreenStartZone.setLayout(new GridLayout(1, 0, 0, 0));
		
		GreenPawn1 = new JLabel("");
		GreenPawn1.setIcon(new ImageIcon("Images\\GreenPawn1.png"));
		GreenPawn1.setOpaque(true);
		GreenStartZone.add(GreenPawn1);
		
		GreenPawn2 = new JLabel("");
		GreenPawn2.setIcon(new ImageIcon("Images\\GreenPawn2.png"));
		GreenPawn2.setOpaque(true);
		GreenStartZone.add(GreenPawn2);
		
		
		JLabel GreenStart = new JLabel("Start");
		GreenStart.setBackground(new Color(255, 255, 255));
		GreenStart.setVerticalAlignment(SwingConstants.TOP);
		GreenStart.setHorizontalAlignment(SwingConstants.CENTER);
		GreenStart.setFont(new Font("Tahoma", Font.BOLD, 11));
		GreenStart.setOpaque(true);
		GreenStart.setBorder(new LineBorder(new Color(0, 128, 64), 3));
		GreenStart.setBounds(32, 290, 83, 63);
		window.getContentPane().add(GreenStart);
		
		JLabel blue5 = new JLabel("");
		blue5.setOpaque(true);
		blue5.setForeground(Color.BLACK);
		blue5.setBorder(new LineBorder(new Color(0, 0, 0)));
		blue5.setBackground(new Color(0, 128, 192));
		blue5.setBounds(302, 55, 30, 28);
		window.getContentPane().add(blue5);
		bluesquares[4]=blue5;
		
		JLabel blue4 = new JLabel("");
		blue4.setOpaque(true);
		blue4.setForeground(Color.BLACK);
		blue4.setBorder(new LineBorder(new Color(0, 0, 0)));
		blue4.setBackground(new Color(0, 128, 192));
		blue4.setBounds(332, 55, 30, 28);
		window.getContentPane().add(blue4);
		bluesquares[3]=blue4;

		
		JLabel blue3 = new JLabel("");
		blue3.setOpaque(true);
		blue3.setForeground(Color.BLACK);
		blue3.setBorder(new LineBorder(new Color(0, 0, 0)));
		blue3.setBackground(new Color(0, 128, 192));
		blue3.setBounds(362, 55, 30, 28);
		window.getContentPane().add(blue3);
		bluesquares[2]=blue3;

		
		JLabel blue2 = new JLabel("");
		blue2.setOpaque(true);
		blue2.setForeground(Color.BLACK);
		blue2.setBorder(new LineBorder(new Color(0, 0, 0)));
		blue2.setBackground(new Color(0, 128, 192));
		blue2.setBounds(392, 55, 30, 28);
		window.getContentPane().add(blue2);
		bluesquares[1]=blue2;

		
		JLabel blue1 = new JLabel("");
		blue1.setOpaque(true);
		blue1.setForeground(Color.BLACK);
		blue1.setBorder(new LineBorder(new Color(0, 0, 0)));
		blue1.setBackground(new Color(0, 128, 192));
		blue1.setBounds(422, 55, 30, 28);
		window.getContentPane().add(blue1);
		bluesquares[0]=blue1;


		
		JLabel BlueHome = new JLabel("Home");
		BlueHome.setVerticalAlignment(SwingConstants.TOP);
		BlueHome.setOpaque(true);
		BlueHome.setHorizontalAlignment(SwingConstants.CENTER);
		BlueHome.setFont(new Font("Tahoma", Font.BOLD, 11));
		BlueHome.setBorder(new LineBorder(new Color(0, 128, 192), 3));
		BlueHome.setBackground(Color.WHITE);
		BlueHome.setBounds(222, 37, 83, 54);
		window.getContentPane().add(BlueHome);
		
		JLabel BlueStart = new JLabel("Start");
		BlueStart.setBackground(new Color(255, 255, 255));
		BlueStart.setVerticalAlignment(SwingConstants.BOTTOM);
		BlueStart.setOpaque(true);
		BlueStart.setHorizontalAlignment(SwingConstants.CENTER);
		BlueStart.setFont(new Font("Tahoma", Font.BOLD, 11));
		BlueStart.setBorder(new LineBorder(new Color(0, 128, 192), 3));
		BlueStart.setBounds(372, 101, 82, 63);
		window.getContentPane().add(BlueStart);	
	
		/*Some Labels */
		JLabel ReceiveCardText = new JLabel("Receive Card");
		ReceiveCardText.setFont(new Font("Tahoma", Font.BOLD, 15));
		ReceiveCardText.setBounds(514, 244, 103, 24);
		window.getContentPane().add(ReceiveCardText);
		
		
		JLabel CurrentCardText = new JLabel("Current Card");
		CurrentCardText.setFont(new Font("Tahoma", Font.BOLD, 15));
		CurrentCardText.setBounds(631, 244, 103, 24);
		window.getContentPane().add(CurrentCardText);
		
		/*The text area and the currect card button and receive card button */
		Info = new JTextArea();
		Info.setEditable(false);
		Info.setText("Info Box:");
		Info.setBounds(513, 339, 261, 131);
		window.getContentPane().add(Info);
		
		
		ReceiveCard = new JButton();
		ReceiveCard.setIcon(new ImageIcon("Images\\backCard.png"));
		ReceiveCard.setBounds(513, 84, 103, 155);
		window.getContentPane().add(ReceiveCard);
		
		Option1 = new JButton("");
		Option1.setBounds(502, 11, 89, 35);
		Option1.setVisible(false);
		window.getContentPane().add(Option1);
		
		Option2 = new JButton("");
		Option2.setBounds(645, 11, 89, 35);
		Option2.setVisible(false);
		window.getContentPane().add(Option2);
		
		/*Finally the backgrounds ! */
		JLabel BlueLayout = new JLabel("");
		BlueLayout.setOpaque(true);
		BlueLayout.setBackground(new Color(0, 255, 255));
		BlueLayout.setBounds(10, -34, 465, 483);
		window.getContentPane().add(BlueLayout); 
		
		JLabel Background = new JLabel("");
		Background.setBackground(new Color(240, 240, 240));
		Background.setFont(new Font("Tahoma", Font.BOLD, 13));
		Background.setIcon(new ImageIcon("Images\\background.png"));
		Background.setBounds(0, -20, 798, 795);
		window.getContentPane().add(Background);
		
		
		window.setVisible(true);
		
		
	}
	/**
	 * Method which add actionlistener to all of our button
	 * @param ButtonHandler
	 * @pre ActionListener should be valid
	 * @post All button have actionListener
	 */
	public void setActionListeners(ActionListener ButtonHandler)
	{
		this.ReceiveCard.addActionListener(ButtonHandler);
		this.ExitGame.addActionListener(ButtonHandler);
		this.NewGameButton.addActionListener(ButtonHandler);
		this.CurrectCard.addActionListener(ButtonHandler);
		this.ContinueSavedGame.addActionListener(ButtonHandler);
		this.SaveGameButton.addActionListener(ButtonHandler);
		this.FoldButton.addActionListener(ButtonHandler);
	}
	
	public void setoptions(ActionListener options)
	{
		this.Option1.addActionListener(options);
		this.Option2.addActionListener(options);
	}
	
	public JLabel[] getsquares()
	{
		
		JLabel[] copiedArray=new JLabel[squares.length];
		for(int i=0;i<60;i++)
		{
			JLabel piece=new JLabel();
			piece.setIcon(squares[i].getIcon());
			copiedArray[i]=piece;
		}
		
		
		
		return copiedArray;
	}
	
	public JLabel[] getredsquares()
	{
		JLabel[] copiedArray=new JLabel[5];
		for(int i=0;i<5;i++)
		{
			JLabel piece=new JLabel();
			piece.setIcon(this.redsquares[i].getIcon());
			copiedArray[i]=piece;
		}	
		return copiedArray;
	}
	
	public JLabel[] getyellowsquares()
	{
		JLabel[] copiedArray=new JLabel[5];
		for(int i=0;i<5;i++)
		{
			JLabel piece=new JLabel();
			piece.setIcon(this.yellowsquares[i].getIcon());
			copiedArray[i]=piece;
		}	
		return copiedArray;
	}
	
	public JLabel[] getgreensquares()
	{
		JLabel[] copiedArray=new JLabel[5];
		for(int i=0;i<5;i++)
		{
			JLabel piece=new JLabel();
			piece.setIcon(this.greensquares[i].getIcon());
			copiedArray[i]=piece;
		}	
		return copiedArray;
	}
	
	public JLabel[] getbluesquares()
	{
		JLabel[] copiedArray=new JLabel[5];
		for(int i=0;i<5;i++)
		{
			JLabel piece=new JLabel();
			piece.setIcon(this.bluesquares[i].getIcon());
			copiedArray[i]=piece;
		}	
		return copiedArray;
	}
	
	
	public void setMouseListeners(MouseListener Mouse)
	{
		this.RedPawn1.addMouseListener(Mouse);
		this.RedPawn2.addMouseListener(Mouse);
		this.YellowPawn1.addMouseListener(Mouse);
		this.YellowPawn2.addMouseListener(Mouse);
		this.BluePawn1.addMouseListener(Mouse);
		this.BluePawn2.addMouseListener(Mouse);
		this.GreenPawn1.addMouseListener(Mouse);
		this.GreenPawn2.addMouseListener(Mouse);
		this.addMouseListener(Mouse);
	}
}

