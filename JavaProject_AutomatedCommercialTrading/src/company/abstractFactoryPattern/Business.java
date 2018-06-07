package company.abstractFactoryPattern;
/**
 * Abstract Java Class that contain parameters where the company class will use.
 *  
 * @author Ennio
 * @author Thieres
 * @author Fernanda 
 * @version 1.0, 22 April 2018
 */
public abstract class Business {
    public abstract int getId();
    public abstract String getName();
    
    /**
     * ToString method that return the parameter from the class Business(). 
     * 
     *@return getName()
     * @since version 1.00
     */
    @Override
    public String toString(){
      return " name: " + this.getName(); 
    }
        
}
