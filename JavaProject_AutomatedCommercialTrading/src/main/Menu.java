package main;

import trading.abstractFactoryPattern.EnumSingletonPatter.TradeAutomatically;
import trading.abstractFactoryPattern.EnumSingletonPatter.TradeManually;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Java Class that displays the menu to the user.
 *  
 * @author Ennio
 * @author Thieres
 * @author Fernanda 
 * @version 1.0, 22 April 2018
 */
public final class Menu {
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    

	boolean inputOk;
	int option;

    /**
     * Constructor method showing the welcome message and calls the menu for options
     * 
     * @throws java.lang.CloneNotSupportedException gets a exception at the clone process
     * @since version 1.00
     */    
    public Menu() throws CloneNotSupportedException{
        System.out.println("****************************************************************************"
            + "**********************************" + "*\n********************************"
		+ "****** Welcome to the Commercial Trading System **************"
                	+ "*****************\n*******************************************"
			+ "**************************************************************" + "******");
        
        menu();
    }
    
    /**
     * Method showing options to operate the system.
     * 
     * @throws java.lang.CloneNotSupportedException gets a exception at the clone process
     * @since version 1.00
     */ 
    public void menu() throws CloneNotSupportedException {
	printMenu();
        TradeAutomatically t = new TradeAutomatically();
        TradeManually tm = new TradeManually();
	switch (option) {
            case 1:
		t.tradeAutomatically();
		menu();
		break;
            case 2:
		tm.tradeManually();
		menu();
        	break;
            case 3:
		exit();
		break;
        }        
    }

    /**
     * Method to print the menu on the screen and prompt a field to the user 
     * type the option
     * 
     * @since version 1.00
     */ 
    public void printMenu() {
        option = 0;
        inputOk = false;
        do {
            try {
                System.out.println("\n");
                System.out.println("Press [1] to Trade automatically");
                System.out.println("Press [2] to Trade manually");
                System.out.println("Press [3] to Exit the program");
                                
                option = Integer.parseInt(br.readLine());

                if (option <= 3 && option >= 1) {
                    inputOk = true;
                } else {
                    inputOk = false;
                    System.out.println("******************************\nOption : " + option + " is not avaliable"
                        + " \nPlease enter a valid option \n******************************");
                }
            } catch (IOException | NumberFormatException e) {
                inputOk = false;
            }
        } while (inputOk != true);
    }   
    
    /**
     * Method to exit the program
     * 
     * @since version 1.00
     */ 
    public void exit() {
	System.out.println("The program is successfully finalized...\n");
        System.out.println("**********COME AGAIN, SEE YOU SOON**********");
	System.exit(0);
    }        
}
