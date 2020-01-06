package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ComboBox {

	public static void main(String[] args) {
		BoxFrame myBoxFrame = new BoxFrame();
	}

}


class BoxFrame extends JFrame {
	
	public BoxFrame() {
		
		this.setBounds(500, 300, 500, 350);
		
		BoxPanel boxPanel = new BoxPanel();
		
		this.add(boxPanel);
		
		this.setVisible(true);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}


class BoxPanel extends JPanel {
	
	public BoxPanel() {
		
		this.setLayout(new BorderLayout());

		//create a new a label with some text and format
		message = new JLabel("Easy peasy lemon squeazy!");
		message.setFont(new Font("Calibri", Font.PLAIN, 22));

		//add the message to this panel
		this.add(message, BorderLayout.CENTER);
		
		//create new panel to insert the combo box on it
		JPanel boxPanel = new JPanel();
		
		//create box
		myComboBox = new JComboBox<>();
		
		//add items to the box
		myComboBox.addItem("BLUE");
		myComboBox.addItem("RED");
		myComboBox.addItem("GREEN");

		//add listener to the box
		myComboBox.addActionListener(new BoxManager());
		
		boxPanel.add(myComboBox);
		
		//insert the box on the north side of this panel
		this.add(boxPanel, BorderLayout.NORTH);
	}
	
	//inner class
	private class BoxManager implements ActionListener {
			
		@Override
		public void actionPerformed(ActionEvent e) {
			selectedItem = (String) myComboBox.getSelectedItem();
			//change the color of the message based on the selected item in the box
			if (selectedItem.equals("BLUE")) messageColor = Color.BLUE;
			if (selectedItem.equals("RED")) messageColor = Color.RED;
			if (selectedItem.equals("GREEN")) messageColor = Color.GREEN;
			message.setForeground(messageColor);
		}
		
		private String selectedItem;
		private Color messageColor;
		
	}
	
	private JLabel message;
	private JComboBox<String> myComboBox;
	
}