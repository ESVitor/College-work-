import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.PrintWriter;
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
public class billing extends JFrame implements ActionListener {

	
	JTextField idpatient = null;
	JTextField idbill = null;
	JTextField idappointment = null;
	
	String paid = "paid"; 
	
	
	public billing() {
		
	
		this.setTitle("clinic software - Billing");
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setLocation(100, 50);
		setSize(1124,612);
		setVisible(true);
		
		JMenuBar bar = new JMenuBar();
	      this.setJMenuBar(bar);
	          JMenu file = new JMenu("File");
	          bar.add(file);
	              
	          	  	              
	              JMenuItem logout = new JMenuItem("Logout");
	              logout.addActionListener(this);
	              logout.setActionCommand("logout");
	              file.add(logout);
		  
	    this.setLayout(new GridBagLayout());
	    GridBagConstraints c = new GridBagConstraints();
	    
	    //This connection will bring the list of patients 
	    //Contain all the contact information
	    		
	    try {
			 Class.forName("com.mysql.jdbc.Driver").newInstance();
			}catch(Exception e ){}
			
			
		 Connection conn = null;
	     Statement stmt = null;
	     ResultSet rs = null;
  	     Object[][] data = new Object[100][6];
  	    
  	     try {
  	    	 conn =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/clinic?user=root&password=");

	    	  // This is the way to use the connection 
  	    	 	
	    	  stmt = conn.createStatement();

	    	
	    	    
	     if (stmt.execute("select * from patient;")) {
	    	 rs = stmt.getResultSet();
	     }

	    	    
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
	    	
	    	   	
	    	JTable table = new JTable(data, columnNames);
	    	JScrollPane js=new JScrollPane(table);
	    	c.gridwidth = 1;
	    	c.insets = new Insets(0,0,0,0);  
	        c.gridx = 1;
	        c.gridy = 1;
	        this.add(js, c);
	        
	        
	        
	        
	        JLabel msg = new JLabel("List of patients");
	        c.gridwidth = 1;
	        c.insets = new Insets(0,0,10,0);
	        c.gridx = 1;
	        c.gridy = 0;
	        this.add(msg, c);
	        
	        
	        
	       
	    	
	        //This connection will bring all the information of the bills, as paid or not.
	        
	        try {
				
				  Class.forName("com.mysql.jdbc.Driver").newInstance();
				
				}catch(Exception e ){}
				
				
				Connection conn1 = null;
		    	Statement stmt1 = null;
		    	ResultSet rs1 = null;
	  	    
		    	Object[][] data1 = new Object[100][8];
	  	    
		    	try {
		    	    conn1 =
		    	       DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/clinic?user=root&password=");

		    	    // Do something with the Connection
		    	    stmt1 = conn1.createStatement();

		    	
		    	    
		    	    if (stmt1.execute("select * from bill;")) {
		    	        rs1 = stmt1.getResultSet();
		    	    }

		    	   		    	    
		    	    int rowCounter1 = 0;
		    	    
		    	    while(rs1.next()){
		    	    
		    	    	
		    	    	String id_bill = rs1.getString("id_bill");
		    	    	data1[rowCounter1][0] = id_bill;
		    	    	
		    	    	String id_patient = rs1.getString("id_patient");
		    	    	data1[rowCounter1][1] = id_patient;
		 
		    	    	String id_user = rs1.getString("id_user");
		    	    	data1[rowCounter1][2] = id_user;
		    	    	
		    	    	String description = rs1.getString("description");
		    	    	data1[rowCounter1][3] = description;
		    	    	
		    	    	String amount = rs1.getString("amount");
		    	    	data1[rowCounter1][4] = amount;
		    	    	
		    	    	String date = rs1.getString("date");
		    	    	data1[rowCounter1][5] = date;
		    	    	
		    	    	String time = rs1.getString("time");    	    
		    	    	data1[rowCounter1][6] = time;
		    	    	
		    	    	String status = rs1.getString("status");
		    	    	data1[rowCounter1][7] = status;
		    	    	
		    	    	   	    	
		    	    	
		    	    	rowCounter1++;    
		    	    } 
		    	   
		    	} catch (SQLException ex) {
		    	    // handle any errors
		    	    System.out.println("SQLException: " + ex.getMessage());
		    	    System.out.println("SQLState: " + ex.getSQLState());
		    	    System.out.println("VendorError: " + ex.getErrorCode());
		    	  }
		    	
		    	
		    	String[] columnNames1 = {
		    			"id_bill",
		    			"id_patient",
		    			"id_user",
		    			"description",
		    			"amount",
		    			"date",
		    			"time",
		    			"status"
		    	       
		    	};
		    	
		    	 JLabel msg1 = new JLabel("Status");
		        c.gridwidth = 1;
		        c.insets = new Insets(0,0,10,0);
		        c.gridx = 2;
		        c.gridy = 0;
		        this.add(msg1, c);
		    	    	
		    	
		    	JTable table1 = new JTable(data1, columnNames1);
		    	JScrollPane js1=new JScrollPane(table1);
		    	js1.setPreferredSize(new Dimension(500,100));
		        c.gridwidth = 1;
		    	c.insets = new Insets(-320,30,0,0);  
		        c.gridx = 2;
		        c.gridy = 1;
		        this.add(js1, c);
		        
		        			    
			    idpatient = new JTextField(4);
				c.ipady = 3;     
			    c.gridwidth = 1;
			    c.insets = new Insets(-95,-800,0,0);  
			    c.gridx = 3;
			    c.gridy = 1;
			    this.add(idpatient, c);
		        
			    JButton select = new JButton("Print patient Total bill - patient ID");
		        select.addActionListener(this);
		        select.setActionCommand("print");
		    	c.gridwidth = 1;
		        c.insets = new Insets(-100,-500,0,0);  
		        c.gridx = 4;
		        c.gridy = 1;
		        this.add(select, c);
		        
		        idbill = new JTextField(4);
				c.ipady = 3;      
			    c.gridwidth = 1;
			    c.insets = new Insets(-400,-800,0,0);  
			    c.gridx = 3;
			    c.gridy = 2;
			    this.add(idbill, c);
		        
			   	       		        		        
		        JButton paid  = new JButton("Set bill as Paid - bill ID");
		        paid.addActionListener(this);
		        paid.setActionCommand("paid");
		    	c.gridwidth = 1;
		        c.insets = new Insets(-400,-550,0,0);  
		        c.gridx = 4;
		        c.gridy = 2;
		        this.add(paid, c);
		        
		        idappointment = new JTextField(4);
				c.ipady = 3;      
				c.gridwidth = 1;
			    c.insets = new Insets(-300,-800,0,0);  
			    c.gridx = 3;
			    c.gridy = 3;
			    this.add(idappointment, c);
		        
			   	       		        		        
		        JButton printAppointment  = new JButton("Print appointment - appointment ID");
		        printAppointment.addActionListener(this);
		        printAppointment.setActionCommand("printAppointment");
		    	c.gridwidth = 1;
		        c.insets = new Insets(-300,-480,0,0);  
		        c.gridx = 4;
		        c.gridy = 3;
		        this.add(printAppointment, c);
	    
		        
		        
		    
	        
	    validate();
		repaint();
	
	}
	
	public void paid(){			// The method paid will set the status of the table bill
								// from the data base to paid for each bill.
	
		
		String p = idbill.getText();
		
	    
		try {
			
			  Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			}catch(Exception e ){}
			
			
			Connection conn = null;
	    	Statement stmt = null;
	    	
	  	try {
	    	conn =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/clinic?user=root&password=");

	    	stmt = conn.createStatement();

	    	stmt.execute(" UPDATE clinic.bill SET status='paid' WHERE id_bill= '"+p+"';");
	    	       
	    	    

	    }catch(Exception e){}
	    
	  	JOptionPane.showMessageDialog(this, "The information have been sent!");
	
	  	this.dispose();    
		new billing();
	}
	
	
	// The method printingNewBill will save all the bills with the informations 
	// from a selected patient into a text file located in this src.
	
	public void printingNewBill (){		
		
		
		String id_p = idpatient.getText();
		
		
		
		 try {
				
			  Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			}catch(Exception e ){}
			
			
			Connection conn1 = null;
	    	Statement stmt1 = null;
	    	ResultSet rs1 = null;
	    	
	    	
	    	Object[][] data1 = new Object[100][8];
 	    
	    try {
	    	    conn1 =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/clinic?user=root&password=");

	    	    
	    	    stmt1 = conn1.createStatement();

	    	//the code above will only select the unpaid bills.
	    	    
	    	    if (stmt1.execute("select * from bill WHERE id_patient = '"+id_p+"' AND status IS NULL ;")) {
	    	        rs1 = stmt1.getResultSet();
	    	    }
	    	    
	    	     
	    	    int rowCounter1 = 0;
	    	    
	    	    while(rs1.next()){
	    	    
	    	    	String id_bill = rs1.getString("id_bill");
	    	    	data1[rowCounter1][0] = id_bill;
	    	    	
	    	    	String id_patient = rs1.getString("id_patient");
	    	    	data1[rowCounter1][1] = id_patient;
	 
	    	    	String id_user = rs1.getString("id_user");
	    	    	data1[rowCounter1][2] = id_user;
	    	    	
	    	    	String description = rs1.getString("description");
	    	    	data1[rowCounter1][3] = description;
	    	    	
	    	    	String amount = rs1.getString("amount");
	    	    	data1[rowCounter1][4] = amount;
	    	    	
	    	    	
	    	    	String date = rs1.getString("date");
	    	    	data1[rowCounter1][5] = date;
	    	    	
	    	    	String time = rs1.getString("time");    	    
	    	    	data1[rowCounter1][6] = time;
	    	    	
	    	    	String status = rs1.getString("status");
	    	    	data1[rowCounter1][7] = status;
	    	    	
	    	    	rowCounter1++;    
	    	        
	    	    	
	    	    	
					if(rs1.getString("status") != paid){
						
			
			// next line have the path where the orders will be saved.
			// it can be modified if needed.
						try { 
							PrintWriter writer = new PrintWriter(new FileWriter	
							("C:\\Users\\Ennio\\workspace\\ClinicSoftware\\src\\bill.txt", false)); 
			
			
								writer.println("               Clinic Ltd.");
								writer.println();
								writer.println();
								writer.println("               Appointment");
								writer.println();
								writer.println("Bill id: " + rs1.getString("id_bill"));
								writer.println();
								writer.println("Patient id: " + rs1.getString("id_patient")); 
								writer.println();
								writer.println("Doctor id: " + rs1.getString("id_user"));
								writer.println();
								writer.println("Description: " + rs1.getString("description"));
								writer.println();
								writer.println("Price: " + rs1.getString("amount"));
								writer.println();
								writer.println("Date: " + rs1.getString("date"));
								writer.println();
								writer.println("Time: " + rs1.getString("time"));
								writer.println();
								writer.println();
								writer.println();

								writer.close();  
			
						}catch(Exception e) {}		
						
				}      	    
	    	        
	    	    } 
	    	   
	    } catch (SQLException ex) {
	    	    // handle any errors
	    	    System.out.println("SQLException: " + ex.getMessage());
	    	    System.out.println("SQLState: " + ex.getSQLState());
	    	    System.out.println("VendorError: " + ex.getErrorCode());
	      }
		
	
	    JOptionPane.showMessageDialog(this, "The information have been sent!");
	   
	    this.dispose();    
		new billing();	
	
	}
	
	
	
	
	public void printingAppointment(){
		
		
		String id_a = idappointment.getText();
		
		
		
		 try {
				
			  Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			}catch(Exception e ){}
			
			
			  Connection conn1 = null;
	    	  Statement stmt1 = null;
	    	  ResultSet rs1 = null;
	          
// if you have to create a new column into the table appointment 
// you have to set the size of this array 
	    	  Object[][] data1 = new Object[100][7];
	    
	    	try {
	    	    conn1 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/clinic?user=root&password=");

	    	    
	    	    stmt1 = conn1.createStatement();

	    	
	    	    
	    	    if (stmt1.execute("select * from appointment WHERE id_appointment = '"+id_a+"';")) {
	    	        rs1 = stmt1.getResultSet();
	    	    }

	    	   
	    	    

	    	    
	    	    int rowCounter1 = 0;
	    	    
	    	    
	    	    
	    	    while(rs1.next()){
	    	    
	    	    	
	    	    	String id_appointment = rs1.getString("id_appointment");
	    	    	data1[rowCounter1][0] = id_appointment;
	    	    	
	    	    	String id_patient = rs1.getString("id_patient");
	    	    	data1[rowCounter1][1] = id_patient;
	 
	    	    	String id_user = rs1.getString("id_user");
	    	    	data1[rowCounter1][2] = id_user;
	    	    	
	    	    	String date = rs1.getString("date");
	    	    	data1[rowCounter1][3] = date;
	    	    	
	    	    	String time = rs1.getString("time");
	    	    	data1[rowCounter1][4] = time;
	    	    	
	    	    	String id_medication = rs1.getString("id_medication");
	    	    	data1[rowCounter1][5] = id_medication;
	    	    	
	    	    	String comments = rs1.getString("comments");    	    
	    	    	data1[rowCounter1][6] = comments;
	    	    	
	    	    	
	    	    	
	    	    	   	    	
	    	    	
	    	    	rowCounter1++;    
	    	        
	    	    	
// next line have the path where the appointment will be saved.	
// it may change in order to create a new location to the file	    	    	
					try {  
						PrintWriter writer = new PrintWriter(new FileWriter
						("C:\\Users\\Ennio\\workspace\\ClinicSoftware\\src\\appointment.txt", false)); 
			
						writer.println("               Clinic Ltd.");
						writer.println();
						writer.println();
						writer.println("               Appointment");
						writer.println();
						writer.println("Appointment id: " + rs1.getString("id_appointment"));
						writer.println();
						writer.println("Patient id:     " + rs1.getString("id_patient")); 
						writer.println();
						writer.println("Doctor id:      " + rs1.getString("id_user"));
						writer.println();
						writer.println("Date:           " + rs1.getString("date"));
						writer.println();
						writer.println("Time:           " + rs1.getString("time"));
						writer.println();
						writer.println("Medication:     " + rs1.getString("id_medication"));
						writer.println();
						writer.println("Comments:       " + rs1.getString("comments"));
						writer.println();

			
// closes the "print writer". It have to be there.			
						writer.close();    
						}catch(Exception e) {}		
						
					}      	    
	    	        
	    	     
	    	   
	    	} catch (SQLException ex) {
	    	    // handle any errors
	    	    System.out.println("SQLException: " + ex.getMessage());
	    	    System.out.println("SQLState: " + ex.getSQLState());
	    	    System.out.println("VendorError: " + ex.getErrorCode());
	    	}
		
	
	    	JOptionPane.showMessageDialog(this, "The information have been sent!");
	    	
	    	this.dispose();    
			new billing();
		
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("print")){
			
			printingNewBill();
		}
		
		else if(e.getActionCommand().equals("paid")){
			
			paid();
		}
		
		else if(e.getActionCommand().equals("printAppointment")){
			
			printingAppointment();
		}
		
		else if(e.getActionCommand().equals("logout")){
			
			this.dispose();
			new login();
		}
		
	}

}
