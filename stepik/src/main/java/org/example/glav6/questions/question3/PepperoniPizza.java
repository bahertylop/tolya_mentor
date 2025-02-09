package org.example.glav6.questions.question3;

public class PepperoniPizza implements Pizza {

    private String description = "Ingredients: dough, sauce, pepperoni sausage, seasoning";

    private double cost = 5.0;

    public PepperoniPizza(String description, double cost) {
        this.description = description;
        this.cost = cost;
    }

    public PepperoniPizza() {
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getCost() {
        return cost;
    }
}
