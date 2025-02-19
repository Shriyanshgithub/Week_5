package org.capgemini.ConvertJavaObjectIntoJson;

public class Car {
    private String name ;
    private int price;
    private int numberOfSeat;
    private String engine;

    public Car(String name, int price, int numberOfSeat, String engine) {
        this.name = name;
        this.price = price;
        this.numberOfSeat = numberOfSeat;
        this.engine = engine;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getNumberOfSeat() {
        return numberOfSeat;
    }

    public String getEngine() {
        return engine;
    }
}
