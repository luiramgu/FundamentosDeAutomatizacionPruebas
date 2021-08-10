package PageObjectModelLib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage  {
    private WebDriver driver ;

        //Elementos
    public By SearchBarLocator = new By.ByXPath("//*[@id=\"search\"]/input");
    public By SearchButtonLocator = new By.ByXPath("//*[@id=\"search\"]/span/button/i");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void SearchCriteria (String search, WebDriver driver){
        SearchPage sp = new SearchPage(driver);
        driver.findElement(SearchBarLocator).sendKeys(search);
        driver.findElement(SearchButtonLocator).click();
    }

    public int getResults(){

        return driver.findElements(By.cssSelector(".product-thumb")).size();
    }

}
