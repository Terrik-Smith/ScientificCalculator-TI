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

public void switchUnitsMode(String mode) {
    if (mode.equalsIgnoreCase("degrees") || mode.equalsIgnoreCase("radians")) {
        unitsMode = mode.toLowerCase();
    }
}

public void sine() {
    if (unitsMode.equals("degrees")) {
        display = Math.sin(Math.toRadians(display));
    } else {
        display = Math.sin(display);
    }
}

public void cosine() {
    if (unitsMode.equals("degrees")) {
        display = Math.cos(Math.toRadians(display));
    } else {
        display = Math.cos(display);
    }
}
public void tangent() {
    if (unitsMode.equals("degrees")) {
        display = Math.tan(Math.toRadians(display));
    } else {
        display = Math.tan(display);
    }
    }

    public void inverseSine() {
    if (unitsMode.equals("degrees")) {
        display = Math.toDegrees(Math.asin(display));
    } else {
        display = Math.asin(display);
    }
    }
    public void inverseCosine() {
    if (unitsMode.equals("degrees")) {
        display = Math.toDegrees(Math.acos(display));
    } else {
        display = Math.acos(display);
    }
}public void inverseTangent() {
    if (unitsMode.equals("degrees")) {
        display = Math.toDegrees(Math.atan(display));
    } else {
        display = Math.atan(display);
    }
    }
}

