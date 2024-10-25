package dev.mrrobot.elements;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public class InputText extends Element {

    private final boolean trigger;
    private final boolean sneaky;
    private final boolean slowly;

    public InputText(String locator, String name, boolean trigger, boolean sneaky, boolean slowly) {
        super(locator, name);
        this.trigger = trigger;
        this.sneaky = sneaky;
        this.slowly = slowly;

    }


    @Override
    public void applyAction() {
        if (slowly) action = Action.INPUT_TEXT_SLOWLY;
        if (sneaky) action = Action.INPUT_TEXT_SNEAKY;
        else action = Action.INPUT_TEXT;
    }
}
