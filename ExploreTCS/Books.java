package ExploreTCS;

public class Books {
    private int id;
    private String title;
    private String author;
    private double price;
    Books(int id, String title, String author, double price)
    {
        this.id=id;
        this.title=title;
        this.author=author;
        this.price=price;

    }
    public int getId()
    {
        return id;
    }
    public String getTitle()
    {
        return title;
    }
    public String getAuthor()
    {
        return author;
    }
    public double getPrice()
    {
        return price;
    }
}
