
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
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
		
		this.setBounds(500, 300, 500, 250);
		
		AreaSheet mySheet = new AreaSheet();
		
		this.add(mySheet);
		
		this.setVisible(true);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}


class AreaSheet extends JPanel {
	public AreaSheet() {
		
		myTextArea = new JTextArea(6, 15);
		myTextArea.setLineWrap(true);
		
		JScrollPane scrollSheet = new JScrollPane(myTextArea);
		
		this.add(scrollSheet);
		
		//When clicked, show the written text on the console
		JButton myButton = new JButton("Display on the console");
		myButton.addActionListener(new AreaManage());
		
		this.add(myButton);
	}
	
	private class AreaManage implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(myTextArea.getText());
		}
		
	}
	
	
	private JTextArea myTextArea;
}