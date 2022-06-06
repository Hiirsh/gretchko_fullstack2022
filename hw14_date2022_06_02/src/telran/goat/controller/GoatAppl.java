package telran.goat.controller;

import telran.goat.model.Goat;

public class GoatAppl {
    public static void main(String[] args) {
        Goat[] goatlings = new Goat[3];
        goatlings[0] = new Goat(0, 10);
        for (int i = 0; i < Goat.COUNT_MAX; i++) {
            goatlings[0].count++;
        }
        System.out.println(goatlings[0].getCount());
        goatlings[1] = new Goat(0, 15);
        for (int i = 0; i < Goat.COUNT_MAX; i++) {
            goatlings[1].count++;
        }
        System.out.println(goatlings[1].getCount());
        System.out.println(goatlings[0].getCount());
    }
}
