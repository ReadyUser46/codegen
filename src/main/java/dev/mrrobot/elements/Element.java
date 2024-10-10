package dev.mrrobot.elements;

import lombok.Data;
import org.openqa.selenium.By;

@Data
public abstract class Element {

    private Action action;
    private String locatorStr;
    private By locator;

    public Element(String locatorStr) {
        this.locatorStr = locatorStr;
    }

    protected void getLocator(String locatorStr) {
        locator = locatorStr.contains("//") ? By.xpath(locatorStr) : By.id(locatorStr);
    }

    public abstract Action setAction();


}
