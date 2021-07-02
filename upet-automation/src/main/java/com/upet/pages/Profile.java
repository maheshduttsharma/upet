package com.upet.pages;

import com.upet.base.Base;
import com.upet.utils.CommonUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class Profile extends Base {

    @FindBy(id="uploadPhoto")
    WebElement btnProfilePic;

    @FindBy(xpath="//h1[text()='Contact info']")
    WebElement lblContactInfo;

    @FindBy(xpath="//button[@label='Save']")
    WebElement btnSave;

    public Profile(){
        PageFactory.initElements(driver, this);
    }
    public void uploadProfilePicture(){
        CommonUtils.waitForVisibility(lblContactInfo);
        driver.setFileDetector(new LocalFileDetector());
        File file = new File(System.getProperty("user.dir") + "/src/test/data/heic-image.HEIC");
        String imagePath = file.getAbsolutePath();
        btnProfilePic.sendKeys(imagePath);
        CommonUtils.waitForVisibility(btnSave);
        btnSave.click();
    }
}
