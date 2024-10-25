package dev.mrrobot.lab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LabPage {

    private static final By lctrA = By.id("#23");
    private static final By prmtrzLocator = By.xpath("//*[@class=%s]");
    private WebDriver driver;

    public static void main(String[] args) {
        String string = prmtrzLocator.toString();

    }

    public void performActionA(String text) {
        getElementA().click();
        getElementA().sendKeys(text);
        //todo makeScreenshot();
    }

    private WebElement getElementA() {
        return driver.findElement(lctrA);
    }
}
