package com.yesim.test.page;

import com.yesim.test.contracts.ISearchPage;
import com.yesim.test.util.BasePageUtil;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage extends BasePageUtil implements ISearchPage {

    public By searchBox = By.id("searchBox");
    public By searchIcon = By.id("basic-addon2");
    public By bookName = By.cssSelector("span[id='see-book-Speaking JavaScript']");
    List<WebElement> list = findElements(bookName);

    @Override
    public void bookSearch(String book) {
        Assert.assertTrue("arama alanı görüntülenmedi!" , isElementDisplayed(searchBox));
        sendKeys(searchBox,book);
        click(searchIcon);
        Assert.assertEquals("Aradığınız kitap ile listelenen kitap uyuşmamaktadır.",getText(bookName),book);
        /*
        System.out.println("Dizinin boyutu : " +list.size());

        for (WebElement i : list) {
            System.out.println("Listelenenler : " +i.getText());
            if(i.getText().contains(book)){
                System.out.println("Aradığınız kitap ile listelenen kitap uyuşmaktadır. Listelenen : " +i.getText());
            }
        }
*/
    }
}
