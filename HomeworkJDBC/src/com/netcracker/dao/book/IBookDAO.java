package com.netcracker.dao.book;

import com.netcracker.model.Book;

import java.util.List;
import java.util.Map;

public interface IBookDAO {

    void saveBook(Book entity);

    List<Book> findAllBooks();

    Book findBookById(int id);

    void deleteBookById(int id);

    long countRow();

    List getBooksByTitlePrice();

    List getBooksByDistrictQtyMore10();

}
