import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SeleniumPrimerosPasos {

    public static void main (String[] args){
        String getpath = main.class.getResource("chromedriver.exe").getPath();
        System.setProperty("webdriver.chrome.driver",getpath);
        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.opencart.com");
        WebElement searchBar = driver.findElement(By.name("search"));
        WebElement findBtn = driver.findElement(By.xpath("//button[contains(@class,'btn btn-default btn-lg')]"));
        searchBar.sendKeys("macbook");

        findBtn.click();

        WebElement addCart =driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[1]/div/div[2]/div[2]/button[1]"));
        addCart.click();

        WebElement message = driver.findElement(By.xpath("//div[contains(@class,'alert alert-success alert-dismissible')]"));

        Assert.assertTrue(message.isDisplayed());
        driver.quit();
    }

}

