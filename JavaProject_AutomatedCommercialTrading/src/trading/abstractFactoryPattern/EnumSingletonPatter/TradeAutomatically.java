package trading.abstractFactoryPattern.EnumSingletonPatter;

import depot.abstractFactoryPattern.Branch;
import depot.abstractFactoryPattern.DepotFactory;
import company.abstractFactoryPattern.CompanyFactory;
import company.abstractFactoryPattern.Business;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * Public final class to trade automatically
 *  
 * @author Ennio
 * @author Thieres
 * @author Fernanda 
 * @version 1.0, 22 April 2018
 */
public final class TradeAutomatically {
    
    
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
    
    // Holds the created companies from the abstract factory
    List<Business> businessList = new ArrayList();
    
    // Holds the created depots from the abstract factory
    List<Branch> branchA = new ArrayList<>();
    List<Branch> branchB = new ArrayList<>();
    List<Branch> branchC = new ArrayList<>();
    
    int totalTradeCompanyA = 0;
    int totalTradeCompanyB = 0;
    int totalTradeCompanyC = 0;
    
    int companyAProfit = 0;
    int companyBProfit = 0;
    int companyCProfit = 0;
    
    int companyATotalAmountOfB = 0;
    int companyAtotalCostOfB = 0;
    int companyAtotalCostDeliveryB = 0;
    
    int companyBTotalAmountOfA = 0;
    int companyBtotalCostOfA = 0;
    int companyBtotalCostDeliveryA = 0;
    
    int companyATotalAmountOfC = 0;
    int companyAtotalCostOfC = 0;
    int companyAtotalCostDeliveryC = 0;
    
    int companyCTotalAmountOfA = 0;
    int companyCtotalCostOfA = 0;
    int companyCtotalCostDeliveryA = 0;
    
    int companyCTotalAmountOfB = 0;
    int companyCtotalCostOfB = 0;
    int companyCtotalCostDeliveryB = 0;
    
    int companyBTotalAmountOfC = 0;
    int companyBtotalCostOfC = 0;
    int companyBtotalCostDeliveryC = 0;
    
    int companyASpent = 0;
    int companyBSpent = 0;
    int companyCSpent = 0;
    
    int companyAMade = 0;
    int companyBMade = 0;
    int companyCMade = 0;
    
    String companyToTrade = null;
    
    
    // This constructor initialize the array list populating the companies and depots
    public TradeAutomatically() throws CloneNotSupportedException {
        populateListOfCompany();
        populateListsOfDepot();
                
    }
    
    /**
     * Method to trade automatically  
     * 
     * @throws java.lang.CloneNotSupportedException gets a exception at the clone process
     * @since version 1.00
     */ 
    public void tradeAutomatically() throws CloneNotSupportedException{ 
        
        // Sequence of depots to the buying process.
        // This order metters. All depots will attempt to trade with the other one 
        // from the other company. 
        depotABuysFromDepotB (); // First 
        depotBBuysFromDepotA (); // Second 
        depotABuysFromDepotC (); // Third
        depotCBuysFromDepotA (); // Fourth
        depotCBuysFromDepotB (); // Fifth 
        depotBBuysFromDepotC (); // Sixth
        
        // Final report of the trades
        finalReport();    
    }
        
    /**
     * Method to populate the companies into the system's memory
     * 
     * @since version 1.00
     */ 
    public void populateListOfCompany() {
        
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
    }
    
    /**
     * Method to populate the depots into the system's memory
     * 
     * @throws java.lang.CloneNotSupportedException gets a exception at the clone process  
     * @since version 1.00
     */ 
    public final void populateListsOfDepot() throws CloneNotSupportedException { 
        
        int x = 0;
        int y = 0;           
        int z = 0;
        
        int countA = 1;
        int countB = 1;
        int countC = 1;
        
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
    }
    
