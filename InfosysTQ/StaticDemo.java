package InfosysTQ;

class Participant {
    private static int counter;
    static{
        counter = 1;
    }
    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Participant.counter = counter;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    private String registrationId;
    private String name;
    private long contactNumber;
    private String cityName;

    Participant(String name,long contactNumber,String cityName){
        this.name = name;
        this.cityName = cityName;
        this.contactNumber = contactNumber;
        setRegistrationId("D"+(10000+counter));
        ++counter;
    }
}

class StaticDemo {

    public static void main(String[] args) {

        Participant participant1 = new Participant("Franklin", 7656784323L, "Texas");
        Participant participant2 = new Participant("Merina", 7890423112L, "New York");

        //Create more objects and add them to the participants array for testing your code

        Participant[] participants = { participant1, participant2 };

        for (Participant participant : participants) {
            System.out.println("Hi "+participant.getName()+"! Your registration id is "+participant.getRegistrationId());
        }

    }
}
