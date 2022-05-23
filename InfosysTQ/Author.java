package InfosysTQ;

class Author1 {
    //Implement your code here
    private String name;
    private String emailID;
    private char gender;

    public Author1(String name, String emailID, char gender) {
        setName(name);
        this.emailID = emailID;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
}


class Book {
    //Implement your code here
   private String name;
   private Author author;
   private int quantity;
   private double price;

    public Book(String name, Author author, int quantity, double price) {
        this.name = name;
        this.author = author;
        this.quantity = quantity;
        this.price = price;
    }

    public Book() {

    }

    public void displayAuthorDetails(){
        String res="";
        Author1 a = new Author1("Abdul Bari","bari@email.com",'M');
        System.out.println("Author's Name: "+a.getName());
        System.out.println("Author's Email: "+a.getEmailID());
        System.out.println("Author's Gender: "+a.getGender());

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}


class Author {
    public static void main(String[] args) {
     Book book = new Book();
     book.displayAuthorDetails();
    }
}

