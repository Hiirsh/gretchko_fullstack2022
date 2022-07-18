package telran.supermarket.model;

import java.time.LocalDate;

public class Product {
  long barCode;
  String name;
  String category;
  String brand;
  double price;
  LocalDate expDate;

  public Product(long barCode, String name, String category, String brand, double price, LocalDate expDate) {
    this.barCode = barCode;
    this.name = name;
    this.category = category;
    this.brand = brand;
    this.price = price;
    this.expDate = expDate;
  }

  public long getBarCode() {
    return barCode;
  }

  public String getName() {
    return name;
  }

  public String getCategory() {
    return category;
  }

  public String getBrand() {
    return brand;
  }

  public double getPrice() {
    return price;
  }

  public LocalDate getExpDate() {
    return expDate;
  }

  @Override
  public String toString() {
    return "Product [barCode=" + barCode + ", brand=" + brand + ", category=" + category + ", expDate=" + expDate
        + ", name=" + name + ", price=" + price + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (int) (barCode ^ (barCode >>> 32));
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Product other = (Product) obj;
    if (barCode != other.barCode)
      return false;
    return true;
  }
  
  

}