    /**
     * Method every depotA buys attempt to trade with every depot B  
     * 
     * @throws java.lang.CloneNotSupportedException gets a exception at the clone process
     * @since version 1.00
     */     
    public void depotABuysFromDepotB () throws CloneNotSupportedException {        
         // Loop over each depotA's 
        for(int z=0; z<=99; z++){ 
            // Loop how many times to Shop the maximum is 100 times.
            for(int v=0; v<=99; v++){ 
                // Loop over each depotB's
                for(int i=0; i<=99; i++){                                         
                    // order: the maximum amount of products at a time is 1.
                    int order = 1;                      
                    // Stock of product B in depotA
                    int aStockOfB = branchA.get(z).getProductBStock();
                    // Get the total of product B in depotB    
                    int supplierB = branchB.get(i).getProductBStock();
                    // If the stock of product B + Order is less than 40 a new order is made 
                    if(aStockOfB < 3 ||  aStockOfB < 40 && supplierB > 16) {  
                        
                        // Total of products B sold
                        int totalsoldSupplierB = branchB.get(i).getTotalSold();
                        // Reduce product B from depotB
                        branchB.get(i).setProductBStock( supplierB - order);
                        // Set the total of product B sold in depotB
                        branchB.get(i).setTotalSold(totalsoldSupplierB + order); 
                        // Set stock of product B in depotA
                        branchA.get(z).setProductBStock(aStockOfB + order);     
                        // Get Price of product B in depotB
                        int productBPrice = branchB.get(i).getProductPrice();
                        // Get delivery of productB in depotB.
                        int deliveryBPrice = branchB.get(i).getDeliveyPrice();
                        // DepotA paying the total.
                        int depotACach = branchA.get(z).getAllowance();
                        branchA.get(z).setAllowance(depotACach - ((productBPrice + deliveryBPrice)*order));
                        // DepotB sets payment
                        int depotBCach = branchB.get(i).getAllowance();
                        branchB.get(i).setAllowance(depotBCach + ((productBPrice + deliveryBPrice)*order));
                        
                        // Get values to populate the Final report method 
                        int trade = 1;
                        companyATotalAmountOfB = companyATotalAmountOfB + order;
                        companyAtotalCostOfB = companyAtotalCostOfB + productBPrice;
                        companyAtotalCostDeliveryB = companyAtotalCostDeliveryB + deliveryBPrice;
                        totalTradeCompanyA = totalTradeCompanyA + trade;
                        companyAProfit = companyAProfit - productBPrice - deliveryBPrice;
                        companyASpent = companyASpent - productBPrice - deliveryBPrice;
                        
                        totalTradeCompanyB = totalTradeCompanyB + trade;
                        companyBProfit = companyBProfit + productBPrice + deliveryBPrice;
                        companyBMade = companyBMade + productBPrice + deliveryBPrice;                         
                    }
                    // If B stock is less than 15 clone more 
                    if(supplierB <= 15){ 
                        // Delite the registre of products from the class Depot
                        branchB.get(v).deleteBProducts(); 
                        // Clone more products (16 at a time)
                        branchB.get(v).cloneProductB();                       
                    }                    
                }
            }    
        }        
    }    
    
