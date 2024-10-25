package dev.mrrobot.elements;

import lombok.Data;
import org.openqa.selenium.By;

@Data
public abstract class Element {

    protected Action action;
    private String locator;
    private String name;

    private String cteCode;
    private String methodCode;


    public Element(String locator, String name) {
        this.locator = locator;
        this.name = name;
    }

    public By getByLocator() {
        return locator.contains("//") ? By.xpath(locator) : By.id(locator);
    }

    public abstract void applyAction();


}
