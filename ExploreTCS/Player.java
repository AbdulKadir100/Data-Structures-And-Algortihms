package ExploreTCS;

public class Player {
    private int id;
    private String country;
    private String side;
    private double price;

    public static void main(String[] args) {
        System.out.println();
    }
    public static double calculateInterest(Account a, int noOfYears)
    {
        double per = (noOfYears*a.getIntrestRate()/100);
        return  (a.getBal()*(a.getIntrestRate()+per)/100);
    }

    public Player(int id, String country, String side, double price) {
        this.id = id;
        this.country = country;
        this.side = side;
        this.price = price;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

class Account {
    private int id;
    private double bal;
    private double intrestRate;

    public Account(int id, double bal, double intrestRate) {
        this.id = id;
        this.bal = bal;
        this.intrestRate = intrestRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBal() {
        return bal;
    }

    public void setBal(double bal) {
        this.bal = bal;
    }

    public double getIntrestRate() {
        return intrestRate;
    }


}