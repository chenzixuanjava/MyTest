package com.segi.javase.concurrent;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chenzx
 * @date 2019-06-06 下午 6:22
 */
public class Safelock {

    static class Friend {
        private final String name;
        private final ReentrantLock lock = new ReentrantLock();

        public Friend(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public boolean impendingBow(Friend bower) {
            Boolean myLock = false;
            Boolean yourLock = false;
            try {
                myLock = lock.tryLock();
                yourLock = bower.lock.tryLock();
            } finally {
                if (!(myLock && yourLock)) {
                    if (myLock) {
                        lock.unlock();
                    }
                    if (yourLock) {
                        bower.lock.unlock();
                    }
                }
            }
            return myLock && yourLock;
        }

        public void bow(Friend bower) {
            if (impendingBow(bower)) {
                try {
                    System.out.println(String.format("%s:%s向我鞠躬", this.getName(), bower.getName()));
                    bower.backBow(this);
                } finally {
                    this.lock.unlock();
                    bower.lock.unlock();
                }
            }
        }

        private void backBow(Friend bower) {
            System.out.println(String.format("%s:%s向我回鞠躬", this.name, bower.getName()));
        }

        static class LoopBow implements Runnable {
            private Friend bowee;
            private Friend bower;

            public LoopBow(Friend bowee, Friend bower) {
                this.bowee = bowee;
                this.bower = bower;
            }


            @Override
            public void run() {
                Random random = new Random();
                for (; ; ) {
                    try {
                        Thread.sleep(random.nextInt(10));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    bowee.bow(bower);
                }
            }

            public static void main(String[] args) {
                Friend alphonse = new Friend("Alphonse");
                Friend gaston = new Friend("Gaston");
                new Thread(new LoopBow(alphonse, gaston)).start();
                new Thread(new LoopBow(gaston, alphonse)).start();
            }
        }
    }
}
