
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * 
 * @author albert
 *
 */
public class CheckBox {

	public static void main(String[] args) {
		CBFrame myFrame = new CBFrame();
	}
}


/**
 * Frame Class
 * @author albert
 *
 */
class CBFrame extends JFrame {
	public CBFrame() {
		
		this.setTitle("CheckBox example");
		
		this.setBounds(500, 300, 500, 350);

		CBSheet mySheet = new CBSheet();
		
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
class CBSheet extends JPanel {
	public CBSheet() {
		this.setLayout(new BorderLayout());
		
		Font myFont = new Font("Calibri", Font.PLAIN, 28);
		
		text = new JLabel("Easy peasy lemon squeezy!");
		text.setFont(myFont);
		
		JPanel textSheet = new JPanel();
		textSheet.add(text);
		
		//Add the sheet with the text to be changed
		this.add(textSheet, BorderLayout.CENTER);
		
		checkBox1 = new JCheckBox("Bold");
		checkBox2 = new JCheckBox("Italic");
		
		checkBox1.addActionListener(new CheckBoxManager());
		checkBox2.addActionListener(new CheckBoxManager());
		
		JPanel checkBoxSheet = new JPanel();
		checkBoxSheet.add(checkBox1);
		checkBoxSheet.add(checkBox2);
		
		//Add the sheet with the check boxes
		this.add(checkBoxSheet, BorderLayout.SOUTH);
	}
	
	//inner class
	private class CheckBoxManager implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			int fontType=0;
			
			/* Font Class constant values:
			 * Font.BOLD: 1
			 * Font.ITALIC: 2*/
			if (checkBox1.isSelected()) fontType+=Font.BOLD;
			if (checkBox2.isSelected()) fontType+=Font.ITALIC;
			
			text.setFont(new Font("Calibri", fontType, 28));
		}
		
	}
	
	//attributes
	private JLabel text;
	private JCheckBox checkBox1, checkBox2;

}