package dev.mrrobot.elements;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public class ClickButton extends Element {

    private final boolean hardwait;
    private final boolean dinamicwait;


    public ClickButton(String locator, String name, boolean hardwait, boolean dinamicwait) {
        super(locator, name);
        this.hardwait = hardwait;
        this.dinamicwait = dinamicwait;
    }

    @Override
    public void applyAction() {
        action = Action.CLICK;
    }
}
