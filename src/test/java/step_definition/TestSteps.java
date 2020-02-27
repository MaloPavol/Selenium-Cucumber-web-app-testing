package step_definition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class TestSteps {
    WebDriver ChromeDriver;

    @Given("^the from is opened in chrome$")
    public void open_the_Chrome_and_navigate_to_W3S_sample_form() throws Throwable {
        //TODO: Reference driver version corresponding to the chrome on your machine (79, 80 or 81)!
        System.setProperty("webdriver.chrome.driver", "src//test//resources//web_browser_engines//ChromeDriver_80_(Windows).exe");
        this.ChromeDriver = new ChromeDriver();
        this.ChromeDriver.manage().window().maximize();
        this.ChromeDriver.get("https://www.w3schools.com/html/html_forms.asp");
    }

    @When("^user fills in his/her name and clicks submit$")
    public void enter_first_and_last_name_and_submit() throws Throwable {
        WebElement firstNameInput = this.ChromeDriver.findElement(By.id("fname"));
        WebElement lastNameInput = this.ChromeDriver.findElement(By.id("lname"));
        firstNameInput.clear();
        firstNameInput.sendKeys(new CharSequence[]{"MyFirsName"});
        lastNameInput.clear();
        lastNameInput.sendKeys(new CharSequence[]{"MyLastName"});
        lastNameInput.submit();
    }

    @Then("^confirmation page is loaded$")
    public void submit_confirmation_provided() throws Throwable {

        String expectedUrl = "https://www.w3schools.com/action_page.php?fname=MyFirsName&lname=MyLastName";

        String popupTab = null;
        Set<String> tabs = ChromeDriver.getWindowHandles();
        Iterator<String> iterator = tabs.iterator();
        while (iterator.hasNext()){
            popupTab = iterator.next();
        }
        ChromeDriver.switchTo().window(popupTab);
        String actualUrl = ChromeDriver.getCurrentUrl();

        System.out.println("EXPECTED: "+ expectedUrl);
        System.out.println("ACTUAL: "+ actualUrl);
        assertEquals(expectedUrl, actualUrl);
    }
}
