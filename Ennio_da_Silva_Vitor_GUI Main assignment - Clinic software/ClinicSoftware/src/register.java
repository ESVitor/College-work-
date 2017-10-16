import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class register extends JFrame implements ActionListener {
	
	JTextField f_name = null;
	JTextField surname = null;
	JTextField b_date = null;
	JTextField username = null;
	JTextField password = null;
	@SuppressWarnings("rawtypes")
	JComboBox utype = null;
	
	JTextField d_by_id = null;
	
	public register(){
		
		this.setTitle("clinic software - Register");
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setLocation(350, 100);
		
		setSize(512,520);
		setVisible(true);
		 
		 JMenuBar bar = new JMenuBar();
	      this.setJMenuBar(bar);
	          JMenu file = new JMenu("File");
	          bar.add(file);
	              
	          	  	              
	              JMenuItem logout = new JMenuItem("Log out");
	              logout.addActionListener(this);
	              logout.setActionCommand("logout");
	              file.add(logout);
		
		
	    this.setLayout(new GridBagLayout());
	    GridBagConstraints c = new GridBagConstraints();
	
	    
	    JLabel r = new JLabel("Register");
	    c.gridwidth = 1;
	    c.insets = new Insets(20,0,0,-300);  
	    c.gridx = 0;
	    c.gridy = 0;
	    
	    this.add(r, c);
	    
	    
	    JLabel fn = new JLabel("First name");
	    c.gridwidth = 1;
	    c.insets = new Insets(20,0,0,0);  
	    c.gridy = 1;
	    this.add(fn, c);
	    
	    f_name = new JTextField(20);
		c.ipady = 3;      
	    c.gridwidth = 1;
	    c.insets = new Insets(20,20,0,0); 
	    c.gridx = 1;
	    c.gridy = 1;
	    this.add(f_name, c);
	    
	    JLabel sn = new JLabel("Surname");
	    c.gridwidth = 1;
	    c.insets = new Insets(20,0,0,0); 
	    c.gridx = 0;
	    c.gridy = 2;
	    this.add(sn, c);
	    
	    surname = new JTextField(20);
		c.ipady = 3;      
		c.gridwidth = 1;
	    c.insets = new Insets(20,20,0,0); 
	    c.gridx = 1;
	    c.gridy = 2;
	    this.add(surname, c);
	    
	    JLabel bd = new JLabel("Birth date");
	    c.gridwidth = 1;
	    c.insets = new Insets(20,0,0,0);  
	    c.gridx = 0;
	    c.gridy = 3;
	    this.add(bd, c);
	    
	    b_date = new JTextField(20);
		c.ipady = 3;      
	    c.gridwidth = 1;
	    c.insets = new Insets(20,20,0,0);  
	    c.gridx = 1;
	    c.gridy = 3;
	    this.add(b_date, c);
	    
	    
	    
	    JLabel un = new JLabel("User name");
	    c.gridwidth = 1;
	    c.insets = new Insets(20,0,0,0);  
	    c.gridx = 0;
	    c.gridy = 4;
	    this.add(un, c);
	    
	    username = new JTextField(20);
		c.ipady = 3;      
	    c.gridwidth = 1;
	    c.insets = new Insets(20,20,0,0);  
	    c.gridx = 1;
	    c.gridy = 4;
	    this.add(username, c);
	    
	    JLabel pw = new JLabel("Password");
	    c.gridwidth = 1;
	    c.insets = new Insets(20,0,0,0);  
	    c.gridx = 0;
	    c.gridy = 5;
	    this.add(pw, c);
	    
	    password = new JTextField(20);
		c.ipady = 3;      
	    c.gridwidth = 1;
	    c.insets = new Insets(20,20,0,0);  
	    c.gridx = 1;
	    c.gridy = 5;
	    this.add(password, c);
	    
	    String[] usertype = { "doctor", "reception", "billing"};
	    utype = new JComboBox<Object>(usertype);
	    c.ipady = 3;      
	    c.gridwidth = 1;
	    c.insets = new Insets(20,0,0,-250);  
	    c.gridx = 0;
	    c.gridy = 6;
	    this.add(utype, c);
	    
	    JButton register = new JButton("Register");
	    register.addActionListener(this);
	    register.setActionCommand("register");
		c.gridwidth = 1;
	    c.insets = new Insets(20,0,0,-180);  
	    c.gridx = 1;
	    c.gridy = 6;
	    this.add(register, c);
	       
	    d_by_id = new JTextField(3);
		c.ipady = 3;     
	    c.gridwidth = 1;
	    c.insets = new Insets(40,0,0,-150);  
	    c.gridx = 0;
	    c.gridy = 7;
	    this.add(d_by_id , c);
	    
	    JButton dregister = new JButton("Delete user by ID");
	    dregister.addActionListener(this);
	    dregister.setActionCommand("dregister");
		c.gridwidth = 1;
	    c.insets = new Insets(35,0,0,-30);  
	    c.gridx = 1;
	    c.gridy = 7;
	    this.add(dregister, c);
	    
	    
	 validate();
	 repaint();
	
	
	}
	
	public void registerNewUser(){
	
		
		String fn = f_name.getText();
		String sn = surname.getText();
		String bd = b_date.getText();
		String un = username.getText();
	    String pw = password.getText();
	    String accType = (String)utype.getSelectedItem();
	     
	    
	    
		try {
			
			  Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			}catch(Exception e ){}
			
			
			  Connection conn = null;
	    	Statement stmt = null;
	    	
	    	try {
	    	    conn =
	    	       DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/clinic?user=root&password=");

// Do something with the Connection
	    	    stmt = conn.createStatement();

	    	    
	    	    stmt.execute("INSERT INTO  `user` (`b_date`, `f_name`, `surname`, `type`, `username`, `password`) VALUES ('"+bd+"','"+fn+"', '"+sn+"', '"+accType+"','"+un+"', '"+pw+"');");
	    	       
	    	    

	    	}catch(Exception e){}
	    	this.dispose();
	    	JOptionPane.showMessageDialog(this, "The information have been sent!");
	  
	  this.dispose();    
	  new register();   	
	    	
	}
	

	public void deleteregister(){
		
		
		
		String d_id = d_by_id.getText();
		
	    
		try {
			
			  Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			}catch(Exception e ){}
			
			
			  Connection conn = null;
	    	Statement stmt = null;
	    	
	    	try {
	    	    conn =
	    	       DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/clinic?user=root&password=");

// Do something with the Connection
	    	    stmt = conn.createStatement();

	    	    
	    	    stmt.execute("DELETE FROM user WHERE id_user = '"+d_id+"';");
	    	       
	    	    

	    	}catch(Exception e){}
		
		
		
		
	    	JOptionPane.showMessageDialog(this, "The information have been sent!");
	
	    	
	this.dispose();    
	new register(); 
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("register")){
			
			registerNewUser();
				}
		else if(e.getActionCommand().equals("dregister")){
			new confirmDelete(); 
			deleteregister();
			
				}
		else if(e.getActionCommand().equals("logout")){
			setVisible(false );
			new login();
				}
	}

}
