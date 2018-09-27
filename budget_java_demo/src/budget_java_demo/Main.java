package budget_java_demo;

import java.util.ArrayList;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Scanner;

/*
 * The functionality of this main class is to gather information from the user
 * and use that information to perform calculations to improve the user's 
 * financial responsibility / awareness
 */

/*
 * Credit for CalendarOps.java and the methods called from there
 * in here go to Daniel De Leon
 * 
 * Credit for calculations done in the application go to Rene 
 * Vargas
 */

public class Main {
	private static ArrayList<Bill> bills; // an arraylist for bills
	private static String billNames[]; // to help search bills arraylist by name
	
	public static void main(String[] args) {
		//money formatter
		 NumberFormat money = NumberFormat.getCurrencyInstance();
		
		//Scanner function used to take user input
        Scanner keyboard = new Scanner(System.in);
        
        //doubles used to initialize values for calculations
        //Big Decimal function used for accurate calculations
        
        BigDecimal bg;
        double saving = 0;
        double checking = 0;
        double assets;
        double income = 0;
        double carExpense = 0;
        double houseExpense = 0;
        double foodExpense =0;
        double leisureExpense;
        double totalExpense;
        double bResults;
        double aResults;
        
        //Prompts welcome messages to greet user
        System.out.println("Hello, Welcome to the First Step!");
        System.out.println("This program will be used to help you plan out your path to a debt free future!");
        System.out.println("Let's start with your current financial status.");
        
        //User inputs begin to be taken one by one
        System.out.println("Please input all that you earn or spend in the span of one month\n");
        
        //Prompts user with question for savings
        System.out.print("Do you currently have a Savings account?(Y/N): ");
        String input = keyboard.nextLine();
        
        switch (input.toUpperCase()){
            //If response is yes, prompt appears awaiting user input
            case "Y" :
                System.out.print("Please input your current Savings amount: $");
                saving = keyboard.nextDouble();
                keyboard.nextLine();
            //If response is no, prompt does not appear and continues to next question
            //second use of enter button is required in this case
            default: break;
        }
        
        //keyboard.nextLine();
        
        //Prompts user with question for checking
        System.out.print("Do you currently have a checking account?(Y/N): ");
        input = keyboard.nextLine();
        
        switch (input.toUpperCase()){
            //Same result as with savings
            case "Y" :
                System.out.print("Please input your current Checking amount: $");
                checking = keyboard.nextDouble();
                keyboard.nextLine();
            default: break;
        }
        
        //inputs taken and calculated and stored in assets for future use
        assets = saving + checking;
        bg = BigDecimal.valueOf(assets);
        
        
        //Prompts user for Average monthly income
        System.out.print("Next, Do you have income of any kind? (Y/N): ");
        input = keyboard.nextLine();
        
        switch (input.toUpperCase()){
            //Same case as with savings 
            case "Y" :
                System.out.print("Please input your total monthly income: $");
                income = keyboard.nextDouble();
                keyboard.nextLine();
            default: break;
        }
        
        //Prompts user for Expenses
        System.out.println("Now, your monthly expenses . . .");
        
        //Prompts user for car information
        System.out.print("Do you own a car? (Y/N): ");
        input = keyboard.nextLine();
        
        switch (input.toUpperCase()){
	        /*
	         * if case is yes then prompts users for inputs for multiple car-related variables
	         * each variable is then recorded and calculated into a single variable carExpense
	        */
        	case "Y" :
	            System.out.print("How much is your car payment?: $");
	            double carPayment;
	            String temp = keyboard.nextLine();
	            
	            if(temp.isEmpty()) {
	            	carPayment = 0;
	            } else {
	            	carPayment = Double.parseDouble(temp);
	            }
	            
	            System.out.print("How much is your monthly insurance payment?: $");
	            double insPayment;
	            temp = keyboard.nextLine();
	            
	            if(temp.isEmpty()) {
	            	insPayment = 0;
	            } else {
	            	insPayment = Double.parseDouble(temp);
	            }
	            
	            System.out.print("How much do you pay in gas per month?: $");
	            double gasPayment;
	            temp = keyboard.nextLine();
	            
	            if(temp.isEmpty()) {
	            	gasPayment = 0;
	            } else {
	            	gasPayment = Double.parseDouble(temp);
	            }
	            
	            
	            carExpense = carPayment + insPayment + gasPayment;
	            bg = BigDecimal.valueOf(carExpense);
	            System.out.println("Judging from this, your monthly car expense is: " + money.format(carExpense));
	            //Same as savings if case is N
        	default : break;
        }
        
      //prompts user for housing payments
        System.out.print("Do you pay for housing? (Y/N): ");
        input = keyboard.nextLine();
        
        switch (input.toUpperCase()){
            /*if case is yes, program prompts user for inputs of payments and stored
             * each variable is then calculated and stored into houseExpense
            */
            case "Y" :
                System.out.print("How much is your monthly rent payement? $");
                double rentPayment;
                String temp = keyboard.nextLine();
                
                if(temp.isEmpty()) {
	            	rentPayment = 0;
	            } else {
	            	rentPayment = Double.parseDouble(temp);
	            }
                
                System.out.print("What's the total amount of utilities you pay for? $");
                double utilPayment;
                temp = keyboard.nextLine();
                
                if(temp.isEmpty()) {
	            	utilPayment = 0;
	            } else {
	            	utilPayment = Double.parseDouble(temp);
	            }
                
                System.out.print("How much do you pay in taxes? $");
                double taxPayment = 0;
                temp = keyboard.nextLine();
                
                if(temp.isEmpty()) {
	            	taxPayment = 0;
	            } else {
	            	taxPayment = Double.parseDouble(temp);
	            }
                
                houseExpense = rentPayment + utilPayment + taxPayment;
                bg = BigDecimal.valueOf(houseExpense);
                System.out.println("Judging from this, your monthly house expense is: " + money.format(houseExpense));
            //Same as savings if case is N
            default : break;
        }
        
        //Prompts user for input of food expense
        System.out.print("Do you pay for food? (Y/N): ");
        input = keyboard.nextLine();
        
        switch (input.toUpperCase()){
            /*
             * if case is yes then, user is prompted for inputs of various payments
             * each variable is then recorded and stored, and then calculated into foodExpense
             */
            case "Y" :
                System.out.print("How do you spend on average for groceries?: $");
                double grocPayment;
                String temp = keyboard.nextLine();
                
                if(temp.isEmpty()) {
	            	grocPayment = 0;
	            } else {
	            	grocPayment = Double.parseDouble(temp);
	            }

                System.out.print("How do you spend on average eating out? (i.e. resteraunts/takeout/delivery): $");
                double outPayment;
                temp = keyboard.nextLine();
                
                if(temp.isEmpty()) {
	            	outPayment = 0;
	            } else {
	            	outPayment = Double.parseDouble(temp);
	            }
                
                System.out.print("And how much do you spend on average for snacks? (i.e. vending machines, coffee breaks, etc): $");
                double snackPayment;
                temp = keyboard.nextLine();
                
                if(temp.isEmpty()) {
	            	snackPayment = 0;
	            } else {
	            	snackPayment = Double.parseDouble(temp);
	            }
                
                foodExpense = grocPayment + outPayment + snackPayment;
                bg = BigDecimal.valueOf(foodExpense);
                System.out.println("Judging from this, your monthly house expense is: " + money.format(foodExpense));
            //same as savings if case is N
            default : break;
        }
        
        //Prompts user for leisure expense
        //input is recorded and stored in leisure expense
        System.out.print("Lastly, How much do you spend on leisure?(i.e Stuff for fun): $");
        String temp = keyboard.nextLine();
        
        if(temp.isEmpty()) {
        	leisureExpense = 0;
        } else {
        	leisureExpense = Double.parseDouble(temp);
        }
        
        //Each expense input by user is then calculated into a totalExpense
        totalExpense = leisureExpense + carExpense + houseExpense + foodExpense;
        bg = BigDecimal.valueOf(totalExpense);
        
        //displays each user input for assets, income, and expenses
        System.out.println("\n-----------------------------------------------------------------------------------------------------");
        System.out.println("From your inputs it seems your total assets (Savings and Checking accounts) is: " + money.format(assets));
        System.out.println("From your inputs it seems your total monthly income is: " + money.format(income));
        System.out.print("From your inputs it seems your total monthly expenses are: " + money.format(totalExpense) + "\n");
        System.out.println("-----------------------------------------------------------------------------------------------------");
        
        //program then calculates total assets both before and after expenses are calculated
        bResults = assets + income;
        bg = BigDecimal.valueOf(bResults);
        aResults = bResults - totalExpense;
        bg = BigDecimal.valueOf(aResults);
        
        //displays calculations and goodbye messages
        System.out.println("Alrighty, judging from your inputs, it seems your total assets (before expenses) would equal:" + money.format(bResults) + "\n");
        System.out.println("Okay, judging from your inputs, it seems your total assets (after expenses) would equal:" + money.format(aResults));
        System.out.println("Remember, a lot going out and no so much coming in is not a good thing. Try reversing it!");
        System.out.println("Thank you for using The First Step!!");
        System.out.println("**More features to come in the future!!**");
        System.out.println("-----------------------------------------------------------------------------------------------------");
	}
}
