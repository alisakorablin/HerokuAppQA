import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.time.Duration;
import java.util.List;

public class DropdownTest {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void checkDropdownElements(){
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropdownInitialText = driver.findElement(By.id("dropdown"));
        dropdownInitialText.click();
        List<WebElement> dropdownOptions = driver.findElements(By.xpath("//select[@id='dropdown']/option"));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(dropdownOptions.size(), 3, "Должны отображаться 3 опции");
        dropdownOptions.get(1).click();
        softAssert.assertEquals(dropdownOptions.get(1).isSelected(), true,
                "Option1 должна быть выбрана");
        dropdownOptions.get(2).click();
        softAssert.assertEquals(dropdownOptions.get(2).isSelected(), true,
                "Option2 должна быть выбрана");
        softAssert.assertAll();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}
