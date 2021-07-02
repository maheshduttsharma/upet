package com.upet.pages;

import com.upet.base.Base;
import com.upet.utils.CommonUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dashboard extends Base {

    @FindBy(xpath="//div[@role='button']")
    WebElement lnkProfile;

    @FindBy(xpath=" //h1[normalize-space(text())='Pets']")
    WebElement lblPets;

    @FindBy(xpath="//header//button[@type='button']")
    WebElement btnHamburger;

    public Dashboard(){
        PageFactory.initElements(driver, this);
    }

    public void goToProfile(){
        CommonUtils.waitForVisibility(lnkProfile);
        lnkProfile.click();
    }

    public void verifyDashboard(){
        WebDriverWait wait = new WebDriverWait(driver, 15);
        try {
            wait.until(ExpectedConditions.visibilityOf(lblPets));
            markTestStatus("passed", "We are on 'Pets' page!", driver);
        } catch (Exception e) {
            markTestStatus("failed", "could not reach to 'Pets' page!", driver);
        }
    }
}