    /**
     * Method every depotB buys attempt to trade with every depot A  
     * 
     * @throws java.lang.CloneNotSupportedException gets a exception at the clone process
     * @since version 1.00
     */ 
    public void depotBBuysFromDepotA () throws CloneNotSupportedException {
         // Loop over each depotB's 
        for(int z=0; z<=99; z++){ 
            // Loop how many times to Shop the maximum is 100 times.
            for(int v=0; v<=99; v++){ 
                // Loop over each depotA's
                for(int i=0; i<=99; i++){ 
                    // order: the maximum amount of products at a time is 1.
                    int order = 1; 
                    // Stock of product A in depotB
                    int bStockOfA = branchB.get(z).getProductAStock();
                    // Get the total of product A in depotA    
                    int supplierA = branchA.get(i).getProductAStock();
                    // If the stock of product A is less than 3 or less than 40 a new order is made 
                    if(bStockOfA < 3 ||  bStockOfA < 40 && supplierA > 16) {
                        // Total of products A sold
                        int totalsoldSupplierA = branchA.get(i).getTotalSold();
                        // Reduce product A from depotA
                        branchA.get(i).setProductAStock( supplierA - order);
                        // Set the total of product A sold in depotA
                        branchA.get(i).setTotalSold(totalsoldSupplierA + order); 
                        // Set stock of product A in depotB
                        branchB.get(z).setProductAStock(bStockOfA + order);     
                        // Get Price of product A in depotA
                        int productAPrice = branchA.get(i).getProductPrice();
                        // Get delivery of productA in depotA.
                        int deliveryAPrice = branchA.get(i).getDeliveyPrice();
                        // DepotB paying the total.
                        int depotBCach = branchB.get(z).getAllowance();
                        branchB.get(z).setAllowance(depotBCach - ((productAPrice + deliveryAPrice)*order));
                        // DepotA sets payment
                        int depotACach = branchA.get(i).getAllowance();
                        branchA.get(i).setAllowance(depotACach + ((productAPrice + deliveryAPrice)*order));
                        
                        // Get values to populate the Final report method
                        int trade = 1;
                        companyBTotalAmountOfA = companyBTotalAmountOfA + order;
                        companyBtotalCostOfA = companyBtotalCostOfA + productAPrice;
                        companyBtotalCostDeliveryA = companyBtotalCostDeliveryA + deliveryAPrice;
                        totalTradeCompanyB = totalTradeCompanyB + trade;
                        companyBProfit = companyBProfit - productAPrice - deliveryAPrice;
                        companyBSpent = companyBSpent - productAPrice - deliveryAPrice;
                        
                        totalTradeCompanyA = totalTradeCompanyA + trade;
                        companyAProfit = companyAProfit + productAPrice + deliveryAPrice;
                        companyAMade = companyAMade + productAPrice + deliveryAPrice; 
                    }
                    // If B stock is less than 15 clone more 
                    if(supplierA <= 15){ 
                        // Delite the registre of products from the class Depot
                        branchA.get(v).deleteAProducts(); 
                        // Clone more products (16 at a time)
                        branchA.get(v).cloneProductA();                       
                    }                    
                }
            }    
        }
    }
    
