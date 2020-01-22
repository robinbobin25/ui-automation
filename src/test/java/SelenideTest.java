import com.codeborne.selenide.WebDriverRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testcontainers.containers.BrowserWebDriverContainer;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest {

    private String FB_URL = "https://www.facebook.com/";

    @Rule
    public BrowserWebDriverContainer chrome =
            new BrowserWebDriverContainer()
                    .withRecordingMode(BrowserWebDriverContainer.VncRecordingMode.RECORD_ALL, new File("build"))
                    .withCapabilities(new ChromeOptions());

    @Before
    public void setUp() {
        RemoteWebDriver driver = chrome.getWebDriver();
        WebDriverRunner.setWebDriver(driver);
    }

    @After
    public void tearDown() {
        WebDriverRunner.closeWebDriver();
    }

    @Test
    public void test1() {
        open(FB_URL);
        $(By.name("email")).setValue("johny@mail.ua");
        $("#loginbutton").click();
        $(By.xpath("//div[@role='alert']")).should(appear);
    }

}
