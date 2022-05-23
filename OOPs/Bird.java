package OOPs;

public class Bird {
    private String name;
    private String color;
    private int legs;
    private boolean hasTale;
    private int wings;

    public Bird(String name, String color, int legs, boolean hasTale,int wings) {
        this.name = name;
        this.color = color;
        this.legs = legs;
        this.hasTale = hasTale;
        this.wings = wings;
    }


    public void eat(String food){
        System.out.println("Eating "+food);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getLegs() {
        return legs;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    public boolean isHasTale() {
        return hasTale;
    }

    public void setHasTale(boolean hasTale) {
        this.hasTale = hasTale;
    }

    public int getWings() {
        return wings;
    }

    public void setWings(int wings) {
        this.wings = wings;
    }
}