    /**
     * Method every depotA buys attempt to trade with every depot C  
     * 
     * @throws java.lang.CloneNotSupportedException gets a exception at the clone process
     * @since version 1.00
     */ 
    public void depotABuysFromDepotC () throws CloneNotSupportedException {
         // Loop over each depotA's 
        for(int z=0; z<=99; z++){ 
            // Loop how many times to Shop the maximum is 100 times.
            for(int v=0; v<=99; v++){ 
                // Loop over each depotC's
                for(int i=0; i<=99; i++){ 
                    // order: the maximum amount of products at a time is 1.
                    int order = 1; 
                    // Stock of product C in depotA
                    int aStockOfC = branchA.get(z).getProductCStock();
                    // Get the total of product C in depotC    
                    int supplierC = branchC.get(i).getProductCStock();
                    // If the stock of product C + Order is less than 40 a new order is made 
                    if(aStockOfC < 3 ||  aStockOfC < 40 && supplierC > 16) {
                        // Total of products C sold
                        int totalsoldSupplierC = branchC.get(i).getTotalSold();
                        // Reduce product C from depotC
                        branchC.get(i).setProductCStock( supplierC - order);
                        // Set the total of product C sold in depotC
                        branchC.get(i).setTotalSold(totalsoldSupplierC + order); 
                        // Set stock of product C in depotA
                        branchA.get(z).setProductCStock(aStockOfC + order);     
                        // Get Price of product C in depotC
                        int productCPrice = branchC.get(i).getProductPrice();
                        // Get delivery of productC in depotC.
                        int deliveryCPrice = branchC.get(i).getDeliveyPrice();
                        // DepotA paying the total.
                        int depotACach = branchA.get(z).getAllowance();
                        branchA.get(z).setAllowance(depotACach - ((productCPrice + deliveryCPrice)*order));
                        // DepotC sets payment
                        int depotCCach = branchC.get(i).getAllowance();
                        branchC.get(i).setAllowance(depotCCach + ((productCPrice + deliveryCPrice)*order));
                        
                        // Get values to populate the Final report method
                        int trade = 1;
                        companyATotalAmountOfC = companyATotalAmountOfC + order;
                        companyAtotalCostOfC = companyAtotalCostOfC + productCPrice;
                        companyAtotalCostDeliveryC = companyAtotalCostDeliveryC + deliveryCPrice;
                        totalTradeCompanyA = totalTradeCompanyA + trade;
                        companyAProfit = companyAProfit - productCPrice - deliveryCPrice;
                        companyASpent = companyASpent - productCPrice - deliveryCPrice;
                        
                        totalTradeCompanyC = totalTradeCompanyC + trade;
                        companyCProfit = companyCProfit + productCPrice + deliveryCPrice;
                        companyCMade = companyCMade + productCPrice + deliveryCPrice;
                    }
                    // If C stock is less than 15 clone more 
                    if(supplierC <= 15){ 
                        // Delete the registre of products from the class Depot
                        branchC.get(v).deleteCProducts(); 
                        // Clone more products (16 at a time)
                        branchC.get(v).cloneProductC();                       
                    }                    
                }
            }    
        }
    }
    
    /**
     * Method every depotC buys attempt to trade with every depot A
     * 
     * @throws java.lang.CloneNotSupportedException gets a exception at the clone process
     * @since version 1.00
     */ 
    public void depotCBuysFromDepotA () throws CloneNotSupportedException {
         // Loop over each depotC's 
        for(int z=0; z<=99; z++){ 
            // Loop how many times to Shop the maximum is 100 times.
            for(int v=0; v<=99; v++){ 
                // Loop over each depotA's
                for(int i=0; i<=99; i++){ 
                    // order: the maximum amount of products at a time is 1.
                    int order = 1; 
                    // Stock of product C in depotA
                    int cStockOfA = branchC.get(z).getProductAStock();
                    // Get the total of product A in depotA    
                    int supplierA = branchA.get(i).getProductAStock();
                    // If the stock of product A + Order is less than 40 a new order is made 
                    if(cStockOfA < 3 ||  cStockOfA < 40 && supplierA > 16) {
                        // Total of products A sold
                        int totalsoldSupplierA = branchA.get(i).getTotalSold();
                        // Reduce product A from depotA
                        branchA.get(i).setProductAStock( supplierA - order);
                        // Set the total of product A sold in depotA
                        branchA.get(i).setTotalSold(totalsoldSupplierA + order); 
                        // Set stock of product A in depotC
                        branchC.get(z).setProductAStock(cStockOfA + order);     
                        // Get Price of product A in depotA
                        int productAPrice = branchA.get(i).getProductPrice();
                        // Get delivery of productA in depotA.
                        int deliveryAPrice = branchA.get(i).getDeliveyPrice();
                        // DepotC paying the total.
                        int depotCCach = branchC.get(z).getAllowance();
                        branchC.get(z).setAllowance(depotCCach - ((productAPrice + deliveryAPrice)*order));
                        // DepotA sets payment
                        int depotACach = branchA.get(i).getAllowance();
                        branchA.get(i).setAllowance(depotACach + ((productAPrice + deliveryAPrice)*order));
                        
                        // Get values to populate the Final report method
                        int trade = 1;
                        companyCTotalAmountOfA = companyCTotalAmountOfA + order;
                        companyCtotalCostOfA = companyCtotalCostOfA + productAPrice;
                        companyCtotalCostDeliveryA = companyCtotalCostDeliveryA + deliveryAPrice;
                        totalTradeCompanyC = totalTradeCompanyC + trade;
                        companyCProfit = companyCProfit - productAPrice - deliveryAPrice;
                        companyCSpent = companyCSpent - productAPrice - deliveryAPrice;
                        
                        totalTradeCompanyA = totalTradeCompanyA + trade;
                        companyAProfit = companyAProfit + productAPrice + deliveryAPrice;
                        companyAMade = companyAMade + productAPrice + deliveryAPrice;
                    }
                    // If A stock is less than 15 clone more 
                    if(supplierA <= 15){ 
                        // Delete the registre of products from the class Depot
                        branchA.get(v).deleteAProducts(); 
                        // Clone more products (16 at a time)
                        branchA.get(v).cloneProductA();                       
                    }                    
                }
            }    
        }
    }
    
