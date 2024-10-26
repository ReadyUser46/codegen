package dev.mrrobot.services;

import dev.mrrobot.config.Config;
import dev.mrrobot.elements.ClickButton;
import dev.mrrobot.elements.Element;
import dev.mrrobot.elements.InputText;

import java.util.List;

public class CodeConstructor {

    public static void execute(List<Element> elements) {

        if (Config.getConstantType().equals("by")) elements.forEach(CodeConstructor::constrCteBy);
        else elements.forEach(CodeConstructor::constrCteString);

        elements.forEach(element -> {

            switch (element.getAction()) {

                case CLICK_REGULAR:
                    constrActionMethodClickRg(element);
                    break;

                case INPUT_TEXT_REGULAR:
                    constrActionMethodInputRg(element);
                    break;
            }


        });


    }


    public static void constrCteString(Element element) {

        String cte = String.format("private static final String %s = %s",
                NameGenerator.genCteNameString(element),
                element.getLocator()
        );

        element.setCteCode(cte);
    }

    public static void constrCteBy(Element element) {

        String cte = String.format("private static final String %s = %s",
                NameGenerator.genCteNameBy(element),
                element.getByLocator()
        );

        element.setCteCode(cte);
    }

    public static void constrActionMethodClickRg(Element e) {

        ClickButton element = (ClickButton) e;
        StringBuilder code = new StringBuilder();

        String l0 = element.getAction().getStep().replace("placeholder", element.getName());
        String l1 = String.format("public void %s(){", NameGenerator.genMethodName(element));

        String otherParams = "";
        if (element.isDinamicwait()) otherParams = ",true, false";
        else if (element.isHardwait()) otherParams = ",true, true";

        String l2 = String.format(element.getAction().getSeleniumMethod(), element.getByLocator() + otherParams);
        String l3 = "makeScreenShoot();";

        if (Config.isAllureStepsEnabled()) code.append(l0).append("\n");
        code.append(l1).append("\n");
        code.append(l2).append("\n");
        code.append(l3).append("\n");
        code.append("}");

        element.setMethodCode(code.toString());
    }

    public static void constrActionMethodInputRg(Element e) {
        InputText element = (InputText) e;

        StringBuilder code = new StringBuilder();

        String l0 = element.getAction().getStep().replace("placeholder", element.getName());
        String l1 = String.format("public void %s(String text){", NameGenerator.genMethodName(element));

        String triggetParam = element.isTrigger() ? ",true" : "";

        String l2 = String.format(element.getAction().getSeleniumMethod(), element.getByLocator() + triggetParam);
        String l3 = "makeScreenShoot();";

        if (Config.isAllureStepsEnabled()) code.append(l0).append("\n");
        code.append(l1).append("\n");
        code.append(l2).append("\n");
        code.append(l3).append("\n");
        code.append("}");

        element.setMethodCode(code.toString());
    }


}
