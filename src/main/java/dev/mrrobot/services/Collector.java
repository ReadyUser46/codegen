package dev.mrrobot.services;

import dev.mrrobot.elements.ClickButton;
import dev.mrrobot.elements.Element;
import dev.mrrobot.elements.InputText;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
public class Collector {

    private static Collector instance;
    private String pagename;
    private String repositoryname;
    private boolean allureSteps;
    private List<Element> elements;

    private Collector() {
        elements = new LinkedList<>();
    }

    public static Collector getInstance() {
        if (instance == null) instance = new Collector();
        return instance;
    }

    public Collector definePageName(String name) {
        pagename = name;
        return this;
    }

    public Collector enableAllureSteps(boolean allureSteps) {
        this.allureSteps = allureSteps;
        return this;
    }

    public Collector addButtonClick(String locator, String name, boolean dinamicwait, boolean hardwait) {
        elements.add(new ClickButton(locator, name, dinamicwait, hardwait));
        return this;
    }

    public Collector addButtonClick(String locator, String name, boolean dinamicwait) {
        return addButtonClick(locator, name, dinamicwait, false);
    }

    public Collector addInputText(String locator, String name, boolean trigger, boolean sneaky, boolean slowly) {
        elements.add(new InputText(locator, name, trigger, sneaky, slowly));
        return this;
    }

    public Collector addInputTextSlowly(String locator, String name, boolean trigger) {
        elements.add(new InputText(locator, name, trigger, false, true));
        return this;
    }

    /*public void generateActionCode() {
        elements.forEach(e -> {
            String sc = String.format("public void %s()",


        });


    }*/


}
