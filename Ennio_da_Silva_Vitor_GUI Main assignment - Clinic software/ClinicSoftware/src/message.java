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
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;



@SuppressWarnings("serial")
public class message extends JFrame implements ActionListener {
	
	JTextField firstname = null;
	JTextField surname = null;
	JTextField phonenumber = null;
	JTextField date = null;
	JTextField time = null;
	JTextField doctor = null;
	JTextField doctor_id = null;
	JTextField patient_id = null;
	JTextArea message = null;
	
	JTextField d_by_id = null;
	
		
	public message (){
		
		this.setTitle("Clinic Software - Message");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocation(250, 100);
		setSize(800,420);
		setVisible(true);
		
		this.setLayout(new GridBagLayout());
	    GridBagConstraints c = new GridBagConstraints();
	    
	    
	    JLabel msg = new JLabel("Message");
	   
	    c.insets = new Insets(0,300,20,0);
	    c.gridx = 1;
	    c.gridy = 0;
	    this.add(msg, c);
		
	    JLabel fn = new JLabel("First name");
	    c.insets = new Insets(0,0,0,0);
	    c.gridx = 0;
	    c.gridy = 1;
	    this.add(fn, c);
	    
	    firstname = new JTextField(20);
		c.ipady = 3;     
	    c.gridwidth = 1;
	    c.insets = new Insets(0,0,0,0);  
	    c.gridx = 1;
	    c.gridy = 1;
	    this.add(firstname, c);
	    
	    
	    JLabel sn = new JLabel("surname");
	    c.insets = new Insets(0,0,0,0);
	    c.gridx = 2;
	    c.gridy = 1;
	    this.add(sn, c);
	    
	    surname = new JTextField(20);
		c.ipady = 3;      
	    c.gridwidth = 1;
	    c.insets = new Insets(0,10,0,0);  
	    c.gridx = 3;
	    c.gridy = 1;
	    this.add(surname, c);
	    
	    
	    JLabel pn = new JLabel("Phone");
	    c.gridwidth = 1;
	    c.insets = new Insets(30,0,0,0);
	    c.gridy = 2;
	    c.gridx = 0;
	    this.add(pn, c);
	    
	    phonenumber = new JTextField(10);
		c.ipady = 3;      
	    c.gridwidth = 1;
	    c.insets = new Insets(30,-100,0,0);  
	    c.gridx = 1;
	    c.gridy = 2;
	    this.add(phonenumber, c);
	    
	    JLabel d = new JLabel("Date");
	    c.gridwidth = 1;
	    c.insets = new Insets(30,-250,0,0);
	    c.gridx = 2;
	    c.gridy = 2;
	    this.add(d, c);
	    

	    date = new JTextField(10);
		c.ipady = 3;      
	    c.gridwidth = 1;
	    c.insets = new Insets(30,-330,0,0);  
	    c.gridx = 3;
	    c.gridy = 2;
	    this.add(date, c);
	    
	    JLabel t = new JLabel("Time");
	    c.gridwidth = 1;
	    c.insets = new Insets(30,-350,0,0);
	    c.gridx = 4;
	    c.gridy = 2;
	    this.add(t, c);
	    
	    time = new JTextField(10);
		c.ipady = 3;      
	    c.gridwidth = 1;
	    c.insets = new Insets(30,-120,0,0);  
	    c.gridx = 5;
	    c.gridy = 2;
	    this.add(time, c);
	    
	    JLabel doc = new JLabel("Doctor");
	    c.gridwidth = 1;
	    c.insets = new Insets(30,0,0,0);
	    c.gridy = 3;
	    c.gridx = 0;
	    this.add(doc, c);
	    
	    doctor = new JTextField(10);
		c.ipady = 3;      
	    c.gridwidth = 1;
	    c.insets = new Insets(30,-100,0,0); 
	    c.gridx = 1;
	    c.gridy = 3;
	    this.add(doctor, c);
	    
	    JLabel doc_id = new JLabel("Doctor ID");
	    c.gridwidth = 1;
	    c.insets = new Insets(30,-270,0,0);
	    c.gridx = 2;
	    c.gridy = 3;
	    this.add(doc_id, c);
	    
	    doctor_id = new JTextField(10);
		c.ipady = 3;      
	    c.gridwidth = 1;
	    c.insets = new Insets(30,-330,0,0);  
	    c.gridx = 3;
	    c.gridy = 3;
	    this.add(doctor_id, c);
	    
	    JLabel pat_id = new JLabel("Patient ID");
	    c.gridwidth = 1;
	    c.insets = new Insets(30,-350,0,0);
	    c.gridx = 4;
	    c.gridy = 3;
	    this.add(pat_id, c);
	    
	    patient_id = new JTextField(10);
		c.ipady = 3;      
	    c.gridwidth = 1;
	    c.insets = new Insets(30,-130,0,0);  
	    c.gridx = 5;
	    c.gridy = 3;
	    this.add(patient_id, c);
	    
	    JLabel msgfield = new JLabel("Message");
	    c.gridwidth = 1;
	    c.insets = new Insets(30,0,0,0);
	    c.gridy = 6;
	    c.gridx = 0;
	    this.add(msgfield, c);
	    
	    message = new JTextArea(5, 30);
	    message.setLineWrap(true);
	    c.insets = new Insets(30,-200,0,0);  
	    c.gridwidth = 0;
	    c.gridx = 1;
	    c.gridy = 6;
	    this.add(message, c);
	    
	    JButton send = new JButton("Send");
	    send.addActionListener(this);
	    send.setActionCommand("send");
		c.gridwidth = 1;
	    c.insets = new Insets(80,-180,0,0);  
	    c.gridx = 3;
	    c.gridy = 6;
	    this.add(send, c);
	    
	    
	    d_by_id = new JTextField(3);
		c.ipady = 3;      
	    c.gridwidth = 1;
	    c.insets = new Insets(85,-250,0,0);  
	    c.gridx = 4;
	    c.gridy = 6;
	    this.add(d_by_id , c);
	    
	    JButton delete_msg = new JButton("Delete msg by ID");
	    delete_msg.addActionListener(this);
	    delete_msg.setActionCommand("delete_msg");
		c.gridwidth = 1;
	    c.insets = new Insets(85,-100,0,0);  
	    c.gridx = 5;
	    c.gridy = 6;
	    this.add(delete_msg, c);
	    
	    
	    
	    
	    validate();
		repaint();
		
	}
	
	
	public void newMessage(){
		System.out.println("fuck");
	
	String fn = firstname.getText();
	String sn = surname.getText();
	String ph = phonenumber.getText();
	String dt = date.getText();
	String ti = time.getText();
	String doc = doctor.getText();
	String doc_id = doctor_id.getText();
	String pa_id = patient_id.getText();
	String mes = message.getText();
	
		
	try {
		
		  Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		}catch(Exception e ){}
		
		
		  Connection conn = null;
		  Statement stmt = null;
  	
  	try {
  	    conn =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/clinic?user=root&password=");

// Do something with the Connection
  	    stmt = conn.createStatement();

  	     	    
  	    stmt.execute("INSERT INTO  `message` (`f_name`, `surname`, `phone`, `date`, `time`, `doctor`, `id_user`, `id_patient`, `message`) VALUES ('"+fn+"','"+sn+"', '"+ph+"', '"+dt+"','"+ti+"', '"+doc+"','"+doc_id+"','"+pa_id+"', '"+mes+"');");
  	       
  	    

  	}catch(Exception e){}
  
  	JOptionPane.showMessageDialog(this, "The information have been sent!");
	
  	
  	
  	this.dispose();    
	new message();
  	
	}


//The method here is used to delete possible wrong messages 
	
	public void deleteMessage(){

// The method is called to make sure that the user want to delete the message
		
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

// or alternatively, if you don't know ahead of time that
// the query will be a SELECT...

  	
  	    
  	    stmt.execute("DELETE FROM message WHERE id_msg = '"+d_id+"';");
  	       
  	    

  	}catch(Exception e){}
	
	
// This method tells the user that the new information have been registered 
  	JOptionPane.showMessageDialog(this, "The information have been sent!");
	
	
  	this.dispose();    
  	new message();
  	
	}
	
	
	


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("send")){
			
			newMessage();
		}
		
		else if(e.getActionCommand().equals("delete_msg")){
			
			deleteMessage();
			
		}
	}

}
