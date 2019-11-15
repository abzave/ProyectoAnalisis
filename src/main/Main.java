package main;


import control.Three;

public class Main {
    public static void main(String[] args) {
        Three three = new Three(1300, 0, 3);
        System.out.println(three.getDistance());
    }
}
