package org.example;

public class Main {
    public static void main(String[] args) {
        final Friend friend1 = new Friend("Chandler", "I");
        final Friend friend2 = new Friend("Joey", "watched");
        final Friend friend3 = new Friend("Monica", "Friends");
        final Friend friend4 = new Friend("Phoebe", "to");
        final Friend friend5 = new Friend("Rachel", "and");
        final Friend friend6 = new Friend("Ross", "love");

        new Thread(() -> friend1.say(friend2)).start();
        new Thread(() -> friend2.say(friend3)).start();
        new Thread(() -> friend3.say(friend4)).start();
        new Thread(() -> friend4.say(friend5)).start();
        new Thread(() -> friend5.say(friend6)).start();
        new Thread(() -> friend6.say(friend1)).start();
    }
}
