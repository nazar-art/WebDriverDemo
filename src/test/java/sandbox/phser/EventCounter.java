package sandbox.phser;

import java.util.concurrent.Phaser;

public class EventCounter {
    private Phaser count = new Phaser(1);

    public void eventOccured() {
        count.arrive();
    }

    public void waitFor(int events) {
        count.register();

        for (int i = 0; i < events; i++) {
            count.arriveAndAwaitAdvance();
        }

        count.arriveAndDeregister();
    }
}
