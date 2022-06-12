package com.yesim.test.contracts;

public interface ILoginPage {

    void clickNewUser();

    void checkRegisterToBookStore();

    void setRegisterInformations(String firstName,String lastName, String username, String password);

    void clickRegister();

    void checkLoginPage();

    void clickIamNotaRobotChecbox();

    void setUser(String username, String password);

    void clickLogin();

    void checkSuccessfullLogin();

    void clickLogOut();

    void checkSuccessfullRegister();
}
