
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToolBar;


public class Toolbar {

	public static void main(String[] args) {
		ToolbarFrame tbFrame = new ToolbarFrame();
	}

}


/**
 * Frame class
 */
class ToolbarFrame extends JFrame {
	
	public ToolbarFrame() {
		
		setTitle("Toolbar example");
		
		setBounds(700, 300, 500, 300);
		
		ToolbarPanel toolbarPanel = new ToolbarPanel();

		add(toolbarPanel);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);

	}
}


/**
 * Panel class
 */
class ToolbarPanel extends JPanel {
	
	//Constructor
	public ToolbarPanel() {
		
		this.setLayout(new BorderLayout());
		Action yellowAction = new MultipleColor("Yellow", new ImageIcon("img/yellow.png"), Color.YELLOW);
		Action blueAction = new MultipleColor("Blue", new ImageIcon("img/blue.png"), Color.BLUE);
		Action redAction = new MultipleColor("Red", new ImageIcon("img/red.png"), Color.RED);
			
		//Create menu and add Actions
		JMenu menu = new JMenu("Color");
		menu.add(yellowAction);
		menu.add(blueAction);
		menu.add(redAction);
		
		//Add menu to a menu bar
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(menu);
		
		//Add menu bar to this panel
		this.add(menuBar, BorderLayout.NORTH);
		
		
		//Create a new toolbar
		JToolBar toolBar = new JToolBar();
		
		//Add Actions to the toolbar
		toolBar.add(yellowAction);
		toolBar.add(blueAction);
		toolBar.add(redAction);
		
		//Set the toolbar into a vertical orientation
		toolBar.setOrientation(1);
		
		//Add toollbar to this panel
		this.add(toolBar, BorderLayout.WEST);
		
	}
	
	
	//inner class
	private class MultipleColor extends AbstractAction {
		
		public MultipleColor(String buttonName, Icon buttonIcon, Color buttonColor) {
			putValue(Action.NAME, buttonName);
			putValue(Action.SMALL_ICON, buttonIcon);
			putValue(Action.SHORT_DESCRIPTION, "Paint sheet with color " + buttonName);
			putValue("color_background", buttonColor);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Color c = (Color)getValue("color_background");
			setBackground(c);
			
		}
	}

}