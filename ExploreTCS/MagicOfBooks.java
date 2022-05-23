package ExploreTCS;

import java.util.HashMap;

public class MagicOfBooks {
    public static void main(String[] args) {

    }
    public static void function(Book[] books){
        HashMap<Integer,Book> map = new HashMap<>();
        for(Book b : books){
            map.put(b.getBookId(), map.getOrDefault(b.getBookId(),b));
        }

    }
}
class User{
    private String userName;
    private String userId;
    private String emailId;
    private int password;
    private Book newBooks;
    private Book favorite;
    private Book completed;


    public User(String userName, String userId, String emailId, int password, Book newBooks, Book favorite, Book completed) {
        this.userName = userName;
        this.userId = userId;
        this.emailId = emailId;
        this.password = password;
        this.newBooks = newBooks;
        this.favorite = favorite;
        this.completed = completed;
    }

    public Book getNewBooks() {
        return newBooks;
    }

    public void setNewBooks(Book newBooks) {
        this.newBooks = newBooks;
    }

    public Book getFavorite() {
        return favorite;
    }

    public void setFavorite(Book favorite) {
        this.favorite = favorite;
    }

    public Book getCompleted() {
        return completed;
    }

    public void setCompleted(Book completed) {
        this.completed = completed;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }
}
class Book{
    private String bookName;
    private String authorName;
    private String description;
    private int bookId;

    public Book(String bookName, String authorName, String description, int bookId) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.description = description;
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
}