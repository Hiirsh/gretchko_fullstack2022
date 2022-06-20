package telran.garage.test;

import telran.garage.dao.Garage;
import telran.garage.dao.GarageImpl;
import telran.garage.model.Car;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GarageTest {
    Garage garage;
    Car[] cars;

    @BeforeEach
    void setUp() {
        garage = new GarageImpl(6);
        cars = new Car[4];
        cars[0] = new Car("AB0000", "mod0", "comp0", 0.0, "color0");
        cars[1] = new Car("AB0001", "mod1", "comp1", 1.1, "color1");
        cars[2] = new Car("AB0002", "mod2", "comp2", 2.2, "color2");
        cars[3] = new Car("AB0003", "mod3", "comp3", 3.3, "color3");
        for (int i = 0; i < cars.length; i++) {
            garage.addCar(cars[i]);
        }
    }

    @Test
    void testAddCar() {
        assertTrue(garage.addCar(new Car("AB0004", "model4", "company4", 4.4, "color4")));
    }

    @Test
    void testRemoveCar() {
        assertEquals(cars[0], garage.removeCar("AB0001"));
    }
    @Test
    void testFindCarByRegNumber() {
        assertEquals(cars[0], garage.findCarByRegNumber("AB0000"));
    }

    @Test
    void testFindCarByColor() {
        Car car = new Car("AB0004", "mod4", "comp4", 4.4, "color1");
        garage.addCar(car);
        Car[] expected = { cars[1], car };
        assertArrayEquals(expected, garage.findCarsByColor("color1"));
    }

    @Test
    void testFindCarByCompany() {
        Car car = new Car("AB0004", "mod4", "comp2", 4.4, "color4");
        garage.addCar(car);
        Car[] expected = { cars[2], car };
        assertArrayEquals(expected, garage.findCarsByCompany("comp2"));
    }

    @Test
    void testFindCarByEngine() {
        Car[] expected = { cars[1], cars[2] };
        assertArrayEquals(expected, garage.findCarsByEngine(1., 2.5));
    }

    @Test
    void testFindCarByModel() {
        Car car = new Car("AB0004", "mod0", "comp4", 4.4, "color4");
        garage.addCar(car);
        Car[] expected = { cars[0], car };
        assertArrayEquals(expected, garage.findCarsByModel("mod0"));
    }
}
