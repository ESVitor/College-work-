import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class reception extends JFrame implements ActionListener {
	
	JTextField f_name = null;
	JTextField surname = null;
	JTextField b_date = null;
	JTextField p_number = null;
	JTextField address = null;
	JTextField d_by_id = null;
	
	
	
	
	public reception() {
					
		this.setTitle("Clinic Software - Reception");
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setLocationByPlatform(true);
		this.setLocation(350,100);
		setSize(650,520);
		setVisible(true);
		
		 JMenuBar bar = new JMenuBar();
	      this.setJMenuBar(bar);
	          JMenu file = new JMenu("File");
	          bar.add(file);
	              
	          	  JMenuItem message = new JMenuItem("Message");
	              message.addActionListener(this);
	              message.setActionCommand("message");
	              file.add(message);
	              
	              JMenuItem bill = new JMenuItem("Bill");
	              bill.addActionListener(this);
	              bill.setActionCommand("bill");
	              file.add(bill);
	              
	              JMenuItem logout = new JMenuItem("Log out");
	              logout.addActionListener(this);
	              logout.setActionCommand("logout");
	              file.add(logout);
		
		this.setLayout(new GridBagLayout());
	    GridBagConstraints c = new GridBagConstraints();
		
	    
	    JLabel r = new JLabel("Appointment");
	    c.gridwidth = 1;
	    c.insets = new Insets(20,0,0,-300);
	    c.gridx = 0;
	    c.gridy = 0;
	    this.add(r, c);
	    
	    
	    JLabel fn = new JLabel("First name");
	    c.gridwidth = 1;
	    c.insets = new Insets(20,0,0,0);
	    c.gridx = 0;
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
	    
	    JLabel bd = new JLabel("Date of birth");
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
	    	    
	    JLabel pn = new JLabel("Phone number");
	    c.gridwidth = 1;
	    c.insets = new Insets(20,0,0,0);  
	    c.gridx = 0;
	    c.gridy = 4;
	    this.add(pn, c);
	    
	    p_number = new JTextField(20);
		c.ipady = 3;      
	    c.gridwidth = 1;
	    c.insets = new Insets(20,20,0,0);  
	    c.gridx = 1;
	    c.gridy = 4;
	    this.add(p_number, c);
	    
	    JLabel ad = new JLabel("Address");
	    c.gridwidth = 1;
	    c.insets = new Insets(20,0,0,0);  
	    c.gridx = 0;
	    c.gridy = 5;
	    this.add(ad, c);
	    
	    address = new JTextField(20);
		c.ipady = 3;      
	    c.gridwidth = 1;
	    c.insets = new Insets(20,20,0,0);  
	    c.gridx = 1;
	    c.gridy = 5;
	    this.add(address, c);
	    
	    JButton register = new JButton("Save appointment");
	    register.addActionListener(this);
	    register.setActionCommand("register");
		c.gridwidth = 1;
	    c.insets = new Insets(20,-70,0,0);  
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
	    
	    JButton dregister = new JButton("Delete appointment by ID");
	    dregister.addActionListener(this);
	    dregister.setActionCommand("dregister");
		c.gridwidth = 1;
	    c.insets = new Insets(35,0,0,-50);  
	    c.gridx = 1;
	    c.gridy = 7;
	    this.add(dregister, c);
	    
	    
	validate();
	repaint();
	    
	   
	}
	
	

		
public void registerNewAppointment(){
	
		
		String bd = b_date.getText();
		String fn = f_name.getText();
		String sn = surname.getText();
		String ad = address.getText();
		String pn = p_number.getText();
	    
	    
	    
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


	    	    stmt.execute("INSERT INTO  `patient` (`b_date`, `f_name`, `surname`, `address`, `phone_number`) VALUES ('"+bd+"','"+fn+"', '"+sn+"', '"+ad+"' ,'"+pn+"');");
	    	       
	    	     System.out.println("fuckk");

	    	}catch(Exception e){}

	    	
//This close the 	    	
	    this.dispose();
	    JOptionPane.showMessageDialog(this, "The information have been sent!");
	
	this.dispose();    
	new reception();

	}
	

	public void deleteregister(){
		
		new confirmDelete();
		
		
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

	    	  
	    	    stmt.execute("DELETE FROM patient WHERE id_patient = '"+d_id+"';");
	    	       
	    	    

	    	}catch(Exception e){}
		
		
		
	    	this.dispose();
	    	JOptionPane.showMessageDialog(this, "The information have been sent!");
		
	    	this.dispose();    
	    	new reception();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getActionCommand().equals("register")){
			
			registerNewAppointment();
				}
		
		else if(e.getActionCommand().equals("dregister")){
			
			deleteregister();
			
				}
		
		
		
		else if(e.getActionCommand().equals("message")){
			
			new message();
				}
		
		else if(e.getActionCommand().equals("logout")){
			this.dispose();
			new login();
				}
		else if(e.getActionCommand().equals("bill")){
			
			new newbill();
				}
		
	}
		

}
