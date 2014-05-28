package task3;

import org.testng.TestNG;

public class TestRunner {
    public static void main(String[] args) {
        final TestNG testNG = new TestNG(true);
        testNG.setSuiteThreadPoolSize(5);
        testNG.setTestClasses(new Class[] {TestConcurrencyDrive.class});
        testNG.run();
    }
}
