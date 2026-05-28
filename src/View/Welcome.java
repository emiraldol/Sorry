package View;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextField;

/**
 *Welcome screen with some question before the start the real game! 
 */
public class Welcome 
{
	/*All of our variables we need and public so we can modify them from our model and controller */
	public JFrame window;
	public JButton StartGame;
	public JButton QuitGame;
	public JLabel Logo;
	public JLabel WelcomeText;
	public JTextField Player1;
	public JTextField Player2;
	public JTextField Player3;
	public JTextField Player4;
	public JSpinner Players;
	public JButton ok ;
	public JLabel fillText ;
	public JLabel Howmany;
	public JButton enter;
	
	/*Our main constructor which start the screen when called*/
	public Welcome()
	{
		/*We set the screen and set some variables set visible to false so we can modify them later and set them on */
		window=new JFrame("Welcome!");
		window.getContentPane().setBackground(new Color(255, 255, 255));
		window.setSize(804, 628);
		window.setLocationRelativeTo(null);
		window.setResizable(false);
		window.getContentPane().setLayout(null);
		
		Player1 = new JTextField();
		Player1.setVisible(false);
		Player1.setHorizontalAlignment(SwingConstants.CENTER);
		Player1.setText("Player 1 Name (RED)");
		Player1.setBounds(55, 43, 153, 32);
		window.getContentPane().add(Player1);
		Player1.setColumns(10);
		
		Player2 = new JTextField();
		Player2.setVisible(false);
		Player2.setText("Player 2 Name (YELLOW)");
		Player2.setHorizontalAlignment(SwingConstants.CENTER);
		Player2.setColumns(10);
		Player2.setBounds(55, 81, 153, 32);
		window.getContentPane().add(Player2);
		
		/*Examples here and below */
		Player3 = new JTextField();
		Player3.setVisible(false);
		Player3.setText("Player 3 Name (GREEN)");
		Player3.setHorizontalAlignment(SwingConstants.CENTER);
		Player3.setColumns(10);
		Player3.setBounds(55, 124, 153, 32);
		window.getContentPane().add(Player3);
		
		Player4 = new JTextField();
		Player4.setVisible(false);
		Player4.setText("Player 4 Name (BLUE)");
		Player4.setHorizontalAlignment(SwingConstants.CENTER);
		Player4.setColumns(10);
		Player4.setBounds(55, 167, 153, 32);
		window.getContentPane().add(Player4);
		
		enter = new JButton("Lets Play!");
		enter.setVisible(false);
		enter.setBounds(273, 103, 105, 49);
		window.getContentPane().add(enter);
		
		Players = new JSpinner();
		Players.setVisible(false);
		Players.setModel(new SpinnerNumberModel(2, 2, 4, 1));	
		Players.setBounds(226, 221, 126, 31);
		window.getContentPane().add(Players);
		
		Howmany = new JLabel("How Many People Will Play This Game?");
		Howmany.setVisible(false);
		Howmany.setFont(new Font("Tahoma", Font.BOLD, 20));
		Howmany.setBounds(196, 43, 529, 57);
		window.getContentPane().add(Howmany);
		
		fillText = new JLabel("Players :");
		fillText.setVisible(false);
		fillText.setFont(new Font("Tahoma", Font.BOLD, 19));
		fillText.setBounds(112, 217, 105, 39);
		window.getContentPane().add(fillText);
		
		ok = new JButton("ENTER\r\n");
		ok.setVisible(false);
		ok.setBounds(377, 217, 89, 39);
		window.getContentPane().add(ok);
		
	 	Logo = new JLabel("");
		Logo.setIcon(new ImageIcon("Images\\sorryintroduction.jpg"));
		Logo.setBounds(150, 11, 433, 366);
		window.getContentPane().add(Logo);
		
		WelcomeText = new JLabel("Project By CSD5059 Emiraldo Lamkia");
		WelcomeText.setFont(new Font("Tahoma", Font.BOLD, 20));
		WelcomeText.setBackground(new Color(255, 255, 255));
		WelcomeText.setHorizontalAlignment(SwingConstants.CENTER);
		WelcomeText.setBounds(160, 360, 497, 103);
		window.getContentPane().add(WelcomeText);
		
		StartGame = new JButton("Start Game");
		StartGame.setFont(new Font("Tahoma", Font.BOLD, 20));
		StartGame.setForeground(new Color(0, 0, 0));
		StartGame.setBackground(new Color(255, 255, 255));
		StartGame.setBounds(206, 477, 153, 76);
		window.getContentPane().add(StartGame);
		
		QuitGame = new JButton("Quit :(");
		QuitGame.setForeground(new Color(0, 0, 0));
		QuitGame.setFont(new Font("Tahoma", Font.BOLD, 20));
		QuitGame.setBackground(new Color(255, 255, 255));
		QuitGame.setBounds(393, 477, 153, 76);
		window.getContentPane().add(QuitGame); 
		window.setVisible(true);
	}
	/**
	 * Method which add ActionListener to All of button 
	 * @param ButtonHandler
	 * @pre ActionListener should be valid
	 * @post All our buttons have an actionlistener and can be controller from controller
	 */
	public void setActionListeners(ActionListener ButtonHandler)
	{
		this.QuitGame.addActionListener(ButtonHandler);
		this.StartGame.addActionListener(ButtonHandler);
		this.ok.addActionListener(ButtonHandler);
		this.enter.addActionListener(ButtonHandler);
	}
}
