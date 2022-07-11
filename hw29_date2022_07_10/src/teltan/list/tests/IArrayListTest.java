package teltan.list.tests;

import org.junit.jupiter.api.*;

import teltan.list.interfaces.IList;
import teltan.list.model.IArrayList;

class IArrayListTest {
    @Test
    void test() {
        IList<Integer> list = new IArrayList<>();
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(7);
        list.add(2);
        list.add(null);
        list.add(19);
        for (Integer num : list) {
            System.out.print(num+"\t");
        }
        System.out.println();
        System.out.println(list.get(2) + "\t" + list.size());
        list.add(1, 404);
        System.out.println(list.get(2) + "\t" + list.size());
        for (Integer num : list) {
            System.out.print(num+"\t");
        }
    }
    
}
