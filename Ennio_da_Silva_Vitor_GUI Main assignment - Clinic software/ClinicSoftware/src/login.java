import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class login extends JFrame implements ActionListener {
	
	JTextField username = null;
	JTextField password = null;
	
	
	
	
	public login(){
	
		this.setTitle("clinic software - Login");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocation(350, 200);
		setSize(512,320);
		setVisible(true);
	  
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
    
    
		JLabel lg = new JLabel("Login");
		c.insets = new Insets(0,0,20,0);
		c.gridx = 1;
		this.add(lg, c);
    
    
		JLabel uname = new JLabel("Username:");
		c.insets = new Insets(10,0,0,0);
		c.gridx = 0;
		c.gridy = 1;
		this.add(uname, c);
    
 
		username = new JTextField(20);
		c.ipady = 3;      //make this component tall
		c.gridwidth = 1;
		c.insets = new Insets(10,5,0,0);  //top padding
		c.gridx = 1;
		c.gridy = 1;
		this.add(username, c);
    
    
		JLabel pword = new JLabel("Password:");
		c.insets = new Insets(10,0,0,0);  //top padding
		c.gridx = 0;
		c.gridy = 2;
		this.add(pword, c);
    
		password = new JTextField(20);
		c.ipady = 3;      //make this component tall
		c.gridwidth = 1;
		c.insets = new Insets(10,5,0,0);  //top padding
		c.gridx = 1;
		c.gridy = 2;
		this.add(password, c);
    
		JButton login = new JButton("Login!");
		login.addActionListener(this);
		login.setActionCommand("login");
		c.insets = new Insets(20,0,0,100);  
		c.gridx = 1;
		c.gridy = 3;
		this.add(login, c);
    
		JButton register = new JButton("Register");
		register.addActionListener(this);
		register.setActionCommand("register");
		c.insets = new Insets(20,100,0,0);  
		c.gridx = 1;
		c.gridy = 3;
		this.add(register, c);
	
 
    
		validate();
		repaint();
    
    
    }
	
	public static void main(String[] args) {
	
		new login();
	}
	
	
	
	public void loginWithDatabase(){
		
		
	
	
		
		try {
			
		  Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		}catch(Exception e ){}
		
		
		Connection conn = null;
    	Statement stmt = null;
    	ResultSet rs = null;
    	
    	
    	try {
    		
    	    conn =
    	       DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/clinic?user=root&password=");

// Do something with the Connection
    	    stmt = conn.createStatement();

  

    	    String un = username.getText();
    	    String pw = password.getText();
    	    
    	   
    	    
    	    
    	    if (stmt.execute("select * from `user` where username = '"+un+"' and password = '"+pw+"'")) {
    	        rs = stmt.getResultSet();
    	    }

// loop over results
    	    
    	    while(rs.next()){
    	    
    	    	 	    
    	        String type = rs.getString("type");
    	      
    	       
    	        
    	        if(type.equals("doctor")){
    	        	
    	        	this.setVisible(false);
    	        	
    	        	String user2 = username.getText(); 
    	        	
    	        	new doctor(user2 );
    	        	
    	        	
    	        }
    	        else if(type.equals("reception")){
    	        	
    	        	this.setVisible(false);
    	        	new reception();
    	        }
        	    
    	        else if(type.equals("billing")){
    	        	
    	        	this.setVisible(false);
    	        	new billing();
    	        }
    	        
    	       
    	        
    	    } 
    	   
    	
    	
    	
    	} catch (SQLException ex) {
    	    // handle any errors
    	    System.out.println("SQLException: " + ex.getMessage());
    	    System.out.println("SQLState: " + ex.getSQLState());
    	    System.out.println("VendorError: " + ex.getErrorCode());
    	}
   	
}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getActionCommand().equals("login")){
	
			if(username.getText().equals("")){
				JOptionPane.showMessageDialog(this, "Please insert a username and password!");
				
				
			}
	
			else {
				loginWithDatabase();
			}
	
		}

		
		if(e.getActionCommand().equals("register")){
			this.setVisible(false);
			new register();
		}
		
	}
	
	
}