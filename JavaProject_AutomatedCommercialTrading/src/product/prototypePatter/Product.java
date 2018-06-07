package product.prototypePatter;

import java.util.ArrayList;
import java.util.List;

/**
 * This class contains the parameters that the product classes will use to create
 * products, also this class implements Cloneable, so the products can be cloned.
 * 
 *  
 * @author Ennio
 * @author Thieres
 * @author Fernanda 
 * @version 1.0, 22 April 2018
 */
public class Product implements Cloneable{
    int productPicker;
    private final List<String> listOfProducts;

    /**
    * Constructor for the Product class that initialize the listOfProducts and 
    * the id for the product that will be cloned.
    * 
    *  
    * @param productPicker get the product that will be cloned
    * @version 1.0, 22 April 2018     
    */
    public Product(int productPicker) {
        this.productPicker = productPicker;
        listOfProducts = new ArrayList<>();
    }
    
    /**
    * Second Constructor for the Product class that initialize the listOfProducts 
    * for the product that will be cloned.
    * 
    * @param list list of cloned products 
    * @version 1.0
    */
    public Product(List<String> list) {
        this.listOfProducts = list;
    }
    
    /**
    * Method that loads the products to the array list listOfProducts
    * for the product that will be cloned.
    * 
    * @version 1.0
    */        
    public void loadData(){
        listOfProducts.add(" product A");
        listOfProducts.add(" product B");
        listOfProducts.add(" product C");
    }
    
    /**
    * get Method that returns the listOfProducts
    * for the product that will be cloned.
    * 
    * @return listOfProducts list of cloned products  
    * @version 1.0     
    */  
    public List<String> getListOfProducts () {
        return listOfProducts;
    }   
    
    /**
    * Method that returns the Object 
    * for the product that will be cloned.
    * 
    * @return super.clone()  
    * @throws java.lang.CloneNotSupportedException gets a exception at the clone process
    * @version 1.0             
    */  
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }    
}
