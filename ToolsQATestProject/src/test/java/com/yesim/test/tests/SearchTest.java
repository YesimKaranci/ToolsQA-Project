package com.yesim.test.tests;

import com.yesim.test.contracts.ISearchPage;
import com.yesim.test.page.SearchPage;
import cucumber.api.java.en.And;

public class SearchTest {

    public ISearchPage searchPage = new SearchPage();

    @And("^Search alanından bir ([^\\\"]*) aranır ve aranan kitabın listelendiği görülür$")
    public void searchAlanındanBirProductAranırVeArananKitabınListelendiğiGörülür(String book) {
        searchPage.bookSearch(book);
    }
}
