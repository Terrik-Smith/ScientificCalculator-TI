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
    public void multiply(double value) {
    display = display * value;
}
    public void divide(double value) {
    if (value == 0) {
    error = true;
    } else {
    display = display / value;
    }
}
    public void square() {
    display = display * display;
}
    public void squareRoot() {
    if (display < 0) {
    error = true;
    } else { 
    display = Math.sqrt(display);
        }
    }
    public void inverse() {
        if (display == 0) {
            error = true;
        } else { 
           display = 1 / display;
        }
    }
    public void switchSign() {
        display = -display;
    }
    public void power(double exponent) {
    display = Math.pow(display, exponent);
    }
}
