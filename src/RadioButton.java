package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class RadioButton {

	public static void main(String[] args) {
		RB_Frame myFrame = new RB_Frame();

	}

}
	

/**
 * Frame Class
 * @author albert
 *
 */
class RB_Frame extends JFrame {
	public RB_Frame() {
		
		this.setTitle("RadioButton example");
		
		this.setBounds(500, 300, 500, 350);

		RB_Sheet mySheet = new RB_Sheet();
		
		this.add(mySheet);
		
		this.setVisible(true);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}


/**
 * Sheet Class
 * @author albert
 *
 */
class RB_Sheet extends JPanel {
	
	public RB_Sheet() {
		//Set Layout for RB_Sheet
		this.setLayout(new BorderLayout());
		
		message = new JLabel("Esy peasy lemon squeezy");
		message.setFont(new Font("Calibri", Font.PLAIN, 12));
		message.setForeground(Color.RED);
		
		this.add(message, BorderLayout.CENTER);
		
		//Create a new sheet panel to insert buttons on it
		RB_Sheet2 = new JPanel();
		
		//Create a ButtonGroup to group all buttons together
		RBGroup1 = new ButtonGroup();

		//Insert RButtons to RB_Sheet2  
		this.insertButton("Red", true, 12, Color.RED);
		this.insertButton("Blue", true, 18, Color.BLUE);
		this.insertButton("Green", true, 24, Color.GREEN);
		this.insertButton("Pink", true, 30, Color.PINK);
	
		//Add RB_Sheet2 to this Sheet Panel on the SOUTH Border
		this.add(RB_Sheet2, BorderLayout.SOUTH);
	
	}
	
	//method
	public void insertButton(String name, boolean selected, final int fontSize, Color textColor) {
		
		JRadioButton button = new JRadioButton(name, selected);
		
		RBGroup1.add(button);
		
		RB_Sheet2.add(button);
		
		ActionListener event = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				message.setFont(new Font("Calibri", Font.PLAIN, fontSize));
				message.setForeground(textColor);
			}
		};
		
		button.addActionListener(event);
	}

	
	//Attributes
	private JLabel message;
	private JRadioButton button1, button2, button3, button4;
	private ButtonGroup RBGroup1;
	private JPanel RB_Sheet2;

}