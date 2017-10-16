import java.awt.Dimension;
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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class doctor extends JFrame implements ActionListener  {
	
//The selected string will give the message id to be flagged as read	
	JTextField msgID = null;
	
		
	public doctor(String user2) {
		
	
		this.setTitle("clinic software - Doctor");
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setLocation(50, 50);
		setSize(1200,650);
		setVisible(true);
		  
	    this.setLayout(new GridBagLayout());
	    GridBagConstraints c = new GridBagConstraints();
	    
	    try {
			
			  Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			}catch(Exception e ){}
			
			
			  Connection conn = null;
	    	  Statement stmt = null;
	    	  ResultSet rs = null;
  	         
	    	  
	    	  Object[][] data = new Object[100][10];
  	    
	    	try {
	    	    conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/clinic?user=root&password=");

// Use the connection	    	    
	    	    stmt = conn.createStatement();

	    	
	    	    
	    	    
				if (stmt.execute("select * from message WHERE status IS NULL;")) {
	    	        rs = stmt.getResultSet();
	    	    }

// loop over results
	    	    

	    	    
	    	    int rowCounter = 0;
	    	    
	    	    while(rs.next()){
	    	    
	    	    	String id = rs.getString("id_msg");
	    	    	
	    	    	data[rowCounter][0] = id;
	 
	    	        String patient = rs.getString("id_patient");
	    	    	data[rowCounter][1] = patient;
	    	    	
	    	    	String user = rs.getString("id_user");    	    
	    	    	data[rowCounter][2] = user;
	    	    	
	    	    	String message = rs.getString("message");
	    	    	data[rowCounter][3] = message;
	    	    	
	    	    	String f_name = rs.getString("f_name");
	    	    	data[rowCounter][4] = f_name;
	    	    	
	    	    	String surname = rs.getString("surname");
	    	    	data[rowCounter][5] = surname;
	    	    	
	    	    	String phone = rs.getString("phone");
	    	    	data[rowCounter][6] = phone;

	    	    	String date = rs.getString("date");
	    	    	data[rowCounter][7] = date;
	    	    	
	    	    	String time = rs.getString("time");
	    	    	data[rowCounter][8] = time;
	    	    	
	    	    	String doctor = rs.getString("doctor");
	    	    	data[rowCounter][9] = doctor;
	    	    	
	    	    	
	    	    	rowCounter++;    
	    	        
	        	    
	    	        
	    	    } 
	    	   
	    	} catch (SQLException ex) {
	    	    // handle any errors
	    	    System.out.println("SQLException: " + ex.getMessage());
	    	    System.out.println("SQLState: " + ex.getSQLState());
	    	    System.out.println("VendorError: " + ex.getErrorCode());
	    	}
	    	
	    	
	    	String[] columnNames = {
	    			"id_msg",
	                "id_patient",
	                "id_user",
	                "message",
	                "f_name",
	                "surname",
	                "phone",
	                "date",
	                "time",
	                "doctor"
	                
	    	
	    	};
	    	
	    	
	    	
	    	JMenuBar bar = new JMenuBar();
		      this.setJMenuBar(bar);
		          JMenu file = new JMenu("File");
		          bar.add(file);
		              
		          	  JMenuItem patient = new JMenuItem("Patient");
		          	  patient.addActionListener(this);
		          	  patient.setActionCommand("patient");
		              file.add(patient);
		              
		              JMenuItem logout = new JMenuItem("Logout");
		              logout.addActionListener(this);
		              logout.setActionCommand("logout");
		              file.add(logout);
		              
	    	
	    	    	
	    	JTable table = new JTable(data, columnNames);
	    	JScrollPane js=new JScrollPane(table);
	    	js.setPreferredSize(new Dimension(1000,500));
	    	c.gridwidth = 1;
	    	c.insets = new Insets(0,0,0,0);  
	        c.gridx = 1;
	        c.gridy = 1;
	        this.add(js, c);
	        
	        
	        
	        JLabel msg = new JLabel("Message");
	       
	        c.gridwidth = 1;
	        c.insets = new Insets(0,0,10,0);
	        c.gridx = 1;
	        c.gridy = 0;
	        this.add(msg, c);
	        
	        
	        msgID = new JTextField(3);
			c.ipady = 3;     
		    c.gridwidth = 1;
		    c.insets = new Insets(10,0,0,-800);  
		    c.gridx = 1;
		    c.gridy = 2;
		    this.add(msgID , c);
	        
	        JButton flag = new JButton("Flag by id_msg");
	        flag.addActionListener(this);
	        flag.setActionCommand("flag");
	        c.gridwidth = 1;
	        c.insets = new Insets(10,-55,0,0);  
	        c.gridx = 2;
	        c.gridy = 2;
	        this.add(flag, c);
	    	
	   
	    validate();
		repaint();
	
	}

	

//The method fag will update the data base table `message` to status = flag	
	
	public void flag(){
	
		
		String fl = msgID.getText();
		
	    
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

	    	    stmt.execute(" UPDATE clinic.message SET status='flag' WHERE id_msg= '"+fl+"';");
	    	       
	    	    }catch(Exception e){}
	    
	    	JOptionPane.showMessageDialog(this, "The information have been sent!");
	
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getActionCommand().equals("flag")){
			
			flag();
		}
		
		
		else if(e.getActionCommand().equals("patient")){
			
			new patient();
		}
		
		
		
		else if(e.getActionCommand().equals("logout")){
			
			this.dispose();
			new login();
		}
		
	}

}
