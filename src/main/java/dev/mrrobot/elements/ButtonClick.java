package dev.mrrobot.elements;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public class ButtonClick extends Element {

    private final boolean hardwait;
    private final boolean dinamicwait;


    public ButtonClick(String locatorStr, boolean hardwait, boolean dinamicwait) {
        super(locatorStr);
        this.hardwait = hardwait;
        this.dinamicwait = dinamicwait;
    }

    @Override
    public Action setAction() {
        return Action.CLICK;
    }
}
