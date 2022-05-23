package OOPs;

public class Inhert extends Bird{
    int wings;

    public Inhert(String name, String color, int legs, boolean hasTale, int wings) {
        super(name, color, legs, hasTale,wings);
        this.wings = wings;
    }

    public int getWings() {
        return wings;
    }

    public void setWings(int wings) {
        this.wings = wings;
    }
}
