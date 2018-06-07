package company.abstractFactoryPattern;
/**
 * Java Class that contain parameters to create a new company and also this class
 * extends Business.
 *  
 * @author Ennio
 * @author Thieres
 * @author Fernanda 
 * @version 1.0, 22 April 2018
 */
public class Company extends Business  {
    // The first company will have id 1.
    private int id = 1;
    // counter to increment the id number.
    private static int count = 1;
    private String name;
    
    /**
     * Constructor for the class Company that initialize the name of the company. 
     * This constructor initialize the id that is auto increment and does not 
     * have to be at the parameters field
     * 
     *@param name the only value that has to pass.   
     * 
     * @since version 1.00
     */
    public Company (String name) {
        this.id = count;
        count++;
        this.name = name;
    }
    
    /**
     * Get method that gets the name of the company. 
     * 
     * @return name
     * @since version 1.00
     */
    @Override
    public String getName() {
        return name;
    }            
    
    /**
     * Get method that gets the id of the company. 
     * 
     * @return id
     * @since version 1.00
     */
    @Override
    public int getId() {
        return id; 
    }
}
