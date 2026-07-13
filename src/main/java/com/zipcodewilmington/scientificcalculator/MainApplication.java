package com.zipcodewilmington.scientificcalculator;

public class MainApplication {
    public static void main(String[] args) {
    
        ScientificCalculator calculator = new ScientificCalculator();

        calculator.setDisplay(45);

        calculator.add(5);

        Console.println("Result: %s", calculator.getDisplay());   

    }
}

