package InfosysTQ;
class Calculator {

    int num;
    Calculator(int num){
        this.num = num;
    }
    private int sumOfDigits(){
        int ans = 0;
        while(num > 0){
            int i = num%10;
            ans += i;
            num /= 10;
        }
        return ans;
    }

}

class Test {

    public int getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public double getCostPerTicket() {
        return costPerTicket;
    }

    public void setCostPerTicket(double costPerTicket) {
        this.costPerTicket = costPerTicket;
    }

    private int noOfSeats;
    private int ticketID;
    private double costPerTicket;
    public static void main(String args[]) {
        String a = new String("welcome");
        String b = new String("welcome");
        String c = "welcome";
    }
}
