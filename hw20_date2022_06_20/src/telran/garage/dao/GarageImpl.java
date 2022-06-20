package telran.garage.dao;

import java.util.function.Predicate;

import telran.garage.model.Car;

public class GarageImpl implements Garage {
    private Car[] cars;
    private int size;

    public GarageImpl(int capacity) {
        cars = new Car[capacity];
    }

    @Override
    public boolean addCar(Car car) {
        if (findCarByRegNumber(car.getRegNumber()) == null) {
            cars[size++] = car;
            return true;
        }
        return false;
    }

    @Override
    public Car removeCar(String regNumber) {
        int carIndex = findCarIndex(regNumber);
        if (carIndex == -1) {
            return null;
        }
        Car car = cars[carIndex];
        cars[carIndex] = cars[--size];
        cars[size + 1] = null;
        return car;
    }

    @Override
    public Car[] findCarsByColor(String color) {
        return findCarsByPredicate(c -> c.getColor() == color);
    }

    @Override
    public Car[] findCarsByCompany(String company) {
        return findCarsByPredicate(c -> c.getCompany() == company);
    }

    @Override
    public Car[] findCarsByEngine(double min, double max) {
        return findCarsByPredicate(c -> c.getEngine() >= min && c.getEngine() < max);
    }
    
    @Override
    public Car[] findCarsByModel(String model) {
        return findCarsByPredicate(c -> c.getModel() == model);
    }

    @Override
    public Car findCarByRegNumber(String regNumber) {
        for (int i = 0; i < size; i++) {
            if (cars[i].getRegNumber() == regNumber) {
                return cars[i];
            }
        }
        return null;
    }

    private int findCarIndex(String regNumber) {
        for (int i = 0; i < size; i++) {
            if (findCarByRegNumber(regNumber) != null) {
                return i;
            }
        }
        return -1;
    }

    private Car[] findCarsByPredicate(Predicate<Car> predicate) {
        // Знаю, что реализация странная, но я решил поэкспериментировать
        StringBuffer indStr = new StringBuffer("");
        for (int i = 0; i < size; i++) {
            if (predicate.test(cars[i])) {
                indStr.append(i + ";");
            }
        }
        String[] indArr = indStr.toString().split("\\;");
        Car[] res = new Car[indArr.length];
        for (int i = 0; i < indArr.length; i++) {
            res[i] = cars[Integer.parseInt(indArr[i])];
        }
        return res;
    }

}
