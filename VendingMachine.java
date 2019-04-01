//Name: Darian Thompson
//Class: ITEC 324
//Project 1
import java.util.Scanner;                       
import java.text.DecimalFormat;
public class VendingMachine
{
   public static void main(String []args)
   {
   Scanner keyboard = new Scanner(System.in);   //object for inputting values
   Product candy = new Product(1.00, "A1", 10); //sets products for the vending machine
   Product soda = new Product(1.25, "A2", 15);
   Product chips = new Product(0.75, "A3",12);
   String y = " ";                              //string used for exit conditions of while loops
   Coins balance = new Coins();                 //stores the users balance
   Coins mainBalance = new Coins();             //stores total sales of vending machine
   double refund = 0.00;                        //variable for outputting the users change
   DecimalFormat form = new DecimalFormat("#0.00"); //used to set balance variables to display 2 decimal places
   balance.setTotalBalance(0.00);                             
      while(!y.equals("Z")) //loop used to have the vending machine continue to repeat operations
         {   
         while (!y.equals("X")) //loop used to continue to display and take in coins until user desires to move
                                //to select a product.
          {
          System.out.println("-----------------------Vending Machine-----------------------");
          System.out.println("                 Item      Code       Price      Stock       ");
          System.out.println("                 chips     " + chips.getItemCode() + "       " +
          "  " + form.format(chips.getPrice()) + "       " + chips.getTotalStock());
          System.out.println("                 soda      " + soda.getItemCode() + "        " +
          " " + form.format(soda.getPrice()) + "       " + soda.getTotalStock());
          System.out.println("                 candy     " + candy.getItemCode() + "       " +
          "  " + form.format(candy.getPrice()) + "       " + candy.getTotalStock());
          //displays information of the vending machine
          System.out.println("Press Q, D or N to input a quarter, a dime or a nickel.");
          System.out.println("Press X to move to product list."); 
          System.out.println("Press R to recieve a refund of your balance.");
          System.out.println("Total Balance: " + form.format(balance.getTotalBalance()));
             y = keyboard.nextLine(); //input to determine type of coin entered or to obtain refund of money
             //inputs for inputting various types of coins
             if (y.equals("Q"))
               balance.insertQuarter(balance.getTotalBalance());
             else if (y.equals("D"))
                balance.insertDime(balance.getTotalBalance());
             else if (y.equals("N"))
                balance.insertNickel(balance.getTotalBalance());
             else if (y.equals("X"))
                System.out.println();
             //menu selection for returning entered coins   
             else if (y.equals("R"))
             {
                System.out.println("Please take your change.");
                refund = balance.getTotalBalance();
                System.out.println("Change: " + form.format(refund) + ".");
                balance.resetTotalBalance();
             }        
             //secret menu for changing the stock of the machine and for outputting the total sales     
             else if (y.equals("password"))
             {
               String hold = " ";
               while(!hold.equals("Q"))
               {
                  System.out.println("Please either type an item code to change the ");
                  System.out.println("number of stock for that item or type the letter");
                  System.out.println("T to output the total sales of the machine.");
                  System.out.println("Press X to exit from this section and return to");
                  System.out.println("normal operation.");
                  String input = keyboard.nextLine();
                  //Allows user to change the number of stock for each item by entering the item code
                  if (input.equals(chips.getItemCode()))
                  {
                     System.out.println("Please enter the new number of stock for this item.");
                     int set = keyboard.nextInt();
                     if (set < 0)
                        System.out.println("Number entered cannot be negative.");
                     else
                        chips.setStock(set);
                  }
                  else if (input.equals(soda.getItemCode()))
                  {
                     System.out.println("Please enter the new number of stock for this item.");
                     int set = keyboard.nextInt();
                     if (set < 0)
                        System.out.println("Number entered cannot be negative.");
                     else
                        soda.setStock(set);
                  }
                  else if (input.equals(candy.getItemCode()))
                  {
                     System.out.println("Please enter the new number of stock for this item.");
                     int set = keyboard.nextInt();
                     if (set < 0)
                        System.out.println("Number entered cannot be negative.");
                     else
                        candy.setStock(set);
                  }
                  //Outputs the total sales recieved from the machine
                  else if (input.equals("T"))
                     System.out.println("Total machine balance: " + form.format(mainBalance.getTotalBalance()));
                  //Exits this section of the menu and returns to main operation
                  else if (input.equals("X"))
                  {
                     System.out.println("Returning to standard vending operation.");
                     hold = "Q";
                  }
               }
             }
             else
             System.out.println("Invalid input.");
             System.out.println("Total Balance:" + form.format(balance.getTotalBalance()));
          }
          while (!y.equals("J")) //loop for second part of program where user selects the item they want
          {  
             System.out.println("Please select a product by typing in its item code.");
             System.out.println("Press X to input more coins.");
             System.out.println("Press R to recieve a refund of your balance.");
             String item = keyboard.nextLine(); //input which takes either item code or allows user to 
                                                //have their money refunded or to add more
                
                //Outputs the item if they type the correct item code and returns the amount of change 
                //they will recieve or will display a message for when the balance is too low
                if (item.equals(chips.getItemCode()))
                { 
                  //checks to see if the item is still in stock before doing further calculation
                  if (chips.getTotalStock() > 0)
                  {
                      //checks to see if the money inputted is at least equal to the price of the item
                      if (balance.getTotalBalance() >= chips.getPrice())
                      {   
                         {
                         System.out.println("You will recieve your item now.");
                         chips.removeStock();
                         refund = balance.getTotalBalance() - chips.getPrice();
                         System.out.println("Item: chips.");
                         }
                         if (refund > 0)
                         {
                             System.out.println("Please take your change.");
                             System.out.println("Change: " + form.format(refund) + ".");
                             y = "J";
                             mainBalance.setTotalBalance(mainBalance.getTotalBalance() + balance.getTotalBalance());
                             balance.resetTotalBalance(); //sets balance equal to zero
                         }
                         else
                         {
                             System.out.println("Thank you.");
                             y = "J";
                             mainBalance.setTotalBalance(mainBalance.getTotalBalance() + balance.getTotalBalance());
                             balance.resetTotalBalance();//sets balance equal to zero
                         }
                     }   
                     else 
                         System.out.println("Your balance is insufficient.");
                 }
                 else
                    System.out.println("Item is out of stock. Please select a new item.");
             } 
              else if (item.equals("X"))//allows user to return to first section
                {
                   System.out.println();
                   y = "J"; //causes exit condition for while loop
                }
                else if (item.equals("R"))
                {
                   System.out.println("Please take your change.");
                   refund = balance.getTotalBalance();
                   System.out.println("Change: " + form.format(refund) + ".");
                   //adds the balance to the variable storing the total sales
                   mainBalance.setTotalBalance(mainBalance.getTotalBalance() + balance.getTotalBalance());
                   balance.resetTotalBalance(); //sets balance equal to zero
                   y = "J";
                }
             else if (item.equals(soda.getItemCode()))
             {
                if (soda.getTotalStock() > 0) //determines if the item is still in stock
                {
                   if (balance.getTotalBalance() >= soda.getPrice())//determines if the balance is greater than 
                      {                                             //or equal to the price of the item
                      System.out.println("You will recieve your item now.");
                      soda.removeStock();
                      //determines the amount of money returned for change
                      refund = balance.getTotalBalance() - soda.getPrice();
                      System.out.println("Item: Soda.");
                      if (refund > 0)
                          {
                          System.out.println("Please take your change.");
                          System.out.println("Change: " + form.format(refund) + ".");
                          y = "J"; //causes exit condition for while loop
                          mainBalance.setTotalBalance(mainBalance.getTotalBalance() + balance.getTotalBalance());
                          balance.resetTotalBalance(); //sets balance equal to zero
                          }
                      else
                          System.out.println("Thank you.");
                          y = "J"; //causes exit condition for while loop
                          mainBalance.setTotalBalance(mainBalance.getTotalBalance() + balance.getTotalBalance());
                          balance.resetTotalBalance(); //sets balance equal to zero
                      }
                   else 
                      System.out.println("Your balance is insufficient.");
                 }
                 else
                     System.out.println("Item is out of stock.");
             }
             else if (item.equals(candy.getItemCode()))
             {
               if (candy.getTotalStock() > 0)
               {
                if (balance.getTotalBalance() >= candy.getPrice())
                   {
                   System.out.println("You will recieve your item now.");
                   candy.removeStock();
                   refund = balance.getTotalBalance() - candy.getPrice();
                   System.out.println("Item: Candy.");
                   if (refund > 0)
                       {
                       System.out.println("Please take your change.");
                       System.out.println("Change: " + form.format(refund) + ".");
                       y = "J"; //causes exit condition for while loop
                       mainBalance.setTotalBalance(mainBalance.getTotalBalance() + balance.getTotalBalance());
                       balance.resetTotalBalance(); //sets balance equal to zero
                       refund = 0;
                       }
                   else
                       System.out.println("Thank you.");
                       y = "J";//causes exit condition for while loop
                       mainBalance.setTotalBalance(mainBalance.getTotalBalance() + balance.getTotalBalance());
                       balance.resetTotalBalance(); //sets balance equal to zero
                   }
                else if (item.equals("X"))
                {
                   System.out.println();
                   y = "J"; //causes exit condition for while loop
                }
                else if (item.equals("R"))
                {
                   System.out.println("Please take your change.");
                   refund = balance.getTotalBalance();
                   System.out.println("Change: " + form.format(refund) + ".");
                   balance.resetTotalBalance(); //sets balance equal to zero
                }
                else 
                   System.out.println("Your balance is insufficient.");
               }
               else
                  System.out.println("Item is out of stock.");
             }
             else //message displayed if item code is invalid
                System.out.println("Invalid item code please enter another.");            
         }
      }
}
}