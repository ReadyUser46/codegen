package dev.mrrobot.services;

import dev.mrrobot.elements.Element;

import java.util.List;

public class Constructor {

    private List<Element> elements;

    public static void genStringCte(Element element) {

        String prefix = element.getAction().getType().name();
        String sufix = element.getLocator().contains("//") ? "XPATH" : "ID";
        String cteName = String.format("%s_%s_%s",
                prefix,
                element.getName().toUpperCase(),
                sufix);
        String cte = String.format("private static final String %s = %s",
                cteName,
                element.getLocator()
        );

        element.setCteCode(cte);
    }

    public static void genByCte(Element element) {

        String prefix = element.getAction().getType().name();
        String cteName = String.format("%s_%s",
                prefix,
                element.getName().toUpperCase());
        String cte = String.format("private static final String %s = %s",
                cteName,
                element.getByLocator()
        );

        element.setCteCode(cte);
    }


}
