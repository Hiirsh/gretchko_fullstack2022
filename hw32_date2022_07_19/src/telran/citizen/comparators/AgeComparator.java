package telran.citizen.comparators;

import java.util.Comparator;

import telran.citizen.model.Person;

public class AgeComparator implements Comparator<Person> {

    @Override
    public int compare(Person p1, Person p2) {
        int res = Integer.compare(p1.getAge(), p2.getAge());
        if (res != 0) {
            return res;
        }
        res = p1.getLastName().compareTo(p2.getLastName());
        if (res != 0) {
            return res;
        }
        res = p1.getFirstName().compareTo(p2.getFirstName());
        if (res != 0) {
            return res;
        }
        return p1.compareTo(p2);
    }

}
