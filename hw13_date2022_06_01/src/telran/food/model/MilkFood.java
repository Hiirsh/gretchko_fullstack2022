package telran.food.model;

public class MilkFood extends Food {
    private String typeOfMilk;

    public String getTypeOfMilk() {
        return typeOfMilk;
    }

    public MilkFood(long barcode, String name, double price, boolean kosher, String expDate, String typeOfMilk) {
        super(barcode, name, price, kosher, expDate);
        this.typeOfMilk = typeOfMilk;
    }

    public void setTypeOfMilk(String typeOfMilk) {
        this.typeOfMilk = typeOfMilk;
    }

    @Override
    public String toString() {
        return super.toString() + "Type of milk=" + typeOfMilk;
    }

}
