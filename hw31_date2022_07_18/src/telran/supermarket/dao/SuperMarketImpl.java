package telran.supermarket.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import telran.supermarket.model.Product;

public class SuperMarketImpl implements SuperMarket {

  Collection<Product> products = new ArrayList<Product>();
  Product[] prodArr;
  int skuQuantity;

  public Collection<Product> getProducts() {
    return products;
  }

  @Override
  public Iterator<Product> iterator() {
    return new Iterator<Product>() {
      int pos = 0;

      Object[] arr = products.toArray();

      @Override
      public boolean hasNext() {
        return pos < skuQuantity;
      }

      @Override
      public Product next() {
        return (Product) arr[pos++];
      }

    };
  }

  @Override
  public boolean addProduct(Product product) {
    if (products.contains(product)) {
      return false;
    }
    products.add(product);
    skuQuantity++;
    return true;
  }

  @Override
  public Product removeProduct(long barCode) {
    return findRemoveIterator(barCode, false);
  }

  @Override
  public Product findByBarCode(long barCode) {
    return findRemoveIterator(barCode, true);
  }

  @Override
  public Iterable<Product> findByCategory(String category) {
    return findBy("category", category);
  }

  @Override
  public Iterable<Product> findByBrand(String brand) {
    return findBy("brand", brand);
  }

  @Override
  public Iterable<Product> findProductWithExpDate() {
    return findBy("expDate", "");
  }

  @Override
  public int skuQuantity() {
    return skuQuantity;
  }

  private Product findRemoveIterator(long barCode, boolean isRemove) {
    while (iterator().hasNext()) {
      if (iterator().next().getBarCode() == barCode) {
        Product res = iterator().next();
        if (isRemove) {
          iterator().remove();
        }
        return res;
      }
    }
    return null;
  }

  private Iterable<Product> findBy(String searchType, String param) {
    return new Iterable<Product>() {

      @Override
      public Iterator<Product> iterator() {

        return new Iterator<Product>() {
          Object[] arr = products.toArray();
          int i = 0;
          boolean compare;

          @Override
          public boolean hasNext() {
            return i < skuQuantity;
          }

          @Override
          public Product next() {
            return checkCategoty();
          }

          private Product checkCategoty() {
            
            Product temp = (Product) arr[i];
            switch (searchType) {
              case "category":
                compare = temp.getCategory().equals(param);
                break;
              case "brand":
                compare = temp.getBrand().equals(param);
                break;
              case "expDate":
                compare = temp.getExpDate().isBefore(LocalDate.now());
                break;
            }
            if (!compare) {
              i++;
              checkCategoty();
            }
            return (Product) arr[i++];
          }
        };
      }

    };
  }

}
