package com.zipcodewilmington.scientificcalculator;

/**
 * Created by leon on 2/9/18.
 */
public class MainApplication {
    public static void main(String[] args) {
    
        ScientificCalculator calculator = new ScientificCalculator();

        calculator.setDisplay(45);

        calculator.tangent();

        Console.println("Result: %s", calculator.getDisplay());   

    }
}
