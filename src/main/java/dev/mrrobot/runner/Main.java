package dev.mrrobot.runner;

import dev.mrrobot.elements.Element;
import dev.mrrobot.services.Collector;

import java.util.List;

public class Main {


    public static void main(String[] args) {

        Collector.getInstance()
                .definePageName("DatosClientePage")
                .enableAllureSteps(true)
                .addButtonClick("aceptar", "accept", true, true)
                .addButtonClick("//*[@title='minor']", "minorBtn", false)
                .addInputText("surname1", "surname1", true, false, false)
                .addInputTextSlowly("iban", "iban", true);

        List<Element> elements = Collector.getInstance().getElements();


    }


}
