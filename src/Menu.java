
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Menu {

	public static void main(String[] args) {
		
		MenuFrame myFrame = new MenuFrame();

	}

}


/**
 * Frame class
 * @author albert
 *
 */
class MenuFrame extends JFrame {
	
	public MenuFrame() {
		
		this.setBounds(500, 300, 400, 250);
		
		this.setTitle("Menu example");
		
		MenuPanel menuPanel = new MenuPanel();
		
		this.add(menuPanel);
		
		this.setVisible(true);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}


/**
 * Class representing the panel with the menu bar, menu items and sub-items
 * @author albert
 */
class MenuPanel extends JPanel {
	
	public MenuPanel() {
		
		//Create a manu bar
		JMenuBar menuBar = new JMenuBar();
		
		//Create menu option to be added to the bar
		JMenu menu1 = new JMenu("Option 1");
		JMenu menu2 = new JMenu("Option 2");
		
		//Create items for each menu option
		//items 'A' and 'B' contain an image
		JMenuItem menu1Item1 = new JMenuItem("A", new ImageIcon("img/iconA.png"));
		JMenuItem menu1Item2 = new JMenuItem("B", new ImageIcon("img/iconB.png"));
		JMenuItem menu2Item1 = new JMenuItem("C");
		JMenuItem menu2Item2 = new JMenuItem("D");
		//menu2Item3 is a JMenu because it will contain JMenuItem objects itself
		JMenu menu2Item3 = new JMenu("E");
		JMenuItem menu2Item4 = new JMenuItem("F");
		JMenuItem menu2Item5 = new JMenuItem("G");
		
		//Add items to each menu option, including separators
		menu1.add(menu1Item1);
		menu1.addSeparator();
		menu1.add(menu1Item2);
		
		menu2.add(menu2Item1);
		menu2.addSeparator();
		menu2.add(menu2Item2);
		menu2.addSeparator();
		menu2Item3.add(menu2Item4);
		menu2Item3.addSeparator();
		menu2Item3.add(menu2Item5);
		menu2.add(menu2Item3);
		
		//Add menu options to the bar
		menuBar.add(menu1);
		menuBar.add(menu2);
		
		//Add the menu bar to this panel
		this.add(menuBar);
		
	}	
}
