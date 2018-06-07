package company.abstractFactoryPattern;
/**
 * Java interface for the Company Abstract Factory, This interface contains the 
 * abstract method to create a company object. 
 *  
 * @author Ennio
 * @author Thieres
 * @author Fernanda 
 * @version 1.0, 22 April 2018
 */
public interface CompanyAbstractFactory {
    // Abstract method to create a new company.
    abstract Company createCompany();
       
}
