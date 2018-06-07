package depot.abstractFactoryPattern;

import java.util.ArrayList;
import java.util.List;
import product.prototypePatter.Product;

/**
 * Java Class that contain parameters to create a new depot and also this class
 * extends Branch.
 *  
 * @author Ennio
 * @author Thieres
 * @author Fernanda 
 * @version 1.0, 22 April 2018
 */
public final class Depot extends Branch  {
   private final int id;
   private final String type;
   private final String product;
   private int productPrice;
   private int deliveryPrice;   
   private int productAStock;
   private int productBStock;
   private int productCStock;
   private int allowance; 
   private int totalSold;
   // Array list to hold the product A to be used by the depotA's
   // once the depot uses the products it will empty the list and the clone will 
   // create more products. 
   List<Product> aProducts = new ArrayList<>();
   // Array list to hold the product B to be used by the depotB's
   // once the depot uses the products it will empty the list and the clone will 
   // create more products.
   List<Product> bProducts = new ArrayList<>();
   // Arraylist to hold the product C to be used by the depotC's
   // once the depot uses the products it will empty the list and the clone will 
   // create more products.
   List<Product> cProducts = new ArrayList<>();
   
   /**
     * Constructor for the class Depot that initialize the type, minNatStock,
     * maxNatStock, minStock, maxStock, allowance, totalSold. 
     * This constructor initialize the id that is auto increment and does not 
     * have to be at the parameters field
     * 
     * @param id id of the depot
     *@param type it can be 'depotA, depotB or depotC'
     * @param product The native product for this depot 
     * @param productPrice The product price for the native product
     * @param deliveryPrice The delivery price for the native product
     * @param productAStock The stock of productA
     * @param productBStock The stock of productB
     * @param productCStock The stock of productC
     *@param allowance is the cash where the company will start trading
     *@param totalSold is the total of products sold 
     * @since version 1.00
     */
    public Depot(int id, String type, String product,int productPrice, int deliveryPrice, int productAStock, int productBStock, int productCStock, int allowance, int totalSold) {
        this.id = id;
        this.type = type;
        this.product = product;
        this.productPrice = productPrice;
        this.deliveryPrice = deliveryPrice;
        this.productAStock = productAStock;
        this.productBStock = productBStock;
        this.productCStock = productCStock;
        this.allowance = allowance;
        this.totalSold = totalSold;
        
    }
    
    /**
     * Get method that gets the id of the depot. 
     * 
     * @return id
     * @since version 1.00
     */
    @Override
    public int getId() {
        return id;
    }
    
    /**
     * Get method that gets the product of the depot. 
     * 
     * @return product
     * @since version 1.00
     */
    @Override
    public String getProduct() {
        return product;
    }
     
    /**
     * Get method that gets the product price of the depot. 
     * 
     * @return productPrice
     * @since version 1.00
     */
    @Override
    public int getProductPrice() {
        return productPrice;
    }

    /**
     * Get method that gets the product delivery price of the depot. 
     * 
     * @return deliveryPrice
     * @since version 1.00
     */
    @Override
    public int getDeliveyPrice() {
        return deliveryPrice;
    }
    
    /**
     * Get method that gets the 'depotA, depotB or depotC'
     * 
     * @return type
     * @since version 1.00
     */
    @Override
    public String getType() {
        return type;
    }        

    /**
     * Get method that gets the product A stock
     * 
     * @return productAStock
     * @since version 1.00
     */
    @Override
    public int getProductAStock() {
        return this.productAStock;  
    }

    /**
     * Get method that gets the product B stock
     * 
     * @return productBStock
     * @since version 1.00
     */
    @Override
    public int getProductBStock() {
       return this.productBStock;        
    }

    /**
     * Get method that gets the product C stock
     * 
     * @return productCStock
     * @since version 1.00
     */
    @Override
    public int getProductCStock() {
        return this.productCStock;
    }
    
    /**
     * Get method that gets the cash where the company will start trading
     * 
     * @return allowance
     * @since version 1.00
     */
    @Override
    public int getAllowance() {        
        return allowance;
    }

    /**
     * Get method that gets the total of products sold
     * 
     * @return totalSold
     * @since version 1.00
     */
    @Override
    public int getTotalSold() {
        return totalSold;
    }    

