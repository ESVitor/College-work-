package test;


import company.abstractFactoryPattern.Business;
import company.abstractFactoryPattern.Company;
import company.abstractFactoryPattern.CompanyFactory;
import depot.abstractFactoryPattern.Branch;
import depot.abstractFactoryPattern.Depot;
import depot.abstractFactoryPattern.DepotFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static org.junit.Assert.*;
import org.junit.*;
import org.junit.runners.MethodSorters;
import trading.abstractFactoryPattern.EnumSingletonPatter.FactoryProducerEnumSingleton;


/**
 * This class is the test class that checks the methods of the program 
 *  
 * @author Ennio
 * @author Thieres
 * @author Fernanda 
 * @version 1.0, 22 April 2018
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CommercialTradingTest{
    
    String depotA = "depotA";
    String depotB = "depotB";
    String depotC = "depotC";
    
    String productA = "productA";
    String productB = "productB";
    String productC = "productC";

    int productAStock = 0;
    int productBStock = 0;
    int productCStock = 0;

    int totalSold = 0;

    Random randProductPrice = new Random();
    Random randDeliveryPrice = new Random();
    Random randAllowance = new Random();
    
    int x = 0;
    int y = 0;           
    int z = 0;

    int countA = 1;
    int countB = 1;
    int countC = 1;
    
    
    
    @Test
    public void testAIfCompanyBIGaGetsTheFirstID() {
        Company c = new Company("BIGa");
        assertEquals(1, c.getId());
    }
    
    @Test 
    public void testBIfCompanyBIGbGetsTheSecondID() {
        Company c = new Company("BIGb");
        assertEquals(2, c.getId());
    }
    
    @Test 
    public void testCIfCompanyBIGcGetsTheThirdID() {
        Company c = new Company("BIGc");
        assertEquals(3, c.getId());
    }
    
    @Test 
    public void testDIfCompanyBIGaGetsTheName() {
        Company c = new Company("BIGa");
        assertEquals("BIGa", c.getName());
    }
    
    @Test 
    public void testEIfDepotAHasTheFirstID() {
        Depot d = new Depot(1,"depotA","productA",5,7,10,7,3,100,30);
        assertEquals(1, d.getId());
    }
    
    @Test 
    public void testFIfDepotAHasTheRightType() {
        Depot d = new Depot(1,"depotA","productA",5,7,10,7,3,100,30);
        assertEquals("depotA", d.getType());
    }
    
    @Test 
    public void testGIfDepotAHasTheRightProductType() {
        Depot d = new Depot(1,"depotA","productA",5,7,10,7,3,100,30);
        assertEquals("productA", d.getProduct());
    }
    
    @Test 
    public void testHIfDepotAHasTheRightProductPrice() {
        Depot d = new Depot(1,"depotA","productA",5,7,10,7,3,100,30);
        assertEquals(5, d.getProductPrice());
    }
    
    @Test 
    public void testIIfDepotAHasTheRightProductDeliveryPrice() {
        Depot d = new Depot(1,"depotA","productA",5,7,10,7,3,100,30);
        assertEquals(7, d.getDeliveyPrice());
    }
    
    @Test 
    public void testJIfDepotAHasTheRightAmountOfProductAInStock() {
        Depot d = new Depot(1,"depotA","productA",5,7,10,7,3,100,30);
        assertEquals(10, d.getProductAStock());
    }
    
    @Test 
    public void testKIfDepotAHasTheRightAmountOfProductBInStock() {
        Depot d = new Depot(1,"depotA","productA",5,7,10,7,3,100,30);
        assertEquals(7, d.getProductBStock());
    }
    
    @Test 
    public void testLIfDepotAHasTheRightAmountOfProductCInStock() {
        Depot d = new Depot(1,"depotA","productA",5,7,10,7,3,100,30);
        assertEquals(3, d.getProductCStock());
    }
    
    @Test 
    public void testMIfDepotAHasTheRightAmountOfAllowance() {
        Depot d = new Depot(1,"depotA","productA",5,7,10,7,3,100,30);
        assertEquals(100, d.getAllowance());
    }
    
    @Test 
    public void testNIfDepotAHasTheRightAmountOfTotalSold() {
        Depot d = new Depot(1,"depotA","productA",5,7,10,7,3,100,30);
        assertEquals(30, d.getTotalSold());
    }
    
    @Test 
    public final void testOIfCompaniesArePopulated() throws CloneNotSupportedException {
        List<Business> businessList = new ArrayList();
        
        List<String> listOfCompanies = new ArrayList();
        listOfCompanies.add("BIGa");
        listOfCompanies.add("BIGb");
        listOfCompanies.add("BIGc");       
        
        for (int i=0; i<listOfCompanies.size() ; i++){
            
            @SuppressWarnings("static-access")
            Business business = FactoryProducerEnumSingleton.INSTANCE.getBusiness
                    (new CompanyFactory(listOfCompanies.get(i)));                   
            businessList.add(business);
        
        }   
        int size = businessList.size();
        assertEquals(3, size);
    }
    
    @Test 
    public void testPIFDepotAIsPopulated() throws CloneNotSupportedException {
        List<Branch> branchA = new ArrayList<>();
        
        
        
        while (x <= 99){
            // Auto increment the id of depots.
            int id = countA;
            countA++;
            // The delivery price is a random number between 1 t0 10.
            int deliveryPrice = randDeliveryPrice.nextInt(10) + 1;
            // The product price is a random number between 1 t0 10.
            int productPrice = randProductPrice.nextInt(10) + 1; 
            // The allowance is a random number between 50 t0 100.
            int allowance = randAllowance.nextInt(50) + 50;
            
            @SuppressWarnings("static-access")
            Branch branch = FactoryProducerEnumSingleton.INSTANCE.getBranch(new
            DepotFactory(id, depotA, productA, productPrice, deliveryPrice, 
                    productAStock, productBStock, productCStock, 
                            allowance, totalSold));
            // Delete any product that is in the Depot Class.
            branch.deleteAProducts();
            // Clone the new product A into the Depot Class.
            branch.cloneProductA();
            // Add the depotA object to the branchA list.
            branchA.add(branch);
            
            x++;
           
        } 
        assertEquals(100, branchA.size());
    }
    
    
    @Test 
    public void testQIfDepotBIsPopulated() throws CloneNotSupportedException {
         List<Branch> branchB = new ArrayList<>();
         
         while (y <= 99){
            // Auto increment the id of depots.
            int id = countB;
            countB++;
            // The delivery price is a random number between 1 t0 10.
            int deliveryPrice = randDeliveryPrice.nextInt(10) + 1;
            // The product price is a random number between 1 t0 10.
            int productPrice = randProductPrice.nextInt(10) + 1; 
            // The allowance is a random number between 50 t0 100.
            int allowance = randAllowance.nextInt(50) + 50;
            
            @SuppressWarnings("static-access")
            Branch branch = FactoryProducerEnumSingleton.INSTANCE.getBranch(new
            DepotFactory(id, depotB, productB, productPrice, deliveryPrice, 
                    productBStock, productAStock, productCStock, 
                            allowance, totalSold));
            // Delete any product that is in the Depot Class.
            branch.deleteBProducts();
            // Clone the new product A into the Depot Class.
            branch.cloneProductB();
            // Add the depotB object to the branchB list.
            branchB.add(branch);
            
            y++;
           
        }
         
        assertEquals(100, branchB.size());
    }
    
    @Test 
    public void testRIfDepotCIsPopulated() throws CloneNotSupportedException {
         List<Branch> branchC = new ArrayList<>();
    
         while (z <= 99){
            // Auto increment the id of depots.
            int id = countC;
            countC++;
            // The delivery price is a random number between 1 t0 10.
            int deliveryPrice = randDeliveryPrice.nextInt(10) + 1;
            // The product price is a random number between 1 t0 10.
            int productPrice = randProductPrice.nextInt(10) + 1; 
            // The allowance is a random number between 50 t0 100.
            int allowance = randAllowance.nextInt(50) + 50;
            
            @SuppressWarnings("static-access")
            Branch branch = FactoryProducerEnumSingleton.INSTANCE.getBranch(new
            DepotFactory(id, depotC, productC, productPrice, deliveryPrice, 
                    productCStock, productAStock, productBStock, 
                            allowance, totalSold));
             // Delete any product that is in the Depot Class.
            branch.deleteCProducts();
            // Clone the new product A into the Depot Class.
            branch.cloneProductC();
            // Add the depotC object to the branchC list.
            branchC.add(branch);
            
            z++;
            
        }            
        assertEquals(100, branchC.size());
    }        
}
