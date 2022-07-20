package telran.citizen.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import telran.citizen.comparators.AgeComparator;
import telran.citizen.comparators.LastNameComparator;
import telran.citizen.interfaces.Citizens;
import telran.citizen.model.Person;

public class CitizensImpl implements Citizens {

    private List<Person> idList;
    private List<Person> lastNameList;
    private List<Person> ageList;
    private static Comparator<Person> lastNameComparator = new LastNameComparator();
    private static Comparator<Person> ageComparator = new AgeComparator();

    public CitizensImpl() {
        idList = new ArrayList<>();
        lastNameList = new ArrayList<>();
        ageList = new ArrayList<>();
    }

    public CitizensImpl(List<Person> citizens) {
        idList = new ArrayList<>();
        lastNameList = new ArrayList<>();
        ageList = new ArrayList<>();
        for (Person person : citizens) {
                add(person);
        }
    }

    @Override
    public boolean add(Person person) {
        int index = Collections.binarySearch(idList, person);
        if (index >= 0) {
            return false;
        }
        index = -index - 1;
        if (index == size()) {
            idList.add(person);
        } else {
            idList.add(index, person);
        }
        index = Collections.binarySearch(lastNameList, person, lastNameComparator);
        index = index < 0 ? -index - 1 : index;
        if (index == size()) {
            lastNameList.add(person);
        } else {
            lastNameList.add(index, person);
        }
        index = Collections.binarySearch(ageList, person, ageComparator);
        index = index < 0 ? -index - 1 : index;
        if (index == size()) {
            ageList.add(person);
        } else {
            ageList.add(index, person);
        }
        return true;
    }

    @Override
    public boolean remove(int id) {
        Person pattern = new Person(id, "", "", 0);
        int index = Collections.binarySearch(idList, pattern);
        if (index < 0) {
            return false;
        }
        Person victim = idList.get(index);
        idList.remove(index);
        index = Collections.binarySearch(lastNameList, victim, lastNameComparator);
        lastNameList.remove(index);
        index = Collections.binarySearch(ageList, victim, ageComparator);
        ageList.remove(index);
        return true;
    }

    @Override
    public Person find(int id) {
        Person pattern = new Person(id, "", "", 0);
        int index = Collections.binarySearch(idList, pattern);
        return index < 0 ? null : idList.get(index);
    }

    @Override
    public Iterable<Person> find(int minAge, int maxAge) {
        if (minAge > maxAge) {
            return null;
        }
        ArrayList<Person> res = new ArrayList<>();
        Person patternMin = new Person(0, "", "", minAge);
        Person patternMax = new Person(0, "", "", maxAge);
        int indexMin = Collections.binarySearch(ageList, patternMin, ageComparator);
        indexMin = indexMin < 0 ? -indexMin - 1 : indexMin;
        int indexMax = Collections.binarySearch(ageList, patternMax, ageComparator);
        indexMax = indexMax < 0 ? -indexMax - 1 : indexMax;
        while (ageList.get(indexMin - 1).getAge() >= minAge) {
            indexMin--;
        }
        while (ageList.get(indexMax + 1).getAge() <= maxAge) {
            indexMax++;
        }
        for (int i = indexMin; i <= indexMax; i++) {
            res.add(ageList.get(i));
        }
        return res;
    }

    @Override
    public Iterable<Person> find(String lastName) {
        ArrayList<Person> res = new ArrayList<>();
        Person pattern = new Person(0, "", lastName, 0);
        int minIndex = Collections.binarySearch(lastNameList, pattern, lastNameComparator);
        minIndex = minIndex < 0 ? -minIndex - 1 : minIndex;
        int maxIndex = minIndex;
        while (lastNameList.get(minIndex - 1).getLastName().equals(lastName)) {
            minIndex--;
        }
        while (lastNameList.get(maxIndex + 1).getLastName().equals(lastName)) {
            maxIndex++;
        }
        for (int i = minIndex; i <= maxIndex; i++) {
            res.add(lastNameList.get(i));
        }
        return res;
    }

    @Override
    public Iterable<Person> getAllPersonSortedById() {
        return idList;
    }

    @Override
    public Iterable<Person> getAllPersonSortedByAge() {
        return ageList;
    }

    @Override
    public Iterable<Person> getAllPersonSortedByLastName() {
        return lastNameList;
    }

    @Override
    public int size() {
        return idList.size();
    }

}
