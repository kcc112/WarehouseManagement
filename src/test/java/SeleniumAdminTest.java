import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

public class SeleniumAdminTest {

    @Test
    public void ChangeUserRole() {
        System.setProperty("webdriver.chrome.driver", System.getenv("WEBDRIVER"));
        DesiredCapabilities handlSSLErr = DesiredCapabilities.chrome();
        handlSSLErr.setAcceptInsecureCerts(true);
        WebDriver webDriver = new ChromeDriver(handlSSLErr);
        webDriver.navigate().to(System.getenv("WM") + "/faces/common/signIn.xhtml");
        webDriver.findElement(By.xpath("/html/body/div/div[3]/div/form/table/tbody/tr/td/table/tbody/tr[1]/td[2]/input")).sendKeys(System.getenv("LOGINA"));
        webDriver.findElement(By.xpath("/html/body/div/div[3]/div/form/table/tbody/tr/td/table/tbody/tr[2]/td[2]/input")).sendKeys(System.getenv("PASSWORDA"));
        webDriver.findElement(By.xpath("/html/body/div/div[3]/div/form/p/input")).click();
        webDriver.navigate().to(System.getenv("WM") + "/faces/account/listAuthorizedAccounts.xhtml");
        String value = webDriver.findElement(By.xpath("/html/body/div/div[3]/div/form/table/tbody/tr[1]/td[5]/input[5]")).getAttribute("disabled");
        assertNull(value);
        webDriver.findElement(By.xpath("/html/body/div/div[3]/div/form/table/tbody/tr[1]/td[5]/input[5]")).click();
        value = webDriver.findElement(By.xpath("/html/body/div/div[3]/div/form/table/tbody/tr[1]/td[5]/input[5]")).getAttribute("disabled");
        assertEquals("true", value);
        webDriver.findElement(By.xpath("/html/body/div/div[3]/div/form/table/tbody/tr[1]/td[5]/input[4]")).click();
        value = webDriver.findElement(By.xpath("/html/body/div/div[3]/div/form/table/tbody/tr[1]/td[5]/input[5]")).getAttribute("disabled");
        assertNull(value);
        webDriver.quit();
    }
}
