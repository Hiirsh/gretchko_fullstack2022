package telran.food.model;

public class MeatFood extends Food {
    private String typeOfMeat;

    public MeatFood(long barcode, String name, double price, boolean kosher, String expDate, String typeOfMeat) {
        super(barcode, name, price, kosher, expDate);
        this.typeOfMeat = typeOfMeat;
    }

    public String getTypeOfMilk() {
        return typeOfMeat;
    }

    public void setTypeOfMilk(String typeOfMilk) {
        this.typeOfMeat = typeOfMilk;
    }

}
