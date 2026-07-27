import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class DiningPhilosophers {
    private final Lock[] forks = new ReentrantLock[5];

    public DiningPhilosophers() {
        for (int i = 0; i < 5; i++) {
            forks[i] = new ReentrantLock();
        }
    }

    public void wantsToEat(int philosopher,
                          Runnable pickLeftFork,
                          Runnable pickRightFork,
                          Runnable eat,
                          Runnable putLeftFork,
                          Runnable putRightFork) throws InterruptedException {

        int leftFork = philosopher;
        int rightFork = (philosopher + 4) % 5;
        int firstFork = Math.min(leftFork, rightFork);
        int secondFork = Math.max(leftFork, rightFork);

        forks[firstFork].lock();
        try {
            forks[secondFork].lock();
            try {
                pickLeftFork.run();
                pickRightFork.run();
                eat.run();
                putLeftFork.run();
                putRightFork.run();
            } finally {
                forks[secondFork].unlock();
            }
        } finally {
            forks[firstFork].unlock();
        }
    }
}
