package dev.mrrobot.elements;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Action {

    INPUT_TEXT("Entering text in '%s': '%s'", "typeText"),
    INPUT_TEXT_SLOWLY("Entering text in '%s': {}", "typeTextSlowly"),
    INPUT_TEXT_SNEAKY("Entering text in '%s': {}", "typeTextSneaky"),
    CLICK("Clicking on button: '%s'", "click"),

    UNDEFINED("-", "-");

    private final String step;
    private final String seleniumMethod;


    public static Action getItem(String name) {

        for (Action i : Action.values()) {
            if (i.getStep().equals(name)) return i;
        }
        return UNDEFINED;
    }

}
