package com.netcracker.homework.one.book;

import java.util.Arrays;

public class Book {

    private String title;
    private Author[] authors;
    private int price;
    private int qty = 0;

    public Book() {
    }

    public Book(String title, Author[] authors, int price, int qty) {
        this.title = title;
        this.authors = authors;
        this.price = price;
        this.qty = qty;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public void setAuthors(Author[] authors) {
        this.authors = authors;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public String getAuthorNames() {
        String authorNames = "";
        for(Author author : getAuthors()) {
            authorNames += author.getName() + "/n";
        }
        return authorNames;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !(o instanceof Book)) {
            return false;
        }
        Book book = (Book) o;
        return price == book.price &&
                title.equals(book.title) &&
                Arrays.equals(authors, book.authors);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + title.hashCode();
        result = 31 * result + Arrays.hashCode(authors);
        result = 31 * result + (int)(Double.doubleToLongBits(price) ^ (Double.doubleToLongBits(price) >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + getTitle() + '\'' +
                ", authors=" + Arrays.toString(getAuthors()) +
                ", price=" + getPrice() +
                ", qty=" + getQty() +
                '}';
    }
}
