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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class patientProfile extends JFrame implements ActionListener {
	
	JTextField id_patient = null;
	JTextField id_user = null;
	JTextField comments = null;    
	JTextField date = null;
	@SuppressWarnings("rawtypes")
	JComboBox medicationList = null;
	JTextField time = null; 
	
	JTextField d_by_id = null; 
	
	String alert = null;
	
	
	GridBagConstraints c = new GridBagConstraints();
	
	
	
	public patientProfile (String tb) {
		
	
		
		
		
		this.setTitle("clinic software - Patient Profile");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocation(200, 100);
		setSize(1050,550);
		setVisible(true);
		  
	    this.setLayout(new GridBagLayout());
	   
	    
	    
	    try {
			
			  Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			}catch(Exception e ){}
			
			
			Connection conn = null;
	    	Statement stmt = null;
	    	ResultSet rs = null;
  	    
	    	
	    	
	    	Object[][] data = new Object[1][4];
  	    
	    	try {
	    	    conn =
	    	       DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/clinic?user=root&password=");

// Do something with the Connection
	    	    stmt = conn.createStatement();

	    	
	    	    
	    	    if (stmt.execute("select * from patient WHERE `id_patient` = '"+tb+"';")) {
	    	        rs = stmt.getResultSet();
	    	    }

// loop over results
	    	    

	    	    
	    	    int rowCounter = 0;
	    	    
	    	    while(rs.next()){
	    	    
	    	    	String f_name = rs.getString("f_name");    	    
	    	    	data[rowCounter][0] = f_name;
	    	    	
	    	    	System.out.println(rs.getString("f_name"));
	    	    	
	    	    	String surname = rs.getString("surname");
	    	    	data[rowCounter][1] = surname;
	    	    	
	    	    	String address = rs.getString("address");
	    	    	data[rowCounter][2] = address;
	    	        
	    	    	String phone_number = rs.getString("phone_number");
	    	    	data[rowCounter][3] = phone_number;
	    	    	
	    	    	
	    	    	rowCounter++;    
	    	        
	        	    
	    	        
	    	    } 
	    	   
	    	} catch (SQLException ex) {
// handle any errors
	    	    System.out.println("SQLException: " + ex.getMessage());
	    	    System.out.println("SQLState: " + ex.getSQLState());
	    	    System.out.println("VendorError: " + ex.getErrorCode());
	    	}
	    	
	    	
	    	String[] columnNames = {
	    			"Name",
	                "Surname",
	                "Address",
	                "Phone number"
	                
	    	};
	    	
	    	
	    	JTable table = new JTable(data, columnNames);
	    	
	    	JScrollPane js=new JScrollPane(table);
	    	js.setPreferredSize(new Dimension(500,39));
	        c.gridwidth = 1;
	    	c.insets = new Insets(0,0,0,0);  
	        c.gridx = 1;
	        this.add(js, c);
	        
	        
	    	
	        
	        
//Select all the previous messages that the patient could be sent to the doctors
	        
	        
	        try {
				
				  Class.forName("com.mysql.jdbc.Driver").newInstance();
				
				}catch(Exception e ){}
				
				
				  Connection conn1 = null;
		    	Statement stmt1 = null;
		    	ResultSet rs1 = null;
	  	    Object[][] data1 = new Object[10][1];
	  	    
		    	try {
		    	    conn1 =
		    	       DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/clinic?user=root&password=");

// Do something with the Connection
		    	    stmt1 = conn1.createStatement();

		    	
		    	    
		    	    if (stmt1.execute("select * from message WHERE `id_patient` = '"+tb+"';")) {
		    	        rs1 = stmt1.getResultSet();
		    	    }

// loop over results
		    	    

		    	    
		    	    int rowCounter1 = 0;
		    	    
		    	    while(rs1.next()){
		    	    
		    	    	String message1 = rs1.getString("message");
		    	    	data1[rowCounter1][0] = message1;
		    	    	
		    	    	
		    	    	rowCounter1++;    
		    	        
		        	    
		    	        
		    	    } 
		    	   
		    	} catch (SQLException ex) {
// handle any errors
		    	    System.out.println("SQLException: " + ex.getMessage());
		    	    System.out.println("SQLState: " + ex.getSQLState());
		    	    System.out.println("VendorError: " + ex.getErrorCode());
		    	}
		    	
		    	
		    	String[] columnNames1 = {
		    			
		                "Message"
		                
		    	};
		    	
		    	
		       
		    	JTable table1 = new JTable(data1, columnNames1);
		    	
		    	JScrollPane js1=new JScrollPane(table1);
		    	js1.setPreferredSize(new Dimension(500,100));
		        c.gridwidth = 1;
		    	c.insets = new Insets(20,0,0,0);  
		        c.gridx = 1;
		        c.gridy = 1;
		        this.add(js1, c);
		        

// Select all the previous appointments from the selected patient	        
		
		        try {
					
					  Class.forName("com.mysql.jdbc.Driver").newInstance();
					
					}catch(Exception e ){}
					
					
					  Connection conn2 = null;
			    	Statement stmt2 = null;
			    	ResultSet rs2 = null;
		  	    Object[][] data2 = new Object[10][7];
		  	    
			    	try {
			    	    conn2 =
			    	       DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/clinic?user=root&password=");

// Do something with the Connection
			    	    stmt2 = conn2.createStatement();

			    	
			    	    
			    	    if (stmt2.execute("select * from appointment WHERE `id_patient` = '"+tb+"';")) {
			    	        rs2 = stmt2.getResultSet();
			    	    }

// loop over results
			    	    

			    	    
			    	    int rowCounter2 = 0;
			    	    
			    	    while(rs2.next()){
			    	    
			    	    	String id_appointment = rs2.getString("id_appointment");
			    	    	data2[rowCounter2][0] = id_appointment;
			    	    	
			    	    	String id_patient = rs2.getString("id_patient");
			    	    	data2[rowCounter2][1] = id_patient;
			    	    	
			    	    	String id_user = rs2.getString("id_user");
			    	    	data2[rowCounter2][2] = id_user;
			    	    	
			    	    	String date = rs2.getString("date");
			    	    	data2[rowCounter2][3] = date;
			    	    	
			    	    	String time = rs2.getString("time");
			    	    	data2[rowCounter2][4] = time;
			    	    	
			    	    	String id_medication = rs2.getString("id_medication");
			    	    	data2[rowCounter2][5] = id_medication;
			    	    	alert = alert + rs2.getString("id_medication");
			    	    	
			    	    	
			    	    	
			    	    	
			    	    	String comments = rs2.getString("comments");
			    	    	data2[rowCounter2][6] = comments;
			    	    	
			    	    	
			    	    	rowCounter2++;    
			    	        
			        	    
			    	        
			    	    } 
			    	   
			    	} catch (SQLException ex) {
// handle any errors
			    	    System.out.println("SQLException: " + ex.getMessage());
			    	    System.out.println("SQLState: " + ex.getSQLState());
			    	    System.out.println("VendorError: " + ex.getErrorCode());
			    	}
			    	
			    	
			    	String[] columnNames2 = {
			    			
			                "Appointment ID",
			                "Patient ID",
			                "Dr. ID",
			                "Date",
			                "Time",
			                "Medication",
			                "Comments"
			                
			    	};
			    	
			    	
			       
			    	JTable table2 = new JTable(data2, columnNames2);
			    	
			    	JScrollPane js2=new JScrollPane(table2);
			    	js2.setPreferredSize(new Dimension(500,100));
			        c.gridwidth = 1;
			    	c.insets = new Insets(30,0,0,0);  
			        c.gridx = 1;
			        c.gridy = 2;
			        this.add(js2, c);
	    

			        
			        
//From here starts the section to input the values for a new registration			        
			        
			        JLabel com = new JLabel("Comments");
				    c.gridwidth = 1;
				    c.insets = new Insets(-25,200,0,0);
				    c.gridx = 2;
				    c.gridy = 0;
				    this.add(com, c);
			       
			        
			        
				    JLabel fn = new JLabel("Patient ID");
				    c.gridwidth = 1;
				    c.insets = new Insets(-50,-10,0,0);  
				    c.gridx = 2;
				    c.gridy = 1;
				    this.add(fn, c);
				    
				    id_patient = new JTextField(20);
					c.ipady = 3;      
				    c.gridwidth = 1;
				    c.insets = new Insets(-50,-100,0,0);  
				    c.gridx = 3;
				    c.gridy = 1;
				    this.add(id_patient, c);
				    
				    JLabel sn = new JLabel("User ID");
				    c.gridwidth = 1;
				    c.insets = new Insets(-200,0,0,0);  
				    c.gridx = 2;
				    c.gridy = 2;
				    this.add(sn, c);
				    
				    id_user = new JTextField(20);
					c.ipady = 3;      
				    c.gridwidth = 1;
				    c.insets = new Insets(-200,-100,0,0);  
				    c.gridx = 3;
				    c.gridy = 2;
				    this.add(id_user, c);
				    
				   	
				    JLabel cm = new JLabel("Comments");
				    c.gridwidth = 1;
				    c.insets = new Insets(-250,-20,0,0);  
				    c.gridx = 2;
				    c.gridy = 3;
				    this.add(cm, c);
				    
				    comments = new JTextField(20);
					c.ipady = 3;      
				    c.gridwidth = 1;
				    c.insets = new Insets(-250,-100,0,0);  
				    c.gridx = 3;
				    c.gridy = 3;
				    this.add(comments, c);
				    
				    
				    
				    JLabel un = new JLabel("Date");
				    c.gridwidth = 1;
				    c.insets = new Insets(-180,0,0,0);  
				    c.gridx = 2;
				    c.gridy = 4;
				    this.add(un, c);
				    
				    date = new JTextField(20);
					c.ipady = 3;      
				    c.gridwidth = 1;
				    c.insets = new Insets(-180,-100,0,0);  
				    c.gridx = 3;
				    c.gridy = 4;
				    this.add(date, c);
				    
				    
				    JLabel pw = new JLabel("Time");
				    c.gridwidth = 1;
				    c.insets = new Insets(-100,0,0,0);  
				    c.gridx = 2;
				    c.gridy = 5;
				    this.add(pw, c);
				    
				    				    
				    time = new JTextField(20);
					c.ipady = 3;      
				    c.gridwidth = 1;
				    c.insets = new Insets(-100,-100,0,0);  
				    c.gridx = 3;
				    c.gridy = 5;
				    this.add(time, c);
				    
				    String[] medication = { "Category A", "VND 1", "XXV 2","HNF 232","GB334",
				    						"Category B", "X34","HH5","DDF23","JHH7",
				    						"Category C", "543H","344BB","JUY9","232B"
				    
				    };
				    medicationList = new JComboBox<Object>(medication);
				    c.ipady = 3;      
				    c.gridwidth = 1;
				    c.insets = new Insets(-20,0,0,-150);  
				    c.gridx = 2;
				    c.gridy = 6;
				    this.add(medicationList, c);
				    
				    JButton register = new JButton("Save");
				    register.addActionListener(this);
				    register.setActionCommand("register");
					c.gridwidth = 1;
				    c.insets = new Insets(20,0,0,0);  
				    c.gridx = 2;
				    c.gridy = 7;
				    this.add(register, c);
				    
				        
				    d_by_id = new JTextField(3);
					c.ipady = 3;      
				    c.gridwidth = 1;
				    c.insets = new Insets(40,-160,0,0);  
				    c.gridx = 3;
				    c.gridy = 7;
				    this.add(d_by_id , c);
				    
				    JButton dregister = new JButton("Delete comment by ID");
				    dregister.addActionListener(this);
				    dregister.setActionCommand("dregister");
					c.gridwidth = 1;
				    c.insets = new Insets(35,-120,0,0);  
				    c.gridx = 4;
				    c.gridy = 7;
				    this.add(dregister, c);
				    
				    
	    validate();
		repaint();
	
	
	}
	
	
	public void registerNewUser(){
	
	
	
		  String idP = id_patient.getText();
		  String idU = id_user.getText();	
		  String da = date.getText();
		  String ti = time.getText();
		  String medic = (String)medicationList.getSelectedItem();
		  
		  String comm = comments.getText();
	     
		  
		  
	      
	      	
		
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

// or alternatively, if you don't know ahead of time that
// the query will be a SELECT...

	    	
	    	    
	    	    stmt.execute("INSERT INTO  `appointment` (`id_patient`,`id_user`,`date`,`time`,`id_medication`,`comments` ) VALUES ('"+idP+"','"+idU+"','"+da+"','"+ti+"','"+medic+"','"+comm+"');");
	    	       
	    	    

	    	}catch(Exception e){}
	    
// Tells the user that a new registration have been created 
	    	JOptionPane.showMessageDialog(this, "The information have been sent!");
	
	this.dispose();
	
	new patientProfile(null);
	
	}
	

	public void deleteregister(){
		
		new confirmDelete(); 
		
		
		String id = d_by_id.getText();
		
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

// or alternatively, if you don't know ahead of time that
// the query will be a SELECT...

	    	
	    	    
	    	    stmt.execute("DELETE FROM appointment WHERE id_appointment = '"+id+"';");
	    	       
	    	    

	    	}catch(Exception e){}
	
	    	JOptionPane.showMessageDialog(this, "The information have been sent!");
	this.dispose();
	new patientProfile(null);
	}
	
	
		@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getActionCommand().equals("register")){
			
			registerNewUser();
		}
		
		else if(e.getActionCommand().equals("dregister")){
			
			deleteregister();
			
		}
		
	}

}
