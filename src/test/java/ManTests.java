import dataproviders.TestDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
public class ManTests {
    @Test(groups = {"all", "getters_setters"}, dataProvider = "ageData", dataProviderClass = TestDataProvider.class)
    public void testGetAge(int age) {
        Man man = new Man("John", "Doe", age);
        Assert.assertEquals(man.getAge(), age, "Incorrect age");
    }

    @Test(groups = {"all", "getters_setters"}, dataProvider = "ageData", dataProviderClass = TestDataProvider.class)
    public void testSetAge(int age) {
        Man man = new Man("John", "Doe", 40);
        man.setAge(age);
        Assert.assertEquals(man.getAge(), age, "Age not set correctly");
    }

    @Test(groups = "all")
    public void testIsRetired() {
        Man man1 = new Man("John", "Doe", 60);
        Man man2 = new Man("Jane", "Smith", 70);
        Assert.assertFalse(man1.isRetired(), "Incorrect retirement status");
        Assert.assertTrue(man2.isRetired(), "Incorrect retirement status");
    }
}
