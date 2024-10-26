package dev.mrrobot.elements;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum Action {

    CLICK_REGULAR(ElementType.BUTTON, ActionType.CLICK, "@Step(\"Clicking on button: 'placeholder'\")", "click(%s);"),
    INPUT_TEXT_REGULAR(ElementType.INPUT, ActionType.INPUT, "@Step(\"Entering text in '%s': '{0}'\")", "typeText(%s);"),
    INPUT_TEXT_SLOWLY(ElementType.INPUT, ActionType.INPUT, "@Step(\"Entering text in '%s': {0}\")", "typeTextSlowly(%s);"),
    INPUT_TEXT_SNEAKY(ElementType.INPUT, ActionType.INPUT, "@Step(\"Entering text in '%s': {0}\")", "typeTextSneaky(%s);"),

    UNDEFINED(ElementType.UNDEFINED, ActionType.UNDEFINED, "-", "-");

    private final ElementType elementType;
    private final ActionType actionType;
    private final String step;
    private final String seleniumMethod;

}
