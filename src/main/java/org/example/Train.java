package org.example;

import java.util.concurrent.ThreadLocalRandom;

public class Train {
    private final int numberOfCarriages;
    private Boolean[] lights; // true - свет горит, false - свет не горит
    private int currentCarriageIndex; // индекс текущего вагона, перед которым находится наблюдатель

    public Train(int numberOfCarriages) {
        this.numberOfCarriages = numberOfCarriages;
        lights = ThreadLocalRandom
                .current()
                .doubles(numberOfCarriages)
                .mapToObj(it -> it < 0.5)
                .toArray(Boolean[]::new);
        currentCarriageIndex = (int) (Math.random() * numberOfCarriages);
    }

    public int getNumberOfCarriages() {
        return numberOfCarriages;
    }

    public boolean isLightOn(int carriageIndex) {
        return lights[carriageIndex];
    }

    public void toggleLight(int carriageIndex) {
        lights[carriageIndex] = !lights[carriageIndex];
    }

    public int getCurrentCarriageIndex() {
        return currentCarriageIndex;
    }

    public void moveObserver(int steps) {
        currentCarriageIndex = (currentCarriageIndex + steps) % numberOfCarriages;
    }
}