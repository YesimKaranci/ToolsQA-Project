package com.yesim.test.tests;

import com.yesim.test.contracts.ILoginPage;
import com.yesim.test.page.LoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginTest {
    public ILoginPage loginPage = new LoginPage();


    @When("^Yeni üyelik için New User butonuna tıklanır$")
    public void yeniÜyelikIçinNewUserButonunaTıklanır() {
        loginPage.clickNewUser();
    }

    @Then("^Register ekranına gidildiği kontrol edilir$")
    public void registerEkranınaGidildiğiKontrolEdilir() {
        loginPage.checkRegisterToBookStore();
    }

    @Given("^([^\\\"]*) ([^\\\"]*) ([^\\\"]*) ([^\\\"]*) alanları girilir$")
    public void firstnameLastnameUsernamePasswordAlanlarıGirilir(String firstName, String lastName, String username, String password) {
        loginPage.setRegisterInformations(firstName,lastName,username,password);
    }

    @When("^Register butonuna tıklanır$")
    public void registerButonunaTıklanır() {
        loginPage.clickRegister();
    }

    @Then("^Login sayfasına gidildiği kontrol edilir$")
    public void loginSayfasınaGidildiğiKontrolEdilir() {
        loginPage.checkLoginPage();
    }

    @And("^I'm a not robot checboxına tıklanır$")
    public void ıMANotRobotChecboxınaTıklanır() {
        loginPage.clickIamNotaRobotChecbox();
    }

    @Given("^Kullanıcı adı alanına ([^\\\"]*) parola alanına ([^\\\"]*) girilir$")
    public void kullanıcıAdıAlanınaUsernameParolaAlanınaPasswordGirilir(String username,String password) {
        loginPage.setUser(username,password);
    }

    @And("^Giriş ekranında Login butonuna tıklanır$")
    public void girişEkranındaLoginButonunaTıklanır() {
        loginPage.clickLogin();
    }

    @Then("^Başarılı giriş yapıldığı kontrol edilir$")
    public void başarılıGirişYapıldığıKontrolEdilir() {
        loginPage.checkSuccessfullLogin();
    }

    @And("^Uygulamadan çıkış yapılır$")
    public void uygulamadanÇıkışYapılır() {
        loginPage.clickLogOut();
    }

    @Then("^Üye olunduğu kontrol edilir$")
    public void üyeOlunduğuKontrolEdilir() {
        loginPage.checkSuccessfullRegister();
    }
}
