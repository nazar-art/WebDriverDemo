package task4;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
format = {"html:target/cucumber"},
tags = { "@draft-folder-feature" } )
public class RunTest {

}
