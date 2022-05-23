package InfosysTQ;

public class Customer {
    private String customerId;
    private String customerName;
    private long contactNumber;

    public Customer(String customerId, String customerName, long contactNumber) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.contactNumber = contactNumber;

    }
    public Customer(){}

    public static void main(String[] args) {
        Customer c = new RegularCustomer("1","ABC",23432,5);
          c.customerDetails();
       // System.out.println(c.payBill());
    }
    public void customerDetails(){
        Customer c = new Customer("3","David",+120021);
        System.out.println(c.getCustomerId()+" "+c.getCustomerName()+" "+c.getContactNumber());
        System.out.println(c.payBill(100));
    }
    public double payBill(double totalPrice) {
        System.out.println("Final bill for the customer is calculated here");
        if (customerId.equals("1")){
            totalPrice = totalPrice - 2;
        }
        if (customerId.equals("2")){
            totalPrice = totalPrice - (totalPrice*5)/100;
        }
        if (customerId.equals("3")){
            totalPrice = totalPrice - (totalPrice*8)/100;
        }
        return totalPrice;
    }
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(long contactNumber) {
        this.contactNumber = contactNumber;
    }
}
class RegularCustomer extends Customer{
    private float discountPercentage;

    public RegularCustomer(String customerId, String customerName, long contactNumber, float discountPercentage) {
        super(customerId, customerName, contactNumber);
        this.discountPercentage = 0.5f;
    }
    @Override
    public double payBill(double totalPrice) {
        double priceAfterDiscount = totalPrice * (1 - (discountPercentage / 100));
        return priceAfterDiscount;
    }
}