    /**
     * Method every depotC buys attempt to trade with every depot B  
     * 
     * @throws java.lang.CloneNotSupportedException gets a exception at the clone process
     * @since version 1.00
     */ 
    public void depotCBuysFromDepotB () throws CloneNotSupportedException {
         // Loop over each depotC's 
        for(int z=0; z<=99; z++){ 
            // Loop how many times to Shop the maximum is 100 times.
            for(int v=0; v<=99; v++){ 
                // Loop over each depotC's
                for(int i=0; i<=99; i++){ 
                    // order: the maximum amount of products at a time is 1.
                    int order = 1; 
                    // Stock of product B in depotc
                    int cStockOfB = branchC.get(z).getProductBStock();
                    // Get the total of product B in depotB    
                    int supplierB = branchB.get(i).getProductBStock();
                    // If the stock of product B + Order is less than 40 a new order is made 
                    if(cStockOfB < 3 ||  cStockOfB < 40 && supplierB > 16) {
                        // Total of products B sold
                        int totalsoldSupplierB = branchB.get(i).getTotalSold();
                        // Reduce product B from depotB
                        branchB.get(i).setProductBStock( supplierB - order);
                        // Set the total of product B sold in depotB
                        branchB.get(i).setTotalSold(totalsoldSupplierB + order); 
                        // Set stock of product B in depotC
                        branchC.get(z).setProductBStock(cStockOfB + order);     
                        // Get Price of product B in depotB
                        int productBPrice = branchB.get(i).getProductPrice();
                        // Get delivery of productB in depotB.
                        int deliveryBPrice = branchB.get(i).getDeliveyPrice();
                        // DepotC paying the total.
                        int depotCCach = branchC.get(z).getAllowance();
                        branchC.get(z).setAllowance(depotCCach - ((productBPrice + deliveryBPrice)*order));
                        // DepotB sets payment
                        int depotBCach = branchB.get(i).getAllowance();
                        branchB.get(i).setAllowance(depotBCach + ((productBPrice + deliveryBPrice)*order));
                        
                        // Get values to populate the Final report method
                        int trade = 1;
                        companyCTotalAmountOfB = companyCTotalAmountOfB + order;
                        companyCtotalCostOfB = companyCtotalCostOfB + productBPrice;
                        companyCtotalCostDeliveryB = companyCtotalCostDeliveryB + deliveryBPrice;
                        totalTradeCompanyC = totalTradeCompanyC + trade;
                        companyCProfit = companyCProfit - productBPrice - deliveryBPrice;
                        companyCSpent = companyCSpent - productBPrice - deliveryBPrice;
                        
                        totalTradeCompanyB = totalTradeCompanyB + trade;
                        companyBProfit = companyBProfit + productBPrice + deliveryBPrice;
                        companyBMade = companyBMade + productBPrice + deliveryBPrice;
                    }
                    // If A stock is less than 15 clone more 
                    if(supplierB <= 15){ 
                        // Delete the registre of products from the class Depot
                        branchB.get(v).deleteBProducts(); 
                        // Clone more products (16 at a time)
                        branchB.get(v).cloneProductB();                       
                    }                    
                }
            }    
        }
    }
    
