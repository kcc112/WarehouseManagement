import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

public class SeleniumAdminTest {

    @Test
    public void ChangeUserRole() {
        System.setProperty("webdriver.gecko.driver", System.getenv("WEBDRIVER"));
        WebDriver webDriver = new FirefoxDriver();
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