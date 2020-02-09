
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class Spinner {

	public static void main(String[] args) {
		SpinnerFrame myFrame = new SpinnerFrame();
	}
}


/**
 * Class representing the frame
 * @author albert
 */
class SpinnerFrame extends JFrame {
	
	public SpinnerFrame() {
		
		this.setBounds(500, 300, 300, 150);
		
		this.setTitle("Spinner example");
		
		SpinnerPanel spinnerPanel = new SpinnerPanel();
		
		this.add(spinnerPanel);
		
		this.setVisible(true);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}


/**
 * Class representing the panel with the spinner.
 * @author albert
 */
class SpinnerPanel extends JPanel {
	
	public SpinnerPanel() {
		
		this.setLayout(new BorderLayout());
		
		/* Panel containing the two spinners */
		JPanel spinnerPanel = new JPanel();
		
		//spinner 1: colors
		String colors[] = {"Red", "Green", "Blue"};
		
		spinColors = new JSpinner(new SpinnerListModel(colors));
		
		spinColors.setPreferredSize(new Dimension(80, 20));
		
		spinColors.addChangeListener(new SpinnerManager(spinColors));
		
		//spinner 2: numbers, inverting the control of the spinner			
		spinSize = new JSpinner(new SpinnerNumberModel(12,0,30,2) {
		
			public Object getNextValue() {
				return super.getPreviousValue();
			}
			
			public Object getPreviousValue() {
				return super.getNextValue();
			}	
		
		});
		
		spinSize.addChangeListener(new SpinnerManager(spinSize));
		
		
		//Add the two spinners to the spinnerPanel
		spinnerPanel.add(spinColors);
		spinnerPanel.add(spinSize);
		
		
		//------------------------------------------------------------
		/* Panel containing the message */
		
		JPanel textPanel = new JPanel();
		
		message = new JLabel("Hello World");		
		
		textPanel.add(message);
		
		//Add the two panels into this main Panel
		this.add(spinnerPanel, BorderLayout.NORTH);
		this.add(textPanel, BorderLayout.SOUTH);
	}
	
	
	private class SpinnerManager implements ChangeListener {
		
		JSpinner spinnerType;
		
		SpinnerManager (JSpinner spinner) {
			spinnerType = spinner;
		}
		
		Color messageColor;
		
		String spinnerColor;
		
		@Override
		public void stateChanged(ChangeEvent e) {
			
			//if the selected spinner is spinColors then change message color
			if (spinnerType.getValue() instanceof String) {
				spinnerColor = spinColors.getValue().toString();
				
				if (spinnerColor.equals("Red")) {
					messageColor = Color.RED;
				} else if (spinnerColor.equals("Green")) {
					messageColor = Color.GREEN;
				} else if (spinnerColor.equals("Blue")) {
					messageColor = Color.BLUE;
				}
				
				message.setForeground(messageColor);
			}
			//if the selected spinner is spinSize then change message size
			else if (spinnerType.getValue() instanceof Integer) {
				message.setFont(new Font(message.getFont().getName(), message.getFont().getStyle(), (int) spinnerType.getValue()));
			}			
		}
	}
	
	//Class attributes
	private JLabel message;
	private JSpinner spinColors;
	private JSpinner spinSize;	
}