    /**
     * Method every depotB buys attempt to trade with every depot C
     * 
     * @throws java.lang.CloneNotSupportedException gets a exception at the clone process
     * @since version 1.00
     */ 
    public void depotBBuysFromDepotC () throws CloneNotSupportedException {
         // Loop over each depotB's 
        for(int z=0; z<=99; z++){ 
            // Loop how many times to Shop the maximum is 100 times.
            for(int v=0; v<=99; v++){ 
                // Loop over each depotC's
                for(int i=0; i<=99; i++){ 
                    // order: the maximum amount of products at a time is 1.
                    int order = 1; 
                    // Stock of product C in depotb
                    int bStockOfC = branchB.get(z).getProductCStock();
                    // Get the total of product C in depotC    
                    int supplierC = branchC.get(i).getProductCStock();
                    // If the stock of product C + Order is less than 40 a new order is made 
                    if(bStockOfC < 3 ||  bStockOfC < 40 && supplierC > 16) {
                        // Total of products C sold
                        int totalsoldSupplierC = branchC.get(i).getTotalSold();
                        // Reduce product C from depotC
                        branchC.get(i).setProductCStock( supplierC - order);
                        // Set the total of product C sold in depotC
                        branchC.get(i).setTotalSold(totalsoldSupplierC + order); 
                        // Set stock of product C in depotB
                        branchB.get(z).setProductCStock(bStockOfC + order);     
                        // Get Price of product C in depotC
                        int productCPrice = branchC.get(i).getProductPrice();
                        // Get delivery of productC in depotC.
                        int deliveryCPrice = branchC.get(i).getDeliveyPrice();
                        // DepotB paying the total.
                        int depotBCach = branchB.get(z).getAllowance();
                        branchB.get(z).setAllowance(depotBCach - ((productCPrice + deliveryCPrice)*order));
                        // DepotC sets payment
                        int depotCCach = branchC.get(i).getAllowance();
                        branchC.get(i).setAllowance(depotCCach + ((productCPrice + deliveryCPrice)*order));
                        
                        // Get values to populate the Final report method
                        int trade = 1;
                        companyBTotalAmountOfC = companyBTotalAmountOfC + order;
                        companyBtotalCostOfC = companyBtotalCostOfC + productCPrice;
                        companyBtotalCostDeliveryC = companyBtotalCostDeliveryC + deliveryCPrice;
                        totalTradeCompanyB = totalTradeCompanyB + trade;
                        companyBProfit = companyBProfit - productCPrice - deliveryCPrice;
                        companyBSpent = companyBSpent - productCPrice - deliveryCPrice;
                        
                        totalTradeCompanyC = totalTradeCompanyC + trade;
                        companyCProfit = companyCProfit + productCPrice + deliveryCPrice;
                        companyCMade = companyCMade + productCPrice + deliveryCPrice;
                    }
                    // If A stock is less than 15 clone more 
                    if(supplierC <= 15){ 
                        // Delete the registre of products from the class Depot
                        branchC.get(v).deleteCProducts(); 
                        // Clone more products (16 at a time)
                        branchC.get(v).cloneProductC();                       
                    }                    
                }
            }    
        }
    }
    
