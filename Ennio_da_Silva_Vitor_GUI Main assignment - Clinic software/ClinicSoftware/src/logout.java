import javax.swing.JFrame;
import javax.swing.JOptionPane;



@SuppressWarnings("serial")
public class logout extends JFrame  {
	
	
// This method does the confirmation where if the user wants or not to logout from the system	
	public logout(){
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationByPlatform(true);
		int option = JOptionPane.showConfirmDialog(this,
			    "Are you sure you want to logout?",
			    "clinic software - Logout",
			    JOptionPane.YES_NO_OPTION);
		
		if (option == JOptionPane.YES_OPTION  ){
			new login();
			
		}
		
	}

	
	
	
}
