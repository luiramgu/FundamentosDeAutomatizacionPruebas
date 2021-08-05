import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class TestSearch extends BaseClass{
    @Description ("Looks for an existing item on the list and verifies it was found")
    @Test
    @Parameters({"searchCriteria", "expectedResult"})
    public void Validate_Search(@Optional("macbook") String searchCriteria, @Optional("3") String expectedResult){
        int results = Integer.parseInt(expectedResult);

        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.sendKeys(searchCriteria);

        //Hacemos Click en el boton en vez de enter porque en FF da error
        WebElement searchbutton = driver.findElement(By.xpath("//*[@id=\"search\"]/span/button/i"));
        searchbutton.click();

        Assert.assertTrue(driver.getCurrentUrl().contains("search="+searchCriteria));
        Assert.assertEquals(getResults(), results,
                "Expecting " + expectedResult + " results, but got " + getResults());

    }
    @Description ("Looks for an un-existing item on the list and verifies it was not found")
    @Test
    public void Test_Empty_Results(){
        String searchCriteria = "Star Wars";
        int expectedResult = 0;

        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.sendKeys(searchCriteria);

        //Hacemos Click en el boton en vez de enter porque en FF da error
        WebElement searchbutton = driver.findElement(By.xpath("//*[@id=\"search\"]/span/button/i"));
        searchbutton.click();

        Assert.assertEquals(getResults(), expectedResult,
                "Expecting " + expectedResult + " results, but got " + getResults());

    }

    public int getResults(){
        return driver.findElements(By.cssSelector(".product-thumb")).size();
    }
}
