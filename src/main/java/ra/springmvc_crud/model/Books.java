package ra.springmvc_crud.model;

public class Books {
    private int bookId;
    private String bookName;
    private float price;
    private boolean status;

    public Books() {
    }

    public Books(int bookId, String bookName, float price, boolean status) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.price = price;
        this.status = status;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
