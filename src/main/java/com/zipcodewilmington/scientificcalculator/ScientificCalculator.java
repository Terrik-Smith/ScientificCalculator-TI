package com.zipcodewilmington.scientificcalculator;

public class ScientificCalculator {
    
    private double display;
    private double memory;
    private boolean error;
    private String displayMode;
    private String unitsMode;

   public ScientificCalculator() { 
   display = 0;
   memory = 0;
   error = false;
   displayMode = "decimal";
   unitsMode = "degrees";
   }

   public double getDisplay() {
    return display;
   }
   public void setDisplay(double value) {
    display = value;   }
   public void clear() {
    display = 0;
    error = false;
   }
   public void add(double value) {
    display = display + value;
   }
    public void subtract(double value) {
    display = display - value;
}

}
