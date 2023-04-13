package org.example;

public class Friend implements Comparable<Friend> {
    private final String name;
    private String phase;
    private volatile boolean talking = false;

    public Friend(String name, String phase) {
        this.name = name;
        this.phase = phase;
    }

    public synchronized void startTalking(Friend speaker) throws InterruptedException {
        while (speaker.isTalking()) {
            wait();
        }
        System.out.format("%s: %s %n", speaker.getName(), speaker.phase);
        talking = true;
    }

    public synchronized void stopTalking(Friend speaker) {
        talking = false;
        System.out.format("%s: %s %n", getName(), speaker.getName());
        notifyAll();
    }

    public String getName() {
        return name;
    }

    public String getPhase() {
        return phase;
    }

    public boolean isTalking() {
        return talking;
    }

    public void say(Friend speaker) {
        try {
            startTalking(this);
            speaker.say(this);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            stopTalking(speaker);
        }
    }

    @Override
    public int compareTo(Friend o) {
        return this.getName().compareTo(o.getName());
    }
}