    /**
     * Set method that gets the product price
     * 
     * @param productPrice The native product price
     * @return productPrice
     * @since version 1.00
     */
    @Override
    public int setProductPrice(int productPrice) {
        
        this.productPrice = productPrice;
        
        return this.productPrice;
    }

    /**
     * Set method that gets the product delivery price
     * 
     * @param deliveryPrice The delivery price of the native product
     * @return deliveryPrice
     * @since version 1.00
     */
    @Override
    public int setDeliveyPrice(int deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
        return deliveryPrice;
    }

    /**
     * Set method that gets the product A stock
     * 
     * @param productAStock The product A stock
     * @return this.prductAStock
     * @since version 1.00
     */
    @Override
    public int setProductAStock(int productAStock) {
        this.productAStock = productAStock;
        return this.productAStock;
    }

    /**
     * Set method that gets the product B stock
     * 
     * @param productBStock The product B stock
     * @return this.prductBStock
     * @since version 1.00
     */
    @Override
    public int setProductBStock(int productBStock) {
        this.productBStock = productBStock;
        return this.productBStock;
    }

    /**
     * Set method that gets the product C stock
     * 
     * @param productCStock The product c stock
     * @return this.prductCStock
     * @since version 1.00
     */
    @Override
    public int setProductCStock(int productCStock) {
        this.productCStock = productCStock;
        return this.productCStock;
    }

    /**
     * Set method that gets the product Allowance
     * 
     * @param allowance The allowance of the depot
     * @return allowance
     * @since version 1.00
     */
    @Override
    public int setAllowance(int allowance) {
        this.allowance = allowance;
        return allowance;
    }

    /**
     * Set method that gets the total of products sold
     * 
     * @param totalSold The total number of products sold by the depot
     * @return totalSold
     * @since version 1.00
     */
    @Override
    public int setTotalSold(int totalSold) {
        this.totalSold = totalSold;
        return totalSold;
    }
    
    /**
     * Method that delete the products a from the array list aProducts 
     * 
     * @since version 1.00
     */
    @Override
    public void deleteAProducts() {
        aProducts.clear();       
    } 
    
    /**
     * Method that delete the products a from the array list bProducts 
     * 
     * @since version 1.00
     */
   @Override
    public void deleteBProducts() {
        bProducts.clear();       
    }
    
    /**
     * Method that delete the products a from the array list cProducts 
     * 
     * @since version 1.00
     */
    @Override
    public void deleteCProducts() {
        cProducts.clear();       
    } 
    
    /**
     * Method to clone the 'A' Products into the provisional array aProducts
     * 
     * @throws java.lang.CloneNotSupportedException get a exception at the clone process
     * @since version 1.00
     */     
   @Override
    public void cloneProductA() throws CloneNotSupportedException{
               
        for(int i=0; i<=16; i++){
            Product productCache = new Product(1);
            productCache.loadData();
            Product clonedProductA = (Product) productCache.clone();
            aProducts.add(clonedProductA); 
            // Set the product A stock to the size of the array aProducts
            this.productAStock = aProducts.size();

        }
    }    
     
    /**
     * Method to clone the 'B' Products into the provisional array bProducts
     * 
     * @throws java.lang.CloneNotSupportedException get a exception at the clone process
     * @since version 1.00
     */  
    @Override
    public void cloneProductB() throws CloneNotSupportedException{
        
        for(int i=0; i<=16; i++){
            Product productCache = new Product(2);
            productCache.loadData();
            Product clonedProductB = (Product) productCache.clone();
            bProducts.add(clonedProductB);
            // Set the product B stock to the size of the array bProducts
            this.productBStock = bProducts.size();
            
        }
        
    }    
    
   /**
     * Method to clone the 'C' Products into the provisional array cProducts
     * 
     * @throws java.lang.CloneNotSupportedException get a exception at the clone process
     * @since version 1.00
     */   
   @Override
    public void cloneProductC() throws CloneNotSupportedException{
        for(int i=0; i<=16; i++){
            Product productCache = new Product(3);
            productCache.loadData();
            Product clonedProductC = (Product) productCache.clone();
            cProducts.add(clonedProductC); 
            // Set the product C stock to the size of the array cProducts
            this.productCStock = cProducts.size();

        }                     
    }
}
