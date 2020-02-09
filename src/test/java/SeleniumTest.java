import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

public class SeleniumTest {

    @Test

    public void changeUserRole() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        RemoteWebDriver webDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
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

    @Test
    public void increaseStockWarehouse() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        RemoteWebDriver webDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        webDriver.navigate().to(System.getenv("WM") + "/faces/common/signIn.xhtml");

        //logowanie
        webDriver.findElement(By.xpath("/html/body/div/div[3]/div/form/table/tbody/tr/td/table/tbody/tr[1]/td[2" +
                "]/input")).sendKeys("LOGINW");
        webDriver.findElement(By.xpath("/html/body/div/div[3]/div/form/table/tbody/tr/td/table/tbody/tr[2]/td[2" +
                "]/input")).sendKeys("PASSWORDA");
        webDriver.findElement(By.xpath("/html/body/div/div[3]/div/form/p/input")).click();

        //zwiekszenie stanu
        webDriver.navigate().to(System.getenv("WM") + "/faces/stock/stockUp.xhtml");
        webDriver.findElement(By.xpath("/html/body/div/div[3]/div/form/table/tbody/tr[1]/td[2]/select/option[2]")).click();
        webDriver.findElement(By.xpath("/html/body/div/div[3]/div/form/table/tbody/tr[2]/td[2]/select/option[9]")).click();
        webDriver.findElement(By.xpath("/html/body/div/div[3]/div/form/table/tbody/tr[3]/td[2]/input")).sendKeys("5");
        webDriver.findElement(By.xpath("/html/body/div/div[3]/div/form/table/tbody/tr[4]/td[2]/select/option[8]")).click();
        webDriver.findElement(By.xpath("/html/body/div/div[3]/div/form/input[2]")).click();
        webDriver.findElement(By.xpath("/html/body/div/div[3]/div/form/input[2]")).click();

        //sprawdzenie stanu
        webDriver.navigate().to(System.getenv("WM") + "/faces/stock/listStock.xhtml");
        webDriver.findElement(By.xpath("/html/body/div/div[3]/div/form/table[1]/tbody/tr/td[2]/select/option[9]")).click();
        webDriver.findElement(By.xpath("/html/body/div/div[3]/div/form/table[1]/tbody/tr/td[3]/input")).click();
        String res = webDriver.findElement(By.xpath("/html/body/div/div[3]/div/form/table[2]/tbody/tr/td[2]")).getText();
        assertEquals("5", res);

        //zmniejszenie stanu
        webDriver.findElement(By.xpath("/html/body/div/div[3]/div/form/table[2]/tbody/tr/td[6]/input[1]")).click();
        webDriver.findElement(By.xpath("/html/body/div/div[3]/div/form/table/tbody/tr[3]/td[2]/input")).sendKeys("5");
        webDriver.findElement(By.xpath("/html/body/div/div[3]/div/form/input[2]")).click();

        webDriver.quit();

    }

    @Test
    public void changeProductWeight() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", System.getenv("WEBDRIVER"));
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);

        RemoteWebDriver webDriver = new RemoteWebDriver(new URL("http://localhost:5555/wd/hub"), options);
        webDriver.navigate().to(System.getenv("WM") + "/faces/common/signIn.xhtml");
        //logowanie
        webDriver.findElement(By.xpath("/html/body/div/div[3]/div/form/table/tbody/tr/td/table/tbody/tr[1]/td[2" + "]/input")).sendKeys(System.getenv("LOGINP"));
        webDriver.findElement(By.xpath("/html/body/div/div[3]/div/form/table/tbody/tr/td/table/tbody/tr[2]/td[2" + "]/input")).sendKeys(System.getenv("PASSWORDA"));
        webDriver.findElement(By.xpath("/html/body/div/div[3]/div/form/p/input")).click();
        //zmiana wagi
        webDriver.navigate().to(System.getenv("WM") + "/faces/product/listProducts.xhtml");
        String startWeight = webDriver.findElement(By.xpath("/html/body/div/div[3]/div/form/table/tbody/tr[1]/td[3]")).getText();
        webDriver.findElement(By.xpath("/html/body/div/div[3]/div/form/table/tbody/tr[1]/td[6]/input[1]")).click();
        webDriver.findElement(By.xpath("/html/body/div/div[3]/div/form/table/tbody/tr[4]/td[2]/input")).clear();
        webDriver.findElement(By.xpath("/html/body/div/div[3]/div/form/table/tbody/tr[4]/td[2]/input")).sendKeys("150");
        webDriver.findElement(By.xpath("/html/body/div/div[3]/div/form/input[2]")).click();
        //sprawdzenie wagi
        String weight = webDriver.findElement(By.xpath("/html/body/div/div[3]/div/form/table/tbody/tr[1]/td[3]")).getText();
        assertEquals("150", weight);
        //powrot do startowej wagi
        webDriver.findElement(By.xpath("/html/body/div/div[3]/div/form/table/tbody/tr[1]/td[6]/input[1]")).click();
        webDriver.findElement(By.xpath("/html/body/div/div[3]/div/form/table/tbody/tr[4]/td[2]/input")).clear();
        webDriver.findElement(By.xpath("/html/body/div/div[3]/div/form/table/tbody/tr[4]/td[2]/input")).sendKeys(startWeight);
        webDriver.findElement(By.xpath("/html/body/div/div[3]/div/form/input[2]")).click();

        webDriver.quit();


    }
}