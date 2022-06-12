package com.yesim.test.page;

import com.yesim.test.contracts.IHomePage;
import com.yesim.test.util.BasePageUtil;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends BasePageUtil implements IHomePage {

    public By imageToolsQA = By.xpath("//*[@id='app']//img[@src='/images/Toolsqa.jpg']");
    public By closeFixedban = By.id("close-fixedban");
    public By cardTitle = By.xpath("//*[@id='app']//div[@class='category-cards']//*[@class='card-body']");
    List <WebElement> categoryCards = driver.findElements(cardTitle);
    public By loginButton = By.id("login");

    @Override
    public void checkHomePage() {
        Assert.assertTrue("Web sitesi görüntülenmedi!",isElementDisplayed(imageToolsQA));
    }

    @Override
    public void scrollBookApplication() {
        for (int i = 0; i < categoryCards.size(); i++) {
            PageScrolldown();
            if (categoryCards.get(i).getText().contains("Book Store Application")) {
                System.out.println("Category name : " +categoryCards.get(i).getText());
                categoryCards.get(i).click();
                break;
            }

        }
    }

    @Override
    public void clickLoginButton() {
        Assert.assertTrue("Login butonu görüntülenmedi!!!" ,isElementDisplayed(loginButton));
        click(loginButton);
    }
}
