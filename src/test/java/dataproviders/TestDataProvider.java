package dataproviders;
import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name = "ageData")
    public static Object[][] provideAgeData() {
        return new Object[][]{
                {45},
                {50},
                {60},
                {70}
        };
    }
}