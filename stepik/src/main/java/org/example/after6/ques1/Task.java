package org.example.after6.ques1;

import org.example.after6.ques1.tools.Otvertka;
import org.example.after6.ques1.tools.Knife;
import org.example.after6.ques1.tools.Pila;
import org.example.after6.ques1.tools.Tool;

public class Task {

    public static void main(String[] args) {

        System.out.println("Мультитул:");
        Tool multitool = new Knife(new Otvertka(new Pila()));
        multitool.work();

        System.out.println("Другой мультитул:");
        Tool multitool2 = new Pila(new Otvertka());
        multitool2.work();

        System.out.println("Просто инструмент:");
        Tool pila = new Pila();
        pila.work();
    }
}
