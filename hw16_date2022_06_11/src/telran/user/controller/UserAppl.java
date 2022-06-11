package telran.user.controller;

import telran.user.model.User;

public class UserAppl {
    public static void main(String[] args) {
        User user = new User("peter@gmail.com", "324gRR#21*");
        System.out.println(user);
        user.setEmail("peter@yahoo.com");
        System.out.println(user);
        user.setPassword("223DDSwaq/**)");
        System.out.println(user.getPassword());
    }
}
