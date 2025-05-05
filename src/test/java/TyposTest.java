import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.time.Duration;
import java.util.List;

public class TyposTest {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void checkTyposElements(){
        driver.get("https://the-internet.herokuapp.com/typos");
        List<WebElement> paragraphs = driver.findElements(By.tagName("p"));
        String actualTextContentOne = paragraphs.get(0).getText();
        String actualTextContentTwo = paragraphs.get(1).getText();
        String expectedTextOne = "This example demonstrates a typo being " +
                "introduced. It does it randomly on each page load.";
        String expectedTextTwo = "Sometimes you'll see a typo, other times you won,t.";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualTextContentOne, expectedTextOne, "Тексты должны совпадать");
        softAssert.assertEquals(actualTextContentTwo, expectedTextTwo, "Тексты должны совпадать");
        softAssert.assertAll();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}
