package org.example;

public class OOP {
    public static void main(String[] args) {
        Train train = new Train(10);
        int numberOfCarriages = train.getNumberOfCarriages();
        int currentCarriageIndex = train.getCurrentCarriageIndex();
        System.out.println("Начальное положение наблюдателя: " + currentCarriageIndex);

        for (int i = 0; i < numberOfCarriages; i++) {
            train.toggleLight(i);
            System.out.println("Состояние " + (i + 1) + "-го вагона: " + train.isLightOn(i));
        }

        int steps = 5;
        train.moveObserver(steps);
        currentCarriageIndex = train.getCurrentCarriageIndex();
        System.out.println("Новое положение наблюдателя: " + currentCarriageIndex);
    }
}

