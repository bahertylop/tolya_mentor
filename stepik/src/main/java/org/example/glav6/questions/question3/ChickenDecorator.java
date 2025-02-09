package org.example.glav6.questions.question3;

public class ChickenDecorator extends PizzaDecorator {

    public ChickenDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", baked chicken";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 2.00;
    }
}
