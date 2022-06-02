package telran.food.model;

public class Food extends Product {
    private boolean kosher;
    private String expDate;

    public Food(long barcode, String name, double price, boolean kosher, String expDate) {
        super(barcode, name, price);
        this.kosher = kosher;
        this.expDate = expDate;
    }

    public boolean isKosher() {
        return kosher;
    }

    public void setKosher(boolean kosher) {
        this.kosher = kosher;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    @Override
    public String toString() {
        return super.toString() + "expDate: " + expDate + ", kosher: " + kosher;
    }

}
