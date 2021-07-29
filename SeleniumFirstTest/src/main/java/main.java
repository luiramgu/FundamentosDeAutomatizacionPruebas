import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class main {
    public static void main (){
        String getpath = main.class.getResource("chromedriver.exe").getPath();
        System.setProperty("webdriver.chrome.driver",getpath);
        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.opencart.com/index.php?route=account/login");
        WebElement emailElement = driver.findElement(By.name("email"));


    }


}
