import PageObjectModelLib.SearchPage;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestSearch extends BaseClass{
    @Description ("Looks for an existing item on the list and verifies it was found")
    @Test
    @Parameters({"searchCriteria", "expectedResult"})
    public void Validate_Search(@Optional("macbook") String searchCriteria, @Optional("3") String expectedResult){
        int results = Integer.parseInt(expectedResult);

        SearchPage searchPage = new SearchPage(driver);
        searchPage.SearchCriteria(searchCriteria,driver);

        Assert.assertTrue(driver.getCurrentUrl().contains("search="+searchCriteria));
        Assert.assertEquals(searchPage.getResults(), results,
                "Expecting " + expectedResult + " results, but got " + searchPage.getResults());

    }
    @Description ("Looks for an un-existing item on the list and verifies it was not found")
    @Test
    public void Test_Empty_Results(){
        String searchCriteria = "Star Wars";
        int expectedResult = 0;
        SearchPage searchPage = new SearchPage(driver);
        searchPage.SearchCriteria(searchCriteria,driver);


        Assert.assertEquals(searchPage.getResults(), expectedResult,
                "Expecting " + expectedResult + " results, but got " + searchPage.getResults());

    }
}


