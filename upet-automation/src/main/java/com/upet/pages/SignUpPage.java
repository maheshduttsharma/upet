package com.upet.pages;

import com.upet.base.Base;
import com.upet.utils.CommonUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage extends Base
{
    @FindBy(xpath = "//*[@name='name']")
    WebElement txtFirstName;

    @FindBy(xpath = "//*[@name='lastName']")
    WebElement txtLastName;

    @FindBy(xpath = "//*[@name='email']")
    WebElement txtEmail;

    @FindBy(xpath = "//*[@name='password']")
    WebElement txtPassword;

    @FindBy(xpath = "//button[@label='Create Account']")
    WebElement btnCreateAccount;

    public SignUpPage(){
        PageFactory.initElements(driver, this);
    }

    public void fillForm(){
        txtFirstName.sendKeys(CommonUtils.generateRandomString(6));
        txtLastName.sendKeys(CommonUtils.generateRandomString(6));
        txtEmail.sendKeys(CommonUtils.generateRandomString(6)+"@gmail.com");
        txtPassword.sendKeys(CommonUtils.generateRandomString(6)+"#3A");
    }

    public void clickCreateAccount(){
        btnCreateAccount.click();
    }
}
