import java.awt.List;
import java.math.BigDecimal;
import java.util.ArrayList;

public class main {

  private static ArrayList<Products> productsList = new ArrayList();

  private static void addProduct() {
    System.out.println("What's the name of the product to add?");
    String name = System.console().readLine();

    System.out.println("What's the price?");
    String priceStr = System.console().readLine();

    Products newProduct = new Products(name, priceStr, "1.0");

    productsList.add(newProduct);

    System.out.println("Added product " + newProduct.getName() + " " +
        newProduct.getPrice() + "$.");
  }

  private static void removeProduct() {
    System.out.println("What's the name of the product to remove?");
    String name = System.console().readLine();

    for (int i = 0; i < productsList.size(); i++) {
      if (productsList.get(i).getName().equals(name)) {
        System.out.println("Removed product " + productsList.get(i).getName() +
            " " + productsList.get(i).getPrice() + "$.");
        productsList.remove(i);
      }
    }
  }

  private static void editProduct() {
    System.out.println("Which product would you like to edit?(Name)");
    for (int i = 0; i < productsList.size(); i++) {
      System.out.print(productsList.get(i).getWhole());
      System.out.print("; ");
    }
    System.out.println();

    String name = System.console().readLine();
    int index = 0;
    for (int i = 0; i < productsList.size(); i++) {
      if (productsList.get(i).getName().equals(name))
        index = i;
    }

    System.out.println("Type new name for the product.");
    name = System.console().readLine();

    System.out.println("Type new price for product.");
    String priceStr = System.console().readLine();

    Products currentProduct = new Products(name, priceStr, "1.0");

    productsList.set(index, currentProduct);
  }

  private static void createBill() {
    System.out.println(
        "Type in product index, then the quantity. When you're done, type EXIT");

    ArrayList<Products> billProductsList = new ArrayList<Products>();

    for (int i = 0; i < productsList.size(); i++) {
      System.out.print(i + 1 + ": " + productsList.get(i).getWhole() + "; ");
    }

    while (true) {
      System.out.println("Which product to add?");
      String indexStr = System.console().readLine();
      if (indexStr.equals("EXIT"))
        break;

      System.out.println("Quantity:");
      String quantityStr = System.console().readLine();
      if (quantityStr.equals("EXIT"))
        break;

      Integer index = Integer.parseInt(indexStr);

      billProductsList.add(new Products(
          productsList.get(index - 1).getName(),
          productsList.get(index - 1).getPrice().toString(), quantityStr));
    }

    Double totalPriceD = 0.0;
    BigDecimal totalPrice = new BigDecimal(totalPriceD);

    for (int i = 0; i < billProductsList.size(); i++) {
      Products currentProduct = billProductsList.get(i);
      totalPrice = totalPrice.add(
          currentProduct.getPrice().multiply(currentProduct.getQuantity()));
      System.out.print(
          currentProduct.getWhole() + " total price: " +
              currentProduct.getPrice().multiply(currentProduct.getQuantity()) +
              "$; ");
    }

    System.out.println("Total price of bill: " + totalPrice + "$");
  }

  private static void menu() {
    while (true) {
      System.out.println("Welcome to Supermarket Billing System.");
      System.out.println("What would you like to do?");
      System.out.println("1. Add product.");
      System.out.println("2. Remove product.");
      System.out.println("3. Edit product.");
      System.out.println("4. Create new bill.");
      System.out.println("5. Exit.");

      String choiceStr = System.console().readLine();
      Integer choice = Integer.parseInt(choiceStr);

      switch (choice) {
        case 1:
          addProduct();
          break;

        case 2:
          removeProduct();
          break;

        case 3:
          editProduct();
          break;

        case 4:
          createBill();
          break;

        case 5:
          System.exit(0);
          break;

        default:
          break;
      }
    }
  }

  public static void main(String[] args) {
    menu();
  }
}
