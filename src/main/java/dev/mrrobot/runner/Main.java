package dev.mrrobot.runner;

import dev.mrrobot.config.Config;
import dev.mrrobot.services.CodeConstructor;
import dev.mrrobot.services.Collector;

public class Main {


    public static void main(String[] args) {


        Config.loadProperties();

        Collector.getInstance()
                .definePageName("DatosClientePage")
                .addButtonClick("aceptar", "accept", true, true)
                .addButtonClick("//*[@title='minor']", "minorBtn", false)
                .addInputText("surname1", "surname1", true)
                .addInputTextSneaky("surname2", "surname2", true)
                .addInputTextSlowly("iban", "iban", true);


        CodeConstructor.execute(Collector.getInstance().getElements());




    }


}
