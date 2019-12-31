
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Usage example of the JTextArea swing component combined with JButtons
 * 
 * @author albert
 *
 */
public class TextArea {

	public static void main(String[] args) {
		AreaFrame myFrame = new AreaFrame();

	}

}


class AreaFrame extends JFrame {
	public AreaFrame() {
		
		this.setBounds(400, 300, 400, 250);
		
		AreaSheet mySheet = new AreaSheet();
		
		this.add(mySheet);
		
		this.setVisible(true);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}


class AreaSheet extends JPanel {
	public AreaSheet() {
		
		this.add(new JLabel("The white box below is a JTextArea"));
		
		myTextArea = new JTextArea(6, 15);
		myTextArea.setLineWrap(true);
		
		JScrollPane scrollSheet = new JScrollPane(myTextArea);
		
		this.add(scrollSheet);
		
		//new Panel to add buttons on it
		JPanel buttonsPanel = new JPanel();
		
		//When clicked, show the written text on the console
		myButton = new JButton("Display on the console");
		myButton.addActionListener(new AreaManage());
		
		//Button to remove content of text area
		remButton = new JButton("Remove content");
		remButton.addActionListener(new AreaManage());
		
		buttonsPanel.add(myButton);
		buttonsPanel.add(remButton);
		
		this.add(buttonsPanel);
	}
	
	private class AreaManage implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
			
			if (source == myButton) {	//print on the console
				System.out.println(myTextArea.getText());
			}
			else if (source == remButton) {	//remove content
				myTextArea.setText(null);
			}
		}
		
	}
	
	
	private JTextArea myTextArea;
	private JButton myButton;
	private JButton remButton;
}