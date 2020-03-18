package com.segi.javase.concurrent;

/**
 * @author chenzx
 * @date 2019-06-06 上午 11:05
 */
public class DeadLock {

    static class Friend {
        private final String name;

        public Friend(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public synchronized void bow(Friend friend) {
            System.out.println(String.format("%s:%s" + "has bowed to me%n", this.name, friend.getName()));
            friend.bowBack(this);
        }

        public synchronized void bowBack(Friend friend) {
            System.out.println(String.format("%s:%s" + "has bowed to me%n", this.name, friend.getName()));
        }
    }

    public static void main(String[] args) {
        Friend alphone = new Friend("Alphone");
        Friend gaston = new Friend("Gaston");
        new Thread(() -> {alphone.bow(gaston);}).start();
        new Thread(() -> {gaston.bow(alphone);}).start();
    }
}
