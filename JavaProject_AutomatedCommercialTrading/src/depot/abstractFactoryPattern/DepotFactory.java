package depot.abstractFactoryPattern;
/**
 * Factory class that produce depots, this class implements 
 * DepotAbstractFactory.
 *  
 * @author Ennio
 * @author Thieres
 * @author Fernanda 
 * @version 1.0, 22 April 2018
 */
public class DepotFactory implements DepotAbstractFactory{
   private final int id; 
   private final String type;
   private final String product;   
   private final int productPrice;
   private final int deliveryPrice;
   private final int productAStock;
   private final int productBStock;
   private final int productCStock;
   private final int allowance; 
   private final int totalSold;
  
   /**
     * Constructor for the class DepotFactory that initialize the type, minNatStock,
     * maxNatStock, minStock, maxStock, allowance, totalSold. 
     * This constructor initialize the id that is auto increment and does not 
     * have to be at the parameters field
     * 
     * @param id id of the depot
     *@param type it can be 'depotA, depotB or depotC'
     *@param product Native product of the depot
     * @param productPrice price of the native product
     * @param deliveryPrice price of delivery price of the native product
     * @param productAStock product A stock
     * @param productBStock product B stock
     * @param productCStock product C stock
     *@param allowance is the cash where the company will start trading
     *@param totalSold is the total of products sold 
     * @since version 1.00
     */
    public DepotFactory (int id, String type, String product,int productPrice, int deliveryPrice, int productAStock, int productBStock, int productCStock, int allowance, int totalSold) {
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
     * Method to produce a depot object
     * 
     *@return type it can be 'depotA, depotB or depotC', 
     *         minNatStock is the minimum stock of native product, 
     *         maxNatStock is the maximum stock of native product,
     *         minStock is  the minimum stock of other products,
     *         maxStock is the maximum stock of other products,
     *         allowance is the cash where the company will start trading,
     *         totalSold is the total of products sold   
     * 
     * @since version 1.00
     */
    @Override
    public Depot createDepot() {
        return new Depot(id, type, product, productPrice, deliveryPrice , productAStock, productBStock, productCStock, allowance, totalSold);
    }
}
