package dev.mrrobot;

import dev.mrrobot.elements.ButtonClick;
import dev.mrrobot.elements.Element;
import dev.mrrobot.elements.InputText;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
public class Service {

    private static Service instance;
    private String pagename;
    private String repositoryname;
    private boolean allureSteps;
    private List<Element> elements;

    private Service() {
        elements = new LinkedList<>();
    }

    public static Service getInstance() {
        if (instance == null) instance = new Service();
        return instance;
    }

    public Service definePageName(String name) {
        pagename = name;
        return this;
    }

    public Service enableAllureSteps(boolean allureSteps) {
        this.allureSteps = allureSteps;
        return this;
    }

    public Service addButtonClick(String locator, boolean dinamicwait, boolean hardwait) {
        elements.add(new ButtonClick(locator, dinamicwait, hardwait));
        return this;
    }

    public Service addButtonClick(String locator, boolean dinamicwait) {
        return addButtonClick(locator, dinamicwait, false);
    }

    public Service addInputText(String locator, boolean trigger, boolean sneaky, boolean slowly) {
        elements.add(new InputText(locator, trigger, sneaky, slowly));
        return this;
    }

    public Service generateCode() {


        return this;
    }


}
