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
import javax.swing.JOptionPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class newbill extends JFrame implements ActionListener {

	
	JTextField id_patient = null;
	JTextField  id_user = null;
	@SuppressWarnings("rawtypes")
	JComboBox desc = null;
	@SuppressWarnings("rawtypes")
	JComboBox pri = null;
	JTextField  date = null;
	JTextField   time = null;
	JTextField d_bill_by_id = null;
	public newbill(){
		
	
	this.setTitle("Clinic software - New bill");
	this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	this.setLocation(320, 100);
	setSize(600,450);
	setVisible(true);
	  
    this.setLayout(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();
	
    JLabel nb = new JLabel("New bill");
    c.gridwidth = 1;
    c.insets = new Insets(0,0,20,-300);
    c.gridx = 0;
    c.gridy = 0;
    this.add(nb, c);
    
    JLabel idp = new JLabel("Patient ID");
    c.gridwidth = 1;
    c.insets = new Insets(20,0,0,0);
    c.gridy = 1;
    c.gridx = 0;
    this.add(idp, c); 
   
    id_patient = new JTextField(20);
	c.ipady = 3;      
    c.gridwidth = 1;
    c.insets = new Insets(20,0,0,0);  
    c.gridx = 1;
    c.gridy = 1;
    this.add(id_patient, c);
    
    JLabel idu = new JLabel("Dr. ID");
    c.gridwidth = 1;
    c.insets = new Insets(20,20,0,0);
    c.gridx = 0;
    c.gridy = 2;
    this.add(idu, c); 
   
    id_user = new JTextField(20);
	c.ipady = 3;      
    c.gridwidth = 1;
    c.insets = new Insets(20,0,0,0);  
    c.gridx = 1;
    c.gridy = 2;
    this.add(id_user, c);
    
    JLabel descr = new JLabel("Description");
    c.gridwidth = 1;
    c.insets = new Insets(20,0,0,0);
    c.gridx = 0;
    c.gridy = 3;
    this.add(descr, c); 
   
    String[] description = { "General doctors visit: 50 euros", " Prescription requested: 30 euros",
    						 "Certain Dental: 100 euros","Ophthalmic (Eye): 70 euros","Aural (Ear): 50 euros" };
    desc = new JComboBox<Object>(description);
    c.gridwidth = 1;
    c.insets = new Insets(20,0,0,0);  
    c.gridx = 1;
    c.gridy = 3;
    this.add(desc, c);
    
    JLabel pr = new JLabel("Price");
    c.gridwidth = 1;
    c.insets = new Insets(20,20,0,0);
    c.gridx = 2;
    c.gridy = 3;
    this.add(pr, c);
    
    String[] price = { "50.00", "30.00", "100.00", "70.00"};
    pri = new JComboBox<Object>(price);
    c.gridwidth = 1;
    c.insets = new Insets(20,0,0,0);  
    c.gridx = 3;
    c.gridy = 3;
    this.add(pri, c);
        
    JLabel dt = new JLabel("Date (YYYY-MM-DD)");
    c.gridwidth = 1;
    c.insets = new Insets(20,0,0,0);
    c.gridx = 0;
    c.gridy = 4;
    this.add(dt, c); 
   
    date = new JTextField(20);
	c.ipady = 3;      
    c.gridwidth = 1;
    c.insets = new Insets(20,0,0,0);  
    c.gridx = 1;
    c.gridy = 4;
    this.add(date, c);
    
    JLabel ti = new JLabel("Time (HH:MM:SS)");
    c.gridwidth = 1;
    c.insets = new Insets(20,0,0,0);
    c.gridx = 0;
    c.gridy = 5;
    this.add(ti, c); 
   
    time = new JTextField(20);
	c.ipady = 3;      
    c.gridwidth = 1;
    c.insets = new Insets(20,0,0,0);  
    c.gridx = 1;
    c.gridy = 5;
    this.add(time, c);
    
    
    JButton save = new JButton("Save");
    save.addActionListener(this);
    save.setActionCommand("save");
	c.gridwidth = 1;
    c.insets = new Insets(20,0,0,-170);  
    c.gridx = 0;
    c.gridy = 6;
    this.add(save, c);
    
    
    d_bill_by_id = new JTextField(3);
	c.ipady = 3;      
    c.gridwidth = 1;
    c.insets = new Insets(27, 50,0,0);  
    c.gridx = 1;
    c.gridy = 6;
    this.add(d_bill_by_id, c);
        
    JButton delete = new JButton("Delete bill by ID");
    delete.addActionListener(this);
    delete.setActionCommand("delete");
    c.gridwidth = 1;
    c.insets = new Insets(20,-62,0,0);  
    c.gridx = 2;
    c.gridy = 6;
    this.add(delete, c);
    
    
    
       
    validate();
	repaint();
   
	 
	}
	
public void saveBill(){
	
		
		String ip = id_patient.getText();
		String iu = id_user.getText();
		String des = (String)desc.getSelectedItem();
		String pr = (String)pri.getSelectedItem();
		String dt = date.getText();
		String ti = time.getText();
	   
	     
	    
	    
	    
	    
	    
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

	    	
	    	    
	    	    stmt.execute("INSERT INTO  `bill` (`id_patient`, `id_user`, `description`, `amount`, `date`, `time`) VALUES ('"+ip+"','"+iu+"', '"+des+"', '"+pr+"','"+dt+"', '"+ti+"');");
	    	       
	    	  

	    	}catch(Exception e){}

	    	
	    	
//Inform the user that the information have been sent	    	
	    	JOptionPane.showMessageDialog(this, "The information have been sent!");	    	
	



	  this.dispose();    
	  new newbill(); 
	}
	
	
	public void deletebill(){
		
		
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		int option = JOptionPane.showConfirmDialog(this,
			    "Are you sure you want to proceed?",
			    "Delete",
			    JOptionPane.YES_NO_OPTION);
		
		
		if (option == JOptionPane.YES_OPTION  ){
			
			String d_id = d_bill_by_id.getText();
			
		     
		    
		    
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

		    	
		    	    
		    	    stmt.execute("DELETE FROM bill WHERE id_bill = '"+d_id+"';");
		    	       
		    	    

		    	}catch(Exception e){}
		    	
		    	
		    	JOptionPane.showMessageDialog(this, "The information have been sent!");	
			
		
		
		}
		
		else if (option == JOptionPane.NO_OPTION  ){
			
			this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			
		}
	
		this.dispose();    
		new newbill();
	}
	

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("save")){
			
			saveBill(); 
		}
		
		else if(e.getActionCommand().equals("delete")){
			
			deletebill(); 
			
			
		}
		

				
	}


	
}





	