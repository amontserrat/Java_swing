
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class Slider {

	public static void main(String[] args) {
		
		SliderFrame myFrame = new SliderFrame();

	}

}


class SliderFrame extends JFrame {
	
	public SliderFrame() {
		
		this.setBounds(500, 300, 500, 350);
		
		this.setTitle("Slider example");
		
		SliderPanel sliderPanel = new SliderPanel();
		
		this.add(sliderPanel);
		
		this.setVisible(true);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
}

/**
 * Class representing the panel with the slider and another panel with the message.
 * @author albert
 */
class SliderPanel extends JPanel {
	
	public SliderPanel() {
		
		this.setLayout(new BorderLayout());
		
		//create a new slider
		slider = new JSlider(0,42,20);
		
		//set slider configuration
		slider.setMajorTickSpacing(10);
		slider.setMinorTickSpacing(2);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setSnapToTicks(true);
		
		Font sliderFont = new Font("Calibri", Font.BOLD, 10);
		slider.setFont(sliderFont);
		
		slider.addChangeListener(new SliderEventManager());
		//add slider to this panel
		this.add(slider, BorderLayout.NORTH);
		
		//create new panel with a JLabel
		JPanel textPanel = new JPanel();
		textPanel.setLayout(new BorderLayout());
		
		message = new JLabel("Easy peasy lemon squeazy!");
		message.setFont(new Font("Serif", Font.PLAIN, 21));
		message.setHorizontalAlignment(SwingConstants.CENTER);
		
		textPanel.add(message, BorderLayout.CENTER);
		
		//add textPanel to this main Panel
		this.add(textPanel, BorderLayout.CENTER);
		
	}
	
	/**
	 * Inner class for handling change listeners. 
	 * @author albert
	 */
	private class SliderEventManager implements ChangeListener {

		//the size of the message updates its value according to the current value of the slider
		@Override
		public void stateChanged(ChangeEvent e) {
			Font updateFont = new Font("Serif", Font.PLAIN, slider.getValue());
			message.setFont(updateFont);
		}
		
	}
	
	//Class attributes
	private JSlider slider;
	private JLabel message;
	
}