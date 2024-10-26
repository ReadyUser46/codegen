package dev.mrrobot.services;

import dev.mrrobot.elements.Element;

public class NameGenerator {

    public static String genCteNameString(Element element) {

        String prefix = element.getAction().getElementType().name();
        String sufix = element.getLocator().contains("//") ? "XPATH" : "ID";
        String name = NameGenerator.undercoreLowerCamelCase(element.getName());

        return String.format("%s_%s_%s",
                prefix,
                name,
                sufix);
    }

    public static String genCteNameBy(Element element) {

        String prefix = element.getAction().getElementType().name();

        return String.format("%s_%s",
                prefix,
                element.getName().toUpperCase());
    }

    public static String genMethodName(Element element) {
        String actionType = element.getAction().getActionType().name().toLowerCase();
        return String.format("%s%s", actionType, element.getName());
    }

    private static String undercoreLowerCamelCase(String name) {

        StringBuilder cteName = new StringBuilder();
        for (Character c : name.toCharArray()) {
            if (Character.isUpperCase(c)) {
                cteName.append("_");
            }

            cteName.append(Character.toUpperCase(c));
        }
        return cteName.toString();
    }
}
