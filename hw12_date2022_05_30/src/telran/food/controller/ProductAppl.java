package telran.food.controller;

import telran.food.model.Food;
import telran.food.model.MeatFood;
import telran.food.model.MilkFood;
import telran.food.model.Product;;

public class ProductAppl {
    public static void main(String[] args) {
        Product[] products = new Product[5];
        products[0] = new Food(1234, "bread", 14.9, true, "30.05.2022");
        products[1] = new Product(10001, "Newspaper", 3.5);
        products[2] = new MilkFood(10002, "milk", 5.94, true, "29.05.2022", "cow");
        products[3] = new MeatFood(10003, "beef", 50.4, true, "25.05.2022", "beef");
        products[4] = new MeatFood(10004, "pork", 45.8, false, "24.05.2022", "pork");
        System.out.println("sumKosher = " + sumPriceKosher(products));
    }

    private static double sumPriceKosher(Product[] arr) {
        double res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] instanceof Food) {
                Food temp = (Food) arr[i];
                res += temp.isKosher() ? temp.getPrice() : res;
            }
        }
        return res;
    }
}
