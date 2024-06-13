package com.example.srinivas_22bce9653.javaexs.lambdas.inheritance;

public class GST extends incomeTax {

//    String mobileNumber;
    @Override
    int calculateTax(int income) {
        int oldTax = super.calculateTax(income);
        int newTax = 1000;
        return oldTax + newTax;
    }
}


//declaration  -- i will buy a car  -- Student srinivas;
////instantiation  -- nano car  -- srinivas = new Student();
//initialization  -- started ignition  -- srinivas.name = "Kantheti"