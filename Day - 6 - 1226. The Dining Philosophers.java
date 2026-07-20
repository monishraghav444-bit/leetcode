import java.util.concurrent.Semaphore;

class DiningPhilosophers {

    // Limit the number of philosophers who can try to pick up forks at once to 4.
    // This breaks the circular wait condition and prevents deadlock.
    private final Semaphore eatLimiter = new Semaphore(4);
    private final Semaphore[] forks = new Semaphore[5];

    public DiningPhilosophers() {
        for (int i = 0; i < 5; i++) {
            forks[i] = new Semaphore(1);
        }
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                            Runnable pickLeftFork,
                            Runnable pickRightFork,
                            Runnable eat,
                            Runnable putLeftFork,
                            Runnable putRightFork) throws InterruptedException {

        int leftFork = philosopher;
        int rightFork = (philosopher + 4) % 5;

        eatLimiter.acquire();

        forks[leftFork].acquire();
        forks[rightFork].acquire();

        pickLeftFork.run();
        pickRightFork.run();

        eat.run();

        putLeftFork.run();
        putRightFork.run();

        forks[leftFork].release();
        forks[rightFork].release();

        eatLimiter.release();
    }
}
