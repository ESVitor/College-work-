package trading.abstractFactoryPattern.EnumSingletonPatter;

import depot.abstractFactoryPattern.Branch;
import depot.abstractFactoryPattern.DepotAbstractFactory;
import company.abstractFactoryPattern.Business;
import company.abstractFactoryPattern.CompanyAbstractFactory;

/**
 * This class contains the producer approach for the Abstract Factory  and 
 * to control the productions of objects this class contain also the Enum Singleton 
 * method where the class is instantiated by the INSTANCE enum.   
 *  
 * @author Ennio
 * @author Thieres
 * @author Fernanda 
 * @version 1.0, 22 April 2018
 */
public enum FactoryProducerEnumSingleton {

    INSTANCE;
    
    /**
     * Method to get the values of company object, to pass to the Business class
     * 
     *@param factory to use the CompanyAbstractFactory to pass the values to create 
     *company
     * 
     *@return createCompany().
     * 
     * @since version 1.00
     */
    public static Business getBusiness(CompanyAbstractFactory factory) {
       return factory.createCompany();
    }
    
    /**
     * Method to get the values of depot object, to pass to the Branch class
     * 
     *@param factory to use the DepotAbstractFactory to pass the values to create 
     * a company
     * 
     *@return createDepot().
     * 
     * @since version 1.00
     */
    public static Branch getBranch(DepotAbstractFactory factory){
        return factory.createDepot();
    }    
}
