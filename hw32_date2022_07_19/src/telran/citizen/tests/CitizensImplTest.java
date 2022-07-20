package telran.citizen.tests;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.citizen.comparators.AgeComparator;
import telran.citizen.dao.CitizensImpl;
import telran.citizen.interfaces.Citizens;
import telran.citizen.model.Person;

public class CitizensImplTest {
    Citizens citizens;

    @BeforeEach
    void setUp() throws Exception {
        citizens = new CitizensImpl(Arrays.asList(
                new Person(0, "firstName0", "lastName0", 4),
                new Person(1, "firstName1", "lastName1", 3),
                new Person(2, "firstName2", "lastName2", 2),
                new Person(3, "firstName3", "lastName3", 1),
                new Person(4, "firstName4", "lastName4", 0)));
    }

    @Test
    void testAdd() {
        assertTrue(citizens.add(new Person(5, "firstName5", "lastName5", 5)));
        assertEquals(6, citizens.size());
        assertFalse(citizens.add(new Person(0, null, null, 0)));
        assertEquals(6, citizens.size());
    }

    @Test
    void testFind() {
        assertEquals(new Person(1, null, null, 0), citizens.find(1));
    }

    @Test
    void testFindLastName() {
        Person person1 = new Person(5, "firstName0", "lastName1", 1);
        Person person2 = new Person(6, "firstName0", "lastName1", 1);
        Person person3 = new Person(6, "firstName0", "lastName1", 2);
        citizens.add(person1);
        citizens.add(person2);
        citizens.add(person3);
        ArrayList<Person> expected = new ArrayList<>();
        expected.add(person1);
        expected.add(person2);
        ArrayList<Person> res = (ArrayList<Person>) citizens.find("lastName1");
        assertEquals(3, res.size());

    }

    @Test
    void testFindAge() {
        Person person1 = new Person(5, "firstName5", "lastName5", 1);
        Person person2 = new Person(6, "firstName6", "lastName6", 2);
        Person person3 = new Person(7, "firstName6", "lastName6", 1);
        citizens.add(person1);
        citizens.add(person2);
        citizens.add(person3);
        ArrayList<Person> expected = new ArrayList<>();
        expected.add(person1);
        expected.add(person2);
        expected.add(person3);
        expected.add(citizens.find(2));
        expected.add(citizens.find(3));
        expected.sort(new AgeComparator());
        ArrayList<Person> actual = (ArrayList<Person>) citizens.find(1, 2);
        for (Person person : actual) {
            System.out.println(person);
        }
        assertEquals(5, actual.size());
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    void testGetAllPersonSortedByAge() {
        Person person1 = new Person(5, "firstName0", "lastName1", 5);
        Person person2 = new Person(6, "firstName3", "lastName4", 2);
        citizens.add(person1);
        citizens.add(person2);
        ArrayList<Person> res = (ArrayList<Person>) citizens.getAllPersonSortedByAge();
        for (Person person : res) {
            System.out.println(person);
        }
    }

    @Test
    void testGetAllPersonSortedById() {
        ArrayList<Person> res = (ArrayList<Person>) citizens.getAllPersonSortedById();
        for (Person person : res) {
            System.out.println(person);
        }
    }

    @Test
    void testGetAllPersonSortedByLastName() {
        Person person1 = new Person(5, "firstName0", "lastName1", 1);
        Person person2 = new Person(6, "firstName3", "lastName4", 2);
        citizens.add(person1);
        citizens.add(person2);
        ArrayList<Person> res = (ArrayList<Person>) citizens.getAllPersonSortedByLastName();
        for (Person person : res) {
            System.out.println(person);
        }
    }

    @Test
    void testRemove() {
        for (Person person : citizens.getAllPersonSortedByAge()) {
            System.out.println(person);
        }
        assertTrue(citizens.remove(0));
        assertEquals(4, citizens.size());
    }

    @Test
    void testSize() {
        assertEquals(5, citizens.size());
    }
}
