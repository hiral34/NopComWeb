package InfoSys;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = ".",tags="@addToCart", plugin={"pretty","html:target/Destination"})

public class RunTest {
}
