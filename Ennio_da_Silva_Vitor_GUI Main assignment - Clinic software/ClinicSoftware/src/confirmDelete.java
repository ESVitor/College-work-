import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class confirmDelete extends JFrame {
	
	
// This method will confirm any delete action that will
// happen in any part of the entire program
	public confirmDelete(){
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationByPlatform(true);
		int option = JOptionPane.showConfirmDialog(this,
			    "Are you sure you want delete it?.",
			    "clinic software - Delete",
			    JOptionPane.YES_NO_OPTION);
		
		if (option == JOptionPane.YES_OPTION  ){
			
			
		}
// Here the command shutdown the program to avoid any modification not desired into the data base		
		if (option == JOptionPane.NO_OPTION  ){
			
			System.exit(0);
			
		}
 
		
	}

	
}