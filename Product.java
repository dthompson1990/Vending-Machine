//class for the products of the vending machine
public class Product
{
   private double price;
   private String itemCode;
   private int totalStock;
   
   public Product(double Price, String code, int stock)
   {
      price = Price;
      itemCode = code;
      totalStock = stock;
   }
   protected void setPrice(double Price)
   {
      price = Price;
   }
   protected void setItemCode(String code)
   {
      itemCode = code;
   }
   protected void setStock(int stock)
   {
      totalStock = stock;
   }
   protected double getPrice()
   {
      return price;
   }
   protected String getItemCode()
   {
      return itemCode;
   }
   protected int getTotalStock()
   {
      return totalStock;
   }
   protected void removeStock()
   {
      totalStock = totalStock - 1;
   }
   




}