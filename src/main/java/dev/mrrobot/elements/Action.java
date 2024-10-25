package dev.mrrobot.elements;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static dev.mrrobot.elements.Type.BUTTON;
import static dev.mrrobot.elements.Type.INPUT;

@Getter
@AllArgsConstructor
public enum Action {

    CLICK(BUTTON, "Clicking on button: '%s'", "click"),
    INPUT_TEXT(INPUT, "Entering text in '%s': '{}'", "typeText"),
    INPUT_TEXT_SLOWLY(INPUT, "Entering text in '%s': {}", "typeTextSlowly"),
    INPUT_TEXT_SNEAKY(INPUT, "Entering text in '%s': {}", "typeTextSneaky"),

    UNDEFINED(Type.UNDEFINED, "-", "-");

    private final Type type;
    private final String step;
    private final String seleniumMethod;

    public static Action getItem(String name) {
        for (Action i : Action.values()) {
            if (i.getStep().equals(name)) return i;
        }
        return UNDEFINED;
    }

}
