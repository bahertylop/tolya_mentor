package org.example.after6.ques1.tools;

public class Pila extends Tool {

    public Pila(Tool in) {
        super(in);
    }

    public Pila() {
    }

    @Override
    public void use() {
        System.out.println("работа пилой");
    }
}
