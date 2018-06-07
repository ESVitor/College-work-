package company.abstractFactoryPattern;
/**
 * Factory class that produce companies, this class implements 
 * CompanyAbstractFactory.
 *  
 * @author Ennio
 * @author Thieres
 * @author Fernanda 
 * @version 1.0, 22 April 2018
 */
public class CompanyFactory implements CompanyAbstractFactory {
    
    String name;

    /**
     * Constructor for the class CompanyFactory that initialize the name of the company. 
     * 
     *@param name the only value that has to pass.   
     * 
     * @since version 1.00
     */
    public CompanyFactory(String name) {
        // Set the name of the new company.
        this.name = name;
    }
    
    /**
     * Method to produce a company object
     * 
     *@return name the only value that has to pass.   
     * 
     * @since version 1.00
     */
    @Override
    public Company createCompany() {
        // Returns the name of the new company to the Company class.
        return new Company (name);
    }    
}
