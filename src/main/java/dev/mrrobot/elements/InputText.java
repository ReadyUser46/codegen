package dev.mrrobot.elements;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public class InputText extends Element {

    private final boolean trigger;
    private final boolean sneaky;
    private final boolean slowly;

    public InputText(String locatorStr, boolean trigger, boolean sneaky, boolean slowly) {
        super(locatorStr);
        this.trigger = trigger;
        this.sneaky = sneaky;
        this.slowly = slowly;
    }


    @Override
    public Action setAction() {
        if (slowly) return Action.INPUT_TEXT_SLOWLY;
        if (sneaky) return Action.INPUT_TEXT_SNEAKY;
        else return Action.INPUT_TEXT;
    }
}
