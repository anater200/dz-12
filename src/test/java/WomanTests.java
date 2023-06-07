import dataproviders.TestDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
public class WomanTests {
    @Test(groups = {"all", "getters_setters"}, dataProvider = "ageData", dataProviderClass = TestDataProvider.class)
    public void testGetAge(int age) {
        Woman woman = new Woman("Jane", "Doe", age);
        Assert.assertEquals(woman.getAge(), age, "Incorrect age");
    }

    @Test(groups = {"all", "getters_setters"}, dataProvider = "ageData", dataProviderClass = TestDataProvider.class)
    public void testSetAge(int age) {
        Woman woman = new Woman("Jane", "Doe", 45);
        woman.setAge(age);
        Assert.assertEquals(woman.getAge(), age, "Age not set correctly");
    }

    @Test(groups = "all")
    public void testIsRetired() {
        Woman woman1 = new Woman("Jane", "Doe", 55);
        Woman woman2 = new Woman("Mary", "Smith", 65);
        Assert.assertFalse(woman1.isRetired(), "Incorrect retirement status");
        Assert.assertTrue(woman2.isRetired(), "Incorrect retirement status");
    }

    @Test(groups = "all")
    public void testRegisterPartnership() {
        Woman woman1 = new Woman("Jane", "Doe", 45);
        Woman woman2 = new Woman("Mary", "Smith", 55);
        woman1.setPartner(woman2);
        woman1.registerPartnership();
        Assert.assertEquals(woman1.getLastName(), "Smith", "Last name not updated");
    }

    @Test(groups = "all")
    public void testDeregisterPartnership_revertLastName() {
        Woman woman1 = new Woman("Jane", "Doe", 45);
        Woman woman2 = new Woman("Mary", "Smith", 55);
        woman1.setPartner(woman2);
        woman1.deregisterPartnership(true);
        Assert.assertEquals(woman1.getLastName(), "Mary", "Last name not reverted");
    }

    @Test(groups = "all")
    public void testDeregisterPartnership_removePartner() {
        Woman woman1 = new Woman("Jane", "Doe", 45);
        Woman woman2 = new Woman("Mary", "Smith", 55);
        woman1.setPartner(woman2);
        woman1.deregisterPartnership(false);
        Assert.assertNull(woman1.getPartner(), "Partner not removed");
    }
}
