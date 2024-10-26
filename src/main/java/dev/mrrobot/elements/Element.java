package dev.mrrobot.elements;

import lombok.Data;

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

    public String getByLocator() {
        return locator.contains("//") ? String.format("By.xpath(%s)", locator) : String.format("By.id(%s)", locator);
    }

    protected abstract void applyAction();


}
