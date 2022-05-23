package InfosysTQ;

class Booking{
    private String customerEmail;
    private int seatsRequired;
    private boolean isBooked;
    private static int availableSeat;

    public Booking(String customerEmail, int seatsRequired) {
        this.customerEmail = customerEmail;
        this.seatsRequired = seatsRequired;

        if(seatsRequired > availableSeat){
            setBooked(false);
        }else{
            setBooked(true);
            setAvailableSeat(availableSeat-seatsRequired);
        }

    }

    static {
       availableSeat= 400;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public int getSeatsRequired() {
        return seatsRequired;
    }

    public void setSeatsRequired(int seatsRequired) {
        this.seatsRequired = seatsRequired;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public static int getSeatsAvailable() {
        return availableSeat;
    }

    public void setAvailableSeat(int availableSeat) {
        this.availableSeat = availableSeat;
    }
}

class Cinema {
    public static void main(String[] args) {
        Booking booking1 = new Booking("jack@email.com", 100);
        Booking booking2 = new Booking("jill@email.com", 350);
        Booking booking3 = new Booking("jl@email.com", 35);

        //Create more objects and add them to the bookings array for testing your code

        Booking[] bookings = { booking1, booking2,booking3 };

        for (Booking booking : bookings) {

                 if (booking.isBooked()) {

                     System.out.println(booking.getSeatsRequired() + " seats successfully booked for " + booking.getCustomerEmail());
                 }

            else {
                System.out.println("Sorry "+booking.getCustomerEmail()+", required number of seats are not available!");
                System.out.println("Seats available: "+Booking.getSeatsAvailable());
            }
        }
    }
}


