package depot.abstractFactoryPattern;


/**
 * Abstract Java Class that contain parameters where the Depot class will use.
 *  
 * @author Ennio
 * @author Thieres
 * @author Fernanda 
 * @version 1.0, 22 April 2018
 */
public abstract class Branch {
    public abstract int getId();
    public abstract String getType();
    public abstract String getProduct();
    public abstract int getProductPrice();
    public abstract int setProductPrice(int productPrice);
    public abstract int getDeliveyPrice();
    public abstract int setDeliveyPrice(int DeliveyPrice);
    public abstract int getProductAStock();
    public abstract int setProductAStock(int ProductAStock);    
    public abstract int getProductBStock();
    public abstract int setProductBStock(int ProductBStock);
    public abstract int getProductCStock();
    public abstract int setProductCStock(int ProductCStock);
    public abstract int getAllowance();
    public abstract int setAllowance(int Allowance);
    public abstract int getTotalSold();
    public abstract int setTotalSold(int TotalSold);
    public abstract void cloneProductA()throws CloneNotSupportedException;
    public abstract void cloneProductB()throws CloneNotSupportedException;
    public abstract void cloneProductC()throws CloneNotSupportedException;
    public abstract void deleteAProducts();
    public abstract void deleteBProducts();
    public abstract void deleteCProducts();
    
    
    /**
     * ToString method that return the parameter from the class Branch(). 
     * 
     *@return getId(), getType(), getProductPrice(), getDeliveryPrice(),getProductAStock(),
     *        getProductBStock(), getProductCStock(), getAllowance(), getTotalSold().   
     * 
     * @since version 1.00
     */
    @Override
    public String toString(){
      return  "ID: " + this.getId() 
                + "     Type: " + this.getType() + "    Product price: " + this.getProductPrice()
                + "     Delivery price: " + this.getDeliveyPrice() + "      Product A Stock: " + this.getProductAStock()
                    + "     Product B Stock: " + this.getProductBStock() + "    Product C Stock: " + this.getProductCStock()
                        + "     Allowance: " + this.getAllowance() + "      Total Sold: " + this.getTotalSold() ; 
    } 
}
