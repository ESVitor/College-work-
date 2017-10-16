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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class patient extends JFrame implements ActionListener {
	
	JTextField id_patient = null;
	
	
	
	
	
	
	public patient() {
		
	
		this.setTitle("clinic software - List of patients");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocation(350, 100);
		setSize(612,600);
		setVisible(true);
		  
	    this.setLayout(new GridBagLayout());
	    GridBagConstraints c = new GridBagConstraints();
	    
	    
	    
	    try {
			
			  Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			}catch(Exception e ){}
			
			
			Connection conn = null;
	    	Statement stmt = null;
	    	ResultSet rs = null;
	    	
	    	
	    	
	    	Object[][] data = new Object[100][6];
  	    
	    	try {
	    	    conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/clinic?user=root&password=");

// Do something with the Connection
	    	    stmt = conn.createStatement();

	    	
	    	    
	    	    if (stmt.execute("select * from patient;")) {
	    	        rs = stmt.getResultSet();
	    	    }

// loop over results
	    	    

	    	    
	    	    int rowCounter = 0;
	    	    
	    	    while(rs.next()){
	    	    
	    	    	String id_patient = rs.getString("id_patient");
	    	    	
	    	    	data[rowCounter][0] = id_patient;
	 
	    	        String b_date = rs.getString("b_date");
	    	    	data[rowCounter][1] = b_date;
	    	    	
	    	    	String f_name = rs.getString("f_name");    	    
	    	    	data[rowCounter][2] = f_name;
	    	    	
	    	    	String surname = rs.getString("surname");
	    	    	data[rowCounter][3] = surname;
	    	    	
	    	    	String address = rs.getString("address");
	    	    	data[rowCounter][4] = address;
	    	        
	    	    	String phone_number = rs.getString("phone_number");
	    	    	data[rowCounter][5] = phone_number;
	    	    	
	    	    	
	    	    	rowCounter++;    
	    	        
	        	    
	    	        
	    	    } 
	    	   
	    	} catch (SQLException ex) {
	    	    // handle any errors
	    	    System.out.println("SQLException: " + ex.getMessage());
	    	    System.out.println("SQLState: " + ex.getSQLState());
	    	    System.out.println("VendorError: " + ex.getErrorCode());
	    	}
	    	
	    	
	    	String[] columnNames = {
	    			
	    			"id_patient",
	                "b_date",
	                "f_name",
	                "surname",
	                "address",
	                "phone_number"
	                
	    	};
	    	
	    		        
	        	JLabel msg = new JLabel("List of patients");
	        	c.gridwidth = 1;
	        	c.insets = new Insets(0,0,10,0);
	        	c.gridx = 1;
	        	this.add(msg, c);
	        
	        	JTable table = new JTable(data, columnNames);
	        	JScrollPane js=new JScrollPane(table);
	        	c.gridwidth = 1;
	        	c.insets = new Insets(0,0,0,0);  
	        	c.gridx = 1;
	        	c.gridy = 1;
	        	this.add(js, c);
	        
	       
	        	id_patient = new JTextField(4);
	        	c.ipady = 3;      //make this component tall
	        	c.gridwidth = 1;
	        	c.insets = new Insets(15,0,0,-300);  //top padding
	        	c.gridx = 1;
	        	c.gridy = 2;
	        	this.add(id_patient, c);
	        
	        
	        
	        
	        	JButton select = new JButton("Select patient by ID");
	        	select.addActionListener(this);
	        	select.setActionCommand("select");
	        	c.gridwidth = 1;
	        	c.insets = new Insets(10,-55,0,0);  
	        	c.gridx = 2;
	        	c.gridy = 2;
	        	this.add(select, c);
	    	
	   
	    validate();
		repaint();
	
	}

	
		
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getActionCommand().equals("select")){
			
			String tb = id_patient.getText(); 
	
	
			new patientProfile(tb);
	
		}
		
	
	}

}