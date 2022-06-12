package com.yesim.test.util;

import com.yesim.test.tests.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class BasePageUtil {

    public WebDriver driver = BaseTest.getDriver();
    WebDriverWait wait = new WebDriverWait(driver,30,500);
    //public WebDriverWait wait = BaseTest.getWait();
    //public Scanner scanner = new Scanner(System.in);

    public WebElement findElement(By by){

        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public List<WebElement> findElements(By by){

        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public void click(By by) {
        WebElement element = findElement(by);
        //((JavascriptExecutor)driver).executeScript("argument[0].scrollIntoViewIfNeeded()",element);
        wait.until(ExpectedConditions.elementToBeClickable(element))
                .click();
    }

    public void sendKeys(By by, CharSequence text) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(by))
                .sendKeys(text);
    }

    public String getText(By by){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return findElement(by).getText();
    }

    public boolean isElementDisplayed(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return findElement(by).isDisplayed();
    }
    public void PageScrolldown() {
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,240)");
    }

    public Actions getActions(){
        return new Actions(driver);
    }
    public void hoverElement(By by){
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        getActions().moveToElement(findElement(by)).build().perform();
    }
    public void highLighterMethod(By element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",element);
    }

    public void doubleClick(By by){
        wait.until(ExpectedConditions.elementToBeClickable(by));
        Actions act = new Actions(driver);
        act.doubleClick().perform();
    }

    public String getAttribute(By by,String text)  {
        return findElement(by).getAttribute(text);
    }

    public boolean isEnabled(By by) {
        return wait.until(ExpectedConditions.elementToBeClickable(by)).isEnabled();
    }



}


