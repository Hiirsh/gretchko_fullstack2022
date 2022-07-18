package telran.supermarket.controller;

import java.time.LocalDate;
import java.util.Iterator;

import telran.supermarket.dao.SuperMarketImpl;
import telran.supermarket.model.Product;

public class SuperMarketAllp {
  public static void main(String[] args) {
    SuperMarketImpl sm = new SuperMarketImpl();
    Product[] prod = new Product[10];
    prod[0] = new Product(0, "name0", "category0", "brand0", 10., LocalDate.now().plusDays(4));
    for (int i = 0; i < 3; i++) {
      prod[i] = new Product(i, "name" + i, "category" + i, "brand" + i, 10. + i, LocalDate.now().plusDays(i + 1));
    }
    for (int i = 3; i < 8; i++) {
      prod[i] = new Product(i, "name" + i, "category" + i, "brand" + i, 10. + i, LocalDate.now().minusDays(i + 1));
    }
    int i = 8;
    prod[i] = new Product(i, "name" + i, "category" + 0, "brand" + i, 10. + i, LocalDate.now().plusDays(i + 1));
    i = 9;
    prod[i] = new Product(i, "name" + i, "category" + 0, "brand" + 1, 10. + i, LocalDate.now().plusDays(i + 1));
    for (int j = 0; j < prod.length; j++) {
      sm.addProduct(prod[j]);
    }

    Iterator<Product> iterator = sm.iterator();
    // while(iterator.hasNext()){
    //   System.out.println(iterator.next());
    // }
    iterator = sm.findProductWithExpDate().iterator();
    while(iterator.hasNext()){
      System.out.println(iterator.next());
    }
  }
}
