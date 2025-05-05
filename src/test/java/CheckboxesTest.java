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

public class CheckboxesTest {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void checkCheckboxesElements(){
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("[type=checkbox]"));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(checkboxes.get(0).isSelected(), false,
        "Первый чекбокс должен быть НЕ выбран");
        checkboxes.get(0).isSelected();
        checkboxes.get(0).click();
        softAssert.assertEquals(checkboxes.get(0).isSelected(), true,
                "Первый чекбокс должен быть выбран");
        checkboxes.get(0).isSelected();
        softAssert.assertEquals(checkboxes.get(1).isSelected(), true,
                "Второй чекбокс должен быть выбран");
        checkboxes.get(1).isSelected();
        checkboxes.get(1).click();
        softAssert.assertEquals(checkboxes.get(1).isSelected(), false,
                "Второй чекбокс должен быть НЕ выбран");
        checkboxes.get(1).isSelected();
        softAssert.assertAll();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}
