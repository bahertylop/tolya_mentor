package org.example.after6.ques1.tools;

public class Otvertka extends Tool {

    public Otvertka(Tool in) {
        super(in);
    }

    public Otvertka() {
    }

    @Override
    public void use() {
        System.out.println("работа отверткой");
    }
}
