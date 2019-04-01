//class for the balance of the vending machine
public class Coins
{
   private double totalBalance;
   //class constructor
   public void Coins(int balance)
   {
      totalBalance = balance;
   }
   //method for inserting a quarter into vending machine
   protected void insertQuarter(double balance)
   {
      totalBalance = balance;
      totalBalance = totalBalance + 0.25;
      
   }
   //method for inserting a dime into vending machine
   protected void insertDime(double balance)
   {
      totalBalance = balance;
      totalBalance = totalBalance + 0.1;
   }
   //method for inserting a nickel into vending machine
   protected void insertNickel(double balance)
   {
      totalBalance = balance;
      totalBalance = totalBalance + 0.05;
   }
   //method that returns the value of the balance
   protected double getTotalBalance()
   {
      return totalBalance;
   }
   //method that sets the value of the balance
   protected void setTotalBalance(double balance)
   {
      totalBalance = balance;
   }
   //method that initializes balance to 0.00 
   protected void resetTotalBalance()
   {
      totalBalance = 0.00;
   }
   
}   
   