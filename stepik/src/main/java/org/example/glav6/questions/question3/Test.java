package org.example.glav6.questions.question3;

public class Test {
    public static void main(String[] args) {

        Pizza pepperoniPizza = new PepperoniPizza();
        pepperoniPizza = new CheeseDecorator(pepperoniPizza);
        System.out.println(pepperoniPizza.getDescription() + ". Cost: $" + pepperoniPizza.getCost());

        pepperoniPizza = new ChickenDecorator(pepperoniPizza);
        System.out.println(pepperoniPizza.getDescription() + ". Cost: $" + pepperoniPizza.getCost());
    }
}
