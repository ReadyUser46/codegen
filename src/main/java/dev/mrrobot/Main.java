package dev.mrrobot;

public class Main {


    public static void main(String[] args) {

        Service.getInstance()
                .definePageName("DatosClientePage")
                .enableAllureSteps(true)
                .addButtonClick("aceptar", true, true)
                .addButtonClick("//*[@title='minor']", false)
                .addInputText("surname1", true, false, false)
                .addInputText("iban", true, false, true)
                .generateCode();


    }


}
