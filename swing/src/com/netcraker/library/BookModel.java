package com.netcraker.library;

import java.io.FileWriter;
import java.util.*;
import javax.swing.table.AbstractTableModel;

import org.json.simple.*;
import org.json.simple.parser.*;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;
import java.io.FileReader;
import java.io.IOException;



public class BookModel extends AbstractTableModel {
    private List<Book> library = new ArrayList<>();  //list of books for table
    private String path = "library.json";

    public BookModel() {
        readFile();    //I decided it's necessary to read all books into the table
    }

    public void addBook(Book b){
        library.add(b);
        writeFile();
        fireTableDataChanged();   //Notifies all listeners that all cell values in the table's rows may have changed.
    }


    public void editBook(Book b, int index){
        library.set(index, b);
        writeFile();
        fireTableDataChanged();  //Notifies all listeners that all cell values in the table's rows may have changed.
    }

    public void deleteBook(int index) {
        library.remove(index);
        writeFile();
        fireTableDataChanged();   //Notifies all listeners that all cell values in the table's rows may have changed.
    }

    public List<Book> getBookList() {
        return this.library;
    }

    @Override
    public int getRowCount() {
        return library.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Book cur = library.get(rowIndex);
        switch (columnIndex){
            case 0:
                return cur.getName();
            case 1:
                return cur.getAuthor().getName();
            case 2:
                return cur.getAuthor().getGender();
            case 3:
                return cur.getAuthor().getCountry();
            case 4:
                return cur.getGenre();
            case 5:
                return cur.getYear();
            case 6:
                return cur.getPrice();
            case 7:
                return cur.getQty();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column){
            case 0:
                return "Title";
            case 1:
                return "Author's name";
            case 2:
                return "Author's gender";
            case 3:
                return "Author's country";
            case 4:
                return "Genre";
            case 5:
                return "Year";
            case 6:
                return "Price";
            case 7:
                return "Quantity";
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex){
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            case 4:
                return String.class;
            case 5:
                return Integer.class;
            case 6:
                return Double.class;
            case 7:
                return Integer.class;
        }
        return Object.class;
    }


    public void readFile() {
        library.clear();  //need to delete all books in list to avoid double info in table
        JSONParser parser = new JSONParser();
        try {
            JSONObject object = (JSONObject)parser.parse(new FileReader(path));
            JSONArray jsonArray = (JSONArray)object.get("books");  //could't do it better - one object has only one array jsonArray
            Iterator bookIterator =jsonArray.iterator();   //use array for using an iterator
            while(bookIterator.hasNext()) {
                JSONObject book = (JSONObject)bookIterator.next();
                String name = (String) book.get("name");
                String authorName = (String) book.get("author name");
                String authorGender = (String) book.get("gender");
                String authorCountry = (String) book.get("country");
                String genre = (String) book.get("genre");
                int year = Integer.parseInt(book.get("year").toString());
                double price = Double.parseDouble(book.get("price").toString());
                int qty = Integer.parseInt(book.get("qty").toString());
                Book readBook = new Book(name, new Author(authorName, authorGender, authorCountry), genre, year, price, qty);
                this.library.add(readBook);
            }
        }
        catch(ParseException e ){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        fireTableDataChanged();
    }

    public void writeFile() {   //write one book to file
        JSONObject lib = new JSONObject();
        JSONArray books = new JSONArray();
        for(Book b : library) {
            JSONObject object = new JSONObject();
            object.put("name", b.getName());
            object.put("author name", b.getAuthor().getName());
            object.put("gender", b.getAuthor().getGender());
            object.put("country", b.getAuthor().getCountry());
            object.put("genre", b.getGenre());
            object.put("year", b.getYear());
            object.put("price", b.getPrice());
            object.put("qty", b.getQty());
            books.add(object);
        }
        lib.put("books", books);
        try (FileWriter writer = new FileWriter(path)) {
            writer.write(lib.toJSONString());
            writer.flush();
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        fireTableDataChanged();
    }

}
