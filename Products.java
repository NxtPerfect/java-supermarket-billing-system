import java.math.BigDecimal;

public class Products {
  private String name;
  private BigDecimal price;
  private BigDecimal quantity;

  public String getName() {
    return this.name;
  }

  public BigDecimal getPrice() {
    return this.price;
  }

  public BigDecimal getQuantity() {
    return this.quantity;
  }

  public String getWhole() {
    return this.name + " " + this.price + "$ " + this.quantity;
  }

  public void changeName(String newName) {
    if (newName.isEmpty() || Character.isJavaIdentifierStart(newName.charAt(0)))
      return;
    this.name = newName;
  }

  public void changePrice(String newPrice) {
    if (newPrice.isEmpty() ||
        Character.isJavaIdentifierStart(newPrice.charAt(0)))
      return;
    this.price = new BigDecimal(newPrice);
  }

  public void changeQuantity(String newQuantity) {
    if (newQuantity.isEmpty() ||
        Character.isJavaIdentifierStart(newQuantity.charAt(0)))
      return;
    this.quantity = new BigDecimal(newQuantity);
  }

  public Products(String name, String price, String quantity) {
    this.name = name;
    this.price = new BigDecimal(price);
    this.quantity = new BigDecimal(quantity);
  }
}
