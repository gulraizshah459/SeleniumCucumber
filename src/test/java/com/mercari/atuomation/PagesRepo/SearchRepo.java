package com.mercari.atuomation.PagesRepo;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import static Utilities.CommonFunctions.*;

public class SearchRepo {

    WebDriver driver;
    // Locators for various elements on the search page
    By searchField = By.xpath("//input[@aria-label = '検索キーワードを入力']");
    By categoryTierSelect = By.cssSelector("li[data-testid='category_id'] select.merInputNode");
    By searchListItemsText = By.xpath("//section[@data-testid='search-history']//div[@role='listitem']//p");
    By homePageLogo = By.xpath("//*[@data-testid='mercari-logo']");
    By searchResultText = By.xpath("//*[contains(text(),'の検索結果')]");
    By searchButton = By.xpath("//button[@aria-label='検索']");


    //Constructor to initialize the WebDriver object.
    public SearchRepo(WebDriver driver){
        this.driver = driver;
    }

    //Clicks on the search field.
    public void clickOnSearchField(){
        Assert.assertTrue("Search element not found",waitUntilElementDisplayed(searchField,10));
        driver.findElement(searchField).click();
    }
    //Clicks on an element with the specified text.
    public void clickOnText(String text){
        By categoryTier = By.xpath("//*[text()='"+text+"']");
        Assert.assertTrue("Element not found "+ text,waitUntilElementDisplayed(categoryTier,10));
        driver.findElement(categoryTier).click();
    }
    //erifies that the selected categories and checkbox are present and correct.
    public void verifyCategoriesShouldBePresent(String text1, String text2, String text3){
        Assert.assertTrue("Element not found "+ text1,waitUntilElementDisplayed(categoryTierSelect,10));
        // Get the list of select elements
        List<WebElement> selectElements = driver.findElements(categoryTierSelect);

        // Get the selected text of the first select element
        Select select1 = new Select(selectElements.get(0));
        String selectedText1 = select1.getFirstSelectedOption().getText();
        Assert.assertEquals("The first selected category is incorrect",text1,selectedText1);

        // Get the selected text of the second select element
        Select select2 = new Select(selectElements.get(1));
        String selectedText2 = select2.getFirstSelectedOption().getText();
        Assert.assertEquals("The second selected category is incorrect",text2,selectedText2);

        // Locate the checkbox element
        By checkboxToCheck = By.xpath("//span[text()='"+text3+"']/ancestor::label/input");
        Assert.assertTrue("Category checkbox is not showing for "+text3,waitUntilElementSelected(checkboxToCheck,10));
        WebElement checkbox = driver.findElement(checkboxToCheck);

        // Assert that the checkbox is selected
        Assert.assertTrue("The checkbox is not checked for "+text3, checkbox.isSelected());

    }
    // Verifies the number of search history list items.
    public void verifySearchHistoryListItems(int countOfItems){
        waitForElementRendering(searchListItemsText);
        List<WebElement> listElements = driver.findElements(searchListItemsText);
        int tempListCount = listElements.size();
        Assert.assertEquals("The count of search items is not right",countOfItems,tempListCount);
    }
    // Verifies that the latest browsing history is showing the expected text.
    public void verifyLatestBrowsingHistoryIsShowing(String textToCheck){
        waitForElementRendering(searchListItemsText);
        List<WebElement> listElements = driver.findElements(searchListItemsText);
        String tempHistoryText = listElements.get(0).getText();
        Assert.assertEquals("Latest search is not showing right",textToCheck,tempHistoryText);
    }
    // Verifies that the search result screen is visible.
    public void verifySearchScreenVisible(){
        Assert.assertTrue("Search screen is not visible",waitUntilElementDisplayed(searchResultText,10));
    }
    // Clicks on the homepage logo to navigate to the homepage.
    public void clickOnHomepage(){
        driver.findElement(homePageLogo).click();
    }
    // Searches for the given text.
    public void searchForText(String textToSearch){
        driver.findElement(searchField).sendKeys(textToSearch);
        driver.findElement(searchButton).click();
    }


}
