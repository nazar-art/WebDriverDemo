package pages.utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class BrowserCreator implements Callable {

    private static final Logger log = Logger.getLogger(BrowserCreator.class);
    private CyclicBarrier barrier;

    BrowserCreator(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public Object call() {
        WebDriver driver = null;
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    driver = new FirefoxDriver();
                }
                barrier.await();
            }
        } catch (InterruptedException e) {
            log.error(e);
        } catch (BrokenBarrierException e) {
            log.error(e);
        }
        return driver;
    }
}

public class BrowsersPool {

    private List<BrowserCreator> webDrivers = new ArrayList<BrowserCreator>();
    private ExecutorService exec = Executors.newFixedThreadPool(5);
    private CyclicBarrier barrier;

    public BrowsersPool(final int nTasks) {
        barrier = new CyclicBarrier(nTasks, new Runnable() {
            int counter = 0;

            @Override
            public void run() {
                if (counter > nTasks) {
                    exec.shutdownNow();
                }
                for (int i = 0; i < nTasks; i++) {
                    BrowserCreator browser = new BrowserCreator(barrier);
                    webDrivers.add(browser);
                    exec.submit(browser);
                    counter++;
                }
            }
        });
    }
}
