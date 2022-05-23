package ExploreTCS;

public class Medicine {
    private String medicineName;
    private String batchNo;
    private String diseas;
    private int price;

    public Medicine(String medicineName, String batchNo, String diseas, int price) {
        this.medicineName = medicineName;
        this.batchNo = batchNo;
        this.diseas = diseas;
        this.price = price;
    }
    public String getDiseas() {
        return diseas;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

