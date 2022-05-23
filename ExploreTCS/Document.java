package ExploreTCS;

public class Document {
    private int id;
    private String title;
    private String folderName;
    private int pages;
   public Document(int id,String title,String folderName,int pages)
    {
        this.id=id;
        this.title=title;
        this.folderName=folderName;
        this.pages=pages;
    }
    public int getId()
    {
        return id;
    }
    public String getTitle()
    {
        return title;
    }
    public int getPages()
    {
        return pages;
    }
}