    /**
     * Method that displays the Final report of the trades
     * 
     * @since version 1.00
     */ 
    public void finalReport() {
        System.out.println("***********************************************************");
        System.out.println("FINAL REPORT FOR COMPANY A \n");
        
        System.out.println("Total trade Company" + businessList.get(0) + ":: " + totalTradeCompanyA);
        System.out.println("Profit:: " + companyAProfit);
        System.out.println("\n");
        System.out.println("Total product B purchased:: " + companyATotalAmountOfB);
        System.out.println("Total cost of product B:: " + companyAtotalCostOfB);
        System.out.println("Total cost of delivery product B:: " + companyAtotalCostDeliveryB);
        System.out.println("....................");
        System.out.println("Total product C purchased:: " + companyATotalAmountOfC);
        System.out.println("Total cost of product C:: " + companyAtotalCostOfC);
        System.out.println("Total cost of delivery product C:: " + companyAtotalCostDeliveryC);
        System.out.println("\n");
        
        System.out.println("***********************************************************");
        System.out.println("FINAL REPORT FOR COMPANY B \n");
        System.out.println("Total trade Company" + businessList.get(1) + ":: " + totalTradeCompanyB);
        System.out.println("Profit:: " + companyBProfit);
        System.out.println("\n");
        System.out.println("Total product A purchased:: " + companyBTotalAmountOfA);
        System.out.println("Total cost of product A:: " + companyBtotalCostOfA);
        System.out.println("Total cost of delivery product A:: " + companyBtotalCostDeliveryA);
        System.out.println("....................");
        System.out.println("Total product C purchased:: " + companyBTotalAmountOfC);
        System.out.println("Total cost of product C:: " + companyBtotalCostOfC);
        System.out.println("Total cost of delivery product C:: " + companyBtotalCostDeliveryC);
        System.out.println("\n");        
        
        System.out.println("***********************************************************");
        System.out.println("FINAL REPORT FOR COMPANY C \n");
        System.out.println("Total trade Company" + businessList.get(2) + ":: " + totalTradeCompanyC);
        System.out.println("Profit:: " + companyCProfit);
        System.out.println("\n");
        System.out.println("Total product A purchased:: " + companyCTotalAmountOfA);
        System.out.println("Total cost of product A:: " + companyCtotalCostOfA);
        System.out.println("Total cost of delivery product A:: " + companyCtotalCostDeliveryA);
        System.out.println("....................");
        System.out.println("Total product B purchased:: " + companyCTotalAmountOfB);
        System.out.println("Total cost of product B:: " + companyCtotalCostOfB);
        System.out.println("Total cost of delivery product B:: " + companyCtotalCostDeliveryB);
        System.out.println("\n");        
        
        System.out.println("***********************************************************");
        System.out.println("COMPANY THAT MADE THE MOST AND COMPANY THAT SPENT THE MOST \n");
        
        Business highest = null;
        Business lowest = null;
        
        if (companyAMade > companyBMade && companyAMade > companyCMade ){
            highest = businessList.get(0);
        }else if(companyBMade > companyAMade && companyBMade > companyCMade){
            highest = businessList.get(1);
        }else if(companyCMade > companyAMade && companyCMade > companyBMade){
            highest = businessList.get(2);
        }
        
        if (companyASpent < companyBSpent && companyASpent < companyCSpent ){
            lowest = businessList.get(0);
        }else if(companyBSpent < companyASpent && companyBSpent < companyCSpent){
            lowest = businessList.get(1);
        }else if(companyCSpent < companyASpent && companyCSpent < companyBSpent){
            lowest = businessList.get(2);
        }        
        
        System.out.println("COMPANY THAT MADE THE MOST:: " + highest );
        System.out.println("COMPANY THAT SPENT THE MOST:: " + lowest );
        System.out.println("\n");
        System.out.println(businessList.get(0) + " made:: " + companyAMade);
        System.out.println(businessList.get(1) + " made:: " + companyBMade);
        System.out.println(businessList.get(2) + " made:: " + companyCMade);
        System.out.println("\n");
        System.out.println(businessList.get(0) + " spent:: " + companyASpent);
        System.out.println(businessList.get(1) + " spent:: " + companyBSpent);
        System.out.println(businessList.get(2) + " spent:: " + companyCSpent);
        
        System.out.println("\n");        
        System.out.println("***********************************************************");
    }
}
