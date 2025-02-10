package org.example.after6.ques1.tools;

public class Knife extends Tool {

    public Knife(Tool in) {
        super(in);
    }

    public Knife() {
    }

    @Override
    public void use() {
        System.out.println("работа ножом");
    }
}
