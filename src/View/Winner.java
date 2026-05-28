package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;

public class Winner extends JFrame
{
	public JLabel msg;
	public JFrame window;
	private JLabel lblNewLabel;
	
	
	public Winner()
	{
		window=new JFrame("WINNER!");
		window.getContentPane().setBackground(new Color(255, 255, 255));
		window.setSize(804, 628);
		window.setLocationRelativeTo(null);
		window.setResizable(false);
		window.getContentPane().setLayout(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		msg = new JLabel("Winner is:");
		msg.setFont(new Font("Tahoma", Font.PLAIN, 18));
		msg.setHorizontalAlignment(SwingConstants.CENTER);
		msg.setBounds(214, 59, 303, 73);
		window.getContentPane().add(msg);
		
		JLabel lblNewLabel_1 = new JLabel("Thanks for playing!");
		lblNewLabel_1.setBounds(27, 293, 123, 39);
		window.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("Images\\finalwinner.png"));
		lblNewLabel.setBounds(131, 178, 623, 341);
		window.getContentPane().add(lblNewLabel);
		window.setVisible(true);
		
	}
}
