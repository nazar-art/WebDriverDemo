package task3;

import org.testng.annotations.DataProvider;

public class DataSource {

    @DataProvider(parallel = true)
    public static synchronized Object[][] concurrencyData() {
        return new Object[][] {
                { "This is the test message for draft link #1" }, { "This is the test message for draft link #2" },
                { "This is the test message for draft link #3" }, { "This is the test message for draft link #4" },
                { "This is the test message for draft link #5" }, { "This is the test message for draft link #6" },
                { "This is the test message for draft link #7" }, { "This is the test message for draft link #8" },
                { "This is the test message for draft link #9" }, { "This is the test message for draft link #10" },
                { "This is the test message for draft link #11" }, { "This is the test message for draft link #12" },
                { "This is the test message for draft link #13" }, { "This is the test message for draft link #14" },
                { "This is the test message for draft link #15" }, { "This is the test message for draft link #16" },
                { "This is the test message for draft link #17" }, { "This is the test message for draft link #18" },
                { "This is the test message for draft link #19" }, { "This is the test message for draft link #20" }
        };
    }
}
