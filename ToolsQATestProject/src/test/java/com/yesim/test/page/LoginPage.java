package com.yesim.test.page;

import com.yesim.test.contracts.ILoginPage;
import com.yesim.test.util.BasePageUtil;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginPage extends BasePageUtil implements ILoginPage {

    public By newUserButton = By.id("newUser");
    public By registerTitle = By.xpath("//*[@id='userForm']//*[@style='margin-bottom: 50px;']");
    public By loginTitle = By.xpath("//*[@id='userForm']//h2");
    public By firstname = By.id("firstname");
    public By lastname = By.id("lastname");
    public By userName = By.id("userName");
    public By pass = By.id("password");
    public By checkbox = By.cssSelector("span[id='recaptcha-anchor']");
    public By registerButton = By.xpath("//*[@id='userForm']//button[@id='register']");
    public By closefixedband = By.id("close-fixedban");
    public By loginButton = By.id("login");
    public By usernameValue = By.id("userName-value");
    public By logoutButton = By.id("submit");
    public By errorMessage = By.id("name");

    @Override
    public void clickNewUser() {
        click(newUserButton);
    }

    @Override
    public void checkRegisterToBookStore() {
        Assert.assertEquals("Register sayfası görüntülenmedi!", getText(registerTitle), "Register to Book Store");
    }

    @Override
    public void setRegisterInformations(String firstName, String lastName, String username, String password) {
        sendKeys(firstname, firstName);
        sendKeys(lastname, lastName);
        sendKeys(userName, username);
        sendKeys(pass, password);
    }

    @Override
    public void checkLoginPage() {
        //highLighterMethod(registerButton);
        click(closefixedband);
        Assert.assertEquals("Welcome yazısı görüntülenmedi!", getText(loginTitle), "Welcome,");
        Assert.assertTrue("Login sayfası görüntülenmedi", isElementDisplayed(newUserButton));
        System.out.println("Giriş sayfasındasınız " + getText(loginTitle));
    }

    @Override
    public void clickIamNotaRobotChecbox() {
        click(closefixedband);
        PageScrolldown();
        int size = driver.findElements(By.tagName("iframe")).size();
        System.out.println("Total Frames --" + size);
        /*
        System.out.println("********We are switch to the iframe*******");
        for(int i=0; i<=size; i++){
            driver.switchTo().frame(i);
            int total=driver.findElements(By.xpath("//label[@id='recaptcha-anchor-label']")).size();
            System.out.println(total);
            driver.switchTo().defaultContent();//switching back from the iframe
        }

         */
        driver.switchTo().frame(2);// Switching the Outer Frame
        click(checkbox);
        driver.switchTo().defaultContent();//switching back from the iframe
    }

    @Override
    public void clickRegister() {
        Assert.assertTrue("Register butonu görüntülenmedi!!!", isElementDisplayed(registerButton));
        if (!isEnabled(registerButton)) {
            System.out.println("CAPTCHA sebebiyle üye olunamadı !!!");

        } else
            click(registerButton);

        /*
        int size = driver.findElements(By.tagName("iframe")).size();
        System.out.println("Total Frames --" + size);
        System.out.println("********We are switch to the iframe*******");
        for(int i=0; i<=size; i++){
            driver.switchTo().frame(i);
            int total=driver.findElements(By.xpath("//*[@id='userForm']//button[@id='register']")).size();
            System.out.println(total);
            driver.switchTo().defaultContent();//switching back from the iframe
        }

         */
}
    @Override
    public void setUser(String username, String password) {
        sendKeys(userName,username);
        sendKeys(pass,password);

    }

    @Override
    public void clickLogin() {
        click(loginButton);
    }

    @Override
    public void checkSuccessfullLogin() {
        Assert.assertEquals("Başarılı giriş yapılamadı!",getText(usernameValue),"yesimkaranci");
        Assert.assertTrue("Log out butonu görüntülenmedi!",isElementDisplayed(logoutButton));
    }

    @Override
    public void clickLogOut() {
        click(logoutButton);
        Assert.assertEquals("Welcome yazısı görüntülenmedi!",getText(loginTitle),"Welcome,");
    }

    @Override
    public void checkSuccessfullRegister() {
        try {
            if (!isElementDisplayed(errorMessage)) {

                System.out.println("Tebrikler başarılı üye oldunuz :) ");

            }
            else {
                if(getText(errorMessage) == "User exists!")
                    System.out.println("Kullanıcının üyeliği var!!!");
                else
                    System.out.println("CAPTCHA sebebiyle üye olunamadı!!!");
            }
        } catch (Exception ex) {
        }
    }


}
